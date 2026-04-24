package dev.meanmail.analytics

import com.intellij.openapi.components.service

class NginxFreeAnalyticsConsentActivity : AnalyticsConsentActivity() {
    override fun getConfig(): AnalyticsConfig = NginxAnalyticsConfig()
    override fun getSettings(): AnalyticsSettings = service<NginxFreeAnalyticsSettings>()
    override fun getMilestoneTracker(): MilestoneTracker = service<NginxFreeMilestoneTracker>()
    override fun getAnalyticsService(): AnalyticsService = NginxFreeAnalyticsService.getInstance()
}
