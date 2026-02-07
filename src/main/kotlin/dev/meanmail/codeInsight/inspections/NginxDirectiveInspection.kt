package dev.meanmail.codeInsight.inspections

import com.intellij.codeInsight.intention.preview.IntentionPreviewUtils
import com.intellij.codeInspection.*
import com.intellij.ide.BrowserUtil
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.findParentOfType
import dev.meanmail.NginxFileType
import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.any
import dev.meanmail.directives.catalog.findDirectives
import dev.meanmail.directives.determineFileContext
import dev.meanmail.psi.DirectiveStmt

class NginxDirectiveInspection : LocalInspectionTool() {
    override fun checkFile(
        file: PsiFile,
        manager: InspectionManager,
        isOnTheFly: Boolean
    ): Array<ProblemDescriptor> {
        if (file.fileType !is NginxFileType) return emptyArray()

        val problems = mutableListOf<ProblemDescriptor>()

        val directivesStmts = PsiTreeUtil.findChildrenOfType(file, DirectiveStmt::class.java)

        for (directiveStmt in directivesStmts) {
            val nameElement = directiveStmt.nameIdentifier ?: continue
            val matchingDirectives = findDirectives(nameElement.text)
            if (matchingDirectives.isEmpty()) {
                problems.add(
                    manager.createProblemDescriptor(
                        nameElement,
                        "Unknown directive",
                        UnknownDirectiveQuickFix(),
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
        nameElement: PsiElement,
        matchingDirectives: List<Directive>,
        manager: InspectionManager,
        isOnTheFly: Boolean
    ): List<ProblemDescriptor> {
        val directiveName = directiveStmt.name

        if (matchingDirectives.any { any in it.context }) {
            return emptyList()
        }

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
        val matchingDirectivesContext = matchingDirectives.flatMap { it.context }.toSet()
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

    /**
     * Quick Fix that suggests installing the Pro version for unknown directives
     */
    private class UnknownDirectiveQuickFix : LocalQuickFix {
        override fun getName(): String = "Check if this directive is available in Pro version"

        override fun getFamilyName(): String = "NGINX Pro Features"

        override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
            // Avoid side effects during intention preview (runs on a copy). See IDEA SideEffectGuard.
            if (IntentionPreviewUtils.isPreviewElement(descriptor.psiElement)) {
                return
            }

            ApplicationManager.getApplication().invokeLater {
                BrowserUtil.browse("https://plugins.jetbrains.com/plugin/18280-nginx-configuration-pro")
            }
        }
    }
}
