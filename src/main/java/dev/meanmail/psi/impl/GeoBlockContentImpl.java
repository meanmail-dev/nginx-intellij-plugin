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

public class GeoBlockContentImpl extends NginxCompositeElementBase implements GeoBlockContent {

  public GeoBlockContentImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Visitor visitor) {
    visitor.visitGeoBlockContent(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) accept((Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GeoDefaultStmt getGeoDefaultStmt() {
    return findChildByClass(GeoDefaultStmt.class);
  }

  @Override
  @Nullable
  public GeoDeleteStmt getGeoDeleteStmt() {
    return findChildByClass(GeoDeleteStmt.class);
  }

  @Override
  @Nullable
  public GeoIncludeStmt getGeoIncludeStmt() {
    return findChildByClass(GeoIncludeStmt.class);
  }

  @Override
  @Nullable
  public GeoProxyStmt getGeoProxyStmt() {
    return findChildByClass(GeoProxyStmt.class);
  }

  @Override
  @Nullable
  public GeoRangesStmt getGeoRangesStmt() {
    return findChildByClass(GeoRangesStmt.class);
  }

  @Override
  @Nullable
  public GeoValueStmt getGeoValueStmt() {
    return findChildByClass(GeoValueStmt.class);
  }

}
