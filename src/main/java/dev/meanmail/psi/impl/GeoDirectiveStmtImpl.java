// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import dev.meanmail.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GeoDirectiveStmtImpl extends ASTWrapperPsiElement implements GeoDirectiveStmt {

    public GeoDirectiveStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull Visitor visitor) {
        visitor.visitGeoDirectiveStmt(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof Visitor) accept((Visitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public GeoBlockStmt getGeoBlockStmt() {
        return findChildByClass(GeoBlockStmt.class);
    }

    @Override
    @NotNull
    public GeoStmt getGeoStmt() {
        return findNotNullChildByClass(GeoStmt.class);
    }

    @Override
    @NotNull
    public List<VariableStmt> getVariableStmtList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, VariableStmt.class);
    }

}
