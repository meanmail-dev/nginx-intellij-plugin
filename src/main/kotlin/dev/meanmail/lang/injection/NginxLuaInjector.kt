package dev.meanmail.lang.injection

import com.intellij.lang.Language
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import dev.meanmail.psi.LuaCodeStmt


class NginxLuaInjector : MultiHostInjector {
    override fun getLanguagesToInject(
        registrar: MultiHostRegistrar, context: PsiElement
    ) {
        val language = Language.findLanguageByID("Lua") ?: return
        if (context is LuaCodeStmt) {
            registrar
                .startInjecting(language)
                .addPlace(
                    null, null,
                    context, TextRange(0, context.textLength)
                ).doneInjecting()
        }
    }

    override fun elementsToInjectIn(): MutableList<out Class<out PsiElement>> {
        return mutableListOf(LuaCodeStmt::class.java)
    }
}
