package dev.meanmail.analytics

interface AnalyticsConfig {
    /** PostHog project API key */
    val posthogApiKey: String

    /** Plugin ID as registered in plugin.xml */
    val pluginId: String

    /** Notification group ID (must match plugin.xml notificationGroup id) */
    val notificationGroupId: String

    /** Plugin display name shown in consent notification title */
    val pluginDisplayName: String

    /**
     * Product code from plugin.xml productDescriptor.
     * Set to null for free plugins (disables license tracking).
     */
    val productCode: String?
        get() = null

    /** Trial duration in days (only relevant when productCode is set) */
    val trialDurationDays: Int
        get() = 30

    /** PostHog API host */
    val posthogHost: String
        get() = "https://us.i.posthog.com"

    /** Consent notification body text */
    val notificationBody: String
        get() = "Help improve the plugin by sending anonymous usage statistics " +
                "(IDE version, OS, plugin version). No personal data or file contents are collected."

    /** Display name in Preferences → Tools */
    val settingsDisplayName: String
        get() = "$pluginDisplayName Analytics"

    /** Checkbox label in analytics settings */
    val checkboxLabel: String
        get() = "Send anonymous usage statistics (IDE version, OS, plugin version)"

    /** Description HTML shown below the checkbox in settings */
    val descriptionHtml: String
        get() = "<html><body style='width:100%'><p style='margin-top:8px;color:gray;'>" +
                "No personal data or file contents are collected. " +
                "This helps us understand which IDE versions and platforms to prioritize." +
                "</p></body></html>"
}
