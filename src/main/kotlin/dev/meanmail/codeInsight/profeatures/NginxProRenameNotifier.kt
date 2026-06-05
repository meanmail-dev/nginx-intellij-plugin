package dev.meanmail.codeInsight.profeatures

import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.components.service
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.refactoring.rename.RenameHandler
import dev.meanmail.codeInsight.NginxProPluginInstaller

/**
 * High-intent Pro upsell on the rename "wall". The free plugin has no rename
 * refactoring for variables or upstream references, so when the user explicitly
 * invokes Rename (Shift+F6) on one of those, surface the Pro refactoring feature.
 *
 * Only claims the rename action for those exact symbols (other positions fall
 * through to normal handling), and is bounded by [ProFeaturePromptPolicy].
 */
class NginxProRenameNotifier : RenameHandler {

    override fun isAvailableOnDataContext(dataContext: DataContext): Boolean {
        return proSymbolUnderCaret(dataContext) != null
    }

    override fun invoke(project: Project, editor: Editor?, file: PsiFile?, dataContext: DataContext?) {
        val context = dataContext ?: return
        if (proSymbolUnderCaret(context) == null) return
        showPrompt(project)
    }

    override fun invoke(project: Project, elements: Array<out PsiElement>, dataContext: DataContext?) {
        // Editor-driven rename only; nothing to do for element-array invocations.
    }

    private fun proSymbolUnderCaret(dataContext: DataContext): PsiElement? {
        val editor = CommonDataKeys.EDITOR.getData(dataContext) ?: return null
        val file = CommonDataKeys.PSI_FILE.getData(dataContext) ?: return null
        val element = file.findElementAt(editor.caretModel.offset)
        return if (NginxProNavTargets.isNavigableProSymbol(element)) element else null
    }

    private fun showPrompt(project: Project) {
        service<ProFeaturePromptService>().tryShowNotification(
            project = project,
            source = ProFeatureEntryPoint.REFACTORING,
            title = "Rename across the whole config — Nginx Pro",
            message = "Nginx Pro renames variables, upstreams and named locations and updates every usage for you. " +
                "Free 14-day trial, no account needed.",
            onInstall = {
                NginxProPluginInstaller.openInstallDialog(project, ProFeatureEntryPoint.REFACTORING, "notification")
            }
        )
    }
}
