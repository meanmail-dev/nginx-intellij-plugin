package dev.meanmail.analytics

import com.intellij.openapi.components.service

class NginxAnalyticsConsentActivity : AnalyticsConsentActivity() {
    override fun getConfig(): AnalyticsConfig = NginxAnalyticsConfig()
    override fun getSettings(): AnalyticsSettings = service<NginxAnalyticsSettings>()
    override fun getMilestoneTracker(): MilestoneTracker = service<NginxMilestoneTracker>()
    override fun getAnalyticsService(): AnalyticsService = NginxAnalyticsService.getInstance()
}
