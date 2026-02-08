package dev.meanmail.codeInsight

import com.intellij.ide.BrowserUtil
import com.intellij.notification.NotificationAction
import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.impl.source.codeStyle.PostFormatProcessor
import dev.meanmail.NginxFileType

class NginxProFormatNotifier : PostFormatProcessor {

    override fun processElement(source: PsiElement, settings: CodeStyleSettings): PsiElement = source

    override fun processText(source: PsiFile, rangeToReformat: TextRange, settings: CodeStyleSettings): TextRange {
        if (source.fileType !is NginxFileType) return rangeToReformat

        val project = source.project
        ApplicationManager.getApplication().invokeLater {
            val url = "https://meanmail.dev/nginx-pro?utm_source=free_plugin&utm_medium=format"
            NotificationGroupManager.getInstance()
                .getNotificationGroup("Nginx Pro Features")
                .createNotification(
                    "Auto-formatting for Nginx configuration files is available in Nginx Pro",
                    NotificationType.INFORMATION
                )
                .addAction(NotificationAction.createSimpleExpiring("Learn more") {
                    BrowserUtil.browse(url)
                })
                .notify(project)
        }

        return rangeToReformat
    }
}
