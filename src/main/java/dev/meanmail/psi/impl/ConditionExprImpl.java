// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import dev.meanmail.psi.ConcatenatedExpr;
import dev.meanmail.psi.ConditionExpr;
import dev.meanmail.psi.StringStmt;
import dev.meanmail.psi.Visitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ConditionExprImpl extends ASTWrapperPsiElement implements ConditionExpr {

    public ConditionExprImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull Visitor visitor) {
        visitor.visitConditionExpr(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof Visitor) accept((Visitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ConcatenatedExpr getConcatenatedExpr() {
        return findChildByClass(ConcatenatedExpr.class);
    }

    @Override
    @Nullable
    public StringStmt getStringStmt() {
        return findChildByClass(StringStmt.class);
    }

}
