package dev.meanmail.analytics

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service

@Service
class NginxFreeAnalyticsService : AnalyticsService(
    NginxAnalyticsConfig(),
    service<NginxFreeAnalyticsSettings>(),
) {
    companion object {
        fun getInstance(): NginxFreeAnalyticsService = service()
    }
}
