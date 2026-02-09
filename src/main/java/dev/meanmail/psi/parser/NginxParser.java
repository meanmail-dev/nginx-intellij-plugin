// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static dev.meanmail.psi.Types.*;
import static dev.meanmail.psi.parser.NginxParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class NginxParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_) {
    return parse_root_(root_, builder_, 0);
  }

  static boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return nginxFile(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // LBRACE statement* RBRACE
  public static boolean block_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "block_stmt")) return false;
    if (!nextTokenIs(builder_, LBRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, BLOCK_STMT, null);
    result_ = consumeToken(builder_, LBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, block_stmt_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RBRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // statement*
  private static boolean block_stmt_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "block_stmt_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!statement(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "block_stmt_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER !EQUAL | VALUE | variable_stmt | string_stmt
  static boolean concat_atom(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "concat_atom")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = concat_atom_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, VALUE);
    if (!result_) result_ = variable_stmt(builder_, level_ + 1);
    if (!result_) result_ = string_stmt(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // IDENTIFIER !EQUAL
  private static boolean concat_atom_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "concat_atom_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    result_ = result_ && concat_atom_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // !EQUAL
  private static boolean concat_atom_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "concat_atom_0_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !consumeToken(builder_, EQUAL);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // concat_atom (CONCAT_JOIN concat_atom)+
  public static boolean concatenated_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "concatenated_expr")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, CONCATENATED_EXPR, "<concatenated expr>");
    result_ = concat_atom(builder_, level_ + 1);
    result_ = result_ && concatenated_expr_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (CONCAT_JOIN concat_atom)+
  private static boolean concatenated_expr_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "concatenated_expr_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = concatenated_expr_1_0(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!concatenated_expr_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "concatenated_expr_1", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // CONCAT_JOIN concat_atom
  private static boolean concatenated_expr_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "concatenated_expr_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, CONCAT_JOIN);
    result_ = result_ && concat_atom(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // string_stmt | variable_stmt | VALUE | IDENTIFIER | concatenated_expr
  public static boolean condition_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "condition_expr")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, CONDITION_EXPR, "<condition expr>");
    result_ = string_stmt(builder_, level_ + 1);
    if (!result_) result_ = variable_stmt(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, VALUE);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = concatenated_expr(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // UNARY_OPERATOR condition_expr
  //                  | condition_expr (EQUAL condition_expr | BINARY_OPERATOR regex_expr)?
  public static boolean condition_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "condition_stmt")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, CONDITION_STMT, "<condition stmt>");
    result_ = condition_stmt_0(builder_, level_ + 1);
    if (!result_) result_ = condition_stmt_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // UNARY_OPERATOR condition_expr
  private static boolean condition_stmt_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "condition_stmt_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, UNARY_OPERATOR);
    result_ = result_ && condition_expr(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // condition_expr (EQUAL condition_expr | BINARY_OPERATOR regex_expr)?
  private static boolean condition_stmt_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "condition_stmt_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = condition_expr(builder_, level_ + 1);
    result_ = result_ && condition_stmt_1_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (EQUAL condition_expr | BINARY_OPERATOR regex_expr)?
  private static boolean condition_stmt_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "condition_stmt_1_1")) return false;
    condition_stmt_1_1_0(builder_, level_ + 1);
    return true;
  }

  // EQUAL condition_expr | BINARY_OPERATOR regex_expr
  private static boolean condition_stmt_1_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "condition_stmt_1_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = condition_stmt_1_1_0_0(builder_, level_ + 1);
    if (!result_) result_ = condition_stmt_1_1_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // EQUAL condition_expr
  private static boolean condition_stmt_1_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "condition_stmt_1_1_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, EQUAL);
    result_ = result_ && condition_expr(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // BINARY_OPERATOR regex_expr
  private static boolean condition_stmt_1_1_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "condition_stmt_1_1_0_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, BINARY_OPERATOR);
    result_ = result_ && regex_expr(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // regular_directive_stmt
  //                     | map_directive_stmt
  //                     | num_map_directive_stmt
  //                     | geo_directive_stmt
  //                     | types_directive_stmt
  //                     | lua_directive_stmt
  //                     | if_directive_stmt
  //                     | location_directive_stmt
  //                     | var_stmt
  public static boolean directive_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "directive_stmt")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, DIRECTIVE_STMT, "<directive stmt>");
    result_ = regular_directive_stmt(builder_, level_ + 1);
    if (!result_) result_ = map_directive_stmt(builder_, level_ + 1);
    if (!result_) result_ = num_map_directive_stmt(builder_, level_ + 1);
    if (!result_) result_ = geo_directive_stmt(builder_, level_ + 1);
    if (!result_) result_ = types_directive_stmt(builder_, level_ + 1);
    if (!result_) result_ = lua_directive_stmt(builder_, level_ + 1);
    if (!result_) result_ = if_directive_stmt(builder_, level_ + 1);
    if (!result_) result_ = location_directive_stmt(builder_, level_ + 1);
    if (!result_) result_ = var_stmt(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // geo_delete_stmt |
  //     geo_default_stmt |
  //     geo_proxy_stmt |
  //     geo_ranges_stmt |
  //     geo_include_stmt |
  //     geo_value_stmt
  public static boolean geo_block_content(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "geo_block_content")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, GEO_BLOCK_CONTENT, "<geo block content>");
    result_ = geo_delete_stmt(builder_, level_ + 1);
    if (!result_) result_ = geo_default_stmt(builder_, level_ + 1);
    if (!result_) result_ = geo_proxy_stmt(builder_, level_ + 1);
    if (!result_) result_ = geo_ranges_stmt(builder_, level_ + 1);
    if (!result_) result_ = geo_include_stmt(builder_, level_ + 1);
    if (!result_) result_ = geo_value_stmt(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // LBRACE geo_block_content* RBRACE
  public static boolean geo_block_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "geo_block_stmt")) return false;
    if (!nextTokenIs(builder_, LBRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, GEO_BLOCK_STMT, null);
    result_ = consumeToken(builder_, LBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, geo_block_stmt_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RBRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // geo_block_content*
  private static boolean geo_block_stmt_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "geo_block_stmt_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!geo_block_content(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "geo_block_stmt_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // GEO_DEFAULT value_stmt SEMICOLON
  public static boolean geo_default_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "geo_default_stmt")) return false;
    if (!nextTokenIs(builder_, GEO_DEFAULT)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, GEO_DEFAULT_STMT, null);
    result_ = consumeToken(builder_, GEO_DEFAULT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, value_stmt(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SEMICOLON) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // GEO_DELETE value_stmt SEMICOLON
  public static boolean geo_delete_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "geo_delete_stmt")) return false;
    if (!nextTokenIs(builder_, GEO_DELETE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, GEO_DELETE_STMT, null);
    result_ = consumeToken(builder_, GEO_DELETE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, value_stmt(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SEMICOLON) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // geo_stmt variable_stmt [variable_stmt] geo_block_stmt
  public static boolean geo_directive_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "geo_directive_stmt")) return false;
    if (!nextTokenIs(builder_, GEO)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, GEO_DIRECTIVE_STMT, null);
    result_ = geo_stmt(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, variable_stmt(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, geo_directive_stmt_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && geo_block_stmt(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // [variable_stmt]
  private static boolean geo_directive_stmt_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "geo_directive_stmt_2")) return false;
    variable_stmt(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // GEO_INCLUDE value_stmt SEMICOLON
  public static boolean geo_include_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "geo_include_stmt")) return false;
    if (!nextTokenIs(builder_, GEO_INCLUDE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, GEO_INCLUDE_STMT, null);
    result_ = consumeToken(builder_, GEO_INCLUDE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, value_stmt(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SEMICOLON) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // GEO_PROXY value_stmt SEMICOLON
  public static boolean geo_proxy_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "geo_proxy_stmt")) return false;
    if (!nextTokenIs(builder_, GEO_PROXY)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, GEO_PROXY_STMT, null);
    result_ = consumeToken(builder_, GEO_PROXY);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, value_stmt(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SEMICOLON) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // GEO_RANGES SEMICOLON
  public static boolean geo_ranges_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "geo_ranges_stmt")) return false;
    if (!nextTokenIs(builder_, GEO_RANGES)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, GEO_RANGES_STMT, null);
    result_ = consumeTokens(builder_, 1, GEO_RANGES, SEMICOLON);
    pinned_ = result_; // pin = 1
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // GEO
  public static boolean geo_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "geo_stmt")) return false;
    if (!nextTokenIs(builder_, GEO)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, GEO);
    exit_section_(builder_, marker_, GEO_STMT, result_);
    return result_;
  }

  /* ********************************************************** */
  // value_stmt value_stmt SEMICOLON
  public static boolean geo_value_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "geo_value_stmt")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, GEO_VALUE_STMT, "<geo value stmt>");
    result_ = value_stmt(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, value_stmt(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SEMICOLON) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // if_stmt if_paren_stmt block_stmt
  public static boolean if_directive_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "if_directive_stmt")) return false;
    if (!nextTokenIs(builder_, IF)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, IF_DIRECTIVE_STMT, null);
    result_ = if_stmt(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, if_paren_stmt(builder_, level_ + 1));
    result_ = pinned_ && block_stmt(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // LPAREN condition_stmt RPAREN
  public static boolean if_paren_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "if_paren_stmt")) return false;
    if (!nextTokenIs(builder_, LPAREN)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, IF_PAREN_STMT, null);
    result_ = consumeToken(builder_, LPAREN);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, condition_stmt(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RPAREN) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // IF
  public static boolean if_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "if_stmt")) return false;
    if (!nextTokenIs(builder_, IF)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IF);
    exit_section_(builder_, marker_, IF_STMT, result_);
    return result_;
  }

  /* ********************************************************** */
  // location_stmt location_modifier_stmt? location_path_stmt block_stmt
  public static boolean location_directive_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "location_directive_stmt")) return false;
    if (!nextTokenIs(builder_, LOCATION)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, LOCATION_DIRECTIVE_STMT, null);
    result_ = location_stmt(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, location_directive_stmt_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, location_path_stmt(builder_, level_ + 1)) && result_;
    result_ = pinned_ && block_stmt(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // location_modifier_stmt?
  private static boolean location_directive_stmt_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "location_directive_stmt_1")) return false;
    location_modifier_stmt(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // (BINARY_OPERATOR | EQUAL | CARET_TILDE)?
  public static boolean location_modifier_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "location_modifier_stmt")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, LOCATION_MODIFIER_STMT, "<location modifier stmt>");
    location_modifier_stmt_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, true, false, null);
    return true;
  }

  // BINARY_OPERATOR | EQUAL | CARET_TILDE
  private static boolean location_modifier_stmt_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "location_modifier_stmt_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, BINARY_OPERATOR);
    if (!result_) result_ = consumeToken(builder_, EQUAL);
    if (!result_) result_ = consumeToken(builder_, CARET_TILDE);
    return result_;
  }

  /* ********************************************************** */
  // value_stmt
  public static boolean location_path_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "location_path_stmt")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, LOCATION_PATH_STMT, "<location path stmt>");
    result_ = value_stmt(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // LOCATION
  public static boolean location_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "location_stmt")) return false;
    if (!nextTokenIs(builder_, LOCATION)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LOCATION);
    exit_section_(builder_, marker_, LOCATION_STMT, result_);
    return result_;
  }

  /* ********************************************************** */
  // LBRACE lua_code_stmt RBRACE
  public static boolean lua_block_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lua_block_stmt")) return false;
    if (!nextTokenIs(builder_, LBRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, LUA_BLOCK_STMT, null);
    result_ = consumeToken(builder_, LBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, lua_code_stmt(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RBRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // LUA+
  public static boolean lua_code_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lua_code_stmt")) return false;
    if (!nextTokenIs(builder_, LUA)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LUA);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!consumeToken(builder_, LUA)) break;
      if (!empty_element_parsed_guard_(builder_, "lua_code_stmt", pos_)) break;
    }
    exit_section_(builder_, marker_, LUA_CODE_STMT, result_);
    return result_;
  }

  /* ********************************************************** */
  // lua_stmt value_stmt* lua_block_stmt
  public static boolean lua_directive_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lua_directive_stmt")) return false;
    if (!nextTokenIs(builder_, LUA_BLOCK_DIRECTIVE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, LUA_DIRECTIVE_STMT, null);
    result_ = lua_stmt(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, lua_directive_stmt_1(builder_, level_ + 1));
    result_ = pinned_ && lua_block_stmt(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // value_stmt*
  private static boolean lua_directive_stmt_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lua_directive_stmt_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!value_stmt(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "lua_directive_stmt_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // LUA_BLOCK_DIRECTIVE
  public static boolean lua_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "lua_stmt")) return false;
    if (!nextTokenIs(builder_, LUA_BLOCK_DIRECTIVE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LUA_BLOCK_DIRECTIVE);
    exit_section_(builder_, marker_, LUA_STMT, result_);
    return result_;
  }

  /* ********************************************************** */
  // map_volatile_stmt |
  //     map_default_stmt |
  //     map_hostnames_stmt |
  //     map_include_stmt |
  //     map_value_stmt
  public static boolean map_block_content(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "map_block_content")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MAP_BLOCK_CONTENT, "<map block content>");
    result_ = map_volatile_stmt(builder_, level_ + 1);
    if (!result_) result_ = map_default_stmt(builder_, level_ + 1);
    if (!result_) result_ = map_hostnames_stmt(builder_, level_ + 1);
    if (!result_) result_ = map_include_stmt(builder_, level_ + 1);
    if (!result_) result_ = map_value_stmt(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // LBRACE map_block_content* RBRACE
  public static boolean map_block_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "map_block_stmt")) return false;
    if (!nextTokenIs(builder_, LBRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MAP_BLOCK_STMT, null);
    result_ = consumeToken(builder_, LBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, map_block_stmt_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RBRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // map_block_content*
  private static boolean map_block_stmt_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "map_block_stmt_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!map_block_content(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "map_block_stmt_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // MAP_DEFAULT value_stmt SEMICOLON
  public static boolean map_default_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "map_default_stmt")) return false;
    if (!nextTokenIs(builder_, MAP_DEFAULT)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MAP_DEFAULT_STMT, null);
    result_ = consumeToken(builder_, MAP_DEFAULT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, value_stmt(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SEMICOLON) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // map_stmt value_stmt value_stmt map_block_stmt
  public static boolean map_directive_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "map_directive_stmt")) return false;
    if (!nextTokenIs(builder_, MAP)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MAP_DIRECTIVE_STMT, null);
    result_ = map_stmt(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, value_stmt(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, value_stmt(builder_, level_ + 1)) && result_;
    result_ = pinned_ && map_block_stmt(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // MAP_HOSTNAMES SEMICOLON
  public static boolean map_hostnames_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "map_hostnames_stmt")) return false;
    if (!nextTokenIs(builder_, MAP_HOSTNAMES)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MAP_HOSTNAMES_STMT, null);
    result_ = consumeTokens(builder_, 1, MAP_HOSTNAMES, SEMICOLON);
    pinned_ = result_; // pin = 1
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // MAP_INCLUDE value_stmt SEMICOLON
  public static boolean map_include_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "map_include_stmt")) return false;
    if (!nextTokenIs(builder_, MAP_INCLUDE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MAP_INCLUDE_STMT, null);
    result_ = consumeToken(builder_, MAP_INCLUDE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, value_stmt(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SEMICOLON) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // MAP
  public static boolean map_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "map_stmt")) return false;
    if (!nextTokenIs(builder_, MAP)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, MAP);
    exit_section_(builder_, marker_, MAP_STMT, result_);
    return result_;
  }

  /* ********************************************************** */
  // value_stmt value_stmt SEMICOLON
  public static boolean map_value_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "map_value_stmt")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MAP_VALUE_STMT, "<map value stmt>");
    result_ = value_stmt(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, value_stmt(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SEMICOLON) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // MAP_VOLATILE SEMICOLON
  public static boolean map_volatile_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "map_volatile_stmt")) return false;
    if (!nextTokenIs(builder_, MAP_VOLATILE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MAP_VOLATILE_STMT, null);
    result_ = consumeTokens(builder_, 1, MAP_VOLATILE, SEMICOLON);
    pinned_ = result_; // pin = 1
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean name_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "name_stmt")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    exit_section_(builder_, marker_, NAME_STMT, result_);
    return result_;
  }

  /* ********************************************************** */
  // IDENTIFIER EQUAL part_value_stmt
  public static boolean named_value_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "named_value_stmt")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, IDENTIFIER, EQUAL);
    result_ = result_ && part_value_stmt(builder_, level_ + 1);
    exit_section_(builder_, marker_, NAMED_VALUE_STMT, result_);
    return result_;
  }

  /* ********************************************************** */
  // statement*
  static boolean nginxFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "nginxFile")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!statement(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "nginxFile", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // num_map_volatile_stmt |
  //     num_map_default_stmt |
  //     num_map_include_stmt |
  //     num_map_value_stmt
  public static boolean num_map_block_content(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "num_map_block_content")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, NUM_MAP_BLOCK_CONTENT, "<num map block content>");
    result_ = num_map_volatile_stmt(builder_, level_ + 1);
    if (!result_) result_ = num_map_default_stmt(builder_, level_ + 1);
    if (!result_) result_ = num_map_include_stmt(builder_, level_ + 1);
    if (!result_) result_ = num_map_value_stmt(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // LBRACE num_map_block_content* RBRACE
  public static boolean num_map_block_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "num_map_block_stmt")) return false;
    if (!nextTokenIs(builder_, LBRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, NUM_MAP_BLOCK_STMT, null);
    result_ = consumeToken(builder_, LBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, num_map_block_stmt_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RBRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // num_map_block_content*
  private static boolean num_map_block_stmt_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "num_map_block_stmt_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!num_map_block_content(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "num_map_block_stmt_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // NUM_MAP_DEFAULT value_stmt SEMICOLON
  public static boolean num_map_default_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "num_map_default_stmt")) return false;
    if (!nextTokenIs(builder_, NUM_MAP_DEFAULT)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, NUM_MAP_DEFAULT_STMT, null);
    result_ = consumeToken(builder_, NUM_MAP_DEFAULT);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, value_stmt(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SEMICOLON) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // num_map_stmt value_stmt value_stmt num_map_block_stmt
  public static boolean num_map_directive_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "num_map_directive_stmt")) return false;
    if (!nextTokenIs(builder_, NUM_MAP)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, NUM_MAP_DIRECTIVE_STMT, null);
    result_ = num_map_stmt(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, value_stmt(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, value_stmt(builder_, level_ + 1)) && result_;
    result_ = pinned_ && num_map_block_stmt(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // NUM_MAP_INCLUDE value_stmt SEMICOLON
  public static boolean num_map_include_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "num_map_include_stmt")) return false;
    if (!nextTokenIs(builder_, NUM_MAP_INCLUDE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, NUM_MAP_INCLUDE_STMT, null);
    result_ = consumeToken(builder_, NUM_MAP_INCLUDE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, value_stmt(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SEMICOLON) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // NUM_MAP
  public static boolean num_map_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "num_map_stmt")) return false;
    if (!nextTokenIs(builder_, NUM_MAP)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NUM_MAP);
    exit_section_(builder_, marker_, NUM_MAP_STMT, result_);
    return result_;
  }

  /* ********************************************************** */
  // value_stmt value_stmt SEMICOLON
  public static boolean num_map_value_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "num_map_value_stmt")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, NUM_MAP_VALUE_STMT, "<num map value stmt>");
    result_ = value_stmt(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, value_stmt(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SEMICOLON) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // NUM_MAP_VOLATILE SEMICOLON
  public static boolean num_map_volatile_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "num_map_volatile_stmt")) return false;
    if (!nextTokenIs(builder_, NUM_MAP_VOLATILE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, NUM_MAP_VOLATILE_STMT, null);
    result_ = consumeTokens(builder_, 1, NUM_MAP_VOLATILE, SEMICOLON);
    pinned_ = result_; // pin = 1
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // concatenated_expr
  //                            | VALUE EQUAL (IDENTIFIER | VALUE | variable_stmt | concatenated_expr) (EQUAL (IDENTIFIER | VALUE | variable_stmt | concatenated_expr))*
  //                            | IDENTIFIER !EQUAL
  //                            | VALUE
  //                            | string_stmt
  //                            | variable_stmt
  static boolean part_value_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "part_value_stmt")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = concatenated_expr(builder_, level_ + 1);
    if (!result_) result_ = part_value_stmt_1(builder_, level_ + 1);
    if (!result_) result_ = part_value_stmt_2(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, VALUE);
    if (!result_) result_ = string_stmt(builder_, level_ + 1);
    if (!result_) result_ = variable_stmt(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // VALUE EQUAL (IDENTIFIER | VALUE | variable_stmt | concatenated_expr) (EQUAL (IDENTIFIER | VALUE | variable_stmt | concatenated_expr))*
  private static boolean part_value_stmt_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "part_value_stmt_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, VALUE, EQUAL);
    result_ = result_ && part_value_stmt_1_2(builder_, level_ + 1);
    result_ = result_ && part_value_stmt_1_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // IDENTIFIER | VALUE | variable_stmt | concatenated_expr
  private static boolean part_value_stmt_1_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "part_value_stmt_1_2")) return false;
    boolean result_;
    result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = consumeToken(builder_, VALUE);
    if (!result_) result_ = variable_stmt(builder_, level_ + 1);
    if (!result_) result_ = concatenated_expr(builder_, level_ + 1);
    return result_;
  }

  // (EQUAL (IDENTIFIER | VALUE | variable_stmt | concatenated_expr))*
  private static boolean part_value_stmt_1_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "part_value_stmt_1_3")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!part_value_stmt_1_3_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "part_value_stmt_1_3", pos_)) break;
    }
    return true;
  }

  // EQUAL (IDENTIFIER | VALUE | variable_stmt | concatenated_expr)
  private static boolean part_value_stmt_1_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "part_value_stmt_1_3_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, EQUAL);
    result_ = result_ && part_value_stmt_1_3_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // IDENTIFIER | VALUE | variable_stmt | concatenated_expr
  private static boolean part_value_stmt_1_3_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "part_value_stmt_1_3_0_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = consumeToken(builder_, VALUE);
    if (!result_) result_ = variable_stmt(builder_, level_ + 1);
    if (!result_) result_ = concatenated_expr(builder_, level_ + 1);
    return result_;
  }

  // IDENTIFIER !EQUAL
  private static boolean part_value_stmt_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "part_value_stmt_2")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IDENTIFIER);
    result_ = result_ && part_value_stmt_2_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // !EQUAL
  private static boolean part_value_stmt_2_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "part_value_stmt_2_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NOT_);
    result_ = !consumeToken(builder_, EQUAL);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // string_stmt | variable_stmt | VALUE | IDENTIFIER | regex_group
  public static boolean regex_atom(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "regex_atom")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, REGEX_ATOM, "<regex atom>");
    result_ = string_stmt(builder_, level_ + 1);
    if (!result_) result_ = variable_stmt(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, VALUE);
    if (!result_) result_ = consumeToken(builder_, IDENTIFIER);
    if (!result_) result_ = regex_group(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // regex_atom ((CONCAT_JOIN)? regex_atom)*
  public static boolean regex_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "regex_expr")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, REGEX_EXPR, "<regex expr>");
    result_ = regex_atom(builder_, level_ + 1);
    result_ = result_ && regex_expr_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ((CONCAT_JOIN)? regex_atom)*
  private static boolean regex_expr_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "regex_expr_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!regex_expr_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "regex_expr_1", pos_)) break;
    }
    return true;
  }

  // (CONCAT_JOIN)? regex_atom
  private static boolean regex_expr_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "regex_expr_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = regex_expr_1_0_0(builder_, level_ + 1);
    result_ = result_ && regex_atom(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (CONCAT_JOIN)?
  private static boolean regex_expr_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "regex_expr_1_0_0")) return false;
    consumeToken(builder_, CONCAT_JOIN);
    return true;
  }

  /* ********************************************************** */
  // LPAREN regex_expr? RPAREN
  public static boolean regex_group(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "regex_group")) return false;
    if (!nextTokenIs(builder_, LPAREN)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LPAREN);
    result_ = result_ && regex_group_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RPAREN);
    exit_section_(builder_, marker_, REGEX_GROUP, result_);
    return result_;
  }

  // regex_expr?
  private static boolean regex_group_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "regex_group_1")) return false;
    regex_expr(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // name_stmt (BINARY_OPERATOR | EQUAL)? value_stmt* (SEMICOLON | block_stmt)
  public static boolean regular_directive_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "regular_directive_stmt")) return false;
    if (!nextTokenIs(builder_, IDENTIFIER)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, REGULAR_DIRECTIVE_STMT, null);
    result_ = name_stmt(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, regular_directive_stmt_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, regular_directive_stmt_2(builder_, level_ + 1)) && result_;
    result_ = pinned_ && regular_directive_stmt_3(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // (BINARY_OPERATOR | EQUAL)?
  private static boolean regular_directive_stmt_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "regular_directive_stmt_1")) return false;
    regular_directive_stmt_1_0(builder_, level_ + 1);
    return true;
  }

  // BINARY_OPERATOR | EQUAL
  private static boolean regular_directive_stmt_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "regular_directive_stmt_1_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, BINARY_OPERATOR);
    if (!result_) result_ = consumeToken(builder_, EQUAL);
    return result_;
  }

  // value_stmt*
  private static boolean regular_directive_stmt_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "regular_directive_stmt_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!value_stmt(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "regular_directive_stmt_2", pos_)) break;
    }
    return true;
  }

  // SEMICOLON | block_stmt
  private static boolean regular_directive_stmt_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "regular_directive_stmt_3")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SEMICOLON);
    if (!result_) result_ = block_stmt(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // directive_stmt [COMMENT]
  static boolean statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = directive_stmt(builder_, level_ + 1);
    result_ = result_ && statement_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // [COMMENT]
  private static boolean statement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_1")) return false;
    consumeToken(builder_, COMMENT);
    return true;
  }

  /* ********************************************************** */
  // (QUOTE [STRING] QUOTE) | (DQUOTE [DQSTRING] DQUOTE)
  public static boolean string_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "string_stmt")) return false;
    if (!nextTokenIs(builder_, "<string stmt>", DQUOTE, QUOTE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, STRING_STMT, "<string stmt>");
    result_ = string_stmt_0(builder_, level_ + 1);
    if (!result_) result_ = string_stmt_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // QUOTE [STRING] QUOTE
  private static boolean string_stmt_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "string_stmt_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, QUOTE);
    result_ = result_ && string_stmt_0_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, QUOTE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // [STRING]
  private static boolean string_stmt_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "string_stmt_0_1")) return false;
    consumeToken(builder_, STRING);
    return true;
  }

  // DQUOTE [DQSTRING] DQUOTE
  private static boolean string_stmt_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "string_stmt_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DQUOTE);
    result_ = result_ && string_stmt_1_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, DQUOTE);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // [DQSTRING]
  private static boolean string_stmt_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "string_stmt_1_1")) return false;
    consumeToken(builder_, DQSTRING);
    return true;
  }

  /* ********************************************************** */
  // types_include_stmt | types_mapping_stmt
  public static boolean types_block_content(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "types_block_content")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TYPES_BLOCK_CONTENT, "<types block content>");
    result_ = types_include_stmt(builder_, level_ + 1);
    if (!result_) result_ = types_mapping_stmt(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // LBRACE types_block_content* RBRACE
  public static boolean types_block_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "types_block_stmt")) return false;
    if (!nextTokenIs(builder_, LBRACE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TYPES_BLOCK_STMT, null);
    result_ = consumeToken(builder_, LBRACE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, types_block_stmt_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RBRACE) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // types_block_content*
  private static boolean types_block_stmt_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "types_block_stmt_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!types_block_content(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "types_block_stmt_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // types_stmt types_block_stmt
  public static boolean types_directive_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "types_directive_stmt")) return false;
    if (!nextTokenIs(builder_, TYPES)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TYPES_DIRECTIVE_STMT, null);
    result_ = types_stmt(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && types_block_stmt(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // TYPES_INCLUDE value_stmt SEMICOLON
  public static boolean types_include_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "types_include_stmt")) return false;
    if (!nextTokenIs(builder_, TYPES_INCLUDE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TYPES_INCLUDE_STMT, null);
    result_ = consumeToken(builder_, TYPES_INCLUDE);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, value_stmt(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SEMICOLON) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // value_stmt+ SEMICOLON
  public static boolean types_mapping_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "types_mapping_stmt")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, TYPES_MAPPING_STMT, "<types mapping stmt>");
    result_ = types_mapping_stmt_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // value_stmt+
  private static boolean types_mapping_stmt_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "types_mapping_stmt_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = value_stmt(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!value_stmt(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "types_mapping_stmt_0", pos_)) break;
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // TYPES
  public static boolean types_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "types_stmt")) return false;
    if (!nextTokenIs(builder_, TYPES)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, TYPES);
    exit_section_(builder_, marker_, TYPES_STMT, result_);
    return result_;
  }

  /* ********************************************************** */
  // named_value_stmt
  //                | part_value_stmt
  public static boolean value_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "value_stmt")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, VALUE_STMT, "<value stmt>");
    result_ = named_value_stmt(builder_, level_ + 1);
    if (!result_) result_ = part_value_stmt(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // variable_stmt value_stmt* SEMICOLON
  public static boolean var_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_stmt")) return false;
    if (!nextTokenIs(builder_, VARIABLE)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, VAR_STMT, null);
    result_ = variable_stmt(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, var_stmt_1(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, SEMICOLON) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // value_stmt*
  private static boolean var_stmt_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "var_stmt_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!value_stmt(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "var_stmt_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // VARIABLE
  public static boolean variable_stmt(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "variable_stmt")) return false;
    if (!nextTokenIs(builder_, VARIABLE)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, VARIABLE);
    exit_section_(builder_, marker_, VARIABLE_STMT, result_);
    return result_;
  }

}
