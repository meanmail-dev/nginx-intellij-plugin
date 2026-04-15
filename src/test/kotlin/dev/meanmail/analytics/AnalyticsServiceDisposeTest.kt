package dev.meanmail.analytics

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.ConcurrentLinkedQueue

class AnalyticsServiceDisposeTest {
    @Test
    fun `dispose flushes queued events when allowed`() {
        val service = RecordingAnalyticsService(
            sendBatchResult = true,
            shouldFlushOnDispose = true,
        )
        enqueueEvent(service)

        service.dispose()

        assertEquals(1, service.sendBatchCalls)
        assertEquals(0, getQueueSize(service))
    }

    @Test
    fun `dispose skips flush when shutdown is in progress`() {
        val service = RecordingAnalyticsService(
            sendBatchResult = true,
            shouldFlushOnDispose = false,
        )
        enqueueEvent(service)

        service.dispose()

        assertEquals(0, service.sendBatchCalls)
        assertTrue(getQueueSize(service) > 0)
    }

    @Test
    fun `failed flush keeps events in queue`() {
        val service = RecordingAnalyticsService(
            sendBatchResult = false,
            shouldFlushOnDispose = true,
        )
        enqueueEvent(service)

        service.dispose()

        assertEquals(1, service.sendBatchCalls)
        assertTrue(getQueueSize(service) > 0)
    }

    @Test
    fun `events are restored from disk on next service instance`() {
        val storageFile = Files.createTempFile("analytics-queue-", ".json")
        Files.deleteIfExists(storageFile)

        val first = RecordingAnalyticsService(
            sendBatchResult = true,
            shouldFlushOnDispose = false,
            storageFile = storageFile,
        )
        enqueueEvent(first)
        first.dispose()

        assertTrue(Files.exists(storageFile))

        val second = RecordingAnalyticsService(
            sendBatchResult = true,
            shouldFlushOnDispose = false,
            storageFile = storageFile,
        )

        second.flushPendingEvents()
        assertEquals(1, second.sendBatchCalls)
        assertFalse(Files.exists(storageFile))
        assertEquals(0, getQueueSize(second))
    }

    @Test
    fun `plugin unload flushes when allowed`() {
        val service = RecordingAnalyticsService(
            sendBatchResult = true,
            shouldFlushOnDispose = false,
            shouldFlushBeforePluginUnload = true,
        )
        enqueueEvent(service)

        service.flushBeforePluginUnload()

        assertEquals(1, service.sendBatchCalls)
        assertEquals(0, getQueueSize(service))
    }

    private fun enqueueEvent(service: AnalyticsService) {
        getQueue(service).add(
            mapOf(
                "event" to "test_event",
                "distinct_id" to "test-id",
                "properties" to emptyMap<String, Any>(),
                "timestamp" to "2026-04-12T00:00:00Z",
            )
        )
    }

    @Suppress("UNCHECKED_CAST")
    private fun getQueue(service: AnalyticsService): ConcurrentLinkedQueue<Map<String, Any?>> {
        val field = AnalyticsService::class.java.getDeclaredField("eventQueue")
        field.isAccessible = true
        return field.get(service) as ConcurrentLinkedQueue<Map<String, Any?>>
    }

    private fun getQueueSize(service: AnalyticsService): Int = getQueue(service).size

    private class RecordingAnalyticsService(
        private val sendBatchResult: Boolean,
        private val shouldFlushOnDispose: Boolean,
        private val shouldFlushBeforePluginUnload: Boolean = true,
        private val storageFile: Path? = null,
    ) : AnalyticsService(TestConfig(), TestSettings()) {
        var sendBatchCalls: Int = 0

        override fun sendBatch(payload: Map<String, Any?>): Boolean {
            sendBatchCalls++
            return sendBatchResult
        }

        override fun shouldFlushOnDispose(): Boolean = shouldFlushOnDispose

        override fun shouldFlushBeforePluginUnload(): Boolean = shouldFlushBeforePluginUnload

        override fun getQueueStorageFilePath(): Path? = storageFile
    }

    private class TestConfig : AnalyticsConfig {
        override val posthogApiKey: String = "test-api-key"
        override val pluginId: String = "dev.meanmail.plugin.nginx-intellij-plugin"
        override val notificationGroupId: String = "Nginx Analytics"
        override val pluginDisplayName: String = "Nginx Configuration"
    }

    private class TestSettings : AnalyticsSettings() {
        init {
            loadState(
                AnalyticsSettingsState().apply {
                    consentState = ConsentState.ACCEPTED
                }
            )
        }
    }
}
