// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;
import dev.meanmail.psi.IncludeTargetStmt;
import dev.meanmail.psi.Reference;
import dev.meanmail.psi.Visitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

import static dev.meanmail.psi.ElementFactoryKt.createIncludeTargetStmt;

public class IncludeTargetStmtImpl extends ASTWrapperPsiElement implements IncludeTargetStmt {

    public IncludeTargetStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull Visitor visitor) {
        visitor.visitIncludeTargetStmt(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof Visitor) accept((Visitor) visitor);
        else super.accept(visitor);
    }

    @NotNull
    @Override
    public String getRef() {
        return getText();
    }

    @Override
    public @Nullable PsiElement getNameIdentifier() {
        return this;
    }

    @Override
    public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        PsiReference reference = getReference();
        if (reference == null) {
            throw new IncorrectOperationException();
        }
        PsiElement target = reference.resolve();
        if (target == null) {
            throw new IncorrectOperationException();
        }
        VirtualFile directory = target.getContainingFile()
                .getVirtualFile().getParent();
        File newName = new File(directory.getPath(), name);
        VirtualFile thisDirectory = this.getContainingFile()
                .getVirtualFile().getParent();
        name = new File(thisDirectory.getPath()).toURI()
                .relativize(newName.toURI()).getPath();
        return createIncludeTargetStmt(getProject(), name);
    }

    @Override
    public PsiReference getReference() {
        return new Reference(this);
    }
}
