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

public class TypesDirectiveStmtImpl extends NginxCompositeElementBase implements TypesDirectiveStmt {

  public TypesDirectiveStmtImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Visitor visitor) {
    visitor.visitTypesDirectiveStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) accept((Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TypesBlockStmt getTypesBlockStmt() {
    return findChildByClass(TypesBlockStmt.class);
  }

  @Override
  @NotNull
  public TypesStmt getTypesStmt() {
    return findNotNullChildByClass(TypesStmt.class);
  }

}
