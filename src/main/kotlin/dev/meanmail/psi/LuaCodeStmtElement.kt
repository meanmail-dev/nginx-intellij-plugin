package dev.meanmail.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiLanguageInjectionHost

abstract class LuaCodeStmtElement(node: ASTNode) : NginxCompositeElementBase(node), PsiLanguageInjectionHost {
    override fun isValidHost(): Boolean {
        return true
    }

    override fun updateText(text: String): PsiLanguageInjectionHost {
        return this
    }

    override fun createLiteralTextEscaper(): LiteralTextEscaper<out PsiLanguageInjectionHost?> {
        return LiteralTextEscaper.createSimple(this)
    }
}
