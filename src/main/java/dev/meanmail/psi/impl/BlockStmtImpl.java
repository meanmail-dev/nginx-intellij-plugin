// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import dev.meanmail.psi.BlockStmt;
import dev.meanmail.psi.DirectiveStmt;
import dev.meanmail.psi.Visitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BlockStmtImpl extends ASTWrapperPsiElement implements BlockStmt {

    public BlockStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull Visitor visitor) {
        visitor.visitBlockStmt(this);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof Visitor) accept((Visitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<DirectiveStmt> getDirectiveStmtList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, DirectiveStmt.class);
    }

}
