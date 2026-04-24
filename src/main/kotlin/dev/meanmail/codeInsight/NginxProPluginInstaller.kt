package dev.meanmail.codeInsight

import com.intellij.ide.plugins.PluginManagerConfigurable
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.project.Project

object NginxProPluginInstaller {
    private val proPluginId: PluginId = PluginId.getId("dev.meanmail.plugin.nginx-intellij-plugin-pro")
    private val isOpeningDialog = ThreadLocal.withInitial { false }

    fun openInstallDialog(project: Project?) {
        openInstallDialog(project) { targetProject, pluginIds ->
            installAndEnableViaAdvertiser(targetProject, pluginIds)
        }
    }

    internal fun openInstallDialog(project: Project?, installer: (Project?, Set<PluginId>) -> Unit) {
        if (isOpeningDialog.get()) {
            return
        }

        isOpeningDialog.set(true)
        try {
            installer(project, setOf(proPluginId))
        } finally {
            isOpeningDialog.set(false)
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
            PluginManagerConfigurable.showPluginConfigurable(project, pluginIds)
        }
    }
}
