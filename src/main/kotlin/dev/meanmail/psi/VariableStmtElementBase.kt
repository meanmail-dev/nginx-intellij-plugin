package dev.meanmail.psi

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement

abstract class VariableStmtElementBase(node: ASTNode) : NginxCompositeElementBase(node), NamedElement {

    override fun getName(): String? {
        val text = text ?: return null
        // Strip $ prefix and optional { } braces
        return text.removePrefix("\$").removePrefix("{").removeSuffix("}")
    }

    override fun getNameIdentifier(): PsiElement {
        return this
    }

    override fun setName(name: @NlsSafe String): PsiElement {
        return this
    }
}
