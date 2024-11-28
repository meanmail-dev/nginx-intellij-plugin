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
            Types.INCLUDE -> INCLUDE_KEYS
            Types.IDENTIFIER -> IDENTIFIER_KEYS
            Types.LUA_BLOCK -> IDENTIFIER_KEYS
            Types.SEMICOLON -> SEMICOLON_KEYS
            else -> EMPTY_KEYS
        }
    }

    companion object {
        private val BAD_CHARACTER = createTextAttributesKey("NGINX_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
        private val COMMENT = createTextAttributesKey("NGINX_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        private val INCLUDE = createTextAttributesKey("NGINX_INCLUDE", DefaultLanguageHighlighterColors.KEYWORD)
        private val IDENTIFIER = createTextAttributesKey("NGINX_IDENTIFIER", DefaultLanguageHighlighterColors.KEYWORD)
        private val SEMICOLON = createTextAttributesKey("NGINX_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON)

        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
        private val INCLUDE_KEYS = arrayOf(INCLUDE)
        private val IDENTIFIER_KEYS = arrayOf(IDENTIFIER)
        private val SEMICOLON_KEYS = arrayOf(SEMICOLON)
    }
}
