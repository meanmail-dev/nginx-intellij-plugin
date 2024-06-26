// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import dev.meanmail.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BlockStmtImpl extends ASTWrapperPsiElement implements BlockStmt {

    public BlockStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull Visitor visitor) {
        visitor.visitBlockStmt(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof Visitor) accept((Visitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<AccessByLuaBlockStmt> getAccessByLuaBlockStmtList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, AccessByLuaBlockStmt.class);
    }

    @Override
    @NotNull
    public List<ContentByLuaBlockStmt> getContentByLuaBlockStmtList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ContentByLuaBlockStmt.class);
    }

    @Override
    @NotNull
    public List<DirectiveStmt> getDirectiveStmtList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, DirectiveStmt.class);
    }

    @Override
    @NotNull
    public List<IncludeDirectiveStmt> getIncludeDirectiveStmtList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, IncludeDirectiveStmt.class);
    }

    @Override
    @NotNull
    public List<RewriteByLuaBlockStmt> getRewriteByLuaBlockStmtList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, RewriteByLuaBlockStmt.class);
    }

    @Override
    @NotNull
    public List<SetByLuaBlockStmt> getSetByLuaBlockStmtList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, SetByLuaBlockStmt.class);
    }

    @Override
    @NotNull
    public List<SslCertificateByLuaBlockStmt> getSslCertificateByLuaBlockStmtList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, SslCertificateByLuaBlockStmt.class);
    }

}
