package dev.meanmail.codeInsight.profeatures

import com.intellij.openapi.components.service
import dev.meanmail.analytics.NginxFreeAnalyticsService

object ProFeaturePromptAnalytics {
    private const val EVENT_PROMPT_SHOWN = "pro_feature_prompt_shown"
    private const val EVENT_PROMPT_CLICKED = "pro_feature_prompt_clicked"
    private const val EVENT_PROMPT_DISMISSED = "pro_feature_prompt_dismissed"
    private const val EVENT_INSTALL_DIALOG_OPENED = "pro_feature_install_dialog_opened"

    fun onShown(source: ProFeatureEntryPoint, surface: String) {
        capture(EVENT_PROMPT_SHOWN, source, surface)
    }

    fun onClicked(source: ProFeatureEntryPoint, surface: String) {
        capture(EVENT_PROMPT_CLICKED, source, surface)
    }

    fun onDismissed(source: ProFeatureEntryPoint, surface: String) {
        capture(EVENT_PROMPT_DISMISSED, source, surface)
    }

    fun onInstallDialogOpened(source: ProFeatureEntryPoint, surface: String) {
        capture(EVENT_INSTALL_DIALOG_OPENED, source, surface)
    }

    private fun capture(event: String, source: ProFeatureEntryPoint, surface: String) {
        service<NginxFreeAnalyticsService>().capture(
            event = event,
            properties = mapOf(
                "source" to source.name.lowercase(),
                "surface" to surface
            )
        )
    }
}
