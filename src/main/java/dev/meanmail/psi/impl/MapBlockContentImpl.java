// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import dev.meanmail.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MapBlockContentImpl extends ASTWrapperPsiElement implements MapBlockContent {

    public MapBlockContentImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull Visitor visitor) {
        visitor.visitMapBlockContent(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof Visitor) accept((Visitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public MapDefaultStmt getMapDefaultStmt() {
        return findChildByClass(MapDefaultStmt.class);
    }

    @Override
    @Nullable
    public MapHostnamesStmt getMapHostnamesStmt() {
        return findChildByClass(MapHostnamesStmt.class);
    }

    @Override
    @Nullable
    public MapIncludeStmt getMapIncludeStmt() {
        return findChildByClass(MapIncludeStmt.class);
    }

    @Override
    @Nullable
    public MapValueStmt getMapValueStmt() {
        return findChildByClass(MapValueStmt.class);
    }

    @Override
    @Nullable
    public MapVolatileStmt getMapVolatileStmt() {
        return findChildByClass(MapVolatileStmt.class);
    }

}
