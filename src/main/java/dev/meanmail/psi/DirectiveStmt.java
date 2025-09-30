// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface DirectiveStmt extends WithPathElement {

  @Nullable
  GeoDirectiveStmt getGeoDirectiveStmt();

  @Nullable
  IfDirectiveStmt getIfDirectiveStmt();

  @Nullable
  LocationDirectiveStmt getLocationDirectiveStmt();

  @Nullable
  LuaDirectiveStmt getLuaDirectiveStmt();

  @Nullable
  MapDirectiveStmt getMapDirectiveStmt();

  @Nullable
  RegularDirectiveStmt getRegularDirectiveStmt();

  @Nullable
  ReturnDirectiveStmt getReturnDirectiveStmt();

}
