package dev.meanmail.folding

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import dev.meanmail.psi.BlockStmt
import dev.meanmail.psi.LuaBlockStmt


class NginxFoldingBuilder : FoldingBuilderEx(), DumbAware {
    override fun buildFoldRegions(
        root: PsiElement,
        document: Document,
        quick: Boolean
    ): Array<FoldingDescriptor> {
        val descriptors: MutableList<FoldingDescriptor> = ArrayList()
        val blocks = PsiTreeUtil.findChildrenOfAnyType(
            root,
            BlockStmt::class.java,
            LuaBlockStmt::class.java
        )
        for (block in blocks) {
            descriptors.add(
                FoldingDescriptor(
                    block.node,
                    TextRange(
                        block.textRange.startOffset + 1,
                        block.textRange.endOffset - 1
                    )
                )
            )
        }
        return descriptors.toTypedArray()
    }

    override fun getPlaceholderText(node: ASTNode): String {
        return "..."
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean {
        return false
    }
}
