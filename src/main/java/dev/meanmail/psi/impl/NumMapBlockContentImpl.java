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

public class NumMapBlockContentImpl extends NginxCompositeElementBase implements NumMapBlockContent {

  public NumMapBlockContentImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Visitor visitor) {
    visitor.visitNumMapBlockContent(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) accept((Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public NumMapDefaultStmt getNumMapDefaultStmt() {
    return findChildByClass(NumMapDefaultStmt.class);
  }

  @Override
  @Nullable
  public NumMapIncludeStmt getNumMapIncludeStmt() {
    return findChildByClass(NumMapIncludeStmt.class);
  }

  @Override
  @Nullable
  public NumMapValueStmt getNumMapValueStmt() {
    return findChildByClass(NumMapValueStmt.class);
  }

  @Override
  @Nullable
  public NumMapVolatileStmt getNumMapVolatileStmt() {
    return findChildByClass(NumMapVolatileStmt.class);
  }

}
