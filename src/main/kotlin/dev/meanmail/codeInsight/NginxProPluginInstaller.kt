package dev.meanmail.codeInsight

import com.intellij.ide.plugins.PluginManagerConfigurable
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.project.Project

object NginxProPluginInstaller {
    private val proPluginId: PluginId = PluginId.getId("dev.meanmail.plugin.nginx-intellij-plugin-pro")

    fun openInstallDialog(project: Project?) {
        PluginManagerConfigurable.showPluginConfigurable(project, listOf(proPluginId))
    }
}
