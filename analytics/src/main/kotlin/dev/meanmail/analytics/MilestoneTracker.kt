package dev.meanmail.analytics

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.service

class MilestoneTrackerState {
    var firedMilestones: MutableSet<String> = mutableSetOf()
    var firstLoadTimestamp: Long = 0L
}

abstract class MilestoneTracker : PersistentStateComponent<MilestoneTrackerState> {
    private var state = MilestoneTrackerState()

    override fun getState(): MilestoneTrackerState = state

    override fun loadState(state: MilestoneTrackerState) {
        this.state = state
    }

    var firedMilestones: MutableSet<String>
        get() = state.firedMilestones
        set(value) {
            state.firedMilestones = value
        }

    var firstLoadTimestamp: Long
        get() = state.firstLoadTimestamp
        set(value) {
            state.firstLoadTimestamp = value
        }

    fun recordMilestone(milestone: String) {
        if (!AnalyticsSettings.getInstance().isEnabled) return
        if (milestone in firedMilestones) return

        firedMilestones.add(milestone)

        val minutesSinceFirstLoad = if (firstLoadTimestamp > 0) {
            ((System.currentTimeMillis() - firstLoadTimestamp) / 60_000).toInt()
        } else {
            null
        }

        val properties = buildMap {
            put("milestone", milestone)
            put("minutes_since_first_load", minutesSinceFirstLoad)
            putAll(LicenseHelper.getLicenseProperties())
        }
        AnalyticsService.getInstance().capture("trial_milestone", properties)
    }

    fun ensureFirstLoadTimestamp() {
        if (firstLoadTimestamp == 0L) {
            firstLoadTimestamp = System.currentTimeMillis()
        }
    }

    companion object {
        fun getInstance(): MilestoneTracker = service()
    }
}
