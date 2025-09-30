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

  public final void yypush(int newState) {
      yybegin(newState);
      stack.push(newState);
  }
  
  public final int yycurent() {
      int state = stack.size() == 0 ? YYINITIAL : stack.peek();
      return state;
  }

  public final int yypop() {
      if (stack.size() == 0) {
          yyinitial();
          return YYINITIAL;
      }

      int state = stack.pop();

      if (stack.peek() == null) {
          yyinitial();
      } else {
          yybegin(stack.peek());
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

NUMBER_INTEGER={DIGIT}+
NUMBER_FLOAT={DIGIT}+\.{DIGIT}+
NUMBER_DURATION={DIGIT}+(ms|s|m|h|d|w|M|y)
NUMBER_SIZE={DIGIT}+(b|B|k|K|m|M|g|G)
NUMBER={NUMBER_FLOAT}|{NUMBER_INTEGER}

IPV4_OCTET=(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)
IPV4_ADDRESS_PLAIN={IPV4_OCTET}\.{IPV4_OCTET}\.{IPV4_OCTET}\.{IPV4_OCTET}
IPV4_ADDRESS_CIDR={IPV4_ADDRESS_PLAIN}(\/([0-9]|[12][0-9]|3[0-2]))
IPV6_HEX=[0-9a-fA-F]
IPV6_SEG={IPV6_HEX}{1,4}
IPV6_ADDRESS_PLAIN=(({IPV6_SEG}:){7}{IPV6_SEG}|({IPV6_SEG}:){1,7}:|({IPV6_SEG}:){1,6}:{IPV6_SEG}|({IPV6_SEG}:){1,5}(:{IPV6_SEG}){1,2}|({IPV6_SEG}:){1,4}(:{IPV6_SEG}){1,3}|({IPV6_SEG}:){1,3}(:{IPV6_SEG}){1,4}|({IPV6_SEG}:){1,2}(:{IPV6_SEG}){1,5}|{IPV6_SEG}:((:{IPV6_SEG}){1,6})|:((:{IPV6_SEG}){1,7}|:)|::({IPV6_SEG}:){0,5}{IPV6_SEG}|({IPV6_SEG}:){1,4}:{IPV4_ADDRESS_PLAIN})
IPV6_ADDRESS_CIDR={IPV6_ADDRESS_PLAIN}(\/([0-9]|[1-9][0-9]|1[01][0-9]|12[0-8]))
PORT=:[0-9]{1,5}
IP_ADDRESS_WITH_PORT={IPV4_ADDRESS_PLAIN}{PORT}|\[{IPV6_ADDRESS_PLAIN}\]{PORT}
IP_ADDRESS={IP_ADDRESS_WITH_PORT}|{IPV4_ADDRESS_CIDR}|{IPV6_ADDRESS_CIDR}|{IPV4_ADDRESS_PLAIN}|{IPV6_ADDRESS_PLAIN}
IP_RANGE={IPV4_ADDRESS_PLAIN}\-{IPV4_ADDRESS_PLAIN}

VALUE=[^\s;'\"\{\}\#]+
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
%%

<YYINITIAL> {
    [a-z_]+_by_lua_block     { yypush(LUA_BLOCK_STATE); return LUA_BLOCK_DIRECTIVE; }
    map                      { yypush(MAP_STATE); return MAP; }
    geo                      { yypush(GEO_STATE); return GEO; }
    if                       { yypush(IF_STATE); return IF; }
    location                 { yypush(DIRECTIVE_STATE); return LOCATION; }
    return                   { yypush(DIRECTIVE_STATE); return RETURN; }
    {IDENTIFIER}             { yypush(DIRECTIVE_STATE); return IDENTIFIER; }
    {RBRACE}                 { return RBRACE; }
}

<DIRECTIVE_STATE> {
    {VARIABLE}               { return VARIABLE; }
    {NUMBER_DURATION}            { return NUMBER_DURATION; }
    {NUMBER_SIZE}            { return NUMBER_SIZE; }
    {NUMBER}                 { return NUMBER; }
    {IP_RANGE}               { return IP_RANGE; }
    {IP_ADDRESS}             { return IP_ADDRESS; }
    {IDENTIFIER}             { return IDENTIFIER; }
    {CARET_TILDE}            { return CARET_TILDE; }
    {BINARY_OPERATOR}        { return BINARY_OPERATOR; }
    {SEMICOLON}              { yypop(); return SEMICOLON; }
    {LBRACE}                 { yypop(); return LBRACE; }
    {QUOTE}                  { yypush(STRING_STATE); return QUOTE; }
    {DQUOTE}                 { yypush(DQSTRING_STATE); return DQUOTE; }
    {VALUE}                  { return VALUE; }
}

<IF_STATE> {
    {LBRACE}                 { yypop(); return LBRACE; }
    {LPAREN}                 { yypush(IF_PAREN_STATE); return LPAREN; }
}

<IF_PAREN_STATE> {
    {RPAREN}                      { yypop(); return RPAREN; }
    {QUOTE}                       { yypush(STRING_STATE); return QUOTE; }
    {DQUOTE}                      { yypush(DQSTRING_STATE); return DQUOTE; }
    {VARIABLE}                    { return VARIABLE; }
    {NUMBER_DURATION}                 { return NUMBER_DURATION; }
    {NUMBER_SIZE}                 { return NUMBER_SIZE; }
    {NUMBER}                      { return NUMBER; }
    {IP_ADDRESS}                  { return IP_ADDRESS; }
    {IDENTIFIER}                  { return IDENTIFIER; }
    {UNARY_OPERATOR}              { return UNARY_OPERATOR; }
    {BINARY_OPERATOR}             { return BINARY_OPERATOR; }
    {IF_VALUE}                    { return VALUE; }
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
    {RBRACE}                  { yypop(); if (yycurent() == LUA_STATE) return LUA; yypop(); return RBRACE; }
    {LBRACE}                  { yypush(LUA_STATE); return LUA; }
    [^\{\}]+                  { return LUA; }
}

<STRING_STATE> {
    {QUOTE}                  { yypop(); return QUOTE; }
    {STRING}                 { return STRING; }
}

<DQSTRING_STATE> {
    {DQUOTE}                 { yypop(); return DQUOTE; }
    {DQSTRING}               { return DQSTRING; }
}

<MAP_STATE> {
    {LBRACE}                 { yypush(MAP_BLOCK_STATE); return LBRACE; }
    {QUOTE}                  { yypush(STRING_STATE); return QUOTE; }
    {DQUOTE}                 { yypush(DQSTRING_STATE); return DQUOTE; }
    {VARIABLE}               { return VARIABLE; }
    {NUMBER_DURATION}            { return NUMBER_DURATION; }
    {NUMBER_SIZE}            { return NUMBER_SIZE; }
    {NUMBER}                 { return NUMBER; }
    {IP_RANGE}               { return IP_RANGE; }
    {IP_ADDRESS}             { return IP_ADDRESS; }
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
    {NUMBER_DURATION}            { return NUMBER_DURATION; }
    {NUMBER_SIZE}            { return NUMBER_SIZE; }
    {NUMBER}                 { return NUMBER; }
    {IP_RANGE}               { return IP_RANGE; }
    {IP_ADDRESS}             { return IP_ADDRESS; }
    {SEMICOLON}              { return SEMICOLON; }
    {VALUE}                  { return VALUE; }
}

<GEO_STATE> {
    {LBRACE}                 { yypush(GEO_BLOCK_STATE); return LBRACE; }
    {QUOTE}                  { yypush(STRING_STATE); return QUOTE; }
    {DQUOTE}                 { yypush(DQSTRING_STATE); return DQUOTE; }
    {VARIABLE}               { return VARIABLE; }
    {NUMBER_DURATION}            { return NUMBER_DURATION; }
    {NUMBER_SIZE}            { return NUMBER_SIZE; }
    {NUMBER}                 { return NUMBER; }
    {IP_RANGE}               { return IP_RANGE; }
    {IP_ADDRESS}             { return IP_ADDRESS; }
    {IDENTIFIER}             { return IDENTIFIER; }
    {SEMICOLON}              { return SEMICOLON; }
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
    {NUMBER_DURATION}            { return NUMBER_DURATION; }
    {NUMBER_SIZE}            { return NUMBER_SIZE; }
    {NUMBER}                 { return NUMBER; }
    {IP_RANGE}               { return IP_RANGE; }
    {IP_ADDRESS}             { return IP_ADDRESS; }
    {SEMICOLON}              { return SEMICOLON; }
    {VALUE}                  { return VALUE; }
}


{COMMENT}                { return COMMENT; }
{WHITE_SPACE}                { return WHITE_SPACE; }

[^]                          { yyinitial(); return BAD_CHARACTER; }
