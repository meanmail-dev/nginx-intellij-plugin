package dev.meanmail.analytics

import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity

abstract class AnalyticsConsentActivity : ProjectActivity {
    protected abstract fun getConfig(): AnalyticsConfig
    protected abstract fun getSettings(): AnalyticsSettings
    protected abstract fun getMilestoneTracker(): MilestoneTracker
    protected abstract fun getAnalyticsService(): AnalyticsService

    override suspend fun execute(project: Project) {
        val settings = getSettings()
        val config = getConfig()

        if (settings.consentState != ConsentState.NOT_ASKED) {
            if (settings.isEnabled) {
                getMilestoneTracker().ensureFirstLoadTimestamp()
                getAnalyticsService().capture("plugin_loaded")
            }
            return
        }

        val notification = NotificationGroupManager.getInstance()
            .getNotificationGroup(config.notificationGroupId)
            .createNotification(
                config.pluginDisplayName,
                config.notificationBody,
                NotificationType.INFORMATION
            )

        notification.addAction(object : AnAction("Allow") {
            override fun actionPerformed(e: AnActionEvent) {
                settings.consentState = ConsentState.ACCEPTED
                notification.expire()
                getMilestoneTracker().ensureFirstLoadTimestamp()
                val service = getAnalyticsService()
                service.identify()
                service.capture("plugin_loaded")
                service.capture("analytics_consent", mapOf("consent" to "accepted"))
            }
        })

        notification.addAction(object : AnAction("Deny") {
            override fun actionPerformed(e: AnActionEvent) {
                settings.consentState = ConsentState.DECLINED
                notification.expire()
            }
        })

        notification.notify(project)
    }
}
