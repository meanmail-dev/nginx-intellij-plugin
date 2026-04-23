package dev.meanmail.codeInsight

import com.intellij.openapi.extensions.PluginId
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class NginxProPluginInstallerTest {
    @Test
    fun `reentrant install dialog open is ignored`() {
        var openCount = 0

        lateinit var installer: (com.intellij.openapi.project.Project?, Set<PluginId>) -> Unit
        installer = { project, pluginIds ->
            openCount++
            NginxProPluginInstaller.openInstallDialog(project, installer)
            assertEquals(
                setOf(PluginId.getId("dev.meanmail.plugin.nginx-intellij-plugin-pro")),
                pluginIds
            )
        }

        NginxProPluginInstaller.openInstallDialog(null, installer)

        assertEquals(1, openCount)
        assertFalse(NginxProPluginInstaller.isDialogOpeningForTests())

        NginxProPluginInstaller.resetDialogOpeningStateForTests()
    }
}
