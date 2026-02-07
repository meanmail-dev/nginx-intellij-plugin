package dev.meanmail.psi

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference

abstract class ValueStmtElement(node: ASTNode) : NginxCompositeElementBase(node), ReferenceElement {
    override val ref: String
        get() {
            return text
        }

    override fun getName(): String? {
        return null
    }

    override fun getNameIdentifier(): PsiElement {
        return this
    }

    override fun setName(name: @NlsSafe String): PsiElement {
        return this
    }

    override fun getReference(): PsiReference? {
        val reference = Reference(this)
        if (reference.resolve() == null) {
            return null
        }
        return reference
    }
}
