package dev.meanmail.codeInsight

import com.intellij.openapi.components.service
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.impl.source.codeStyle.PostFormatProcessor
import dev.meanmail.NginxFileType
import dev.meanmail.codeInsight.profeatures.ProFeaturePromptService
import dev.meanmail.codeInsight.profeatures.ProFeatureEntryPoint

class NginxProFormatNotifier : PostFormatProcessor {

    override fun processElement(source: PsiElement, settings: CodeStyleSettings): PsiElement = source

    override fun processText(source: PsiFile, rangeToReformat: TextRange, settings: CodeStyleSettings): TextRange {
        if (source.fileType !is NginxFileType) return rangeToReformat

        val project = source.project
        service<ProFeaturePromptService>().tryShowNotification(
            project = project,
            source = ProFeatureEntryPoint.FORMAT,
            title = "Keep map, geo and upstream blocks aligned automatically",
            message = "Nginx Pro aligns values in map/geo/types/upstream blocks every time you reformat, " +
                "so large configs stay readable without manual spacing. Free 14-day trial, no account needed.",
            onInstall = {
                NginxProPluginInstaller.openInstallDialog(project, ProFeatureEntryPoint.FORMAT, "notification")
            }
        )

        return rangeToReformat
    }
}
