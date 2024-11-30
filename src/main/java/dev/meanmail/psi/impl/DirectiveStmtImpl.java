// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import dev.meanmail.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DirectiveStmtImpl extends ASTWrapperPsiElement implements DirectiveStmt {

    public DirectiveStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull Visitor visitor) {
        visitor.visitDirectiveStmt(this);
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
    @NotNull
    public NameStmt getNameStmt() {
        return findNotNullChildByClass(NameStmt.class);
    }

    @Override
    @NotNull
    public List<ValueStmt> getValueStmtList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValueStmt.class);
    }

    @Override
    public String getName() {
        return getNameIdentifier().getText();
    }

    @Override
    public @NotNull PsiElement getNameIdentifier() {
        return getNameStmt();
    }

    @Override
    public PsiElement setName(@NlsSafe @NotNull String name) throws IncorrectOperationException {
        return this;
    }

    @Override
    public List<String> getPath() {
        List<String> path = new ArrayList<>();
        DirectiveStmt parent = this;
        while (parent != null) {
            path.add(parent.getName());
            parent = PsiTreeUtil.getParentOfType(parent, DirectiveStmt.class);
        }

        List<String> reversedPath = new ArrayList<>();
        for (int i = path.size() - 1; i >= 0; i--) {
            reversedPath.add(path.get(i));
        }
        return reversedPath;
    }
}
