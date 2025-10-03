// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import java.util.List;

import com.intellij.openapi.util.NlsSafe;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static dev.meanmail.psi.Types.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import dev.meanmail.psi.*;

public class ValueStmtImpl extends ASTWrapperPsiElement implements ValueStmt {

  public ValueStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Visitor visitor) {
    visitor.visitValueStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) accept((Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ConcatenatedExpr getConcatenatedExpr() {
    return findChildByClass(ConcatenatedExpr.class);
  }

  @Override
  @Nullable
  public StringStmt getStringStmt() {
    return findChildByClass(StringStmt.class);
  }

  @Override
  @Nullable
  public VariableStmt getVariableStmt() {
    return findChildByClass(VariableStmt.class);
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
    public PsiElement setName(@NlsSafe @NotNull String name) throws IncorrectOperationException {
        return this;
    }

    @Override
    public PsiReference getReference() {
        Reference reference = new Reference(this);
        if (reference.resolve() == null) {
            return null;
        }
        return reference;
    }
}
