package dev.meanmail.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import dev.meanmail.NginxFileType


fun createFileFromText(project: Project, text: String): NginxFile {
    val name = "dummy.nginx"
    return PsiFileFactory.getInstance(project).createFileFromText(
        name, NginxFileType, text
    ) as NginxFile
}

fun createIncludeTargetStmt(project: Project, name: String): IncludeTargetStmt {
    val file = createFileFromText(project, "include $name;")
    return file.firstChild.children[1] as IncludeTargetStmt
}
