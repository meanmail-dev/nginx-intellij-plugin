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

public class RegexGroupImpl extends NginxCompositeElementBase implements RegexGroup {

  public RegexGroupImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Visitor visitor) {
    visitor.visitRegexGroup(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) accept((Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RegexExpr getRegexExpr() {
    return findChildByClass(RegexExpr.class);
  }

}
