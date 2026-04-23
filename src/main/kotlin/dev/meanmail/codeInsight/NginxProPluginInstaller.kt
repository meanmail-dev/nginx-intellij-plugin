package dev.meanmail.codeInsight

import com.intellij.ide.plugins.PluginManagerConfigurable
import com.intellij.openapi.options.ShowSettingsUtil
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.project.Project

object NginxProPluginInstaller {
    private val proPluginId: PluginId = PluginId.getId("dev.meanmail.plugin.nginx-intellij-plugin-pro")
    private const val marketplaceSearchQueryPrefix = "Nginx Configuration Pro"
    private val isOpeningDialog = ThreadLocal.withInitial { false }

    fun openInstallDialog(project: Project?) {
        openInstallDialog(project) { targetProject, query ->
            val configurable = PluginManagerConfigurable()
            var tabInitialized = false
            ShowSettingsUtil.getInstance().editConfigurable(targetProject, configurable) {
                if (!tabInitialized) {
                    tabInitialized = true
                    configurable.openMarketplaceTab(query)
                }
            }
        }
    }

    internal fun openInstallDialog(project: Project?, opener: (Project?, String) -> Unit) {
        if (isOpeningDialog.get()) {
            return
        }

        isOpeningDialog.set(true)
        try {
            val searchQuery = "$marketplaceSearchQueryPrefix ${proPluginId.idString}"
            opener(project, searchQuery)
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
}
