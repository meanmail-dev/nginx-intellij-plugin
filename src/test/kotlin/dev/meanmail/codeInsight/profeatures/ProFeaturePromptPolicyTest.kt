package dev.meanmail.codeInsight.profeatures

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ProFeaturePromptPolicyTest {
    private val day = 24L * 60L * 60L * 1000L

    @Test
    fun `blocks when session cap reached`() {
        val policy = ProFeaturePromptPolicy(sessionNotificationCap = 1)
        val state = ProFeaturePromptState()

        val allowed = policy.canShow(
            source = ProFeatureEntryPoint.FORMAT,
            nowMillis = 10 * day,
            state = state,
            shownNotificationsThisSession = 1
        )

        assertFalse(allowed)
    }

    @Test
    fun `blocks when show cooldown not elapsed`() {
        val policy = ProFeaturePromptPolicy(showCooldownDays = 7)
        val state = ProFeaturePromptState().apply {
            lastShownAtBySource[ProFeatureEntryPoint.FORMAT.name] = 10 * day
        }

        val allowed = policy.canShow(
            source = ProFeatureEntryPoint.FORMAT,
            nowMillis = 15 * day,
            state = state,
            shownNotificationsThisSession = 0
        )

        assertFalse(allowed)
    }

    @Test
    fun `allows when all cooldowns elapsed`() {
        val policy = ProFeaturePromptPolicy(showCooldownDays = 7, dismissCooldownDays = 14, clickCooldownDays = 30)
        val state = ProFeaturePromptState().apply {
            lastShownAtBySource[ProFeatureEntryPoint.UNKNOWN_DIRECTIVE.name] = 1 * day
            lastDismissedAtBySource[ProFeatureEntryPoint.UNKNOWN_DIRECTIVE.name] = 1 * day
            lastClickedAtBySource[ProFeatureEntryPoint.UNKNOWN_DIRECTIVE.name] = 1 * day
        }

        val allowed = policy.canShow(
            source = ProFeatureEntryPoint.UNKNOWN_DIRECTIVE,
            nowMillis = 40 * day,
            state = state,
            shownNotificationsThisSession = 0
        )

        assertTrue(allowed)
    }
}
