// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import dev.meanmail.psi.impl.*;

public interface Types {

    IElementType BLOCK_STMT = new NginxElementType("BLOCK_STMT");
    IElementType CONCATENATED_EXPR = new NginxElementType("CONCATENATED_EXPR");
    IElementType CONDITION_EXPR = new NginxElementType("CONDITION_EXPR");
    IElementType CONDITION_STMT = new NginxElementType("CONDITION_STMT");
    IElementType DIRECTIVE_STMT = new NginxElementType("DIRECTIVE_STMT");
    IElementType GEO_BLOCK_CONTENT = new NginxElementType("GEO_BLOCK_CONTENT");
    IElementType GEO_BLOCK_STMT = new NginxElementType("GEO_BLOCK_STMT");
    IElementType GEO_DEFAULT_STMT = new NginxElementType("GEO_DEFAULT_STMT");
    IElementType GEO_DELETE_STMT = new NginxElementType("GEO_DELETE_STMT");
    IElementType GEO_DIRECTIVE_STMT = new NginxElementType("GEO_DIRECTIVE_STMT");
    IElementType GEO_INCLUDE_STMT = new NginxElementType("GEO_INCLUDE_STMT");
    IElementType GEO_PROXY_STMT = new NginxElementType("GEO_PROXY_STMT");
    IElementType GEO_RANGES_STMT = new NginxElementType("GEO_RANGES_STMT");
    IElementType GEO_STMT = new NginxElementType("GEO_STMT");
    IElementType GEO_VALUE_STMT = new NginxElementType("GEO_VALUE_STMT");
    IElementType IF_DIRECTIVE_STMT = new NginxElementType("IF_DIRECTIVE_STMT");
    IElementType IF_PAREN_STMT = new NginxElementType("IF_PAREN_STMT");
    IElementType IF_STMT = new NginxElementType("IF_STMT");
    IElementType LOCATION_DIRECTIVE_STMT = new NginxElementType("LOCATION_DIRECTIVE_STMT");
    IElementType LOCATION_MODIFIER_STMT = new NginxElementType("LOCATION_MODIFIER_STMT");
    IElementType LOCATION_PATH_STMT = new NginxElementType("LOCATION_PATH_STMT");
    IElementType LOCATION_STMT = new NginxElementType("LOCATION_STMT");
    IElementType LUA_BLOCK_STMT = new NginxElementType("LUA_BLOCK_STMT");
    IElementType LUA_CODE_STMT = new NginxElementType("LUA_CODE_STMT");
    IElementType LUA_DIRECTIVE_STMT = new NginxElementType("LUA_DIRECTIVE_STMT");
    IElementType LUA_STMT = new NginxElementType("LUA_STMT");
    IElementType MAP_BLOCK_CONTENT = new NginxElementType("MAP_BLOCK_CONTENT");
    IElementType MAP_BLOCK_STMT = new NginxElementType("MAP_BLOCK_STMT");
    IElementType MAP_DEFAULT_STMT = new NginxElementType("MAP_DEFAULT_STMT");
    IElementType MAP_DIRECTIVE_STMT = new NginxElementType("MAP_DIRECTIVE_STMT");
    IElementType MAP_HOSTNAMES_STMT = new NginxElementType("MAP_HOSTNAMES_STMT");
    IElementType MAP_INCLUDE_STMT = new NginxElementType("MAP_INCLUDE_STMT");
    IElementType MAP_STMT = new NginxElementType("MAP_STMT");
    IElementType MAP_VALUE_STMT = new NginxElementType("MAP_VALUE_STMT");
    IElementType MAP_VOLATILE_STMT = new NginxElementType("MAP_VOLATILE_STMT");
    IElementType NAME_STMT = new NginxElementType("NAME_STMT");
    IElementType REGULAR_DIRECTIVE_STMT = new NginxElementType("REGULAR_DIRECTIVE_STMT");
    IElementType STRING_STMT = new NginxElementType("STRING_STMT");
    IElementType VALUE_STMT = new NginxElementType("VALUE_STMT");
    IElementType VARIABLE_STMT = new NginxElementType("VARIABLE_STMT");

    IElementType BINARY_OPERATOR = new NginxTokenType("BINARY_OPERATOR");
    IElementType CARET_TILDE = new NginxTokenType("CARET_TILDE");
    IElementType COMMENT = new NginxTokenType("COMMENT");
    IElementType DQSTRING = new NginxTokenType("DQSTRING");
    IElementType DQUOTE = new NginxTokenType("DQUOTE");
    IElementType GEO = new NginxTokenType("GEO");
    IElementType GEO_DEFAULT = new NginxTokenType("GEO_DEFAULT");
    IElementType GEO_DELETE = new NginxTokenType("GEO_DELETE");
    IElementType GEO_INCLUDE = new NginxTokenType("GEO_INCLUDE");
    IElementType GEO_PROXY = new NginxTokenType("GEO_PROXY");
    IElementType GEO_RANGES = new NginxTokenType("GEO_RANGES");
    IElementType IDENTIFIER = new NginxTokenType("IDENTIFIER");
    IElementType IF = new NginxTokenType("IF");
    IElementType LBRACE = new NginxTokenType("LBRACE");
    IElementType LOCATION = new NginxTokenType("LOCATION");
    IElementType LPAREN = new NginxTokenType("LPAREN");
    IElementType LUA = new NginxTokenType("LUA");
    IElementType LUA_BLOCK_DIRECTIVE = new NginxTokenType("LUA_BLOCK_DIRECTIVE");
    IElementType MAP = new NginxTokenType("MAP");
    IElementType MAP_DEFAULT = new NginxTokenType("MAP_DEFAULT");
    IElementType MAP_HOSTNAMES = new NginxTokenType("MAP_HOSTNAMES");
    IElementType MAP_INCLUDE = new NginxTokenType("MAP_INCLUDE");
    IElementType MAP_VOLATILE = new NginxTokenType("MAP_VOLATILE");
    IElementType QUOTE = new NginxTokenType("QUOTE");
    IElementType RBRACE = new NginxTokenType("RBRACE");
    IElementType RPAREN = new NginxTokenType("RPAREN");
    IElementType SEMICOLON = new NginxTokenType("SEMICOLON");
    IElementType STRING = new NginxTokenType("STRING");
    IElementType UNARY_OPERATOR = new NginxTokenType("UNARY_OPERATOR");
    IElementType VALUE = new NginxTokenType("VALUE");
    IElementType VARIABLE = new NginxTokenType("VARIABLE");

    class Factory {
        public static PsiElement createElement(ASTNode node) {
            IElementType type = node.getElementType();
            if (type == BLOCK_STMT) {
                return new BlockStmtImpl(node);
            } else if (type == CONCATENATED_EXPR) {
                return new ConcatenatedExprImpl(node);
            } else if (type == CONDITION_EXPR) {
                return new ConditionExprImpl(node);
            } else if (type == CONDITION_STMT) {
                return new ConditionStmtImpl(node);
            } else if (type == DIRECTIVE_STMT) {
                return new DirectiveStmtImpl(node);
            } else if (type == GEO_BLOCK_CONTENT) {
                return new GeoBlockContentImpl(node);
            } else if (type == GEO_BLOCK_STMT) {
                return new GeoBlockStmtImpl(node);
            } else if (type == GEO_DEFAULT_STMT) {
                return new GeoDefaultStmtImpl(node);
            } else if (type == GEO_DELETE_STMT) {
                return new GeoDeleteStmtImpl(node);
            } else if (type == GEO_DIRECTIVE_STMT) {
                return new GeoDirectiveStmtImpl(node);
            } else if (type == GEO_INCLUDE_STMT) {
                return new GeoIncludeStmtImpl(node);
            } else if (type == GEO_PROXY_STMT) {
                return new GeoProxyStmtImpl(node);
            } else if (type == GEO_RANGES_STMT) {
                return new GeoRangesStmtImpl(node);
            } else if (type == GEO_STMT) {
                return new GeoStmtImpl(node);
            } else if (type == GEO_VALUE_STMT) {
                return new GeoValueStmtImpl(node);
            } else if (type == IF_DIRECTIVE_STMT) {
                return new IfDirectiveStmtImpl(node);
            } else if (type == IF_PAREN_STMT) {
                return new IfParenStmtImpl(node);
            } else if (type == IF_STMT) {
                return new IfStmtImpl(node);
            } else if (type == LOCATION_DIRECTIVE_STMT) {
                return new LocationDirectiveStmtImpl(node);
            } else if (type == LOCATION_MODIFIER_STMT) {
                return new LocationModifierStmtImpl(node);
            } else if (type == LOCATION_PATH_STMT) {
                return new LocationPathStmtImpl(node);
            } else if (type == LOCATION_STMT) {
                return new LocationStmtImpl(node);
            } else if (type == LUA_BLOCK_STMT) {
                return new LuaBlockStmtImpl(node);
            } else if (type == LUA_CODE_STMT) {
                return new LuaCodeStmtImpl(node);
            } else if (type == LUA_DIRECTIVE_STMT) {
                return new LuaDirectiveStmtImpl(node);
            } else if (type == LUA_STMT) {
                return new LuaStmtImpl(node);
            } else if (type == MAP_BLOCK_CONTENT) {
                return new MapBlockContentImpl(node);
            } else if (type == MAP_BLOCK_STMT) {
                return new MapBlockStmtImpl(node);
            } else if (type == MAP_DEFAULT_STMT) {
                return new MapDefaultStmtImpl(node);
            } else if (type == MAP_DIRECTIVE_STMT) {
                return new MapDirectiveStmtImpl(node);
            } else if (type == MAP_HOSTNAMES_STMT) {
                return new MapHostnamesStmtImpl(node);
            } else if (type == MAP_INCLUDE_STMT) {
                return new MapIncludeStmtImpl(node);
            } else if (type == MAP_STMT) {
                return new MapStmtImpl(node);
            } else if (type == MAP_VALUE_STMT) {
                return new MapValueStmtImpl(node);
            } else if (type == MAP_VOLATILE_STMT) {
                return new MapVolatileStmtImpl(node);
            } else if (type == NAME_STMT) {
                return new NameStmtImpl(node);
            } else if (type == REGULAR_DIRECTIVE_STMT) {
                return new RegularDirectiveStmtImpl(node);
            } else if (type == STRING_STMT) {
                return new StringStmtImpl(node);
            } else if (type == VALUE_STMT) {
                return new ValueStmtImpl(node);
            } else if (type == VARIABLE_STMT) {
                return new VariableStmtImpl(node);
            }
            throw new AssertionError("Unknown element type: " + type);
        }
    }
}
