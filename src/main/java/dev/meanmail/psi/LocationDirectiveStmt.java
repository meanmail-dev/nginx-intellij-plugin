// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LocationDirectiveStmt extends PsiElement {

  @Nullable
  BlockStmt getBlockStmt();

  @Nullable
  LocationModifierStmt getLocationModifierStmt();

  @Nullable
  LocationPathStmt getLocationPathStmt();

  @NotNull
  LocationStmt getLocationStmt();

}
