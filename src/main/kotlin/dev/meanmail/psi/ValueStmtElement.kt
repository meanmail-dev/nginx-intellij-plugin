package dev.meanmail.psi

import com.intellij.lang.ASTNode
import com.intellij.openapi.paths.WebReference
import com.intellij.openapi.util.NlsSafe
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference

abstract class ValueStmtElement(node: ASTNode) : NginxCompositeElementBase(node), ReferenceElement {
    override val ref: String
        get() {
            val text = text
            if (text.length >= 2 &&
                (text.startsWith("\"") && text.endsWith("\"") ||
                    text.startsWith("'") && text.endsWith("'"))
            ) {
                return text.substring(1, text.length - 1)
            }
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
        val ref = ref
        if (ref.startsWith("http://") || ref.startsWith("https://")) {
            val text = text
            val offset = if (text.startsWith("\"") || text.startsWith("'")) 1 else 0
            return WebReference(this, TextRange(offset, offset + ref.length), ref)
        }
        val reference = Reference(this)
        if (reference.resolve() == null) {
            return null
        }
        return reference
    }
}
