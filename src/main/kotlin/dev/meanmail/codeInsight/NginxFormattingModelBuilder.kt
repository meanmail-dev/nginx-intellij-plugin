package dev.meanmail.codeInsight

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.formatter.common.AbstractBlock

class NginxFormattingModelBuilder : FormattingModelBuilder {

    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        val file = formattingContext.psiElement.containingFile
        val block = NoOpBlock(file.node)
        return FormattingModelProvider.createFormattingModelForPsiFile(file, block, formattingContext.codeStyleSettings)
    }
}

private class NoOpBlock(node: ASTNode) : AbstractBlock(node, null, null) {
    override fun buildChildren(): List<Block> = emptyList()
    override fun getSpacing(child1: Block?, child2: Block): Spacing? = null
    override fun isLeaf(): Boolean = true
}
