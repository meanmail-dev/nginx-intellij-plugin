package dev.meanmail.lang.injection

import com.intellij.lang.Language
import com.intellij.lang.injection.general.Injection
import com.intellij.lang.injection.general.LanguageInjectionContributor
import com.intellij.lang.injection.general.SimpleInjection
import com.intellij.psi.PsiElement
import dev.meanmail.psi.LuaStmt


class NginxConfigInjector : LanguageInjectionContributor {
    override fun getInjection(context: PsiElement): Injection? {
        val language = Language.findLanguageByID("Lua") ?: return null
        if (context !is LuaStmt) {
            return null
        }

        return SimpleInjection(
            language, "", "", null
        )
    }
}
