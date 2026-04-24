package dev.meanmail.codeInsight

import com.intellij.openapi.extensions.PluginId
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class NginxProPluginInstallerTest {
    @Test
    fun `reentrant install dialog open is ignored`() {
        var openCount = 0

        lateinit var installer: (com.intellij.openapi.project.Project?, Set<PluginId>) -> Unit
        installer = { project, pluginIds ->
            openCount++
            NginxProPluginInstaller.openInstallDialog(project, installer) { runnable -> runnable.run() }
            assertEquals(
                setOf(PluginId.getId("dev.meanmail.plugin.nginx-intellij-plugin-pro")),
                pluginIds
            )
        }

        NginxProPluginInstaller.openInstallDialog(null, installer) { runnable -> runnable.run() }

        assertEquals(1, openCount)
        assertFalse(NginxProPluginInstaller.isDialogOpeningForTests())

        NginxProPluginInstaller.resetDialogOpeningStateForTests()
    }

    @Test
    fun `install flow is scheduled and not executed inline`() {
        var openCount = 0
        var scheduled: Runnable? = null

        NginxProPluginInstaller.openInstallDialog(
            project = null,
            installer = { _, _ -> openCount++ },
            scheduler = { runnable -> scheduled = runnable }
        )

        assertEquals(0, openCount)
        assertTrue(NginxProPluginInstaller.isDialogOpeningForTests())
        assertTrue(scheduled != null)

        scheduled!!.run()

        assertEquals(1, openCount)
        assertFalse(NginxProPluginInstaller.isDialogOpeningForTests())

        NginxProPluginInstaller.resetDialogOpeningStateForTests()
    }
}
