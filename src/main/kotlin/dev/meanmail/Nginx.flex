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

  // nginx quirk (issue #77): nginx's if-directive handler does NOT track parenthesis depth.
  // Instead, it tokenizes the condition normally (respecting quotes), then strips a trailing ')'
  // from the LAST token before '{' to use as the closing paren of if(...).
  //
  // Example: if ($arg_a ~ "x)"{  — nginx tokenizes "x)" as token 'x)', strips trailing ')' →
  // regex becomes 'x', and '{' opens the block. No explicit ')' needed after the string.
  //
  // Our lexer uses ifParenDepth tracking which is more correct, but to match nginx behavior
  // we allow '{' in IF_PAREN_STATE when a quoted string in the condition contained ')'.
  // See also: IF_STRING_STATE, IF_DQSTRING_STATE, and the LBRACE rule in IF_PAREN_STATE.
  boolean ifCloseParenInString = false;
  StringBuilder ifQuotedTokenBuffer = new StringBuilder();

  // Check if string ends with an unbalanced ')'.
  // nginx strips trailing ')' from the last token regardless of balance,
  // so "x)" has an unbalanced ')' (nginx strips it), but "(x)" is balanced (nginx strips it too,
  // breaking the regex). We only set the quirk flag when the string ends with ')' AND
  // closing parens outnumber opening ones — i.e. there's an "extra" ')' at the end.
  //
  // Must account for escape sequences:
  //   Step 1 — nginx config parser collapses \\ → \ in both single- and double-quoted strings;
  //            all other \X sequences (like \) ) are kept verbatim.
  //   Step 2 — PCRE2 treats \( and \) as escaped (literal) parens that don't affect group balance,
  //            and \\ as a literal backslash.
  //
  // Examples (raw lexer text → nginx value → PCRE2 interpretation → quirk?):
  //   x)      → x)      → unmatched )        → true  (quirk)
  //   x\)     → x\)     → escaped )           → false (no quirk)
  //   x\\)    → x\)     → escaped )           → false (no quirk)
  //   x\\\)   → x\\)    → literal \ + real )  → true  (quirk)
  //   x\\\\)  → x\\)    → literal \ + real )  → true  (quirk)
  private boolean endsWithUnbalancedParen(String s) {
      if (!s.endsWith(")")) return false;

      // Step 1: simulate nginx escape processing.
      // \\ → single \;  \X (other) → \X (both chars kept).
      StringBuilder nginxValue = new StringBuilder(s.length());
      int i = 0;
      while (i < s.length()) {
          char c = s.charAt(i);
          if (c == '\\' && i + 1 < s.length()) {
              if (s.charAt(i + 1) == '\\') {
                  nginxValue.append('\\');
                  i += 2;
              } else {
                  nginxValue.append(c);
                  nginxValue.append(s.charAt(i + 1));
                  i += 2;
              }
          } else {
              nginxValue.append(c);
              i++;
          }
      }

      // Step 2: count parens with PCRE2 escape rules.
      // \X (any) → skip both chars (escaped in PCRE2).
      String v = nginxValue.toString();
      int depth = 0;
      i = 0;
      while (i < v.length()) {
          char c = v.charAt(i);
          if (c == '\\' && i + 1 < v.length()) {
              i += 2;
              continue;
          }
          if (c == '(') depth++;
          else if (c == ')') depth--;
          i++;
      }
      return depth < 0;
  }

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
VARIABLE=\$(\{?{IDENTIFIER}\}?|{DIGIT}+)
SEMICOLON=";"
CARET_TILDE=\^\~
UNARY_OPERATOR=\!?-[fdex]
BINARY_OPERATOR=(\!=|=)|(\!?\~\*?|\!?\~)

LPAREN=\(
RPAREN=\)
BRACED_VAR=\$\{{IDENTIFIER}\}
// '#' is NOT excluded from value patterns: in nginx, '#' starts a comment only after
// whitespace, not inside a token. The global COMMENT rule handles '#' after whitespace
// because WHITE_SPACE is matched first, then COMMENT wins by longest-match.
VALUE=({BRACED_VAR}|[^\s;'\"\{\}=])+
MAP_BLOCK_VALUE=({BRACED_VAR}|[^\s;'\"\{\}])+
EQUAL==
IF_VALUE=(\\[^\n\r]|[^\s;'\"\{\}\(\)])+
ESCAPE=\\[^\n\r]
STRING=([^'\\$]|{ESCAPE})+
DQSTRING=([^\"\\$]|{ESCAPE})+

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
%state IF_STRING_STATE
%state IF_DQSTRING_STATE
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
    // URL with scheme (e.g. http://example.com/path?v=1&a=2, http://example.com/path#frag)
    // — includes '=' and '#' in the token so the entire URL is a single VALUE.
    // '#' is allowed here because after '://' it is a URL fragment, not a comment.
    // Excludes '$' so variables remain separate tokens.
    [a-z]+"://"[^\s;'\"\{\}\$]+ {
        if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
        joinPending = false; prevConcatEligible = true; return VALUE;
    }
    // Path with query string (e.g. /index.php?=, /path?key=value&b=) — includes '=' after '?'
    // so the entire path+query is a single VALUE. Excludes '$' so variables remain separate tokens.
    [^\s;'\"\{\}=\$]+"?"[^\s;'\"\{\}\$]* {
        if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
        joinPending = false; prevConcatEligible = true; return VALUE;
    }
    // Bare query string (e.g. ?x=, ?key=value) — typically concatenated after a variable like $uri?x=
    // Includes '=' after '?' so the entire query is a single VALUE token.
    "?"[^\s;'\"\{\}\$]+ {
        if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
        joinPending = false; prevConcatEligible = true; return VALUE;
    }
    // Ampersand query string segment (e.g. &b=, &key=value) — typically concatenated after a variable
    // like $arg_a&b= in proxy_cache_key $uri?a=$arg_a&b=$arg_b&c=$arg_c;
    // Includes '=' after '&' so the entire segment is a single VALUE token.
    "&"[^\s;'\"\{\}\$]+ {
        if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
        joinPending = false; prevConcatEligible = true; return VALUE;
    }
    {VALUE}                  {
        if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
        // Check if the matched VALUE contains a $variable reference ($var, ${var}, $1)
        // that should be a separate VARIABLE token due to longest-match consuming too much.
        String text = yytext().toString();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '$' && i + 1 < text.length()) {
                char next = text.charAt(i + 1);
                if (next == '{') {
                    // Braced variable ${VAR} — split VALUE before it
                    int closeBrace = text.indexOf('}', i + 2);
                    if (closeBrace >= 0) {
                        if (i > 0) {
                            yypushback(text.length() - i);
                            joinPending = false; prevConcatEligible = true; return VALUE;
                        } else {
                            yypushback(text.length() - closeBrace - 1);
                            joinPending = false; prevConcatEligible = true; return VARIABLE;
                        }
                    }
                    continue;
                }
                if ((next >= 'a' && next <= 'z') || (next >= 'A' && next <= 'Z') || next == '_') {
                    // Bare $variable found — split VALUE before it
                    if (i > 0) {
                        yypushback(text.length() - i);
                        joinPending = false; prevConcatEligible = true; return VALUE;
                    } else {
                        // VALUE starts with $variable — find end of variable name and push back the rest
                        int varEnd = i + 1;
                        while (varEnd < text.length()) {
                            char c = text.charAt(varEnd);
                            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '_' || (c >= '0' && c <= '9')) {
                                varEnd++;
                            } else {
                                break;
                            }
                        }
                        yypushback(text.length() - varEnd);
                        joinPending = false; prevConcatEligible = true; return VARIABLE;
                    }
                }
                if (next >= '0' && next <= '9') {
                    // Capture group reference $1, $2, etc. — split VALUE before it
                    if (i > 0) {
                        yypushback(text.length() - i);
                        joinPending = false; prevConcatEligible = true; return VALUE;
                    } else {
                        // VALUE starts with $N — find end of digits and push back the rest
                        int varEnd = i + 1;
                        while (varEnd < text.length()) {
                            char c = text.charAt(varEnd);
                            if (c >= '0' && c <= '9') {
                                varEnd++;
                            } else {
                                break;
                            }
                        }
                        yypushback(text.length() - varEnd);
                        joinPending = false; prevConcatEligible = true; return VARIABLE;
                    }
                }
            }
        }
        joinPending = false; prevConcatEligible = true; return VALUE;
    }
}

<IF_STATE> {
    {LBRACE}                 { yypop(); joinPending = false; prevConcatEligible = false; return LBRACE; }
    {LPAREN}                 {
          // Enter condition parentheses; reset nested depth
          ifParenDepth = 0;
          ifCloseParenInString = false;
          yypush(IF_PAREN_STATE);
          return LPAREN;
      }
}

<IF_PAREN_STATE> {
    // Treat nested parentheses inside regex/values as part of VALUE
    {LPAREN}                      { ifParenDepth++; return VALUE; }
    {RPAREN}                      {
          if (ifParenDepth > 0) { ifParenDepth--; return VALUE; }
          if (ifCloseParenInString) {
              // nginx quirk: ) inside a quoted string already "closed" the if(),
              // so this explicit ) is extra — treat as syntax error.
              yypop(); // pop IF_PAREN_STATE -> IF_STATE
              yypop(); // pop IF_STATE -> YYINITIAL
              joinPending = false; prevConcatEligible = false;
              ifCloseParenInString = false;
              return BAD_CHARACTER;
          }
          yypop();
          return RPAREN;
      }
    {QUOTE}                       {
          if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
          joinPending = false; prevConcatEligible = false;
          ifQuotedTokenBuffer.setLength(0);
          yypush(IF_STRING_STATE);
          return QUOTE;
      }
    {DQUOTE}                      {
          if (prevConcatEligible && !joinPending) { joinPending = true; yypushback(yylength()); return CONCAT_JOIN; }
          joinPending = false; prevConcatEligible = false;
          ifQuotedTokenBuffer.setLength(0);
          yypush(IF_DQSTRING_STATE);
          return DQUOTE;
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
    // nginx quirk: { before ) — the closing ) is embedded in the last condition token.
    // Only accept { when a quoted string in this condition contained ')'.
    {LBRACE}                      {
          if (ifCloseParenInString) {
              yypop(); // pop IF_PAREN_STATE -> IF_STATE
              yypop(); // pop IF_STATE -> YYINITIAL
              joinPending = false; prevConcatEligible = false;
              ifCloseParenInString = false;
              return LBRACE;
          }
          // No ) was in any string — { is genuinely invalid here
          yyinitial();
          return BAD_CHARACTER;
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
    {VARIABLE}               { return VARIABLE; }
    \$                       { return STRING; }
    {STRING}                 { return STRING; }
}

<DQSTRING_STATE> {
    {DQUOTE}                 { yypop(); prevConcatEligible = true; return DQUOTE; }
    {VARIABLE}               { return VARIABLE; }
    \$                       { return DQSTRING; }
    {DQSTRING}               { return DQSTRING; }
}

// String states for if-condition context: identical to normal string states,
// but track whether the string content ends with an unbalanced ')' (nginx quirk flag).
<IF_STRING_STATE> {
    {QUOTE}                  {
          if (endsWithUnbalancedParen(ifQuotedTokenBuffer.toString())) { ifCloseParenInString = true; }
          yypop(); prevConcatEligible = true; return QUOTE;
      }
    {VARIABLE}               { ifQuotedTokenBuffer.append(yytext().toString()); return VARIABLE; }
    \$                       { ifQuotedTokenBuffer.append(yytext().toString()); return STRING; }
    {STRING}                 {
          ifQuotedTokenBuffer.append(yytext().toString());
          return STRING;
      }
}

<IF_DQSTRING_STATE> {
    {DQUOTE}                 {
          if (endsWithUnbalancedParen(ifQuotedTokenBuffer.toString())) { ifCloseParenInString = true; }
          yypop(); prevConcatEligible = true; return DQUOTE;
      }
    {VARIABLE}               { ifQuotedTokenBuffer.append(yytext().toString()); return VARIABLE; }
    \$                       { ifQuotedTokenBuffer.append(yytext().toString()); return DQSTRING; }
    {DQSTRING}               {
          ifQuotedTokenBuffer.append(yytext().toString());
          return DQSTRING;
      }
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
    {COMMENT}                { prevConcatEligible = false; joinPending = false; return COMMENT; }
    // Use MAP_BLOCK_VALUE to allow '=' in unquoted map values (e.g. &a=1)
    {MAP_BLOCK_VALUE}        { return VALUE; }
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
    {COMMENT}                { prevConcatEligible = false; joinPending = false; return COMMENT; }
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
    {COMMENT}                { prevConcatEligible = false; joinPending = false; return COMMENT; }
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
    {COMMENT}                { prevConcatEligible = false; joinPending = false; return COMMENT; }
    {VALUE}                  { return VALUE; }
}


{COMMENT}                    { prevConcatEligible = false; joinPending = false; return COMMENT; }
{WHITE_SPACE}                { prevConcatEligible = false; joinPending = false; return WHITE_SPACE; }

[^]                          { yyinitial(); return BAD_CHARACTER; }
