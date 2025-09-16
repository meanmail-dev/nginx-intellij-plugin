package dev.meanmail

import com.intellij.lang.Language

object NginxLanguage : Language("Nginx Configuration") {
    private fun readResolve(): Any = NginxLanguage
}
