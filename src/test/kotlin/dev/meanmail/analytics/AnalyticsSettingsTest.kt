package dev.meanmail.analytics

import com.intellij.openapi.application.runWriteAction
import com.intellij.testFramework.fixtures.BasePlatformTestCase

class AnalyticsSettingsTest : BasePlatformTestCase() {
    fun testConsentStateUpdateInsideWriteActionDoesNotFail() {
        val settings = NginxFreeAnalyticsSettings()

        runWriteAction {
            settings.consentState = ConsentState.ACCEPTED
        }

        assertEquals(ConsentState.ACCEPTED, settings.consentState)
    }
}
