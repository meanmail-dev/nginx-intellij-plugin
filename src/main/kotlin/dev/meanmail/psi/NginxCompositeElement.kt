package dev.meanmail.psi

import com.intellij.psi.PsiElement
import org.jetbrains.annotations.NotNull

interface NginxCompositeElement : PsiElement {
    fun accept(@NotNull visitor: Visitor)
}
