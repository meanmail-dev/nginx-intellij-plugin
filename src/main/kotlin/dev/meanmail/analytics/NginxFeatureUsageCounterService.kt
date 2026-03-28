package dev.meanmail.analytics

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project

@Service(Service.Level.PROJECT)
class NginxFeatureUsageCounterService(project: Project) : FeatureUsageCounterService(project) {
    override fun getSettings(): AnalyticsSettings = service<NginxAnalyticsSettings>()
    override fun getAnalyticsService(): AnalyticsService = NginxAnalyticsService.getInstance()

    companion object {
        fun getInstance(project: Project): NginxFeatureUsageCounterService = project.service()
    }
}
