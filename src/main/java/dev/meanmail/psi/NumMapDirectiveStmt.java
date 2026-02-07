// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface NumMapDirectiveStmt extends PsiElement {

  @Nullable
  NumMapBlockStmt getNumMapBlockStmt();

  @NotNull
  NumMapStmt getNumMapStmt();

  @NotNull
  List<ValueStmt> getValueStmtList();

}
