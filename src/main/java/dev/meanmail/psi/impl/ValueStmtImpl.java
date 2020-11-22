// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import dev.meanmail.psi.ValueStmt;
import dev.meanmail.psi.Visitor;
import org.jetbrains.annotations.NotNull;

public class ValueStmtImpl extends ASTWrapperPsiElement implements ValueStmt {

    public ValueStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull Visitor visitor) {
        visitor.visitValueStmt(this);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof Visitor) accept((Visitor) visitor);
        else super.accept(visitor);
    }

}
