package dev.meanmail.analytics

import com.google.gson.Gson
import com.intellij.ide.plugins.PluginManagerCore
import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ApplicationInfo
import com.intellij.openapi.application.PermanentInstallationID
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.extensions.PluginId
import com.intellij.ui.LicensingFacade
import com.intellij.util.concurrency.AppExecutorUtil
import com.intellij.util.io.HttpRequests
import java.net.HttpURLConnection
import java.security.MessageDigest
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.TimeUnit

@Service
class AnalyticsService : Disposable {
    private val settings = AnalyticsSettings.getInstance()
    private val config = AnalyticsConfig.getInstance()
    private val gson = Gson()
    private val eventQueue = ConcurrentLinkedQueue<Map<String, Any?>>()

    private val flushTask = AppExecutorUtil.getAppScheduledExecutorService()
        .scheduleWithFixedDelay(::flush, 5, 5, TimeUnit.MINUTES)

    private fun getDistinctId(): String {
        val licensedTo = LicensingFacade.getInstance()?.getLicensedToMessage()
        if (!licensedTo.isNullOrBlank()) {
            return sha256(licensedTo)
        }
        return PermanentInstallationID.get()
    }

    fun capture(event: String, properties: Map<String, Any?> = emptyMap()) {
        if (!settings.isEnabled) return

        val allProperties = buildMap {
            putAll(collectEnvironmentProperties())
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

        eventQueue.add(eventData)

        if (eventQueue.size >= MAX_QUEUE_SIZE) {
            flush()
        }
    }

    fun identify() {
        if (!settings.isEnabled) return

        val distinctId = getDistinctId()
        val installationId = PermanentInstallationID.get()

        val identifyProperties = buildMap {
            put("\$set", collectEnvironmentProperties())
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

    private fun flush() {
        if (eventQueue.isEmpty()) return

        val batch = mutableListOf<Map<String, Any?>>()
        while (batch.size < MAX_QUEUE_SIZE) {
            val event = eventQueue.poll() ?: break
            batch.add(event)
        }

        if (batch.isEmpty()) return

        val payload = mapOf(
            "api_key" to config.posthogApiKey,
            "batch" to batch
        )

        try {
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
                }
        } catch (e: Exception) {
            LOG.warn("Failed to send analytics batch", e)
        }
    }

    override fun dispose() {
        flushTask.cancel(false)
        flush()
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

        fun getInstance(): AnalyticsService = service()

        private fun sha256(input: String): String {
            val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
            return bytes.joinToString("") { "%02x".format(it) }
        }
    }
}
