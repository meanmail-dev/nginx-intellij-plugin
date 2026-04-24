package dev.meanmail.analytics

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project

@Service(Service.Level.PROJECT)
class NginxFreeFeatureUsageCounterService(project: Project) : FeatureUsageCounterService(project) {
    override fun getSettings(): AnalyticsSettings = service<NginxFreeAnalyticsSettings>()
    override fun getAnalyticsService(): AnalyticsService = NginxFreeAnalyticsService.getInstance()

    companion object {
        fun getInstance(project: Project): NginxFreeFeatureUsageCounterService = project.service()
    }
}
