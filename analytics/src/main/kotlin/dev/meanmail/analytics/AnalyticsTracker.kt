package dev.meanmail.analytics

import com.intellij.openapi.project.Project

abstract class AnalyticsTracker {
    protected abstract fun getSettings(): AnalyticsSettings
    protected abstract fun getMilestoneTracker(): MilestoneTracker
    protected abstract fun getFeatureUsageCounterService(project: Project): FeatureUsageCounterService

    fun onInspectionProblemsFound(project: Project, count: Int) {
        if (!getSettings().isEnabled) return
        if (count <= 0) return
        getFeatureUsageCounterService(project).incrementInspections(count)
        getMilestoneTracker().recordMilestone("first_inspection")
    }

    fun onQuickFixApplied(project: Project) {
        if (!getSettings().isEnabled) return
        getFeatureUsageCounterService(project).incrementQuickFixes()
        getMilestoneTracker().recordMilestone("first_quick_fix")
    }

    fun onCompletionAccepted(project: Project) {
        if (!getSettings().isEnabled) return
        getFeatureUsageCounterService(project).incrementCompletions()
        getMilestoneTracker().recordMilestone("first_completion")
    }

    fun onNavigationResolved(project: Project) {
        if (!getSettings().isEnabled) return
        getFeatureUsageCounterService(project).incrementNavigations()
        getMilestoneTracker().recordMilestone("first_navigation")
    }
}
