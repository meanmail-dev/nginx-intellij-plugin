package dev.meanmail.analytics

import com.intellij.openapi.components.service

class NginxAnalyticsSettingsConfigurable : AnalyticsSettingsConfigurable() {
    override fun getConfig(): AnalyticsConfig = NginxAnalyticsConfig()
    override fun getSettings(): AnalyticsSettings = service<NginxAnalyticsSettings>()
    override fun getAnalyticsService(): AnalyticsService = NginxAnalyticsService.getInstance()
}
