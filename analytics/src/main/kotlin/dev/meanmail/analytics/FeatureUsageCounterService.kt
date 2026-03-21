package dev.meanmail.analytics

import com.intellij.openapi.Disposable
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.util.concurrency.AppExecutorUtil
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

@Service(Service.Level.PROJECT)
class FeatureUsageCounterService(
    @Suppress("unused") private val project: Project
) : Disposable {
    private val inspectionsFound = AtomicInteger(0)
    private val quickFixesApplied = AtomicInteger(0)
    private val completionsAccepted = AtomicInteger(0)
    private val navigationsUsed = AtomicInteger(0)

    private val flushTask = AppExecutorUtil.getAppScheduledExecutorService()
        .scheduleWithFixedDelay(::flush, 30, 30, TimeUnit.MINUTES)

    fun incrementInspections(count: Int) {
        inspectionsFound.addAndGet(count)
    }

    fun incrementQuickFixes() {
        quickFixesApplied.incrementAndGet()
    }

    fun incrementCompletions() {
        completionsAccepted.incrementAndGet()
    }

    fun incrementNavigations() {
        navigationsUsed.incrementAndGet()
    }

    private fun flush() {
        if (!AnalyticsSettings.getInstance().isEnabled) return

        val inspections = inspectionsFound.getAndSet(0)
        val fixes = quickFixesApplied.getAndSet(0)
        val completions = completionsAccepted.getAndSet(0)
        val navigations = navigationsUsed.getAndSet(0)

        if (inspections == 0 && fixes == 0 && completions == 0 && navigations == 0) return

        val properties = buildMap {
            put("inspections_found", inspections)
            put("quick_fixes_applied", fixes)
            put("completions_accepted", completions)
            put("navigations_used", navigations)
            putAll(LicenseHelper.getLicenseProperties())
        }
        AnalyticsService.getInstance().capture("feature_value_delivered", properties)
    }

    override fun dispose() {
        flushTask.cancel(false)
        flush()
    }

    companion object {
        fun getInstance(project: Project): FeatureUsageCounterService = project.service()
    }
}
