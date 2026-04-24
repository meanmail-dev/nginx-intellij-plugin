package dev.meanmail.codeInsight

import com.intellij.notification.NotificationAction
import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.options.ShowSettingsUtil
import com.intellij.openapi.project.Project

object NginxProPluginInstaller {
    private val proPluginId: PluginId = PluginId.getId("dev.meanmail.plugin.nginx-intellij-plugin-pro")
    private val isOpeningDialog = ThreadLocal.withInitial { false }

    fun openInstallDialog(project: Project?) {
        openInstallDialog(
            project = project,
            installer = { targetProject, pluginIds ->
                installAndEnableViaAdvertiser(targetProject, pluginIds)
            },
            scheduler = { runnable ->
                ApplicationManager.getApplication().invokeLater(runnable)
            }
        )
    }

    internal fun openInstallDialog(
        project: Project?,
        installer: (Project?, Set<PluginId>) -> Unit,
        scheduler: (Runnable) -> Unit
    ) {
        if (isOpeningDialog.get()) {
            return
        }

        isOpeningDialog.set(true)
        try {
            scheduler(
                Runnable {
                    try {
                        installer(project, setOf(proPluginId))
                    } finally {
                        isOpeningDialog.set(false)
                    }
                }
            )
        } catch (t: Throwable) {
            isOpeningDialog.set(false)
            throw t
        }
    }

    internal fun isDialogOpeningForTests(): Boolean {
        return isOpeningDialog.get()
    }

    internal fun resetDialogOpeningStateForTests() {
        isOpeningDialog.set(false)
    }

    private fun installAndEnableViaAdvertiser(project: Project?, pluginIds: Set<PluginId>) {
        val installed = runCatching {
            val advertiserClass = Class.forName(
                "com.intellij.openapi.updateSettings.impl.pluginsAdvertisement.PluginsAdvertiser"
            )
            val installMethod = advertiserClass.getMethod(
                "installAndEnable",
                Project::class.java,
                Set::class.java,
                Runnable::class.java
            )
            installMethod.invoke(null, project, pluginIds, Runnable { })
            true
        }.getOrDefault(false)

        if (!installed) {
            NotificationGroupManager.getInstance()
                .getNotificationGroup("Nginx Pro Features")
                .createNotification(
                    "Failed to install Nginx Pro plugin automatically. " +
                        "Please open Settings → Plugins and install \"Nginx Pro\" manually.",
                    NotificationType.WARNING
                )
                .addAction(NotificationAction.createSimpleExpiring("Open Plugins") {
                    ShowSettingsUtil.getInstance().showSettingsDialog(project, "Plugins")
                })
                .notify(project)
        }
    }
}
