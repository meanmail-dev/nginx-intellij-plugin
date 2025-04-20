package dev.meanmail


import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon


class NginxFileType : LanguageFileType(NginxLanguage) {
    override fun getName(): String {
        return NginxLanguage.id
    }

    override fun getDescription(): String {
        return "Nginx configuration file"
    }

    override fun getDefaultExtension(): String {
        return "conf"
    }

    override fun getIcon(): Icon {
        return AllIcons.FILE
    }

    companion object {
        val INSTANCE: NginxFileType = NginxFileType()
    }
}
