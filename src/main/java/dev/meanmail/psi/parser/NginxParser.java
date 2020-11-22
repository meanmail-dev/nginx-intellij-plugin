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
  // LBRACE statements* RBRACE
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

  // statements*
  private static boolean block_stmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_stmt_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statements(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_stmt_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // name_stmt wsps values_stmt? wsps (SEMICOLON | block_stmt)
  public static boolean directive_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_stmt")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DIRECTIVE_STMT, null);
    r = name_stmt(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, wsps(b, l + 1));
    r = p && report_error_(b, directive_stmt_2(b, l + 1)) && r;
    r = p && report_error_(b, wsps(b, l + 1)) && r;
    r = p && directive_stmt_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // values_stmt?
  private static boolean directive_stmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_stmt_2")) return false;
    values_stmt(b, l + 1);
    return true;
  }

  // SEMICOLON | block_stmt
  private static boolean directive_stmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_stmt_4")) return false;
    boolean r;
    r = consumeToken(b, SEMICOLON);
    if (!r) r = block_stmt(b, l + 1);
    return r;
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
  // statements*
  static boolean nginxFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nginxFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statements(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nginxFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (wsps stmts wsps COMMENT? (EOL | <<eof>>)) | EOL
  static boolean statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statements")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statements_0(b, l + 1);
    if (!r) r = consumeToken(b, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  // wsps stmts wsps COMMENT? (EOL | <<eof>>)
  private static boolean statements_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statements_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = wsps(b, l + 1);
    r = r && stmts(b, l + 1);
    r = r && wsps(b, l + 1);
    r = r && statements_0_3(b, l + 1);
    r = r && statements_0_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMENT?
  private static boolean statements_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statements_0_3")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  // EOL | <<eof>>
  private static boolean statements_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statements_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EOL);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (
  //                    directive_stmt
  //                    )
  static boolean stmts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmts")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = directive_stmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  //                    | VALUE
  public static boolean value_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_stmt")) return false;
    if (!nextTokenIs(b, "<value stmt>", IDENTIFIER, VALUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_STMT, "<value stmt>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, VALUE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // value_stmt (WHITE_SPACE+ value_stmt)*
  public static boolean values_stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "values_stmt")) return false;
    if (!nextTokenIs(b, "<values stmt>", IDENTIFIER, VALUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUES_STMT, "<values stmt>");
    r = value_stmt(b, l + 1);
    r = r && values_stmt_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (WHITE_SPACE+ value_stmt)*
  private static boolean values_stmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "values_stmt_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!values_stmt_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "values_stmt_1", c)) break;
    }
    return true;
  }

  // WHITE_SPACE+ value_stmt
  private static boolean values_stmt_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "values_stmt_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = values_stmt_1_0_0(b, l + 1);
    r = r && value_stmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITE_SPACE+
  private static boolean values_stmt_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "values_stmt_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHITE_SPACE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "values_stmt_1_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // WHITE_SPACE*
  static boolean wsps(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wsps")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WHITE_SPACE)) break;
      if (!empty_element_parsed_guard_(b, "wsps", c)) break;
    }
    return true;
  }

}
