package dev.meanmail.codeInsight.inspections

import com.intellij.codeInspection.InspectionManager
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.findParentOfType
import dev.meanmail.NginxFileType
import dev.meanmail.codeInsight.completion.directives.Directive
import dev.meanmail.codeInsight.completion.directives.determineFileContext
import dev.meanmail.codeInsight.completion.directives.findDirectives
import dev.meanmail.psi.DirectiveStmt
import dev.meanmail.psi.NameStmt

class NginxDirectiveInspection : LocalInspectionTool() {
    override fun checkFile(
        file: PsiFile,
        manager: InspectionManager,
        isOnTheFly: Boolean
    ): Array<ProblemDescriptor> {
        if (file.fileType != NginxFileType) return emptyArray()

        val problems = mutableListOf<ProblemDescriptor>()

        val directivesStmts = PsiTreeUtil.findChildrenOfType(file, DirectiveStmt::class.java)

        for (directiveStmt in directivesStmts) {
            val nameElement = directiveStmt.children.filterIsInstance<NameStmt>().firstOrNull() ?: continue
            val matchingDirectives = findDirectives(nameElement.text)
            if (matchingDirectives.isEmpty()) {
                problems.add(
                    manager.createProblemDescriptor(
                        nameElement,
                        "Unknown directive",
                        true,
                        ProblemHighlightType.ERROR,
                        isOnTheFly
                    )
                )
            } else {
                problems.addAll(
                    validateDirectiveContext(directiveStmt, nameElement, matchingDirectives, manager, isOnTheFly)
                )
            }
        }

        return problems.toTypedArray()
    }

    private fun validateDirectiveContext(
        directiveStmt: DirectiveStmt,
        nameElement: NameStmt,
        matchingDirectives: List<Directive>,
        manager: InspectionManager,
        isOnTheFly: Boolean
    ): List<ProblemDescriptor> {
        val directiveName = directiveStmt.name

        if (matchingDirectives.all { it.context.isEmpty() }) {
            return listOf(
                manager.createProblemDescriptor(
                    nameElement,
                    "Directive '$directiveName' is not allowed in any context",
                    true,
                    ProblemHighlightType.ERROR,
                    isOnTheFly
                )
            )
        }

        val parent = directiveStmt.findParentOfType<DirectiveStmt>()

        if (parent != null) {
            if (!matchingDirectives.any { matchingDirective ->
                    matchingDirective.isAllowedPath(directiveStmt.path)
                }) {
                return listOf(
                    manager.createProblemDescriptor(
                        nameElement,
                        "Directive '$directiveName' is not allowed in this context. \n" +
                                "Allowed contexts:\n" +
                                matchingDirectives.joinToString("\n") {
                                    "  - ${it.fullName}"
                                },
                        true,
                        ProblemHighlightType.ERROR,
                        isOnTheFly
                    )
                )
            }
            return emptyList()
        }

        val context: Set<Directive> = determineFileContext(directiveStmt.containingFile) ?: return emptyList()
        // Check if directive's context intersects with current context
        val matchingDirectivesContext = matchingDirectives.map { it.context }.flatten().toSet()
        if (matchingDirectivesContext.intersect(context).isEmpty()) {
            return listOf(
                manager.createProblemDescriptor(
                    nameElement,
                    "Directive '$directiveName' cannot be used in this context. " +
                            "Current file context is '${context.joinToString(", ") { it.name }}' " +
                            "(determined by the context of existing directives), " +
                            "but '${directiveName}' block can only be defined in: " +
                            "${matchingDirectivesContext.joinToString(", ") { it.name }}.",
                    true,
                    ProblemHighlightType.ERROR,
                    isOnTheFly
                )
            )
        }

        return emptyList()
    }
}
