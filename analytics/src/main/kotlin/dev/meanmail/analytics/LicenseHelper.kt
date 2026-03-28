package dev.meanmail.analytics

import com.intellij.ui.LicensingFacade
import java.util.Date
import java.util.concurrent.TimeUnit

object LicenseHelper {
    enum class LicenseType {
        TRIAL, PAID, EXPIRED, FREE, NONE
    }

    fun getLicenseType(config: AnalyticsConfig): LicenseType {
        val productCode = config.productCode
            ?: return LicenseType.FREE

        val facade = LicensingFacade.getInstance()
            ?: return LicenseType.NONE

        val expirationDate = facade.getExpirationDate(productCode)

        if (expirationDate != null && expirationDate.before(Date())) {
            return LicenseType.EXPIRED
        }

        if (facade.isEvaluationLicense) {
            return LicenseType.TRIAL
        }

        if (facade.getLicensedToMessage() != null) {
            return LicenseType.PAID
        }

        return LicenseType.NONE
    }

    fun getTrialDay(config: AnalyticsConfig): Int? {
        if (getLicenseType(config) != LicenseType.TRIAL) return null
        val daysRemaining = getDaysUntilExpiration(config) ?: return null
        return (config.trialDurationDays - daysRemaining).coerceIn(1, config.trialDurationDays)
    }

    fun getDaysUntilExpiration(config: AnalyticsConfig): Int? {
        val productCode = config.productCode ?: return null
        val facade = LicensingFacade.getInstance() ?: return null
        val expirationDate = facade.getExpirationDate(productCode) ?: return null
        val diff = expirationDate.time - System.currentTimeMillis()
        if (diff <= 0) return 0
        return TimeUnit.MILLISECONDS.toDays(diff).toInt()
    }

    fun getLicenseProperties(config: AnalyticsConfig): Map<String, Any?> {
        return buildMap {
            put("license_type", getLicenseType(config).name.lowercase())
            put("trial_day", getTrialDay(config))
            put("days_until_expiration", getDaysUntilExpiration(config))
        }
    }
}
