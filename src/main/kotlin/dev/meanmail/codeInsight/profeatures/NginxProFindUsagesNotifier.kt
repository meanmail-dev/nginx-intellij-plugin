package dev.meanmail.codeInsight.profeatures

import com.intellij.find.findUsages.FindUsagesHandler
import com.intellij.find.findUsages.FindUsagesHandlerFactory
import com.intellij.openapi.components.service
import com.intellij.psi.PsiElement
import dev.meanmail.codeInsight.NginxProPluginInstaller

/**
 * High-intent Pro upsell on the Find Usages "wall". The free plugin cannot list
 * usages of variables or upstream references; that is a Pro feature. When the
 * user explicitly invokes Find Usages on such a symbol, surface Pro instead.
 *
 * Fires only on an explicit Find Usages invocation (not the automatic
 * highlight-usages pass), declines to provide a handler, and is bounded by
 * [ProFeaturePromptPolicy].
 */
class NginxProFindUsagesNotifier : FindUsagesHandlerFactory() {

    override fun canFindUsages(element: PsiElement): Boolean {
        return NginxProNavTargets.isNavigableProSymbol(element)
    }

    override fun createFindUsagesHandler(element: PsiElement, forHighlightUsages: Boolean): FindUsagesHandler? {
        if (forHighlightUsages) return null

        val project = element.project
        service<ProFeaturePromptService>().tryShowNotification(
            project = project,
            source = ProFeatureEntryPoint.FIND_USAGES,
            title = "Find every usage of this symbol — Nginx Pro",
            message = "Nginx Pro indexes variables, upstreams and includes so Find Usages lists every reference " +
                "across your config. Free 14-day trial, no account needed.",
            onInstall = {
                NginxProPluginInstaller.openInstallDialog(project, ProFeatureEntryPoint.FIND_USAGES, "notification")
            }
        )
        // Decline to actually handle: lets the platform fall through to its default behavior.
        return null
    }
}
