package dev.meanmail.analytics

import com.intellij.openapi.components.service

class NginxFreeAnalyticsSettingsConfigurable : AnalyticsSettingsConfigurable() {
    override fun getConfig(): AnalyticsConfig = NginxAnalyticsConfig()
    override fun getSettings(): AnalyticsSettings = service<NginxFreeAnalyticsSettings>()
    override fun getAnalyticsService(): AnalyticsService = NginxFreeAnalyticsService.getInstance()
}
