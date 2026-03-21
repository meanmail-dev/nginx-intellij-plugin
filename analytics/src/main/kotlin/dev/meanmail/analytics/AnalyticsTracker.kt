package dev.meanmail.analytics

import com.intellij.openapi.project.Project

object AnalyticsTracker {
    fun onInspectionProblemsFound(project: Project, count: Int) {
        if (!AnalyticsSettings.getInstance().isEnabled) return
        if (count <= 0) return
        FeatureUsageCounterService.getInstance(project).incrementInspections(count)
        MilestoneTracker.getInstance().recordMilestone("first_inspection")
    }

    fun onQuickFixApplied(project: Project) {
        if (!AnalyticsSettings.getInstance().isEnabled) return
        FeatureUsageCounterService.getInstance(project).incrementQuickFixes()
        MilestoneTracker.getInstance().recordMilestone("first_quick_fix")
    }

    fun onCompletionAccepted(project: Project) {
        if (!AnalyticsSettings.getInstance().isEnabled) return
        FeatureUsageCounterService.getInstance(project).incrementCompletions()
        MilestoneTracker.getInstance().recordMilestone("first_completion")
    }

    fun onNavigationResolved(project: Project) {
        if (!AnalyticsSettings.getInstance().isEnabled) return
        FeatureUsageCounterService.getInstance(project).incrementNavigations()
        MilestoneTracker.getInstance().recordMilestone("first_navigation")
    }
}
