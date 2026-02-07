package dev.meanmail.psi

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

abstract class RegularDirectiveStmtElement(node: ASTNode) :
    NginxCompositeElementBase(node),
    PsiNameIdentifierOwner {

    abstract fun getNameStmt(): NameStmt
    abstract fun getValueStmtList(): List<ValueStmt>

    override fun getName(): String? {
        if (getNameStmt().text == "upstream") {
            return getValueStmtList().firstOrNull()?.text
        }
        return getNameStmt().text
    }

    override fun setName(@NlsSafe name: String): PsiElement {
        return this
    }

    override fun getNameIdentifier(): PsiElement? {
        if (getNameStmt().text == "upstream") {
            return getValueStmtList().firstOrNull()
        }
        return getNameStmt()
    }
}
