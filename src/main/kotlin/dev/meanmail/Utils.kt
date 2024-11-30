package dev.meanmail

import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import java.io.File

fun resolveFile(filepath: String, base: VirtualFile): VirtualFile? {
    val target = File(filepath)

    // First try absolute path
    if (target.isAbsolute) {
        return LocalFileSystem.getInstance().findFileByIoFile(target)
    }

    // Try relative to current file
    base.findFileByRelativePath(filepath)?.let { return it }

    // Try relative to nginx root directory (parent directories until we find nginx.conf)
    var currentDir = base
    while (currentDir.parent != null) {
        currentDir = currentDir.parent
        if (currentDir.findChild("nginx.conf") != null) {
            // Found nginx root directory, try to resolve relative to it
            currentDir.findFileByRelativePath(filepath)?.let { return it }
            break
        }
    }

    return null
}


fun getNginxVersion(): String = "1.21.4"
