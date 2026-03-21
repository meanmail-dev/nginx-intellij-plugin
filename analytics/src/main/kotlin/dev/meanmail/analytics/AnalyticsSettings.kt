package dev.meanmail.analytics

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.service

class AnalyticsSettingsState {
    var consentState: ConsentState = ConsentState.NOT_ASKED
}

abstract class AnalyticsSettings : PersistentStateComponent<AnalyticsSettingsState> {
    private var state = AnalyticsSettingsState()

    override fun getState(): AnalyticsSettingsState = state

    override fun loadState(state: AnalyticsSettingsState) {
        this.state = state
    }

    var consentState: ConsentState
        get() = state.consentState
        set(value) {
            state.consentState = value
        }

    val isEnabled: Boolean
        get() = consentState == ConsentState.ACCEPTED

    companion object {
        fun getInstance(): AnalyticsSettings = service()
    }
}
