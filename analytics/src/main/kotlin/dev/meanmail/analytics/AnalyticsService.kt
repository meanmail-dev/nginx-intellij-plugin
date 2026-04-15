package dev.meanmail.analytics

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.intellij.ide.plugins.PluginManagerCore
import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ApplicationInfo
import com.intellij.openapi.application.PathManager
import com.intellij.openapi.application.PermanentInstallationID
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.extensions.PluginId
import com.intellij.ui.LicensingFacade
import com.intellij.util.concurrency.AppExecutorUtil
import com.intellij.util.io.HttpRequests
import java.net.HttpURLConnection
import java.nio.file.Files
import java.nio.file.Path
import java.security.MessageDigest
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.TimeUnit

open class AnalyticsService(
    private val config: AnalyticsConfig,
    private val settings: AnalyticsSettings,
) : Disposable {
    private val gson = Gson()
    private val queueType = object : TypeToken<List<Map<String, Any?>>>() {}.type
    private val queueLock = Any()
    @Volatile
    private var queueRestored: Boolean = false
    private val eventQueue = ConcurrentLinkedQueue<Map<String, Any?>>()

    private val flushTask = AppExecutorUtil.getAppScheduledExecutorService()
        .scheduleWithFixedDelay(::flush, 1, 1, TimeUnit.MINUTES)

    private fun getDistinctId(): String {
        val licensedTo = LicensingFacade.getInstance()?.getLicensedToMessage()
        if (!licensedTo.isNullOrBlank()) {
            return sha256(licensedTo)
        }
        return PermanentInstallationID.get()
    }

    fun capture(event: String, properties: Map<String, Any?> = emptyMap()) {
        if (!settings.isEnabled) return
        ensureQueueRestored()

        val allProperties = buildMap {
            putAll(collectEnvironmentProperties())
            putAll(LicenseHelper.getLicenseProperties(config))
            putAll(properties)
        }

        val eventData = mapOf(
            "event" to event,
            "distinct_id" to getDistinctId(),
            "properties" to allProperties,
            "timestamp" to System.currentTimeMillis().let {
                java.time.Instant.ofEpochMilli(it).toString()
            }
        )

        synchronized(queueLock) {
            eventQueue.add(eventData)
            persistQueueToDisk()
        }

        if (eventQueue.size >= MAX_QUEUE_SIZE) {
            flush()
        }
    }

    fun identify() {
        if (!settings.isEnabled) return

        val distinctId = getDistinctId()
        val installationId = PermanentInstallationID.get()

        val environmentAndLicense = collectEnvironmentProperties() + LicenseHelper.getLicenseProperties(config)

        val identifyProperties = buildMap {
            putAll(environmentAndLicense)
            put("\$set", environmentAndLicense)
            if (distinctId != installationId) {
                put("\$anon_distinct_id", installationId)
            }
        }

        val payload = mapOf(
            "api_key" to config.posthogApiKey,
            "distinct_id" to distinctId,
            "event" to "\$identify",
            "properties" to identifyProperties
        )

        try {
            HttpRequests.post("${config.posthogHost}/capture/", "application/json")
                .tuner { connection ->
                    connection.setRequestProperty("Content-Type", "application/json")
                }
                .connect { request ->
                    request.write(gson.toJson(payload))
                    val response = request.connection as HttpURLConnection
                    if (response.responseCode != 200) {
                        LOG.warn("PostHog identify failed: ${response.responseCode}")
                    }
                }
        } catch (e: Exception) {
            LOG.warn("Failed to send analytics identify", e)
        }
    }

    fun flushPendingEvents() {
        ensureQueueRestored()
        flush()
    }

    private fun flush() {
        ensureQueueRestored()
        val batch = synchronized(queueLock) {
            if (eventQueue.isEmpty()) return

            val extracted = mutableListOf<Map<String, Any?>>()
            while (extracted.size < MAX_QUEUE_SIZE) {
                val event = eventQueue.poll() ?: break
                extracted.add(event)
            }
            extracted
        }

        if (batch.isEmpty()) return

        val payload = mapOf(
            "api_key" to config.posthogApiKey,
            "batch" to batch
        )

        val delivered = sendBatch(payload)
        synchronized(queueLock) {
            if (!delivered) {
                batch.forEach(eventQueue::add)
            }
            persistQueueToDisk()
        }
    }

    override fun dispose() {
        flushTask.cancel(false)
        ensureQueueRestored()
        if (shouldFlushOnDispose()) {
            flush()
        } else {
            synchronized(queueLock) {
                persistQueueToDisk()
            }
        }
    }

    protected open fun shouldFlushOnDispose(): Boolean {
        return try {
            val app = ApplicationManager.getApplication()
            !app.isDisposed && !app.isDisposeInProgress
        } catch (_: IllegalStateException) {
            false
        }
    }

    fun flushBeforePluginUnload() {
        ensureQueueRestored()
        if (shouldFlushBeforePluginUnload()) {
            flush()
        }
    }

    protected open fun shouldFlushBeforePluginUnload(): Boolean {
        return try {
            val app = ApplicationManager.getApplication()
            !app.isDisposed && !app.isDisposeInProgress
        } catch (_: IllegalStateException) {
            false
        }
    }

    protected open fun sendBatch(payload: Map<String, Any?>): Boolean {
        return try {
            HttpRequests.post("${config.posthogHost}/batch/", "application/json")
                .tuner { connection ->
                    connection.setRequestProperty("Content-Type", "application/json")
                }
                .connect { request ->
                    request.write(gson.toJson(payload))
                    val response = request.connection as HttpURLConnection
                    if (response.responseCode != 200) {
                        LOG.warn("PostHog batch failed: ${response.responseCode}")
                    }
                    response.responseCode == 200
                }
        } catch (e: Exception) {
            LOG.warn("Failed to send analytics batch", e)
            false
        }
    }

    protected open fun getQueueStorageFilePath(): Path? {
        val safePluginId = config.pluginId.replace('.', '_')
        return Path.of(PathManager.getSystemPath(), "${safePluginId}_analytics_queue.json")
    }

    private fun ensureQueueRestored() {
        if (queueRestored) return
        synchronized(queueLock) {
            if (queueRestored) return
            restoreQueueFromDisk()
            queueRestored = true
        }
    }

    private fun restoreQueueFromDisk() {
        val storageFile = getQueueStorageFilePath() ?: return
        if (!Files.exists(storageFile)) return

        try {
            val raw = Files.readString(storageFile)
            val restored: List<Map<String, Any?>> = gson.fromJson(raw, queueType) ?: emptyList()
            if (restored.isNotEmpty()) {
                restored.forEach(eventQueue::add)
            }
        } catch (e: Exception) {
            LOG.warn("Failed to restore analytics queue", e)
        }
    }

    private fun persistQueueToDisk() {
        val storageFile = getQueueStorageFilePath() ?: return
        try {
            if (eventQueue.isEmpty()) {
                Files.deleteIfExists(storageFile)
                return
            }

            val parent = storageFile.parent
            if (parent != null) {
                Files.createDirectories(parent)
            }
            val snapshot = eventQueue.toList()
            Files.writeString(storageFile, gson.toJson(snapshot))
        } catch (e: Exception) {
            LOG.warn("Failed to persist analytics queue", e)
        }
    }

    private fun collectEnvironmentProperties(): Map<String, String> {
        val appInfo = ApplicationInfo.getInstance()
        val pluginId = PluginId.getId(config.pluginId)
        val plugin = PluginManagerCore.getPlugin(pluginId)

        return buildMap {
            put("plugin_id", pluginId.idString)
            put("plugin_version", plugin?.version ?: "unknown")
            put("ide_name", appInfo.versionName)
            put("ide_version", appInfo.fullVersion)
            put("ide_build", appInfo.build.asString())
            put("os_name", System.getProperty("os.name", "unknown"))
            put("os_version", System.getProperty("os.version", "unknown"))
            put("os_arch", System.getProperty("os.arch", "unknown"))
        }
    }

    companion object {
        private val LOG = logger<AnalyticsService>()
        private const val MAX_QUEUE_SIZE = 50

        private fun sha256(input: String): String {
            val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
            return bytes.joinToString("") { "%02x".format(it) }
        }
    }
}
