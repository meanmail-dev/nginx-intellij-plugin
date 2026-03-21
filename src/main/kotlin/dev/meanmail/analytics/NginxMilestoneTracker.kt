package dev.meanmail.analytics

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@State(name = "NginxMilestones", storages = [Storage("nginx-milestones.xml")])
@Service
class NginxMilestoneTracker : MilestoneTracker()
