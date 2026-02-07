// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static dev.meanmail.psi.Types.*;
import dev.meanmail.psi.NginxCompositeElementBase;
import dev.meanmail.psi.*;

public class ConditionStmtImpl extends NginxCompositeElementBase implements ConditionStmt {

  public ConditionStmtImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Visitor visitor) {
    visitor.visitConditionStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) accept((Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ConditionExpr> getConditionExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ConditionExpr.class);
  }

  @Override
  @Nullable
  public RegexExpr getRegexExpr() {
    return findChildByClass(RegexExpr.class);
  }

}
