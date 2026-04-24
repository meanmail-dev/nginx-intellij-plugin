package dev.meanmail.analytics

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.service

@State(name = "NginxMilestones", storages = [Storage("nginx-milestones.xml")])
@Service
class NginxFreeMilestoneTracker : MilestoneTracker() {
    override fun getSettings(): AnalyticsSettings = service<NginxFreeAnalyticsSettings>()
    override fun getAnalyticsService(): AnalyticsService = NginxFreeAnalyticsService.getInstance()
}
