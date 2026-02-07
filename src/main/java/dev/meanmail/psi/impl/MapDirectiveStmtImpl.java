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

public class MapDirectiveStmtImpl extends NginxCompositeElementBase implements MapDirectiveStmt {

  public MapDirectiveStmtImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Visitor visitor) {
    visitor.visitMapDirectiveStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) accept((Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MapBlockStmt getMapBlockStmt() {
    return findChildByClass(MapBlockStmt.class);
  }

  @Override
  @NotNull
  public MapStmt getMapStmt() {
    return findNotNullChildByClass(MapStmt.class);
  }

  @Override
  @NotNull
  public List<ValueStmt> getValueStmtList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValueStmt.class);
  }

}
