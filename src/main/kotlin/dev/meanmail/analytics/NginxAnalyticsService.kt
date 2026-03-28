package dev.meanmail.analytics

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service

@Service
class NginxAnalyticsService : AnalyticsService(
    NginxAnalyticsConfig(),
    service<NginxAnalyticsSettings>(),
) {
    companion object {
        fun getInstance(): NginxAnalyticsService = service()
    }
}
