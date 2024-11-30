// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface DirectiveStmt extends NamedElement {

    @Nullable
    BlockStmt getBlockStmt();

    @NotNull
    NameStmt getNameStmt();

    @NotNull
    List<ValueStmt> getValueStmtList();

    @NotNull
    List<String> getPath();
}
