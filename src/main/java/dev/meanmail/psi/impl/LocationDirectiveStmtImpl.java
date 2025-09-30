// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static dev.meanmail.psi.Types.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import dev.meanmail.psi.*;

public class LocationDirectiveStmtImpl extends ASTWrapperPsiElement implements LocationDirectiveStmt {

  public LocationDirectiveStmtImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Visitor visitor) {
    visitor.visitLocationDirectiveStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) accept((Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public BlockStmt getBlockStmt() {
    return findChildByClass(BlockStmt.class);
  }

  @Override
  @Nullable
  public LocationModifierStmt getLocationModifierStmt() {
    return findChildByClass(LocationModifierStmt.class);
  }

  @Override
  @Nullable
  public LocationPathStmt getLocationPathStmt() {
    return findChildByClass(LocationPathStmt.class);
  }

  @Override
  @NotNull
  public LocationStmt getLocationStmt() {
    return findNotNullChildByClass(LocationStmt.class);
  }

}
