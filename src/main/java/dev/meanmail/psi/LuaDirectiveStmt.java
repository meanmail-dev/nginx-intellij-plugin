// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface LuaDirectiveStmt extends PsiElement {

    @Nullable
    LuaBlockStmt getLuaBlockStmt();

    @NotNull
    LuaStmt getLuaStmt();

    @NotNull
    List<ValueStmt> getValueStmtList();

}
