package dev.meanmail.analytics

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.options.Configurable
import java.awt.BorderLayout
import javax.swing.JCheckBox
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel

abstract class AnalyticsSettingsConfigurable : Configurable {
    protected abstract fun getConfig(): AnalyticsConfig
    protected abstract fun getSettings(): AnalyticsSettings
    protected abstract fun getAnalyticsService(): AnalyticsService

    private var enabledCheckBox: JCheckBox? = null

    override fun getDisplayName(): String = getConfig().settingsDisplayName

    override fun createComponent(): JComponent {
        val config = getConfig()
        val panel = JPanel(BorderLayout())

        enabledCheckBox = JCheckBox(config.checkboxLabel).apply {
            isSelected = getSettings().isEnabled
        }
        panel.add(enabledCheckBox!!, BorderLayout.NORTH)

        val description = JLabel(config.descriptionHtml)
        panel.add(description, BorderLayout.CENTER)

        return panel
    }

    override fun isModified(): Boolean {
        return enabledCheckBox?.isSelected != getSettings().isEnabled
    }

    override fun apply() {
        val settings = getSettings()
        val wasEnabled = settings.isEnabled
        settings.consentState = if (enabledCheckBox?.isSelected == true) {
            ConsentState.ACCEPTED
        } else {
            ConsentState.DECLINED
        }

        if (!wasEnabled && settings.isEnabled) {
            ApplicationManager.getApplication().executeOnPooledThread {
                val service = getAnalyticsService()
                service.identify()
                service.capture("analytics_enabled_from_settings")
            }
        }
    }
}
