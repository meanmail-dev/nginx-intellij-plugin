package dev.meanmail.codeInsight.profeatures

class ProFeaturePromptPolicy(
    private val sessionNotificationCap: Int = 1,
    private val showCooldownDays: Long = 7,
    private val dismissCooldownDays: Long = 14,
    private val clickCooldownDays: Long = 30,
) {
    fun canShow(
        source: ProFeatureEntryPoint,
        nowMillis: Long,
        state: ProFeaturePromptState,
        shownNotificationsThisSession: Int,
    ): Boolean {
        if (shownNotificationsThisSession >= sessionNotificationCap) return false
        if (!isCooldownElapsed(state.lastShownAtBySource[source.name], nowMillis, showCooldownDays)) return false
        if (!isCooldownElapsed(state.lastDismissedAtBySource[source.name], nowMillis, dismissCooldownDays)) return false
        if (!isCooldownElapsed(state.lastClickedAtBySource[source.name], nowMillis, clickCooldownDays)) return false
        return true
    }

    private fun isCooldownElapsed(timestamp: Long?, nowMillis: Long, cooldownDays: Long): Boolean {
        if (timestamp == null) return true
        val cooldownMillis = cooldownDays * 24 * 60 * 60 * 1000
        return nowMillis - timestamp >= cooldownMillis
    }
}
