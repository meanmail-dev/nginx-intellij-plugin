package dev.meanmail;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static dev.meanmail.psi.Types.*;

%%

%{
  public NginxLexer() {
      this((java.io.Reader)null);
  }

  Deque<Integer> stack = new ArrayDeque<Integer>();

  // Track nested parentheses depth inside IF_PAREN_STATE
  int ifParenDepth = 0;

  // Concatenation join handling: emit a synthetic CONCAT_JOIN token
  // between two adjacent atoms (VARIABLE/IDENTIFIER/VALUE/STRING) with no separators.
  boolean joinPending = false;           // true when we pushed back current token to emit CONCAT_JOIN
  boolean prevConcatEligible = false;    // true if the last emitted token completed a concat atom

  public final void yypush(int newState) {
      yybegin(newState);
      stack.push(newState);
  }

  public final int yycurrentState() {
      int state = stack.isEmpty() ? YYINITIAL : stack.peek();
      return state;
  }

  public final int yypop() {
      if (stack.isEmpty()) {
          yyinitial();
          return YYINITIAL;
      }

      int state = stack.pop();

      if (!stack.isEmpty()) {
          yybegin(stack.peek());
      } else {
          yyinitial();
      }

      return state;
  }

  public final void yyinitial() {
      stack.clear();
      yypush(YYINITIAL);
  }
%}

%public
%class NginxLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%eof{  return;
%eof}

LETTER=[a-zA-Z_]
DIGIT=[0-9]
WHITE_SPACE=\s+
IDENTIFIER={LETTER}({LETTER}|{DIGIT})*
VARIABLE=\$\{?{IDENTIFIER}\}?
SEMICOLON=";"
CARET_TILDE=\^\~
UNARY_OPERATOR=\!?-[fdex]
BINARY_OPERATOR=(\!=|=)|(\!?\~\*?|\!?\~)

LPAREN=\(
RPAREN=\)
BRACED_VAR=\$\{{IDENTIFIER}\}
VALUE=({BRACED_VAR}|[^\s;'\"\{\}\#=])+
EQUAL==
IF_VALUE=[^\s;'\"\{\}\(\)\#]+
ESCAPE=\\[^\n\r]
STRING=([^'\\]|{ESCAPE})+
DQSTRING=([^\"\\]|{ESCAPE})+

COMMENT=#[^\r\n]*

LBRACE="{"
RBRACE="}"

QUOTE="'"
DQUOTE="\""

%state STRING_STATE
%state DQSTRING_STATE
%state LUA_BLOCK_STATE
%state LUA_STATE
%state MAP_STATE
%state MAP_BLOCK_STATE
%state GEO_STATE
%state GEO_BLOCK_STATE
%state IF_STATE
%state IF_PAREN_STATE
%state DIRECTIVE_STATE
%state TYPES_STATE
%state TYPES_BLOCK_STATE
%state NUM_MAP_STATE
%state NUM_MAP_BLOCK_STATE
%%

<YYINITIAL> {
    [a-z_]+_by_lua_block     { yypush(LUA_BLOCK_STATE); return LUA_BLOCK_DIRECTIVE; }
    num_map                  { yypush(NUM_MAP_STATE); return NUM_MAP; }
    map                      { yypush(MAP_STATE); return MAP; }
    geo                      { yypush(GEO_STATE); return GEO; }
    types                    { yypush(TYPES_STATE); return TYPES; }
    if                       { yypush(IF_STATE); return IF; }
    location                 { yypush(DIRECTIVE_STATE); return LOCATION; }
    {VARIABLE}               { yypush(DIRECTIVE_STATE); return VARIABLE; }
    {IDENTIFIER}             { yypush(DIRECTIVE_STATE); return IDENTIFIER; }
    {RBRACE}                 { prevConcatEligible = false; joinPending = false; return RBRACE; }
}

<DIRECTIVE_STATE> {
    // Status code pattern for try_files directive (e.g., =404, =503)
    // Must be checked before {EQUAL}, but only when preceded by whitespace (not a named param)
    // Named params like "max=200" have no space before =, status codes like "$uri =404" have space
    ={DIGIT}{DIGIT}{DIGIT}   {
        if (prevConcatEligible && !joinPending) {
            // Previous token was adjacent (no space) - this is a named parameter like "max=200"
            // Push back all but the '=' and return EQUAL token
            yypushback(yylength() - 1);
            joinPending = false;
            prevConcatEligible = false;
            return EQUAL;
        }
        // Space before = means this is a standalone status code like "=404"
        joinPending = false; prevConcatEligible = true; return VALUE;
    }
    {VARIABLE}               {
        if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
        joinPending = false; prevConcatEligible = true; return VARIABLE;
    }
    {IDENTIFIER}             {
        if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
        joinPending = false; prevConcatEligible = true; return IDENTIFIER;
    }
    {CARET_TILDE}            { joinPending = false; prevConcatEligible = false; return CARET_TILDE; }
    {EQUAL}                  { joinPending = false; prevConcatEligible = false; return EQUAL; }
    {BINARY_OPERATOR}        { joinPending = false; prevConcatEligible = false; return BINARY_OPERATOR; }
    {SEMICOLON}              { yypop(); joinPending = false; prevConcatEligible = false; return SEMICOLON; }
    {LBRACE}                 { yypop(); joinPending = false; prevConcatEligible = false; return LBRACE; }
    {QUOTE}                  {
        if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
        joinPending = false; prevConcatEligible = false; yypush(STRING_STATE); return QUOTE;
    }
    {DQUOTE}                 {
        if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
        joinPending = false; prevConcatEligible = false; yypush(DQSTRING_STATE); return DQUOTE;
    }
    // URL with scheme (e.g. http://example.com/path?v=1&a=2) — includes '=' in the token
    // so the entire URL is a single VALUE. Excludes '$' so variables remain separate tokens.
    [a-z]+"://"({BRACED_VAR}|[^\s;'\"\{\}\#\$])+ {
        if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
        joinPending = false; prevConcatEligible = true; return VALUE;
    }
    // Path with query string (e.g. /index.php?=, /path?key=value&b=) — includes '=' after '?'
    // so the entire path+query is a single VALUE. Excludes '$' so variables remain separate tokens.
    ({BRACED_VAR}|[^\s;'\"\{\}\#=\$])+"?"({BRACED_VAR}|[^\s;'\"\{\}\#\$])* {
        if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
        joinPending = false; prevConcatEligible = true; return VALUE;
    }
    {VALUE}                  {
        if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
        joinPending = false; prevConcatEligible = true; return VALUE;
    }
}

<IF_STATE> {
    {LBRACE}                 { yypop(); joinPending = false; prevConcatEligible = false; return LBRACE; }
    {LPAREN}                 {
          // Enter condition parentheses; reset nested depth
          ifParenDepth = 0;
          yypush(IF_PAREN_STATE);
          return LPAREN;
      }
}

<IF_PAREN_STATE> {
    // Treat nested parentheses inside regex/values as part of VALUE
    {LPAREN}                      { ifParenDepth++; return VALUE; }
    {RPAREN}                      {
          if (ifParenDepth > 0) { ifParenDepth--; return VALUE; }
          yypop();
          return RPAREN;
      }
    {QUOTE}                       {
          if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
          joinPending = false; prevConcatEligible = false; yypush(STRING_STATE); return QUOTE;
      }
    {DQUOTE}                      {
          if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
          joinPending = false; prevConcatEligible = false; yypush(DQSTRING_STATE); return DQUOTE;
      }
    {VARIABLE}                    {
          if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
          joinPending = false; prevConcatEligible = true; return VARIABLE;
      }
    {IDENTIFIER}                  {
          if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
          joinPending = false; prevConcatEligible = true; return IDENTIFIER;
      }
    // Keep '=' as a dedicated EQUAL token inside if (...) to allow simple comparisons
    {EQUAL}                       { return EQUAL; }
    {UNARY_OPERATOR}              { return UNARY_OPERATOR; }
    {BINARY_OPERATOR}             { return BINARY_OPERATOR; }
    {IF_VALUE}                    {
          if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
          joinPending = false; prevConcatEligible = true; return VALUE;
      }
}

<LUA_BLOCK_STATE> {
    {LBRACE}                 { yypush(LUA_STATE); return LBRACE; }
    {QUOTE}                  { yypush(STRING_STATE); return QUOTE; }
    {DQUOTE}                 { yypush(DQSTRING_STATE); return DQUOTE; }
    {VARIABLE}               { return VARIABLE; }
    {IDENTIFIER}             { return IDENTIFIER; }
    {SEMICOLON}              { return SEMICOLON; }
    {VALUE}                  { return VALUE; }
}

<LUA_STATE> {
    {RBRACE}                  {
          yypop();
          if (yycurrentState() == LUA_STATE) return LUA;
          yypop();
          return RBRACE;
      }
    {LBRACE}                  {
          yypush(LUA_STATE);
          return LUA;
      }
    [^\{\}]+                  { return LUA; }
}

<STRING_STATE> {
    {QUOTE}                  { yypop(); prevConcatEligible = true; return QUOTE; }
    {STRING}                 { return STRING; }
}

<DQSTRING_STATE> {
    {DQUOTE}                 { yypop(); prevConcatEligible = true; return DQUOTE; }
    {DQSTRING}               { return DQSTRING; }
}

<MAP_STATE> {
    {LBRACE}                 { yypush(MAP_BLOCK_STATE); return LBRACE; }
    {QUOTE}                  { yypush(STRING_STATE); return QUOTE; }
    {DQUOTE}                 { yypush(DQSTRING_STATE); return DQUOTE; }
    {VARIABLE}               { return VARIABLE; }
    {IDENTIFIER}             { return IDENTIFIER; }
    {SEMICOLON}              { return SEMICOLON; }
    {VALUE}                  { return VALUE; }
}

<MAP_BLOCK_STATE> {
    {RBRACE}                 { yypop(); yypop(); return RBRACE; }
    {QUOTE}                  { yypush(STRING_STATE); return QUOTE; }
    {DQUOTE}                 { yypush(DQSTRING_STATE); return DQUOTE; }
    default                  { return MAP_DEFAULT; }
    include                  { return MAP_INCLUDE; }
    volatile                 { return MAP_VOLATILE; }
    hostnames                { return MAP_HOSTNAMES; }
    {SEMICOLON}              { return SEMICOLON; }
    {VALUE}                  { return VALUE; }
}

<GEO_STATE> {
    {LBRACE}                 { yypush(GEO_BLOCK_STATE); return LBRACE; }
    {QUOTE}                  { yypush(STRING_STATE); return QUOTE; }
    {DQUOTE}                 { yypush(DQSTRING_STATE); return DQUOTE; }
    {VARIABLE}               { return VARIABLE; }
    {IDENTIFIER}             { return IDENTIFIER; }
    {SEMICOLON}              { return SEMICOLON; }
    {VALUE}                  { return VALUE; }
}

<TYPES_STATE> {
    {LBRACE}                 { yypush(TYPES_BLOCK_STATE); return LBRACE; }
}

<TYPES_BLOCK_STATE> {
    {RBRACE}                 { yypop(); yypop(); return RBRACE; }
    {QUOTE}                  { yypush(STRING_STATE); return QUOTE; }
    {DQUOTE}                 { yypush(DQSTRING_STATE); return DQUOTE; }
    include                  { return TYPES_INCLUDE; }
    {SEMICOLON}              { return SEMICOLON; }
    {VARIABLE}               { return VARIABLE; }
    {VALUE}                  { return VALUE; }
}

<GEO_BLOCK_STATE> {
    {RBRACE}                 { yypop(); yypop(); return RBRACE; }
    {QUOTE}                  { yypush(STRING_STATE); return QUOTE; }
    {DQUOTE}                 { yypush(DQSTRING_STATE); return DQUOTE; }
    delete                   { return GEO_DELETE; }
    default                  { return GEO_DEFAULT; }
    include                  { return GEO_INCLUDE; }
    proxy                    { return GEO_PROXY; }
    ranges                   { return GEO_RANGES; }
    {SEMICOLON}              { return SEMICOLON; }
    {VALUE}                  { return VALUE; }
}

<NUM_MAP_STATE> {
    {LBRACE}                 { yypush(NUM_MAP_BLOCK_STATE); return LBRACE; }
    {QUOTE}                  { yypush(STRING_STATE); return QUOTE; }
    {DQUOTE}                 { yypush(DQSTRING_STATE); return DQUOTE; }
    {VARIABLE}               { return VARIABLE; }
    {IDENTIFIER}             { return IDENTIFIER; }
    {SEMICOLON}              { return SEMICOLON; }
    {VALUE}                  { return VALUE; }
}

<NUM_MAP_BLOCK_STATE> {
    {RBRACE}                 { yypop(); yypop(); return RBRACE; }
    {QUOTE}                  { yypush(STRING_STATE); return QUOTE; }
    {DQUOTE}                 { yypush(DQSTRING_STATE); return DQUOTE; }
    default                  { return NUM_MAP_DEFAULT; }
    include                  { return NUM_MAP_INCLUDE; }
    volatile                 { return NUM_MAP_VOLATILE; }
    {SEMICOLON}              { return SEMICOLON; }
    {VALUE}                  { return VALUE; }
}


{COMMENT}                    { prevConcatEligible = false; joinPending = false; return COMMENT; }
{WHITE_SPACE}                { prevConcatEligible = false; joinPending = false; return WHITE_SPACE; }

[^]                          { yyinitial(); return BAD_CHARACTER; }
