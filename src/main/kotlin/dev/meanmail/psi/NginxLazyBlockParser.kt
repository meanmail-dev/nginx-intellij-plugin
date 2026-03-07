package dev.meanmail.psi

import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import dev.meanmail.psi.parser.NginxParser

/**
 * Parser subclass that dispatches parse_root_ based on element type
 * for lazy block reparsing.
 */
class NginxLazyBlockParser : NginxParser() {

    override fun parse_root_(root_: IElementType, builder_: PsiBuilder): Boolean {
        val debugName = root_.toString()
        return when {
            debugName == "BLOCK_STMT" -> block_stmt(builder_, 1)
            debugName == "MAP_BLOCK_STMT" -> map_block_stmt(builder_, 1)
            debugName == "NUM_MAP_BLOCK_STMT" -> num_map_block_stmt(builder_, 1)
            debugName == "GEO_BLOCK_STMT" -> geo_block_stmt(builder_, 1)
            debugName == "TYPES_BLOCK_STMT" -> types_block_stmt(builder_, 1)
            debugName == "LUA_BLOCK_STMT" -> lua_block_stmt(builder_, 1)
            else -> super.parse_root_(root_, builder_)
        }
    }
}
