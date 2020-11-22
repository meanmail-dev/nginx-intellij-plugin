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
        visitPsiElement(o);
    }

    public void visitNameStmt(@NotNull NameStmt o) {
        visitPsiElement(o);
    }

    public void visitValueStmt(@NotNull ValueStmt o) {
        visitPsiElement(o);
    }

    public void visitValuesStmt(@NotNull ValuesStmt o) {
        visitPsiElement(o);
    }

    public void visitPsiElement(@NotNull PsiElement o) {
        visitElement(o);
    }

}
