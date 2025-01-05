// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import dev.meanmail.psi.MapValueStmt;
import dev.meanmail.psi.ValueStmt;
import dev.meanmail.psi.Visitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MapValueStmtImpl extends ASTWrapperPsiElement implements MapValueStmt {

    public MapValueStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull Visitor visitor) {
        visitor.visitMapValueStmt(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof Visitor) accept((Visitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<ValueStmt> getValueStmtList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValueStmt.class);
    }

}