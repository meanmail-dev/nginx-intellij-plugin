package dev.meanmail.codeInsight

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class NginxProPluginInstallerTest {
    @Test
    fun `reentrant install dialog open is ignored`() {
        var openCount = 0

        lateinit var opener: (com.intellij.openapi.project.Project?, String) -> Unit
        opener = { project, query ->
            openCount++
            NginxProPluginInstaller.openInstallDialog(project, opener)
            assertEquals(
                "Nginx Configuration Pro dev.meanmail.plugin.nginx-intellij-plugin-pro",
                query
            )
        }

        NginxProPluginInstaller.openInstallDialog(null, opener)

        assertEquals(1, openCount)
        assertFalse(NginxProPluginInstaller.isDialogOpeningForTests())

        NginxProPluginInstaller.resetDialogOpeningStateForTests()
    }
}
