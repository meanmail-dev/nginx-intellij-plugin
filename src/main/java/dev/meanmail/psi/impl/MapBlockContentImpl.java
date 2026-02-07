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

public class MapBlockContentImpl extends NginxCompositeElementBase implements MapBlockContent {

  public MapBlockContentImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Visitor visitor) {
    visitor.visitMapBlockContent(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) accept((Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MapDefaultStmt getMapDefaultStmt() {
    return findChildByClass(MapDefaultStmt.class);
  }

  @Override
  @Nullable
  public MapHostnamesStmt getMapHostnamesStmt() {
    return findChildByClass(MapHostnamesStmt.class);
  }

  @Override
  @Nullable
  public MapIncludeStmt getMapIncludeStmt() {
    return findChildByClass(MapIncludeStmt.class);
  }

  @Override
  @Nullable
  public MapValueStmt getMapValueStmt() {
    return findChildByClass(MapValueStmt.class);
  }

  @Override
  @Nullable
  public MapVolatileStmt getMapVolatileStmt() {
    return findChildByClass(MapVolatileStmt.class);
  }

}
