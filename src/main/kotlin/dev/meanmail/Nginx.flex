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

LETTER=[a-zA-Z]
DIGIT=[0-9]
UNDERSCORE="_"
WHITE_SPACE=\s+
EOL=[\n|\r|\r\n]
IDENTIFIER=({LETTER} | {UNDERSCORE}) ({LETTER} | {DIGIT} | {UNDERSCORE})*
SEMICOLON=";"
SHARP="#"
VALUE=[^\s;'\"]
ESCAPE=\\.
STRING=([^'\\]+|{ESCAPE})+
DQSTRING=([^\"\\]+|{ESCAPE})+

LBRACE="{"
RBRACE="}"

QUOTE="'"
DQUOTE="\""

COMMENT={SHARP}.*{EOL}

%state STRING_STATE
%state DQSTRING_STATE
%%

<YYINITIAL> {
    {IDENTIFIER}             { return IDENTIFIER; }
    {SEMICOLON}              { return SEMICOLON; }
    {COMMENT}                { return COMMENT; }
    {LBRACE}                 { return LBRACE; }
    {RBRACE}                 { return RBRACE; }
    {QUOTE}                  { yypush(STRING_STATE); return QUOTE; }
    {DQUOTE}                 { yypush(DQSTRING_STATE); return DQUOTE; }
    ({VALUE}{IDENTIFIER}?)+  { return VALUE; }
}

<STRING_STATE> {
    {QUOTE}                  { yypop(); return QUOTE; }
    {STRING}                 { return STRING; }
}

<DQSTRING_STATE> {
    {DQUOTE}                 { yypop(); return DQUOTE; }
    {DQSTRING}               { return DQSTRING; }
}

{WHITE_SPACE}                { return WHITE_SPACE; }

[^]                          { yyinitial(); return BAD_CHARACTER; }
