// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static dev.meanmail.psi.Types.*;
import dev.meanmail.psi.ValueStmtElement;
import dev.meanmail.psi.*;

public class ValueStmtImpl extends ValueStmtElement implements ValueStmt {

  public ValueStmtImpl(ASTNode node) {
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
  public NamedValueStmt getNamedValueStmt() {
    return findChildByClass(NamedValueStmt.class);
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

}
