package dev.meanmail.analytics

import com.google.gson.Gson
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.nio.file.Files
import java.nio.file.Path

class SharedDistinctIdStorageTest {
    private val storageProperty = "dev.meanmail.analytics.distinctIdStoragePath"
    private val gson = Gson()
    private lateinit var tempFile: Path

    @Before
    fun setUp() {
        tempFile = Files.createTempFile("shared-distinct-id-", ".json")
        Files.deleteIfExists(tempFile)
        System.setProperty(storageProperty, tempFile.toString())
        SharedDistinctIdStorage.resetForTests()
    }

    @After
    fun tearDown() {
        Files.deleteIfExists(tempFile)
        System.clearProperty(storageProperty)
        SharedDistinctIdStorage.resetForTests()
    }

    @Test
    fun `first call creates file with non-empty id`() {
        val id = SharedDistinctIdStorage.get()

        assertTrue(id.isNotBlank())
        assertTrue(Files.exists(tempFile))
    }

    @Test
    fun `subsequent calls return same id`() {
        val first = SharedDistinctIdStorage.get()
        SharedDistinctIdStorage.resetForTests()
        val second = SharedDistinctIdStorage.get()

        assertEquals(first, second)
    }

    @Test
    fun `tampered fingerprint triggers regeneration`() {
        val first = SharedDistinctIdStorage.get()
        val originalRecord = readRecord()

        writeRecord(originalRecord.copy(machineFingerprint = "different-machine-fingerprint"))
        SharedDistinctIdStorage.resetForTests()

        val regenerated = SharedDistinctIdStorage.get()
        assertNotEquals(first, regenerated)
        assertEquals(originalRecord.machineFingerprint, readRecord().machineFingerprint)
    }

    @Test
    fun `corrupt json triggers regeneration`() {
        val first = SharedDistinctIdStorage.get()
        Files.writeString(tempFile, "{not-valid-json")
        SharedDistinctIdStorage.resetForTests()

        val regenerated = SharedDistinctIdStorage.get()
        assertTrue(regenerated.isNotBlank())
        assertNotEquals(first, regenerated)
    }

    @Test
    fun `record on disk does not contain plaintext hostname or os user`() {
        SharedDistinctIdStorage.get()

        val raw = Files.readString(tempFile)
        assertEquals(false, raw.contains(System.getProperty("user.name", "user.name")))
        val record = readRecord()
        assertTrue(record.id.isNotBlank())
        assertTrue(record.machineFingerprint.isNotBlank())
        assertTrue(record.createdAt.isNotBlank())
    }

    private fun readRecord(): SharedDistinctIdStorage.Record {
        return gson.fromJson(Files.readString(tempFile), SharedDistinctIdStorage.Record::class.java)
    }

    private fun writeRecord(record: SharedDistinctIdStorage.Record) {
        Files.writeString(tempFile, gson.toJson(record))
    }
}
