// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MapDirectiveStmt extends PsiElement {

  @Nullable
  MapBlockStmt getMapBlockStmt();

  @NotNull
  MapStmt getMapStmt();

  @NotNull
  List<ValueStmt> getValueStmtList();

}
