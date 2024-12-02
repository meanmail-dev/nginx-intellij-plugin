// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import dev.meanmail.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DirectiveStmtImpl extends ASTWrapperPsiElement implements DirectiveStmt {

    public DirectiveStmtImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull Visitor visitor) {
        visitor.visitDirectiveStmt(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof Visitor) accept((Visitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public GeoDirectiveStmt getGeoDirectiveStmt() {
        return findChildByClass(GeoDirectiveStmt.class);
    }

    @Override
    @Nullable
    public IfDirectiveStmt getIfDirectiveStmt() {
        return findChildByClass(IfDirectiveStmt.class);
    }

    @Override
    @Nullable
    public LocationDirectiveStmt getLocationDirectiveStmt() {
        return findChildByClass(LocationDirectiveStmt.class);
    }

    @Override
    @Nullable
    public LuaDirectiveStmt getLuaDirectiveStmt() {
        return findChildByClass(LuaDirectiveStmt.class);
    }

    @Override
    @Nullable
    public MapDirectiveStmt getMapDirectiveStmt() {
        return findChildByClass(MapDirectiveStmt.class);
    }

    @Override
    @Nullable
    public RegularDirectiveStmt getRegularDirectiveStmt() {
        return findChildByClass(RegularDirectiveStmt.class);
    }

    @Override
    public String getName() {
        PsiElement nameIdentifier = getNameIdentifier();
        if (nameIdentifier == null) return "";
        return nameIdentifier.getText();
    }

    @Override
    public @Nullable PsiElement getNameIdentifier() {
        RegularDirectiveStmt regularDirectiveStmt = getRegularDirectiveStmt();
        if (regularDirectiveStmt != null) {
            return regularDirectiveStmt.getNameStmt();
        }
        LocationDirectiveStmt locationDirectiveStmt = getLocationDirectiveStmt();
        if (locationDirectiveStmt != null) {
            return locationDirectiveStmt.getLocationStmt();
        }
        IfDirectiveStmt ifDirectiveStmt = getIfDirectiveStmt();
        if (ifDirectiveStmt != null) {
            return ifDirectiveStmt.getIfStmt();
        }
        MapDirectiveStmt mapDirectiveStmt = getMapDirectiveStmt();
        if (mapDirectiveStmt != null) {
            return mapDirectiveStmt.getMapStmt();
        }
        GeoDirectiveStmt geoDirectiveStmt = getGeoDirectiveStmt();
        if (geoDirectiveStmt != null) {
            return geoDirectiveStmt.getGeoStmt();
        }
        LuaDirectiveStmt luaDirectiveStmt = getLuaDirectiveStmt();
        if (luaDirectiveStmt != null) {
            return luaDirectiveStmt.getLuaStmt();
        }
        return null;
    }

    @Override
    public PsiElement setName(@NlsSafe @NotNull String name) throws IncorrectOperationException {
        return this;
    }

    @Override
    @NotNull
    public List<String> getPath() {
        List<String> path = new ArrayList<>();
        DirectiveStmt parent = this;
        while (parent != null) {
            path.add(parent.getName());
            parent = PsiTreeUtil.getParentOfType(parent, DirectiveStmt.class);
        }

        List<String> reversedPath = new ArrayList<>();
        for (int i = path.size() - 1; i >= 0; i--) {
            reversedPath.add(path.get(i));
        }
        return reversedPath;
    }
}
