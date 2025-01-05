package dev.meanmail


import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.annotations.NonNls
import javax.swing.Icon


object NginxFileType : LanguageFileType(NginxLanguage) {

    @NonNls
    private val DEFAULT_EXTENSION = "conf"

    override fun getName(): String {
        return NginxLanguage.id
    }

    override fun getDescription(): String {
        return "Nginx configuration file"
    }

    override fun getDefaultExtension(): String {
        return DEFAULT_EXTENSION
    }

    override fun getIcon(): Icon {
        return AllIcons.FILE
    }

}
