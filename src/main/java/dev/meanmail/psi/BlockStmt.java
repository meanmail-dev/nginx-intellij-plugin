// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface BlockStmt extends PsiElement {

    @NotNull
    List<DirectiveStmt> getDirectiveStmtList();

    @NotNull
    List<IncludeDirectiveStmt> getIncludeDirectiveStmtList();

    @NotNull
    List<LuaBlockDirectiveStmt> getLuaBlockDirectiveStmtList();

}
