package dev.meanmail.lexer

import dev.meanmail.NginxLexer
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.StringReader

class NginxLexerStateTest {

    private fun createLexer(input: String): NginxLexer {
        val lexer = NginxLexer(StringReader(input))
        lexer.yyinitial()
        lexer.reset(input, 0, input.length, 0)
        return lexer
    }

    @Test
    fun testFullStateRoundtrip() {
        val input = "server { listen 80; }"
        val lexer = createLexer(input)

        // Advance past "server" and "{"
        lexer.advance() // IDENTIFIER "server"
        lexer.advance() // WS
        lexer.advance() // LBRACE

        val state = lexer.fullState
        val pos = lexer.tokenEnd

        // Create new lexer and restore state
        val lexer2 = createLexer(input)
        lexer2.reset(input, pos, input.length, 0)
        lexer2.restoreFullState(state)

        // Both should produce same tokens from here
        val token1 = lexer.advance()
        val token2 = lexer2.advance()
        assertEquals(token1, token2)
    }

    @Test
    fun testFullStatePreservesStack() {
        val input = "map \$uri \$new { default /; }"
        val lexer = createLexer(input)

        // Advance into the map block
        while (lexer.advance() != null) {
            val state = lexer.fullState

            // Roundtrip: encode → decode → re-encode should be identical
            val lexer2 = NginxLexer(StringReader(""))
            lexer2.restoreFullState(state)
            val state2 = lexer2.fullState

            assertEquals("State roundtrip should be identical", state, state2)
        }
    }

    @Test
    fun testFullStatePreservesFlags() {
        val input = "location /path { proxy_pass http://backend; }"
        val lexer = createLexer(input)

        // Advance to "location" — should set inLocationPath
        lexer.advance() // LOCATION

        val state = lexer.fullState

        // Verify roundtrip preserves the flag
        val lexer2 = NginxLexer(StringReader(""))
        lexer2.restoreFullState(state)
        assertEquals(state, lexer2.fullState)
    }
}
