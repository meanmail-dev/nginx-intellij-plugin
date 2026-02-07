package dev.meanmail.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import org.jetbrains.annotations.NotNull

open class NginxCompositeElementBase(node: ASTNode) : ASTWrapperPsiElement(node), NginxCompositeElement {

    override fun accept(@NotNull visitor: Visitor) {
        visitor.visitPsiElement(this)
    }

    override fun accept(@NotNull visitor: PsiElementVisitor) {
        if (visitor is Visitor) accept(visitor) else super.accept(visitor)
    }
}
