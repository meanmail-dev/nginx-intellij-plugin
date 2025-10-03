// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static dev.meanmail.psi.Types.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class NginxParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return nginxFile(b, l + 1);
  }

  /* ********************************************************** */
  // LBRACE statement* RBRACE
  public static boolean block_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_stmt")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_STMT, null);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, block_stmt_1(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // statement*
  private static boolean block_stmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_stmt_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_stmt_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (variable_stmt | IP_ADDRESS | NUMBER | NUMBER_DURATION | NUMBER_SIZE | VALUE | IDENTIFIER) +
  public static boolean concatenated_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concatenated_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONCATENATED_EXPR, "<concatenated expr>");
    r = concatenated_expr_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!concatenated_expr_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "concatenated_expr", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // variable_stmt | IP_ADDRESS | NUMBER | NUMBER_DURATION | NUMBER_SIZE | VALUE | IDENTIFIER
  private static boolean concatenated_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concatenated_expr_0")) return false;
    boolean r;
    r = variable_stmt(b, l + 1);
    if (!r) r = consumeToken(b, IP_ADDRESS);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, NUMBER_DURATION);
    if (!r) r = consumeToken(b, NUMBER_SIZE);
    if (!r) r = consumeToken(b, VALUE);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  /* ********************************************************** */
  // concatenated_expr | string_stmt
  public static boolean condition_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITION_EXPR, "<condition expr>");
    r = concatenated_expr(b, l + 1);
    if (!r) r = string_stmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // UNARY_OPERATOR condition_expr | condition_expr (BINARY_OPERATOR condition_expr)?
  public static boolean condition_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITION_STMT, "<condition stmt>");
    r = condition_stmt_0(b, l + 1);
    if (!r) r = condition_stmt_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // UNARY_OPERATOR condition_expr
  private static boolean condition_stmt_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_stmt_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNARY_OPERATOR);
    r = r && condition_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // condition_expr (BINARY_OPERATOR condition_expr)?
  private static boolean condition_stmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_stmt_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = condition_expr(b, l + 1);
    r = r && condition_stmt_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (BINARY_OPERATOR condition_expr)?
  private static boolean condition_stmt_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_stmt_1_1")) return false;
    condition_stmt_1_1_0(b, l + 1);
    return true;
  }

  // BINARY_OPERATOR condition_expr
  private static boolean condition_stmt_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_stmt_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BINARY_OPERATOR);
    r = r && condition_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // regular_directive_stmt
  //                     | map_directive_stmt
  //                     | geo_directive_stmt
  //                     | lua_directive_stmt
  //                     | if_directive_stmt
  //                     | location_directive_stmt
  //                     | return_directive_stmt
  public static boolean directive_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DIRECTIVE_STMT, "<directive stmt>");
    r = regular_directive_stmt(b, l + 1);
    if (!r) r = map_directive_stmt(b, l + 1);
    if (!r) r = geo_directive_stmt(b, l + 1);
    if (!r) r = lua_directive_stmt(b, l + 1);
    if (!r) r = if_directive_stmt(b, l + 1);
    if (!r) r = location_directive_stmt(b, l + 1);
    if (!r) r = return_directive_stmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // geo_delete_stmt |
  //     geo_default_stmt |
  //     geo_proxy_stmt |
  //     geo_ranges_stmt |
  //     geo_include_stmt |
  //     geo_value_stmt
  public static boolean geo_block_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "geo_block_content")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GEO_BLOCK_CONTENT, "<geo block content>");
    r = geo_delete_stmt(b, l + 1);
    if (!r) r = geo_default_stmt(b, l + 1);
    if (!r) r = geo_proxy_stmt(b, l + 1);
    if (!r) r = geo_ranges_stmt(b, l + 1);
    if (!r) r = geo_include_stmt(b, l + 1);
    if (!r) r = geo_value_stmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LBRACE geo_block_content* RBRACE
  public static boolean geo_block_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "geo_block_stmt")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GEO_BLOCK_STMT, null);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, geo_block_stmt_1(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // geo_block_content*
  private static boolean geo_block_stmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "geo_block_stmt_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!geo_block_content(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "geo_block_stmt_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // GEO_DEFAULT value_stmt SEMICOLON
  public static boolean geo_default_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "geo_default_stmt")) return false;
    if (!nextTokenIs(b, GEO_DEFAULT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GEO_DEFAULT_STMT, null);
    r = consumeToken(b, GEO_DEFAULT);
    p = r; // pin = 1
    r = r && report_error_(b, value_stmt(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // GEO_DELETE value_stmt SEMICOLON
  public static boolean geo_delete_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "geo_delete_stmt")) return false;
    if (!nextTokenIs(b, GEO_DELETE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GEO_DELETE_STMT, null);
    r = consumeToken(b, GEO_DELETE);
    p = r; // pin = 1
    r = r && report_error_(b, value_stmt(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // geo_stmt variable_stmt [variable_stmt] geo_block_stmt
  public static boolean geo_directive_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "geo_directive_stmt")) return false;
    if (!nextTokenIs(b, GEO)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GEO_DIRECTIVE_STMT, null);
    r = geo_stmt(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, variable_stmt(b, l + 1));
    r = p && report_error_(b, geo_directive_stmt_2(b, l + 1)) && r;
    r = p && geo_block_stmt(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [variable_stmt]
  private static boolean geo_directive_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "geo_directive_stmt_2")) return false;
    variable_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // GEO_INCLUDE value_stmt SEMICOLON
  public static boolean geo_include_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "geo_include_stmt")) return false;
    if (!nextTokenIs(b, GEO_INCLUDE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GEO_INCLUDE_STMT, null);
    r = consumeToken(b, GEO_INCLUDE);
    p = r; // pin = 1
    r = r && report_error_(b, value_stmt(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // GEO_PROXY value_stmt SEMICOLON
  public static boolean geo_proxy_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "geo_proxy_stmt")) return false;
    if (!nextTokenIs(b, GEO_PROXY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GEO_PROXY_STMT, null);
    r = consumeToken(b, GEO_PROXY);
    p = r; // pin = 1
    r = r && report_error_(b, value_stmt(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // GEO_RANGES SEMICOLON
  public static boolean geo_ranges_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "geo_ranges_stmt")) return false;
    if (!nextTokenIs(b, GEO_RANGES)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GEO_RANGES_STMT, null);
    r = consumeTokens(b, 1, GEO_RANGES, SEMICOLON);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // GEO
  public static boolean geo_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "geo_stmt")) return false;
    if (!nextTokenIs(b, GEO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GEO);
    exit_section_(b, m, GEO_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // value_stmt value_stmt SEMICOLON
  public static boolean geo_value_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "geo_value_stmt")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GEO_VALUE_STMT, "<geo value stmt>");
    r = value_stmt(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, value_stmt(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // if_stmt if_paren_stmt block_stmt
  public static boolean if_directive_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_directive_stmt")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IF_DIRECTIVE_STMT, null);
    r = if_stmt(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, if_paren_stmt(b, l + 1));
    r = p && block_stmt(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // LPAREN condition_stmt RPAREN
  public static boolean if_paren_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_paren_stmt")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IF_PAREN_STMT, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, condition_stmt(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // IF
  public static boolean if_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_stmt")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    exit_section_(b, m, IF_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // location_stmt location_modifier_stmt? location_path_stmt block_stmt
  public static boolean location_directive_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "location_directive_stmt")) return false;
    if (!nextTokenIs(b, LOCATION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LOCATION_DIRECTIVE_STMT, null);
    r = location_stmt(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, location_directive_stmt_1(b, l + 1));
    r = p && report_error_(b, location_path_stmt(b, l + 1)) && r;
    r = p && block_stmt(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // location_modifier_stmt?
  private static boolean location_directive_stmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "location_directive_stmt_1")) return false;
    location_modifier_stmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (BINARY_OPERATOR | CARET_TILDE)?
  public static boolean location_modifier_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "location_modifier_stmt")) return false;
    Marker m = enter_section_(b, l, _NONE_, LOCATION_MODIFIER_STMT, "<location modifier stmt>");
    location_modifier_stmt_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // BINARY_OPERATOR | CARET_TILDE
  private static boolean location_modifier_stmt_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "location_modifier_stmt_0")) return false;
    boolean r;
    r = consumeToken(b, BINARY_OPERATOR);
    if (!r) r = consumeToken(b, CARET_TILDE);
    return r;
  }

  /* ********************************************************** */
  // value_stmt
  public static boolean location_path_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "location_path_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOCATION_PATH_STMT, "<location path stmt>");
    r = value_stmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LOCATION
  public static boolean location_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "location_stmt")) return false;
    if (!nextTokenIs(b, LOCATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOCATION);
    exit_section_(b, m, LOCATION_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACE lua_code_stmt RBRACE
  public static boolean lua_block_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lua_block_stmt")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LUA_BLOCK_STMT, null);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, lua_code_stmt(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // LUA+
  public static boolean lua_code_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lua_code_stmt")) return false;
    if (!nextTokenIs(b, LUA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LUA);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, LUA)) break;
      if (!empty_element_parsed_guard_(b, "lua_code_stmt", c)) break;
    }
    exit_section_(b, m, LUA_CODE_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // lua_stmt value_stmt* lua_block_stmt
  public static boolean lua_directive_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lua_directive_stmt")) return false;
    if (!nextTokenIs(b, LUA_BLOCK_DIRECTIVE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LUA_DIRECTIVE_STMT, null);
    r = lua_stmt(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, lua_directive_stmt_1(b, l + 1));
    r = p && lua_block_stmt(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // value_stmt*
  private static boolean lua_directive_stmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lua_directive_stmt_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!value_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lua_directive_stmt_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // LUA_BLOCK_DIRECTIVE
  public static boolean lua_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lua_stmt")) return false;
    if (!nextTokenIs(b, LUA_BLOCK_DIRECTIVE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LUA_BLOCK_DIRECTIVE);
    exit_section_(b, m, LUA_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // map_volatile_stmt |
  //     map_default_stmt |
  //     map_hostnames_stmt |
  //     map_include_stmt |
  //     map_value_stmt
  public static boolean map_block_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_block_content")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAP_BLOCK_CONTENT, "<map block content>");
    r = map_volatile_stmt(b, l + 1);
    if (!r) r = map_default_stmt(b, l + 1);
    if (!r) r = map_hostnames_stmt(b, l + 1);
    if (!r) r = map_include_stmt(b, l + 1);
    if (!r) r = map_value_stmt(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LBRACE map_block_content* RBRACE
  public static boolean map_block_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_block_stmt")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MAP_BLOCK_STMT, null);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, map_block_stmt_1(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // map_block_content*
  private static boolean map_block_stmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_block_stmt_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!map_block_content(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "map_block_stmt_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // MAP_DEFAULT value_stmt SEMICOLON
  public static boolean map_default_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_default_stmt")) return false;
    if (!nextTokenIs(b, MAP_DEFAULT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MAP_DEFAULT_STMT, null);
    r = consumeToken(b, MAP_DEFAULT);
    p = r; // pin = 1
    r = r && report_error_(b, value_stmt(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // map_stmt value_stmt value_stmt map_block_stmt
  public static boolean map_directive_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_directive_stmt")) return false;
    if (!nextTokenIs(b, MAP)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MAP_DIRECTIVE_STMT, null);
    r = map_stmt(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, value_stmt(b, l + 1));
    r = p && report_error_(b, value_stmt(b, l + 1)) && r;
    r = p && map_block_stmt(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // MAP_HOSTNAMES SEMICOLON
  public static boolean map_hostnames_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_hostnames_stmt")) return false;
    if (!nextTokenIs(b, MAP_HOSTNAMES)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MAP_HOSTNAMES_STMT, null);
    r = consumeTokens(b, 1, MAP_HOSTNAMES, SEMICOLON);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // MAP_INCLUDE value_stmt SEMICOLON
  public static boolean map_include_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_include_stmt")) return false;
    if (!nextTokenIs(b, MAP_INCLUDE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MAP_INCLUDE_STMT, null);
    r = consumeToken(b, MAP_INCLUDE);
    p = r; // pin = 1
    r = r && report_error_(b, value_stmt(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // MAP
  public static boolean map_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_stmt")) return false;
    if (!nextTokenIs(b, MAP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MAP);
    exit_section_(b, m, MAP_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // value_stmt value_stmt SEMICOLON
  public static boolean map_value_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_value_stmt")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MAP_VALUE_STMT, "<map value stmt>");
    r = value_stmt(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, value_stmt(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // MAP_VOLATILE SEMICOLON
  public static boolean map_volatile_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_volatile_stmt")) return false;
    if (!nextTokenIs(b, MAP_VOLATILE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MAP_VOLATILE_STMT, null);
    r = consumeTokens(b, 1, MAP_VOLATILE, SEMICOLON);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean name_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "name_stmt")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, NAME_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // statement*
  static boolean nginxFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nginxFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nginxFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // name_stmt BINARY_OPERATOR? value_stmt* (SEMICOLON | block_stmt)
  public static boolean regular_directive_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "regular_directive_stmt")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, REGULAR_DIRECTIVE_STMT, null);
    r = name_stmt(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, regular_directive_stmt_1(b, l + 1));
    r = p && report_error_(b, regular_directive_stmt_2(b, l + 1)) && r;
    r = p && regular_directive_stmt_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // BINARY_OPERATOR?
  private static boolean regular_directive_stmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "regular_directive_stmt_1")) return false;
    consumeToken(b, BINARY_OPERATOR);
    return true;
  }

  // value_stmt*
  private static boolean regular_directive_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "regular_directive_stmt_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!value_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "regular_directive_stmt_2", c)) break;
    }
    return true;
  }

  // SEMICOLON | block_stmt
  private static boolean regular_directive_stmt_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "regular_directive_stmt_3")) return false;
    boolean r;
    r = consumeToken(b, SEMICOLON);
    if (!r) r = block_stmt(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // return_stmt value_stmt* SEMICOLON
  public static boolean return_directive_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_directive_stmt")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RETURN_DIRECTIVE_STMT, null);
    r = return_stmt(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, return_directive_stmt_1(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // value_stmt*
  private static boolean return_directive_stmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_directive_stmt_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!value_stmt(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "return_directive_stmt_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // RETURN
  public static boolean return_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_stmt")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    exit_section_(b, m, RETURN_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // directive_stmt [COMMENT]
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = directive_stmt(b, l + 1);
    r = r && statement_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [COMMENT]
  private static boolean statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  /* ********************************************************** */
  // (QUOTE [STRING] QUOTE) | (DQUOTE [DQSTRING] DQUOTE)
  public static boolean string_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_stmt")) return false;
    if (!nextTokenIs(b, "<string stmt>", DQUOTE, QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_STMT, "<string stmt>");
    r = string_stmt_0(b, l + 1);
    if (!r) r = string_stmt_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // QUOTE [STRING] QUOTE
  private static boolean string_stmt_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_stmt_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUOTE);
    r = r && string_stmt_0_1(b, l + 1);
    r = r && consumeToken(b, QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [STRING]
  private static boolean string_stmt_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_stmt_0_1")) return false;
    consumeToken(b, STRING);
    return true;
  }

  // DQUOTE [DQSTRING] DQUOTE
  private static boolean string_stmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_stmt_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DQUOTE);
    r = r && string_stmt_1_1(b, l + 1);
    r = r && consumeToken(b, DQUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [DQSTRING]
  private static boolean string_stmt_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_stmt_1_1")) return false;
    consumeToken(b, DQSTRING);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  //                | IP_RANGE
  //                | IP_ADDRESS
  //                | NUMBER
  //                | NUMBER_DURATION
  //                | NUMBER_SIZE
  //                | VALUE
  //                | string_stmt
  //                | variable_stmt
  //                | concatenated_expr
  public static boolean value_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_STMT, "<value stmt>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, IP_RANGE);
    if (!r) r = consumeToken(b, IP_ADDRESS);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, NUMBER_DURATION);
    if (!r) r = consumeToken(b, NUMBER_SIZE);
    if (!r) r = consumeToken(b, VALUE);
    if (!r) r = string_stmt(b, l + 1);
    if (!r) r = variable_stmt(b, l + 1);
    if (!r) r = concatenated_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VARIABLE
  public static boolean variable_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_stmt")) return false;
    if (!nextTokenIs(b, VARIABLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VARIABLE);
    exit_section_(b, m, VARIABLE_STMT, r);
    return r;
  }

}
