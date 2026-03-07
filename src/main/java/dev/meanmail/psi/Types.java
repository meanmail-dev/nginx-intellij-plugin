// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import dev.meanmail.psi.impl.*;

public interface Types {

  IElementType BLOCK_STMT = NginxElementTypeFactory.createType("BLOCK_STMT");
  IElementType CONCATENATED_EXPR = NginxElementTypeFactory.createType("CONCATENATED_EXPR");
  IElementType CONDITION_EXPR = NginxElementTypeFactory.createType("CONDITION_EXPR");
  IElementType CONDITION_STMT = NginxElementTypeFactory.createType("CONDITION_STMT");
  IElementType DIRECTIVE_STMT = NginxElementTypeFactory.createType("DIRECTIVE_STMT");
  IElementType GEO_BLOCK_CONTENT = NginxElementTypeFactory.createType("GEO_BLOCK_CONTENT");
  IElementType GEO_BLOCK_STMT = NginxElementTypeFactory.createType("GEO_BLOCK_STMT");
  IElementType GEO_DEFAULT_STMT = NginxElementTypeFactory.createType("GEO_DEFAULT_STMT");
  IElementType GEO_DELETE_STMT = NginxElementTypeFactory.createType("GEO_DELETE_STMT");
  IElementType GEO_DIRECTIVE_STMT = NginxElementTypeFactory.createType("GEO_DIRECTIVE_STMT");
  IElementType GEO_INCLUDE_STMT = NginxElementTypeFactory.createType("GEO_INCLUDE_STMT");
  IElementType GEO_PROXY_STMT = NginxElementTypeFactory.createType("GEO_PROXY_STMT");
  IElementType GEO_RANGES_STMT = NginxElementTypeFactory.createType("GEO_RANGES_STMT");
  IElementType GEO_STMT = NginxElementTypeFactory.createType("GEO_STMT");
  IElementType GEO_VALUE_STMT = NginxElementTypeFactory.createType("GEO_VALUE_STMT");
  IElementType IF_DIRECTIVE_STMT = NginxElementTypeFactory.createType("IF_DIRECTIVE_STMT");
  IElementType IF_PAREN_STMT = NginxElementTypeFactory.createType("IF_PAREN_STMT");
  IElementType IF_STMT = NginxElementTypeFactory.createType("IF_STMT");
  IElementType LOCATION_DIRECTIVE_STMT = NginxElementTypeFactory.createType("LOCATION_DIRECTIVE_STMT");
  IElementType LOCATION_MODIFIER_STMT = NginxElementTypeFactory.createType("LOCATION_MODIFIER_STMT");
  IElementType LOCATION_PATH_STMT = NginxElementTypeFactory.createType("LOCATION_PATH_STMT");
  IElementType LOCATION_STMT = NginxElementTypeFactory.createType("LOCATION_STMT");
  IElementType LUA_BLOCK_STMT = NginxElementTypeFactory.createType("LUA_BLOCK_STMT");
  IElementType LUA_CODE_STMT = NginxElementTypeFactory.createType("LUA_CODE_STMT");
  IElementType LUA_DIRECTIVE_STMT = NginxElementTypeFactory.createType("LUA_DIRECTIVE_STMT");
  IElementType LUA_STMT = NginxElementTypeFactory.createType("LUA_STMT");
  IElementType MAP_BLOCK_CONTENT = NginxElementTypeFactory.createType("MAP_BLOCK_CONTENT");
  IElementType MAP_BLOCK_STMT = NginxElementTypeFactory.createType("MAP_BLOCK_STMT");
  IElementType MAP_DEFAULT_STMT = NginxElementTypeFactory.createType("MAP_DEFAULT_STMT");
  IElementType MAP_DIRECTIVE_STMT = NginxElementTypeFactory.createType("MAP_DIRECTIVE_STMT");
  IElementType MAP_HOSTNAMES_STMT = NginxElementTypeFactory.createType("MAP_HOSTNAMES_STMT");
  IElementType MAP_INCLUDE_STMT = NginxElementTypeFactory.createType("MAP_INCLUDE_STMT");
  IElementType MAP_STMT = NginxElementTypeFactory.createType("MAP_STMT");
  IElementType MAP_VALUE_STMT = NginxElementTypeFactory.createType("MAP_VALUE_STMT");
  IElementType MAP_VOLATILE_STMT = NginxElementTypeFactory.createType("MAP_VOLATILE_STMT");
  IElementType NAMED_VALUE_STMT = NginxElementTypeFactory.createType("NAMED_VALUE_STMT");
  IElementType NAME_STMT = NginxElementTypeFactory.createType("NAME_STMT");
  IElementType NUM_MAP_BLOCK_CONTENT = NginxElementTypeFactory.createType("NUM_MAP_BLOCK_CONTENT");
  IElementType NUM_MAP_BLOCK_STMT = NginxElementTypeFactory.createType("NUM_MAP_BLOCK_STMT");
  IElementType NUM_MAP_DEFAULT_STMT = NginxElementTypeFactory.createType("NUM_MAP_DEFAULT_STMT");
  IElementType NUM_MAP_DIRECTIVE_STMT = NginxElementTypeFactory.createType("NUM_MAP_DIRECTIVE_STMT");
  IElementType NUM_MAP_INCLUDE_STMT = NginxElementTypeFactory.createType("NUM_MAP_INCLUDE_STMT");
  IElementType NUM_MAP_STMT = NginxElementTypeFactory.createType("NUM_MAP_STMT");
  IElementType NUM_MAP_VALUE_STMT = NginxElementTypeFactory.createType("NUM_MAP_VALUE_STMT");
  IElementType NUM_MAP_VOLATILE_STMT = NginxElementTypeFactory.createType("NUM_MAP_VOLATILE_STMT");
  IElementType REGEX_ATOM = NginxElementTypeFactory.createType("REGEX_ATOM");
  IElementType REGEX_EXPR = NginxElementTypeFactory.createType("REGEX_EXPR");
  IElementType REGEX_GROUP = NginxElementTypeFactory.createType("REGEX_GROUP");
  IElementType REGULAR_DIRECTIVE_STMT = NginxElementTypeFactory.createType("REGULAR_DIRECTIVE_STMT");
  IElementType STRING_STMT = NginxElementTypeFactory.createType("STRING_STMT");
  IElementType TYPES_BLOCK_CONTENT = NginxElementTypeFactory.createType("TYPES_BLOCK_CONTENT");
  IElementType TYPES_BLOCK_STMT = NginxElementTypeFactory.createType("TYPES_BLOCK_STMT");
  IElementType TYPES_DIRECTIVE_STMT = NginxElementTypeFactory.createType("TYPES_DIRECTIVE_STMT");
  IElementType TYPES_INCLUDE_STMT = NginxElementTypeFactory.createType("TYPES_INCLUDE_STMT");
  IElementType TYPES_MAPPING_STMT = NginxElementTypeFactory.createType("TYPES_MAPPING_STMT");
  IElementType TYPES_STMT = NginxElementTypeFactory.createType("TYPES_STMT");
  IElementType VALUE_STMT = NginxElementTypeFactory.createType("VALUE_STMT");
  IElementType VARIABLE_STMT = NginxElementTypeFactory.createType("VARIABLE_STMT");
  IElementType VAR_STMT = NginxElementTypeFactory.createType("VAR_STMT");

  IElementType BINARY_OPERATOR = new NginxTokenType("BINARY_OPERATOR");
  IElementType CARET_TILDE = new NginxTokenType("CARET_TILDE");
  IElementType COMMENT = new NginxTokenType("COMMENT");
  IElementType CONCAT_JOIN = new NginxTokenType("CONCAT_JOIN");
  IElementType DQSTRING = new NginxTokenType("DQSTRING");
  IElementType DQUOTE = new NginxTokenType("DQUOTE");
  IElementType EQUAL = new NginxTokenType("EQUAL");
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
  IElementType NUM_MAP = new NginxTokenType("NUM_MAP");
  IElementType NUM_MAP_DEFAULT = new NginxTokenType("NUM_MAP_DEFAULT");
  IElementType NUM_MAP_INCLUDE = new NginxTokenType("NUM_MAP_INCLUDE");
  IElementType NUM_MAP_VOLATILE = new NginxTokenType("NUM_MAP_VOLATILE");
  IElementType QUOTE = new NginxTokenType("QUOTE");
  IElementType RBRACE = new NginxTokenType("RBRACE");
  IElementType RPAREN = new NginxTokenType("RPAREN");
  IElementType SEMICOLON = new NginxTokenType("SEMICOLON");
  IElementType STRING = new NginxTokenType("STRING");
  IElementType TYPES = new NginxTokenType("TYPES");
  IElementType TYPES_INCLUDE = new NginxTokenType("TYPES_INCLUDE");
  IElementType UNARY_OPERATOR = new NginxTokenType("UNARY_OPERATOR");
  IElementType VALUE = new NginxTokenType("VALUE");
  IElementType VARIABLE = new NginxTokenType("VARIABLE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BLOCK_STMT) {
        return new BlockStmtImpl(node);
      }
      else if (type == CONCATENATED_EXPR) {
        return new ConcatenatedExprImpl(node);
      }
      else if (type == CONDITION_EXPR) {
        return new ConditionExprImpl(node);
      }
      else if (type == CONDITION_STMT) {
        return new ConditionStmtImpl(node);
      }
      else if (type == DIRECTIVE_STMT) {
        return new DirectiveStmtImpl(node);
      }
      else if (type == GEO_BLOCK_CONTENT) {
        return new GeoBlockContentImpl(node);
      }
      else if (type == GEO_BLOCK_STMT) {
        return new GeoBlockStmtImpl(node);
      }
      else if (type == GEO_DEFAULT_STMT) {
        return new GeoDefaultStmtImpl(node);
      }
      else if (type == GEO_DELETE_STMT) {
        return new GeoDeleteStmtImpl(node);
      }
      else if (type == GEO_DIRECTIVE_STMT) {
        return new GeoDirectiveStmtImpl(node);
      }
      else if (type == GEO_INCLUDE_STMT) {
        return new GeoIncludeStmtImpl(node);
      }
      else if (type == GEO_PROXY_STMT) {
        return new GeoProxyStmtImpl(node);
      }
      else if (type == GEO_RANGES_STMT) {
        return new GeoRangesStmtImpl(node);
      }
      else if (type == GEO_STMT) {
        return new GeoStmtImpl(node);
      }
      else if (type == GEO_VALUE_STMT) {
        return new GeoValueStmtImpl(node);
      }
      else if (type == IF_DIRECTIVE_STMT) {
        return new IfDirectiveStmtImpl(node);
      }
      else if (type == IF_PAREN_STMT) {
        return new IfParenStmtImpl(node);
      }
      else if (type == IF_STMT) {
        return new IfStmtImpl(node);
      }
      else if (type == LOCATION_DIRECTIVE_STMT) {
        return new LocationDirectiveStmtImpl(node);
      }
      else if (type == LOCATION_MODIFIER_STMT) {
        return new LocationModifierStmtImpl(node);
      }
      else if (type == LOCATION_PATH_STMT) {
        return new LocationPathStmtImpl(node);
      }
      else if (type == LOCATION_STMT) {
        return new LocationStmtImpl(node);
      }
      else if (type == LUA_BLOCK_STMT) {
        return new LuaBlockStmtImpl(node);
      }
      else if (type == LUA_CODE_STMT) {
        return new LuaCodeStmtImpl(node);
      }
      else if (type == LUA_DIRECTIVE_STMT) {
        return new LuaDirectiveStmtImpl(node);
      }
      else if (type == LUA_STMT) {
        return new LuaStmtImpl(node);
      }
      else if (type == MAP_BLOCK_CONTENT) {
        return new MapBlockContentImpl(node);
      }
      else if (type == MAP_BLOCK_STMT) {
        return new MapBlockStmtImpl(node);
      }
      else if (type == MAP_DEFAULT_STMT) {
        return new MapDefaultStmtImpl(node);
      }
      else if (type == MAP_DIRECTIVE_STMT) {
        return new MapDirectiveStmtImpl(node);
      }
      else if (type == MAP_HOSTNAMES_STMT) {
        return new MapHostnamesStmtImpl(node);
      }
      else if (type == MAP_INCLUDE_STMT) {
        return new MapIncludeStmtImpl(node);
      }
      else if (type == MAP_STMT) {
        return new MapStmtImpl(node);
      }
      else if (type == MAP_VALUE_STMT) {
        return new MapValueStmtImpl(node);
      }
      else if (type == MAP_VOLATILE_STMT) {
        return new MapVolatileStmtImpl(node);
      }
      else if (type == NAMED_VALUE_STMT) {
        return new NamedValueStmtImpl(node);
      }
      else if (type == NAME_STMT) {
        return new NameStmtImpl(node);
      }
      else if (type == NUM_MAP_BLOCK_CONTENT) {
        return new NumMapBlockContentImpl(node);
      }
      else if (type == NUM_MAP_BLOCK_STMT) {
        return new NumMapBlockStmtImpl(node);
      }
      else if (type == NUM_MAP_DEFAULT_STMT) {
        return new NumMapDefaultStmtImpl(node);
      }
      else if (type == NUM_MAP_DIRECTIVE_STMT) {
        return new NumMapDirectiveStmtImpl(node);
      }
      else if (type == NUM_MAP_INCLUDE_STMT) {
        return new NumMapIncludeStmtImpl(node);
      }
      else if (type == NUM_MAP_STMT) {
        return new NumMapStmtImpl(node);
      }
      else if (type == NUM_MAP_VALUE_STMT) {
        return new NumMapValueStmtImpl(node);
      }
      else if (type == NUM_MAP_VOLATILE_STMT) {
        return new NumMapVolatileStmtImpl(node);
      }
      else if (type == REGEX_ATOM) {
        return new RegexAtomImpl(node);
      }
      else if (type == REGEX_EXPR) {
        return new RegexExprImpl(node);
      }
      else if (type == REGEX_GROUP) {
        return new RegexGroupImpl(node);
      }
      else if (type == REGULAR_DIRECTIVE_STMT) {
        return new RegularDirectiveStmtImpl(node);
      }
      else if (type == STRING_STMT) {
        return new StringStmtImpl(node);
      }
      else if (type == TYPES_BLOCK_CONTENT) {
        return new TypesBlockContentImpl(node);
      }
      else if (type == TYPES_BLOCK_STMT) {
        return new TypesBlockStmtImpl(node);
      }
      else if (type == TYPES_DIRECTIVE_STMT) {
        return new TypesDirectiveStmtImpl(node);
      }
      else if (type == TYPES_INCLUDE_STMT) {
        return new TypesIncludeStmtImpl(node);
      }
      else if (type == TYPES_MAPPING_STMT) {
        return new TypesMappingStmtImpl(node);
      }
      else if (type == TYPES_STMT) {
        return new TypesStmtImpl(node);
      }
      else if (type == VALUE_STMT) {
        return new ValueStmtImpl(node);
      }
      else if (type == VARIABLE_STMT) {
        return new VariableStmtImpl(node);
      }
      else if (type == VAR_STMT) {
        return new VarStmtImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
