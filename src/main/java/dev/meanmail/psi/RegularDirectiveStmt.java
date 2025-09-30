// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RegularDirectiveStmt extends PsiElement {

  @Nullable
  BlockStmt getBlockStmt();

  @NotNull
  NameStmt getNameStmt();

  @NotNull
  List<ValueStmt> getValueStmtList();

}
