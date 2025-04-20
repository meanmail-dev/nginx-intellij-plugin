// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface DirectiveStmt extends WithPathElement {

    @Nullable
    GeoDirectiveStmt getGeoDirectiveStmt();

    @Nullable
    IfDirectiveStmt getIfDirectiveStmt();

    @Nullable
    LocationDirectiveStmt getLocationDirectiveStmt();

    @Nullable
    LuaDirectiveStmt getLuaDirectiveStmt();

    @Nullable
    MapDirectiveStmt getMapDirectiveStmt();

    @Nullable
    RegularDirectiveStmt getRegularDirectiveStmt();

    @NotNull
    List<String> getPath();
}
