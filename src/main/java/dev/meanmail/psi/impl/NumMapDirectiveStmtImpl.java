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

public class NumMapDirectiveStmtImpl extends NginxCompositeElementBase implements NumMapDirectiveStmt {

  public NumMapDirectiveStmtImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Visitor visitor) {
    visitor.visitNumMapDirectiveStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) accept((Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public NumMapBlockStmt getNumMapBlockStmt() {
    return findChildByClass(NumMapBlockStmt.class);
  }

  @Override
  @NotNull
  public NumMapStmt getNumMapStmt() {
    return findNotNullChildByClass(NumMapStmt.class);
  }

  @Override
  @NotNull
  public List<ValueStmt> getValueStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValueStmt.class);
  }

}
