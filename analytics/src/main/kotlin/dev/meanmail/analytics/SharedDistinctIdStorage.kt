package dev.meanmail.analytics

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.util.SystemInfo
import java.net.InetAddress
import java.net.UnknownHostException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.security.MessageDigest
import java.time.Instant
import java.util.UUID

object SharedDistinctIdStorage {
    private const val FINGERPRINT_SALT = "meanmail-distinct-id-v1"
    private const val VENDOR_DIR = "meanmail"
    private const val FILE_NAME = "distinct_id.json"

    private val LOG = logger<SharedDistinctIdStorage>()
    private val gson = Gson()
    private val lock = Any()

    @Volatile
    private var cached: String? = null

    fun get(): String {
        cached?.let { return it }
        synchronized(lock) {
            cached?.let { return it }
            val id = readOrCreate()
            cached = id
            return id
        }
    }

    private fun readOrCreate(): String {
        val expectedFingerprint = currentFingerprint()
        val path = storagePath()

        val existing = readRecord(path)
        if (existing != null && existing.machineFingerprint == expectedFingerprint && existing.id.isNotBlank()) {
            return existing.id
        }

        val record = Record(
            id = UUID.randomUUID().toString(),
            machineFingerprint = expectedFingerprint,
            createdAt = Instant.now().toString(),
        )
        writeRecord(path, record)
        return record.id
    }

    private fun readRecord(path: Path): Record? {
        if (!Files.exists(path)) return null
        return try {
            gson.fromJson(Files.readString(path), Record::class.java)
        } catch (e: JsonSyntaxException) {
            LOG.warn("Invalid distinct id storage at $path, will regenerate", e)
            null
        } catch (e: Exception) {
            LOG.warn("Failed to read distinct id storage at $path, will regenerate", e)
            null
        }
    }

    private fun writeRecord(path: Path, record: Record) {
        try {
            path.parent?.let { Files.createDirectories(it) }
            Files.writeString(path, gson.toJson(record))
        } catch (e: Exception) {
            LOG.warn("Failed to write distinct id storage at $path", e)
        }
    }

    private fun currentFingerprint(): String {
        val hostname = try {
            InetAddress.getLocalHost().hostName.orEmpty()
        } catch (_: UnknownHostException) {
            ""
        } catch (_: SecurityException) {
            ""
        }
        val osUser = System.getProperty("user.name", "")
        val raw = "$hostname:$osUser:$FINGERPRINT_SALT"
        val bytes = MessageDigest.getInstance("SHA-256").digest(raw.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }

    @org.jetbrains.annotations.VisibleForTesting
    fun storagePath(): Path {
        val testOverride = System.getProperty("dev.meanmail.analytics.distinctIdStoragePath")
        if (!testOverride.isNullOrBlank()) {
            return Paths.get(testOverride)
        }
        val home = System.getProperty("user.home", "")
        val baseDir = when {
            SystemInfo.isMac -> Paths.get(home, "Library", "Application Support", VENDOR_DIR)
            SystemInfo.isWindows -> {
                val localAppData = System.getenv("LOCALAPPDATA").orEmpty().ifBlank { home }
                Paths.get(localAppData, VENDOR_DIR)
            }
            else -> {
                val xdg = System.getenv("XDG_CONFIG_HOME").orEmpty().ifBlank { Paths.get(home, ".config").toString() }
                Paths.get(xdg, VENDOR_DIR)
            }
        }
        return baseDir.resolve(FILE_NAME)
    }

    @org.jetbrains.annotations.VisibleForTesting
    fun resetForTests() {
        synchronized(lock) {
            cached = null
        }
    }

    @org.jetbrains.annotations.VisibleForTesting
    data class Record(
        val id: String = "",
        val machineFingerprint: String = "",
        val createdAt: String = "",
    )
}
