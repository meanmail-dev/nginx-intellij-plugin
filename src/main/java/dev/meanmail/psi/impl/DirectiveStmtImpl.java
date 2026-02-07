// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static dev.meanmail.psi.Types.*;
import dev.meanmail.psi.DirectiveStmtElement;
import dev.meanmail.psi.*;

public class DirectiveStmtImpl extends DirectiveStmtElement implements DirectiveStmt {

  public DirectiveStmtImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull Visitor visitor) {
    visitor.visitDirectiveStmt(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof Visitor) accept((Visitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public GeoDirectiveStmt getGeoDirectiveStmt() {
    return findChildByClass(GeoDirectiveStmt.class);
  }

  @Override
  @Nullable
  public IfDirectiveStmt getIfDirectiveStmt() {
    return findChildByClass(IfDirectiveStmt.class);
  }

  @Override
  @Nullable
  public LocationDirectiveStmt getLocationDirectiveStmt() {
    return findChildByClass(LocationDirectiveStmt.class);
  }

  @Override
  @Nullable
  public LuaDirectiveStmt getLuaDirectiveStmt() {
    return findChildByClass(LuaDirectiveStmt.class);
  }

  @Override
  @Nullable
  public MapDirectiveStmt getMapDirectiveStmt() {
    return findChildByClass(MapDirectiveStmt.class);
  }

  @Override
  @Nullable
  public NumMapDirectiveStmt getNumMapDirectiveStmt() {
    return findChildByClass(NumMapDirectiveStmt.class);
  }

  @Override
  @Nullable
  public RegularDirectiveStmt getRegularDirectiveStmt() {
    return findChildByClass(RegularDirectiveStmt.class);
  }

  @Override
  @Nullable
  public TypesDirectiveStmt getTypesDirectiveStmt() {
    return findChildByClass(TypesDirectiveStmt.class);
  }

  @Override
  @Nullable
  public VarStmt getVarStmt() {
    return findChildByClass(VarStmt.class);
  }

}
