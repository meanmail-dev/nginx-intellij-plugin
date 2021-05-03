// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.util.IncorrectOperationException;
import dev.meanmail.psi.IncludeDirectiveStmt;
import dev.meanmail.psi.IncludeStmt;
import dev.meanmail.psi.IncludeTargetStmt;
import dev.meanmail.psi.Visitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IncludeDirectiveStmtImpl extends ASTWrapperPsiElement implements IncludeDirectiveStmt {

    public IncludeDirectiveStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull Visitor visitor) {
        visitor.visitIncludeDirectiveStmt(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof Visitor) accept((Visitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public IncludeStmt getIncludeStmt() {
        return findNotNullChildByClass(IncludeStmt.class);
    }

    @Override
    @Nullable
    public IncludeTargetStmt getIncludeTargetStmt() {
        return findChildByClass(IncludeTargetStmt.class);
    }

    @Override
    public String getName() {
        String name = getNameIdentifier().getText();
        PsiElement target = getIncludeTargetStmt();
        if (target != null) {
            name += " " + target.getText();
        }
        return name;
    }

    @Override
    public @NotNull PsiElement getNameIdentifier() {
        return getIncludeStmt();
    }

    @Override
    public PsiElement setName(@NlsSafe @NotNull String name) throws IncorrectOperationException {
        return this;
    }
}
