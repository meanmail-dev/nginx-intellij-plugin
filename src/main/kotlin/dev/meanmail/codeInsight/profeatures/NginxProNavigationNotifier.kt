package dev.meanmail.codeInsight.profeatures

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler
import com.intellij.openapi.components.service
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import dev.meanmail.codeInsight.NginxProPluginInstaller
import dev.meanmail.psi.Types

/**
 * High-intent Pro upsell on the navigation "wall".
 *
 * The free plugin resolves include file paths but does not navigate nginx
 * variables (`$uri`, `$backend`, ...) — that is a Pro feature. When a user
 * explicitly invokes Go to Declaration on a variable, there is nothing to jump
 * to, so we surface the Pro navigation feature instead of doing nothing.
 *
 * Display frequency is bounded by [ProFeaturePromptPolicy] (at most once per
 * session, with a multi-day cooldown), so this stays unobtrusive even though
 * the platform also calls this handler on Ctrl-hover.
 */
class NginxProNavigationNotifier : GotoDeclarationHandler {

    override fun getGotoDeclarationTargets(
        sourceElement: PsiElement?,
        offset: Int,
        editor: Editor?
    ): Array<PsiElement>? {
        if (!isVariableReference(sourceElement)) return null

        val element = sourceElement!!
        val project = element.project
        service<ProFeaturePromptService>().tryShowNotification(
            project = project,
            source = ProFeatureEntryPoint.NAVIGATION,
            title = "Go to where ${element.text} is defined — Nginx Pro",
            message = "Nginx Pro resolves variables, upstreams and includes, so Go to Definition and " +
                "Find Usages work across your whole config. Free 14-day trial, no account needed.",
            onInstall = {
                NginxProPluginInstaller.openInstallDialog(project, ProFeatureEntryPoint.NAVIGATION, "notification")
            }
        )
        return null
    }

    companion object {
        /** A variable leaf (`$name`) is the high-intent navigation target the free plugin cannot resolve. */
        fun isVariableReference(element: PsiElement?): Boolean {
            return element?.node?.elementType == Types.VARIABLE
        }
    }
}
