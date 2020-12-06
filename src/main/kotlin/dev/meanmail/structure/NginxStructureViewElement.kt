package dev.meanmail.structure

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil
import dev.meanmail.psi.BlockStmt
import dev.meanmail.psi.DirectiveStmt

class NginxStructureViewElement(private val element: NavigatablePsiElement) : StructureViewTreeElement,
    SortableTreeElement {

    override fun getValue(): Any {
        return element
    }

    override fun navigate(requestFocus: Boolean) {
        element.navigate(requestFocus)
    }

    override fun canNavigate(): Boolean {
        return element.canNavigate()
    }

    override fun canNavigateToSource(): Boolean {
        return element.canNavigateToSource()
    }

    override fun getAlphaSortKey(): String {
        return element.name ?: ""
    }

    override fun getPresentation(): ItemPresentation {
        return element.presentation ?: object : PresentationData() {
            override fun getPresentableText(): String? {
                return element.name
            }
        }
    }

    override fun getChildren(): Array<TreeElement> {
        if (element is DirectiveStmt) {
            return PsiTreeUtil.getChildrenOfTypeAsList(element, BlockStmt::class.java)
                .flatMap { block_stmt ->
                    PsiTreeUtil.getChildrenOfTypeAsList(block_stmt, DirectiveStmt::class.java)
                        .map { NginxStructureViewElement(it as NavigatablePsiElement) }
                }
                .toTypedArray()
        }
        return PsiTreeUtil.getChildrenOfTypeAsList(element, DirectiveStmt::class.java)
            .map { NginxStructureViewElement(it as NavigatablePsiElement) }
            .toTypedArray()
    }
}
