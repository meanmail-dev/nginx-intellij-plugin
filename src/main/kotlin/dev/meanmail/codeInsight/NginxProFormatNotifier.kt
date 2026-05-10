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
            title = "Advanced formatting is available in Nginx Pro",
            message = "For Nginx configs, Pro can align map/geo/types blocks during reformat.",
            onInstall = {
                NginxProPluginInstaller.openInstallDialog(project, ProFeatureEntryPoint.FORMAT, "notification")
            }
        )

        return rangeToReformat
    }
}
