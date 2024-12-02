// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import dev.meanmail.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IfDirectiveStmtImpl extends ASTWrapperPsiElement implements IfDirectiveStmt {

    public IfDirectiveStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull Visitor visitor) {
        visitor.visitIfDirectiveStmt(this);
    }

    @Override
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
    @Nullable
    public IfParenStmt getIfParenStmt() {
        return findChildByClass(IfParenStmt.class);
    }

    @Override
    @NotNull
    public IfStmt getIfStmt() {
        return findNotNullChildByClass(IfStmt.class);
    }

}
