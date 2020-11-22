// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import dev.meanmail.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DirectiveStmtImpl extends ASTWrapperPsiElement implements DirectiveStmt {

    public DirectiveStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull Visitor visitor) {
        visitor.visitDirectiveStmt(this);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof Visitor) accept((Visitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public BlockStmt getBlockStmt() {
        return findChildByClass(BlockStmt.class);
    }

    @Override
    @NotNull
    public NameStmt getNameStmt() {
        return findNotNullChildByClass(NameStmt.class);
    }

    @Override
    @Nullable
    public ValuesStmt getValuesStmt() {
        return findChildByClass(ValuesStmt.class);
    }

}
