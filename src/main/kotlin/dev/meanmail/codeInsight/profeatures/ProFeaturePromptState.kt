package dev.meanmail.codeInsight.profeatures

class ProFeaturePromptState {
    var lastShownAtBySource: MutableMap<String, Long> = mutableMapOf()
    var lastDismissedAtBySource: MutableMap<String, Long> = mutableMapOf()
    var lastClickedAtBySource: MutableMap<String, Long> = mutableMapOf()
}
