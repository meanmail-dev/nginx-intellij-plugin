package dev.meanmail.analytics

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@State(name = "NginxAnalytics", storages = [Storage("nginx-analytics.xml")])
@Service
class NginxFreeAnalyticsSettings : AnalyticsSettings()
