package dev.meanmail.analytics

import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project

object NginxAnalyticsTracker : AnalyticsTracker() {
    override fun getSettings(): AnalyticsSettings = service<NginxAnalyticsSettings>()
    override fun getMilestoneTracker(): MilestoneTracker = service<NginxMilestoneTracker>()
    override fun getFeatureUsageCounterService(project: Project): FeatureUsageCounterService =
        NginxFeatureUsageCounterService.getInstance(project)
}
