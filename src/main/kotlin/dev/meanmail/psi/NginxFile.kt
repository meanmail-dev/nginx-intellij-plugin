package dev.meanmail.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import dev.meanmail.NginxFileType
import dev.meanmail.NginxLanguage


class NginxFile(viewProvider: FileViewProvider) :
    PsiFileBase(viewProvider, NginxLanguage) {

    override fun getFileType(): FileType {
        return NginxFileType.INSTANCE
    }

    override fun toString(): String {
        return "Nginx configuration file"
    }

}
