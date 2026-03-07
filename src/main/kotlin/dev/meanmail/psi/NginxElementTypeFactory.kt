package dev.meanmail.psi

import com.intellij.psi.tree.IElementType

object NginxElementTypeFactory {

    private val LAZY_BLOCK_TYPES = setOf(
        "BLOCK_STMT",
        "MAP_BLOCK_STMT",
        "NUM_MAP_BLOCK_STMT",
        "GEO_BLOCK_STMT",
        "TYPES_BLOCK_STMT",
        "LUA_BLOCK_STMT",
    )

    @JvmStatic
    fun createType(name: String): IElementType {
        if (name in LAZY_BLOCK_TYPES) {
            return NginxLazyBlockElementType(name)
        }
        return NginxElementType(name)
    }
}
