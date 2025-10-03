// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface GeoDirectiveStmt extends PsiElement {

  @Nullable
  GeoBlockStmt getGeoBlockStmt();

  @NotNull
  GeoStmt getGeoStmt();

  @NotNull
  List<VariableStmt> getVariableStmtList();

}
