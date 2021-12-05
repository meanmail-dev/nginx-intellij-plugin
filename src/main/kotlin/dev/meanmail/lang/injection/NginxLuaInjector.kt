package dev.meanmail.lang.injection

import com.intellij.lang.Language
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import dev.meanmail.psi.LuaStmt


class NginxLuaInjector : MultiHostInjector {
    override fun getLanguagesToInject(
        registrar: MultiHostRegistrar, context: PsiElement
    ) {
        val language = Language.findLanguageByID("Lua") ?: return
        if (context is LuaStmt) {
            registrar
                .startInjecting(language)
                .addPlace(
                    null, null,
                    context, TextRange(0, context.textLength)
                ).doneInjecting()
        }
    }

    override fun elementsToInjectIn(): MutableList<out Class<out PsiElement>> {
        return mutableListOf(LuaStmt::class.java)
    }
}
