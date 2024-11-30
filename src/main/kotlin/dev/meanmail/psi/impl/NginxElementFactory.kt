package dev.meanmail.psi.impl

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import dev.meanmail.NginxFileType
import dev.meanmail.psi.ValueStmt

class NginxElementFactory(private val project: Project) {
    fun createValueStmt(value: String): ValueStmt {
        // Try creating a full Nginx configuration context
        val dummyFile = PsiFileFactory.getInstance(project)
            .createFileFromText(
                "dummy.nginx", NginxFileType,
                "events {\n" +
                        "    multi_accept $value;\n" +
                        "}"
            )

        // Find the first ValueStmt in the created file
        val valueStmt = dummyFile.firstChild.children
            .filterIsInstance<PsiElement>()
            .flatMap { it.children.toList() }
            .filterIsInstance<ValueStmt>()
            .firstOrNull()

        return valueStmt
            ?: throw IllegalStateException("Cannot create ValueStmt for value: $value")
    }
}
