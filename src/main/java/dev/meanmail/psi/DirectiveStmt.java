// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface DirectiveStmt extends PsiElement {

    @Nullable
    BlockStmt getBlockStmt();

    @NotNull
    NameStmt getNameStmt();

    @Nullable
    ValuesStmt getValuesStmt();

}
