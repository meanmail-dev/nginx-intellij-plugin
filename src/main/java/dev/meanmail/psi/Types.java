// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import dev.meanmail.psi.impl.*;

public interface Types {

    IElementType BLOCK_STMT = new NginxElementType("BLOCK_STMT");
    IElementType DIRECTIVE_STMT = new NginxElementType("DIRECTIVE_STMT");
    IElementType INCLUDE_DIRECTIVE_STMT = new NginxElementType("INCLUDE_DIRECTIVE_STMT");
    IElementType INCLUDE_STMT = new NginxElementType("INCLUDE_STMT");
    IElementType INCLUDE_TARGET_STMT = new NginxElementType("INCLUDE_TARGET_STMT");
    IElementType LUA_BLOCK_DIRECTIVE_STMT = new NginxElementType("LUA_BLOCK_DIRECTIVE_STMT");
    IElementType LUA_BLOCK_STMT = new NginxElementType("LUA_BLOCK_STMT");
    IElementType LUA_STMT = new NginxElementType("LUA_STMT");
    IElementType NAME_STMT = new NginxElementType("NAME_STMT");
    IElementType STRING_STMT = new NginxElementType("STRING_STMT");
    IElementType VALUE_STMT = new NginxElementType("VALUE_STMT");

    IElementType COMMENT = new NginxTokenType("COMMENT");
    IElementType DQSTRING = new NginxTokenType("DQSTRING");
    IElementType DQUOTE = new NginxTokenType("DQUOTE");
    IElementType IDENTIFIER = new NginxTokenType("IDENTIFIER");
    IElementType INCLUDE = new NginxTokenType("INCLUDE");
    IElementType INCLUDE_TARGET = new NginxTokenType("INCLUDE_TARGET");
    IElementType LBRACE = new NginxTokenType("LBRACE");
    IElementType LUA = new NginxTokenType("LUA");
    IElementType LUA_BLOCK = new NginxTokenType("LUA_BLOCK");
    IElementType QUOTE = new NginxTokenType("QUOTE");
    IElementType RBRACE = new NginxTokenType("RBRACE");
    IElementType SEMICOLON = new NginxTokenType("SEMICOLON");
    IElementType STRING = new NginxTokenType("STRING");
    IElementType VALUE = new NginxTokenType("VALUE");

    class Factory {
        public static PsiElement createElement(ASTNode node) {
            IElementType type = node.getElementType();
            if (type == BLOCK_STMT) {
                return new BlockStmtImpl(node);
            } else if (type == DIRECTIVE_STMT) {
                return new DirectiveStmtImpl(node);
            } else if (type == INCLUDE_DIRECTIVE_STMT) {
                return new IncludeDirectiveStmtImpl(node);
            } else if (type == INCLUDE_STMT) {
                return new IncludeStmtImpl(node);
            } else if (type == INCLUDE_TARGET_STMT) {
                return new IncludeTargetStmtImpl(node);
            } else if (type == LUA_BLOCK_DIRECTIVE_STMT) {
                return new LuaBlockDirectiveStmtImpl(node);
            } else if (type == LUA_BLOCK_STMT) {
                return new LuaBlockStmtImpl(node);
            } else if (type == LUA_STMT) {
                return new LuaStmtImpl(node);
            } else if (type == NAME_STMT) {
                return new NameStmtImpl(node);
            } else if (type == STRING_STMT) {
                return new StringStmtImpl(node);
            } else if (type == VALUE_STMT) {
                return new ValueStmtImpl(node);
            }
            throw new AssertionError("Unknown element type: " + type);
        }
    }
}
