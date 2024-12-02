// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface MapDirectiveStmt extends PsiElement {

    @Nullable
    MapBlockStmt getMapBlockStmt();

    @NotNull
    MapStmt getMapStmt();

    @NotNull
    List<ValueStmt> getValueStmtList();

}
