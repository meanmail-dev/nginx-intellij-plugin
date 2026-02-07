package dev.meanmail.psi

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.IncorrectOperationException

abstract class DirectiveStmtElement(node: ASTNode) : NginxCompositeElementBase(node), WithPathElement {
    open fun getRegularDirectiveStmt(): RegularDirectiveStmt? = null
    open fun getLocationDirectiveStmt(): LocationDirectiveStmt? = null
    open fun getIfDirectiveStmt(): IfDirectiveStmt? = null
    open fun getMapDirectiveStmt(): MapDirectiveStmt? = null
    open fun getNumMapDirectiveStmt(): NumMapDirectiveStmt? = null
    open fun getGeoDirectiveStmt(): GeoDirectiveStmt? = null
    open fun getLuaDirectiveStmt(): LuaDirectiveStmt? = null
    open fun getTypesDirectiveStmt(): TypesDirectiveStmt? = null

    override fun getName(): String? {
        val nameIdentifier = getNameIdentifier() ?: return ""
        return nameIdentifier.text
    }

    override fun getNameIdentifier(): PsiElement? {
        val regularDirectiveStmt: RegularDirectiveStmt? = getRegularDirectiveStmt()
        if (regularDirectiveStmt != null) {
            return regularDirectiveStmt.getNameStmt()
        }
        val locationDirectiveStmt: LocationDirectiveStmt? = getLocationDirectiveStmt()
        if (locationDirectiveStmt != null) {
            return locationDirectiveStmt.getLocationStmt()
        }
        val ifDirectiveStmt: IfDirectiveStmt? = getIfDirectiveStmt()
        if (ifDirectiveStmt != null) {
            return ifDirectiveStmt.getIfStmt()
        }
        val mapDirectiveStmt: MapDirectiveStmt? = getMapDirectiveStmt()
        if (mapDirectiveStmt != null) {
            return mapDirectiveStmt.getMapStmt()
        }
        val numMapDirectiveStmt: NumMapDirectiveStmt? = getNumMapDirectiveStmt()
        if (numMapDirectiveStmt != null) {
            return numMapDirectiveStmt.getNumMapStmt()
        }
        val geoDirectiveStmt: GeoDirectiveStmt? = getGeoDirectiveStmt()
        if (geoDirectiveStmt != null) {
            return geoDirectiveStmt.getGeoStmt()
        }
        val luaDirectiveStmt: LuaDirectiveStmt? = getLuaDirectiveStmt()
        if (luaDirectiveStmt != null) {
            return luaDirectiveStmt.getLuaStmt()
        }
        val typesDirectiveStmt: TypesDirectiveStmt? = getTypesDirectiveStmt()
        if (typesDirectiveStmt != null) {
            return typesDirectiveStmt.getTypesStmt()
        }
        return null
    }

    @Throws(IncorrectOperationException::class)
    override fun setName(name: @NlsSafe String): PsiElement {
        return this
    }

    override val path: List<String>
        get() {
            val path = mutableListOf<String>()
            var parent: DirectiveStmtElement? = this
            while (parent != null) {
                path.add(parent.name ?: "")
                parent = PsiTreeUtil.getParentOfType(parent, this::class.java)
            }

            return path.reversed()
        }
}
