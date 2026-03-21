package dev.meanmail.analytics

import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity

class AnalyticsConsentActivity : ProjectActivity {
    override suspend fun execute(project: Project) {
        val settings = AnalyticsSettings.getInstance()
        val config = AnalyticsConfig.getInstance()

        if (settings.consentState != ConsentState.NOT_ASKED) {
            if (settings.isEnabled) {
                MilestoneTracker.getInstance().ensureFirstLoadTimestamp()
                AnalyticsService.getInstance().capture(
                    "plugin_loaded", LicenseHelper.getLicenseProperties()
                )
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
                MilestoneTracker.getInstance().ensureFirstLoadTimestamp()
                val service = AnalyticsService.getInstance()
                service.identify()
                service.capture("plugin_loaded", LicenseHelper.getLicenseProperties())
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
