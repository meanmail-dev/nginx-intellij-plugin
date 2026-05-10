package dev.meanmail.codeInsight.profeatures

import com.intellij.notification.NotificationAction
import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.project.Project

@State(name = "NginxProFeaturePromptState", storages = [Storage("nginx-pro-feature-prompt-state.xml")])
@Service(Service.Level.APP)
class ProFeaturePromptService : PersistentStateComponent<ProFeaturePromptState> {
    private var state = ProFeaturePromptState()
    private val policy = ProFeaturePromptPolicy()
    private var shownNotificationsThisSession = 0

    override fun getState(): ProFeaturePromptState = state

    override fun loadState(state: ProFeaturePromptState) {
        this.state = state
    }

    fun tryShowNotification(
        project: Project?,
        source: ProFeatureEntryPoint,
        title: String,
        message: String,
        actionText: String = "Enable Pro Features",
        onInstall: (() -> Unit)? = null
    ): Boolean {
        if (isProInstalled()) return false

        val now = System.currentTimeMillis()
        if (!policy.canShow(source, now, state, shownNotificationsThisSession)) {
            return false
        }

        state.lastShownAtBySource[source.name] = now
        shownNotificationsThisSession++
        ProFeaturePromptAnalytics.onShown(source, "notification")

        ApplicationManager.getApplication().invokeLater {
            val notification = NotificationGroupManager.getInstance()
                .getNotificationGroup("Nginx Pro Features")
                .createNotification(title, message, NotificationType.INFORMATION)

            notification.addAction(
                NotificationAction.createSimpleExpiring(actionText) {
                    state.lastClickedAtBySource[source.name] = System.currentTimeMillis()
                    ProFeaturePromptAnalytics.onClicked(source, "notification")
                    onInstall?.invoke()
                }
            )

            notification.whenExpired {
                state.lastDismissedAtBySource[source.name] = System.currentTimeMillis()
                ProFeaturePromptAnalytics.onDismissed(source, "notification")
            }

            notification.notify(project)
        }

        return true
    }

    private fun isProInstalled(): Boolean {
        val pluginId = PluginId.getId("dev.meanmail.plugin.nginx-intellij-plugin-pro")
        return com.intellij.ide.plugins.PluginManagerCore.getPlugin(pluginId) != null
    }
}
