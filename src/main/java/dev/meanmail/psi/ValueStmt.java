// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValueStmt extends ReferenceElement {

  @NotNull
  List<ConcatenatedExpr> getConcatenatedExprList();

  @Nullable
  NamedValueStmt getNamedValueStmt();

  @Nullable
  StringStmt getStringStmt();

  @NotNull
  List<VariableStmt> getVariableStmtList();

}
