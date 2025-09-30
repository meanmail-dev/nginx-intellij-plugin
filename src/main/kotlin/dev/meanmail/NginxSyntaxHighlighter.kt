package dev.meanmail

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import dev.meanmail.psi.Types

class NginxSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer {
        return NginxLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS
            Types.COMMENT -> COMMENT_KEYS
            Types.IDENTIFIER -> IDENTIFIER_KEYS
            Types.VARIABLE -> VARIABLE_KEYS
            Types.VALUE -> VALUE_KEYS
            Types.IP_ADDRESS -> IP_ADDRESS_KEYS
            Types.IP_RANGE -> IP_RANGE_KEYS
            Types.NUMBER -> NUMBER_KEYS
            Types.NUMBER_DURATION -> NUMBER_DURATION_KEYS
            Types.NUMBER_SIZE -> NUMBER_SIZE_KEYS
            Types.LOCATION -> IDENTIFIER_KEYS
            Types.STRING, Types.DQSTRING -> STRING_KEYS
            Types.LBRACE, Types.RBRACE -> BRACE_KEYS
            Types.LPAREN, Types.RPAREN -> PAREN_KEYS
            Types.QUOTE, Types.DQUOTE -> QUOTE_KEYS
            Types.SEMICOLON -> SEMICOLON_KEYS
            Types.LUA_BLOCK_DIRECTIVE -> LUA_BLOCK_DIRECTIVE_KEYS
            Types.MAP -> MAP_KEYS
            Types.MAP_DEFAULT -> MAP_DEFAULT_KEYS
            Types.MAP_VOLATILE -> MAP_VOLATILE_KEYS
            Types.MAP_HOSTNAMES -> MAP_HOSTNAMES_KEYS
            Types.MAP_INCLUDE -> IDENTIFIER_KEYS
            Types.UNARY_OPERATOR -> OPERATOR_KEYS
            Types.BINARY_OPERATOR -> OPERATOR_KEYS
            Types.IF -> IF_KEYS
            Types.RETURN -> RETURN_KEYS
            Types.GEO -> GEO_KEYS
            Types.GEO_DEFAULT -> GEO_DEFAULT_KEYS
            Types.GEO_PROXY -> GEO_PROXY_KEYS
            Types.GEO_RANGES -> GEO_RANGES_KEYS
            Types.GEO_INCLUDE -> IDENTIFIER_KEYS
            else -> EMPTY_KEYS
        }
    }

    companion object {
        internal val BAD_CHARACTER = createTextAttributesKey("NGINX_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
        internal val COMMENT = createTextAttributesKey("NGINX_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        internal val IDENTIFIER = createTextAttributesKey("NGINX_IDENTIFIER", DefaultLanguageHighlighterColors.KEYWORD)
        internal val VARIABLE =
            createTextAttributesKey("NGINX_VARIABLE", DefaultLanguageHighlighterColors.LOCAL_VARIABLE)
        internal val VALUE = createTextAttributesKey("NGINX_VALUE", DefaultLanguageHighlighterColors.STRING)
        internal val IP_ADDRESS = createTextAttributesKey("NGINX_IP_ADDRESS", DefaultLanguageHighlighterColors.NUMBER)
        internal val IP_RANGE = createTextAttributesKey("NGINX_IP_RANGE", IP_ADDRESS)
        internal val NUMBER = createTextAttributesKey("NGINX_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        internal val NUMBER_DURATION = createTextAttributesKey("NGINX_NUMBER_DURATION", DefaultLanguageHighlighterColors.NUMBER)
        internal val NUMBER_SIZE = createTextAttributesKey("NGINX_NUMBER_SIZE", DefaultLanguageHighlighterColors.NUMBER)
        internal val STRING = createTextAttributesKey("NGINX_STRING", DefaultLanguageHighlighterColors.STRING)
        internal val BRACE = createTextAttributesKey("NGINX_BRACE", DefaultLanguageHighlighterColors.BRACES)
        internal val PAREN = createTextAttributesKey("NGINX_PAREN", DefaultLanguageHighlighterColors.PARENTHESES)
        internal val QUOTE = createTextAttributesKey("NGINX_QUOTE", DefaultLanguageHighlighterColors.STRING)
        internal val SEMICOLON = createTextAttributesKey("NGINX_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON)
        internal val KEYWORD = createTextAttributesKey("NGINX_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        internal val LUA_BLOCK_DIRECTIVE =
            createTextAttributesKey("NGINX_LUA_BLOCK_DIRECTIVE", IDENTIFIER)
        internal val MAP = createTextAttributesKey("NGINX_MAP", KEYWORD)
        internal val MAP_DEFAULT = createTextAttributesKey("NGINX_MAP_DEFAULT", KEYWORD)
        internal val MAP_VOLATILE =
            createTextAttributesKey("NGINX_MAP_VOLATILE", KEYWORD)
        internal val MAP_HOSTNAMES =
            createTextAttributesKey("NGINX_MAP_HOSTNAMES", KEYWORD)
        internal val OPERATOR =
            createTextAttributesKey("NGINX_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        internal val IF = createTextAttributesKey("NGINX_IF", KEYWORD)
        internal val RETURN = createTextAttributesKey("NGINX_RETURN", KEYWORD)
        internal val GEO = createTextAttributesKey("NGINX_GEO", KEYWORD)
        internal val GEO_DEFAULT = createTextAttributesKey("NGINX_GEO_DEFAULT", KEYWORD)
        internal val GEO_PROXY = createTextAttributesKey("NGINX_GEO_PROXY", KEYWORD)
        internal val GEO_RANGES = createTextAttributesKey("NGINX_GEO_RANGES", KEYWORD)

        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
        private val IDENTIFIER_KEYS = arrayOf(IDENTIFIER)
        private val VARIABLE_KEYS = arrayOf(VARIABLE)
        private val VALUE_KEYS = arrayOf(VALUE)
        private val IP_ADDRESS_KEYS = arrayOf(IP_ADDRESS)
        private val IP_RANGE_KEYS = arrayOf(IP_RANGE)
        private val NUMBER_KEYS = arrayOf(NUMBER)
        private val NUMBER_DURATION_KEYS = arrayOf(NUMBER_DURATION)
        private val NUMBER_SIZE_KEYS = arrayOf(NUMBER_SIZE)
        private val STRING_KEYS = arrayOf(STRING)
        private val BRACE_KEYS = arrayOf(BRACE)
        private val PAREN_KEYS = arrayOf(PAREN)
        private val QUOTE_KEYS = arrayOf(QUOTE)
        private val SEMICOLON_KEYS = arrayOf(SEMICOLON)
        private val LUA_BLOCK_DIRECTIVE_KEYS = arrayOf(LUA_BLOCK_DIRECTIVE)
        private val MAP_KEYS = arrayOf(MAP)
        private val MAP_DEFAULT_KEYS = arrayOf(MAP_DEFAULT)
        private val MAP_VOLATILE_KEYS = arrayOf(MAP_VOLATILE)
        private val MAP_HOSTNAMES_KEYS = arrayOf(MAP_HOSTNAMES)
        private val OPERATOR_KEYS = arrayOf(OPERATOR)
        private val IF_KEYS = arrayOf(IF)
        private val RETURN_KEYS = arrayOf(RETURN)
        private val GEO_KEYS = arrayOf(GEO)
        private val GEO_DEFAULT_KEYS = arrayOf(GEO_DEFAULT)
        private val GEO_PROXY_KEYS = arrayOf(GEO_PROXY)
        private val GEO_RANGES_KEYS = arrayOf(GEO_RANGES)
    }
}
