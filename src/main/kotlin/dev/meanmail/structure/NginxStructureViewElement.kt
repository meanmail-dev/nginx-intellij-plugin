package dev.meanmail.structure

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil
import dev.meanmail.psi.BlockStmt
import dev.meanmail.psi.DirectiveStmt

class NginxStructureViewElement(private val element: NavigatablePsiElement) : StructureViewTreeElement,
    SortableTreeElement {

    override fun getValue(): Any {
        return element
    }

    override fun navigate(requestFocus: Boolean) {
        element.navigate(requestFocus)
    }

    override fun canNavigate(): Boolean {
        return element.canNavigate()
    }

    override fun canNavigateToSource(): Boolean {
        return element.canNavigateToSource()
    }

    override fun getAlphaSortKey(): String {
        return element.name ?: ""
    }

    private fun getDirectivePresentation(directive: DirectiveStmt): String {
        directive.getLocationDirectiveStmt()?.let { location ->
            val modifier = location.locationModifierStmt?.text?.takeIf { it.isNotBlank() }?.let { "$it " } ?: ""
            val path = location.locationPathStmt?.text ?: ""
            return "location $modifier$path".trim()
        }

        directive.getIfDirectiveStmt()?.let { ifStmt ->
            val condition = ifStmt.ifParenStmt?.text ?: ""
            return "if $condition"
        }

        directive.getMapDirectiveStmt()?.let { map ->
            val values = map.valueStmtList.take(2).joinToString(" ") { it.text }
            return "map $values"
        }

        directive.getNumMapDirectiveStmt()?.let { numMap ->
            val values = numMap.valueStmtList.take(2).joinToString(" ") { it.text }
            return "num_map $values"
        }

        directive.getGeoDirectiveStmt()?.let { geo ->
            val vars = geo.variableStmtList.joinToString(" ") { it.text }
            return "geo $vars"
        }

        directive.getTypesDirectiveStmt()?.let {
            return "types"
        }

        directive.getLuaDirectiveStmt()?.let { lua ->
            return lua.luaStmt.text
        }

        directive.getRegularDirectiveStmt()?.let { regular ->
            val name = regular.nameStmt.text
            val values = regular.valueStmtList

            return when (name) {
                "server" -> {
                    val block = regular.blockStmt
                    if (block != null) {
                        val listen = findDirectiveValue(block, "listen")
                        val serverName = findDirectiveValue(block, "server_name")
                        buildString {
                            append("server")
                            if (listen != null) append(" :$listen")
                            if (serverName != null) append(" ($serverName)")
                        }
                    } else "server"
                }

                "upstream" -> {
                    val upstreamName = values.firstOrNull()?.text ?: ""
                    "upstream $upstreamName"
                }

                "http", "events", "stream", "mail" -> name
                else -> {
                    val valueText = values.take(2).joinToString(" ") { it.text }
                    if (valueText.isNotEmpty()) "$name $valueText" else name
                }
            }
        }

        return directive.name ?: ""
    }

    private fun findDirectiveValue(block: BlockStmt, directiveName: String): String? {
        for (stmt in block.directiveStmtList) {
            val regular = stmt.getRegularDirectiveStmt() ?: continue
            if (regular.nameStmt.text == directiveName) {
                return regular.valueStmtList.firstOrNull()?.text
            }
        }
        return null
    }

    override fun getPresentation(): ItemPresentation {
        val presentableText = if (element is DirectiveStmt) {
            getDirectivePresentation(element)
        } else {
            element.name
        }

        return object : PresentationData() {
            override fun getPresentableText(): String? {
                return presentableText
            }
        }
    }

    override fun getChildren(): Array<TreeElement> {
        if (element is DirectiveStmt) {
            var blockStmt: BlockStmt? = null
            val regularDirectiveStmt = element.getRegularDirectiveStmt()
            if (regularDirectiveStmt != null) {
                blockStmt = regularDirectiveStmt.getBlockStmt()
            } else {
                val locationDirectiveStmt = element.getLocationDirectiveStmt()
                if (locationDirectiveStmt != null) {
                    blockStmt = locationDirectiveStmt.getBlockStmt()
                } else {
                    val ifDirectiveStmt = element.getIfDirectiveStmt()
                    if (ifDirectiveStmt != null) {
                        blockStmt = ifDirectiveStmt.getBlockStmt()
                    }
                }
            }
            if (blockStmt != null) {
                return blockStmt.directiveStmtList.map { NginxStructureViewElement(it as NavigatablePsiElement) }
                    .toTypedArray()
            }
            return emptyArray()
        }
        return PsiTreeUtil.getChildrenOfAnyType(
            element,
            DirectiveStmt::class.java
        )
            .map { NginxStructureViewElement(it as NavigatablePsiElement) }
            .toTypedArray()
    }
}
