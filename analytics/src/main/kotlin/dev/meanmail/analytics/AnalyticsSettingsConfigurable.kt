package dev.meanmail.analytics

import com.intellij.openapi.options.Configurable
import java.awt.BorderLayout
import javax.swing.JCheckBox
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel

class AnalyticsSettingsConfigurable : Configurable {
    private val settings = AnalyticsSettings.getInstance()
    private val config = AnalyticsConfig.getInstance()
    private var enabledCheckBox: JCheckBox? = null

    override fun getDisplayName(): String = config.settingsDisplayName

    override fun createComponent(): JComponent {
        val panel = JPanel(BorderLayout())

        enabledCheckBox = JCheckBox(config.checkboxLabel).apply {
            isSelected = settings.isEnabled
        }
        panel.add(enabledCheckBox!!, BorderLayout.NORTH)

        val description = JLabel(config.descriptionHtml)
        panel.add(description, BorderLayout.CENTER)

        return panel
    }

    override fun isModified(): Boolean {
        return enabledCheckBox?.isSelected != settings.isEnabled
    }

    override fun apply() {
        val wasEnabled = settings.isEnabled
        settings.consentState = if (enabledCheckBox?.isSelected == true) {
            ConsentState.ACCEPTED
        } else {
            ConsentState.DECLINED
        }

        if (!wasEnabled && settings.isEnabled) {
            val service = AnalyticsService.getInstance()
            service.identify()
            service.capture("analytics_enabled_from_settings")
        }
    }
}
