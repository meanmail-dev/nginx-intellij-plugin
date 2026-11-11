package dev.meanmail.psi

import com.intellij.openapi.paths.WebReference
import com.intellij.openapi.util.TextRange
import com.intellij.openapi.vfs.InvalidVirtualFileAccessException
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.IncorrectOperationException
import dev.meanmail.NginxFileType
import java.io.File
import dev.meanmail.resolveFile as resolveFileUtil

interface ReferenceElement : NamedElement {
    val ref: String
}

class Reference(element: ReferenceElement) :
    PsiReferenceBase<ReferenceElement>(element, null, false) {
    override fun resolve(): PsiElement? {
        return resolveToFile(element.ref)
    }

    private fun resolveToFile(ref: String): PsiElement? {
        if (ref.startsWith("http://") || ref.startsWith("https://")) {
            return WebReference(element, ref).resolve()
        }
        if (ref.isEmpty()) return null
        val directory = element.containingFile
            ?.containingDirectory?.virtualFile ?: return null
        val path = if (quote == null) ref else ESCAPED_PATH_CHARACTER.replace(ref) { match ->
            val escaped = match.groupValues[1]
            if (escaped.single() in INCLUDE_GLOB_CHARACTERS && !isInclude) match.value else escaped
        }
        val file = resolveFileUtil(path, directory) ?: return null
        if (!file.isValid) return null

        return try {
            PsiManager.getInstance(element.project).findFile(file)
        } catch (_: InvalidVirtualFileAccessException) {
            null
        }
    }

    override fun getRangeInElement(): TextRange {
        return TextRange(0, element.textLength)
    }

    override fun bindToElement(target: PsiElement): PsiElement {
        val file = (target as? PsiFile)?.virtualFile
            ?: throw IncorrectOperationException("An Nginx file reference requires a file target")
        val sourceDirectory = element.containingFile?.containingDirectory?.virtualFile
        val include = isInclude
        val base = if (include) {
            generateSequence(sourceDirectory) { it.parent }
                .firstOrNull { it.findChild("nginx.conf") != null }
                ?: sourceDirectory
        } else {
            sourceDirectory
        }
        val path = if (base == null || File(element.ref).isAbsolute) {
            file.path
        } else {
            val relative = VfsUtilCore.findRelativePath(base, file, '/')
            relative?.takeIf { resolveFileUtil(it, sourceDirectory ?: base) == file } ?: file.path
        }

        val previousQuote = quote
        val argument = if (previousQuote == null && path.all { it.isLetterOrDigit() || it in "/._-" }) {
            path
        } else {
            val quote = previousQuote ?: '"'
            buildString {
                append(quote)
                for (character in path) {
                    if (character == quote || character == '\\' || include && character in INCLUDE_GLOB_CHARACTERS) {
                        append('\\')
                    }
                    append(character)
                }
                append(quote)
            }
        }

        val template = PsiFileFactory.getInstance(element.project)
            .createFileFromText("include.conf", NginxFileType.INSTANCE, "include $argument;")
        val replacement = PsiTreeUtil.findChildOfType(template, ValueStmt::class.java)
            ?: throw IncorrectOperationException("Unable to parse the new Nginx file path")
        return element.replace(replacement)
    }

    private val quote: Char?
        get() = element.text.firstOrNull()?.takeIf { it == '"' || it == '\'' }

    private val isInclude: Boolean
        get() = (element.parent as? RegularDirectiveStmt)?.nameStmt?.text == "include"

    override fun handleElementRename(newElementName: String): PsiElement? {
        val newElement = element.setName(newElementName)
        element.parent.node.replaceChild(element.node, newElement.node)
        return newElement
    }

    private companion object {
        const val INCLUDE_GLOB_CHARACTERS = "*?["
        val ESCAPED_PATH_CHARACTER = Regex("""\\([\\"'*?\[])""")
    }
}
