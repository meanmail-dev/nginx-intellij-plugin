// This is a generated file. Not intended for manual editing.
package dev.meanmail.psi.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.LightPsiParser;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;

import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import static dev.meanmail.psi.Types.*;

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
    // name_stmt value_stmt* (SEMICOLON | block_stmt)
    public static boolean directive_stmt(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "directive_stmt")) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, DIRECTIVE_STMT, "<directive stmt>");
        r = name_stmt(b, l + 1);
        p = r; // pin = 1
        r = r && report_error_(b, directive_stmt_1(b, l + 1));
        r = p && directive_stmt_2(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // value_stmt*
    private static boolean directive_stmt_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "directive_stmt_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!value_stmt(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "directive_stmt_1", c)) break;
        }
        return true;
    }

    // SEMICOLON | block_stmt
    private static boolean directive_stmt_2(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "directive_stmt_2")) return false;
        boolean r;
        r = consumeToken(b, SEMICOLON);
        if (!r) r = block_stmt(b, l + 1);
        return r;
    }

    /* ********************************************************** */
    // include_stmt include_target_stmt SEMICOLON
    public static boolean include_directive_stmt(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "include_directive_stmt")) return false;
        if (!nextTokenIs(b, INCLUDE)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, INCLUDE_DIRECTIVE_STMT, null);
        r = include_stmt(b, l + 1);
        p = r; // pin = 1
        r = r && report_error_(b, include_target_stmt(b, l + 1));
        r = p && consumeToken(b, SEMICOLON) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // INCLUDE
    public static boolean include_stmt(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "include_stmt")) return false;
        if (!nextTokenIs(b, INCLUDE)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, INCLUDE);
        exit_section_(b, m, INCLUDE_STMT, r);
        return r;
    }

    /* ********************************************************** */
    // INCLUDE_TARGET
    public static boolean include_target_stmt(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "include_target_stmt")) return false;
        if (!nextTokenIs(b, INCLUDE_TARGET)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, INCLUDE_TARGET);
        exit_section_(b, m, INCLUDE_TARGET_STMT, r);
        return r;
    }

    /* ********************************************************** */
    // LUA_BLOCK_DIRECTIVE value_stmt* lua_block_stmt
    public static boolean lua_block_directive_with_params_stmt(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "lua_block_directive_with_params_stmt")) return false;
        if (!nextTokenIs(b, LUA_BLOCK_DIRECTIVE)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, LUA_BLOCK_DIRECTIVE_WITH_PARAMS_STMT, null);
        r = consumeToken(b, LUA_BLOCK_DIRECTIVE);
        p = r; // pin = 1
        r = r && report_error_(b, lua_block_directive_with_params_stmt_1(b, l + 1));
        r = p && lua_block_stmt(b, l + 1) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    // value_stmt*
    private static boolean lua_block_directive_with_params_stmt_1(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "lua_block_directive_with_params_stmt_1")) return false;
        while (true) {
            int c = current_position_(b);
            if (!value_stmt(b, l + 1)) break;
            if (!empty_element_parsed_guard_(b, "lua_block_directive_with_params_stmt_1", c)) break;
        }
        return true;
    }

    /* ********************************************************** */
    // LBRACE lua_stmt RBRACE
    public static boolean lua_block_stmt(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "lua_block_stmt")) return false;
        if (!nextTokenIs(b, LBRACE)) return false;
        boolean r, p;
        Marker m = enter_section_(b, l, _NONE_, LUA_BLOCK_STMT, null);
        r = consumeToken(b, LBRACE);
        p = r; // pin = 1
        r = r && report_error_(b, lua_stmt(b, l + 1));
        r = p && consumeToken(b, RBRACE) && r;
        exit_section_(b, l, m, r, p, null);
        return r || p;
    }

    /* ********************************************************** */
    // LUA
    public static boolean lua_stmt(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "lua_stmt")) return false;
        if (!nextTokenIs(b, LUA)) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = consumeToken(b, LUA);
        exit_section_(b, m, LUA_STMT, r);
        return r;
    }

    /* ********************************************************** */
    // IDENTIFIER
    //               | VALUE
    //               | string_stmt
    public static boolean name_stmt(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "name_stmt")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, NAME_STMT, "<name stmt>");
        r = consumeToken(b, IDENTIFIER);
        if (!r) r = consumeToken(b, VALUE);
        if (!r) r = string_stmt(b, l + 1);
        exit_section_(b, l, m, r, false, null);
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
    // (
    //                        include_directive_stmt
    //                        | directive_stmt
    //                        | lua_block_directive_with_params_stmt
    //                       ) [COMMENT]
    static boolean statement(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "statement")) return false;
        boolean r;
        Marker m = enter_section_(b);
        r = statement_0(b, l + 1);
        r = r && statement_1(b, l + 1);
        exit_section_(b, m, null, r);
        return r;
    }

    // include_directive_stmt
    //                        | directive_stmt
    //                        | lua_block_directive_with_params_stmt
    private static boolean statement_0(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "statement_0")) return false;
        boolean r;
        r = include_directive_stmt(b, l + 1);
        if (!r) r = directive_stmt(b, l + 1);
        if (!r) r = lua_block_directive_with_params_stmt(b, l + 1);
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
    //                | VALUE
    //                | string_stmt
    public static boolean value_stmt(PsiBuilder b, int l) {
        if (!recursion_guard_(b, l, "value_stmt")) return false;
        boolean r;
        Marker m = enter_section_(b, l, _NONE_, VALUE_STMT, "<value stmt>");
        r = consumeToken(b, IDENTIFIER);
        if (!r) r = consumeToken(b, VALUE);
        if (!r) r = string_stmt(b, l + 1);
        exit_section_(b, l, m, r, false, null);
        return r;
    }

}
