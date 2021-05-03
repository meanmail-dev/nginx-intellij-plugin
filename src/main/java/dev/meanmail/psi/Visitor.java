// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

public class Visitor extends PsiElementVisitor {

    public void visitBlockStmt(@NotNull BlockStmt o) {
        visitPsiElement(o);
    }

    public void visitDirectiveStmt(@NotNull DirectiveStmt o) {
        visitNamedElement(o);
    }

    public void visitIncludeDirectiveStmt(@NotNull IncludeDirectiveStmt o) {
        visitNamedElement(o);
    }

    public void visitIncludeStmt(@NotNull IncludeStmt o) {
        visitPsiElement(o);
    }

    public void visitIncludeTargetStmt(@NotNull IncludeTargetStmt o) {
        visitReference(o);
    }

    public void visitNameStmt(@NotNull NameStmt o) {
        visitPsiElement(o);
    }

    public void visitStringStmt(@NotNull StringStmt o) {
        visitPsiElement(o);
    }

    public void visitValueStmt(@NotNull ValueStmt o) {
        visitPsiElement(o);
    }

    public void visitNamedElement(@NotNull NamedElement o) {
        visitElement(o);
    }

    public void visitReference(@NotNull ReferenceElement o) {
        visitElement(o);
    }

    public void visitPsiElement(@NotNull PsiElement o) {
        visitElement(o);
    }

}
