package dev.meanmail.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.tree.IElementType
import dev.meanmail.NginxLexer
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.StringReader

class NginxLexerTest {
    private fun tokenize(input: String): List<Pair<String, String>> {
        val lexer = NginxLexer(StringReader(input))
        val tokens = mutableListOf<Pair<String, String>>()

        println("Input: '$input'")
        println("Lexer initial state: ${lexer.yystate()}")

        try {
            lexer.yyinitial()
            lexer.reset(input, 0, input.length, 0)

            var tokenType: IElementType? = lexer.advance()
            while (tokenType != null) {
                val tokenText = lexer.yytext()

                if (tokenType != WHITE_SPACE) {
                    val tokenName = tokenType.toString().substringAfter(".")
                    tokens.add(tokenName to tokenText.toString())
                }

                tokenType = lexer.advance()
            }
        } catch (e: Exception) {
            println("Exception during lexer processing: ${e.message}")
            e.printStackTrace()
        }

        println("Total tokens: ${tokens.size}")
        return tokens
    }

    @Test
    fun testSimpleDirective() {
        val tokens = tokenize("server_name example.com;")
        val expectedTokens = listOf(
            "IDENTIFIER" to "server_name",
            "VALUE" to "example.com",
            "SEMICOLON" to ";"
        )
        assertEquals("Token count does not match", expectedTokens.size, tokens.size)
        expectedTokens.forEachIndexed { index, (expectedType, expectedValue) ->
            assertEquals("Token type does not match at index $index", expectedType, tokens[index].first)
            assertEquals("Token value does not match at index $index", expectedValue, tokens[index].second)
        }
    }

    @Test
    fun testVariables() {
        val tokens = tokenize("proxy_pass ${'$'}host;")
        val expectedTokens = listOf(
            "IDENTIFIER" to "proxy_pass",
            "VARIABLE" to "${'$'}host",
            "SEMICOLON" to ";"
        )
        assertEquals("Token count does not match", expectedTokens.size, tokens.size)
        expectedTokens.forEachIndexed { index, (expectedType, expectedValue) ->
            assertEquals("Token type does not match at index $index", expectedType, tokens[index].first)
            assertEquals("Token value does not match at index $index", expectedValue, tokens[index].second)
        }
    }

    @Test
    fun testStringLiterals() {
        val tokens = tokenize("error_log '/var/log/nginx/error.log';")
        val expectedTokens = listOf(
            "IDENTIFIER" to "error_log",
            "QUOTE" to "'",
            "STRING" to "/var/log/nginx/error.log",
            "QUOTE" to "'",
            "SEMICOLON" to ";"
        )
        assertEquals("Token count does not match", expectedTokens.size, tokens.size)
        expectedTokens.forEachIndexed { index, (expectedType, expectedValue) ->
            assertEquals("Token type does not match at index $index", expectedType, tokens[index].first)
            assertEquals("Token value does not match at index $index", expectedValue, tokens[index].second)
        }
    }

    @Test
    fun testServerBlock() {
        val tokens = tokenize(
            """
            server {
                listen 80;
                location / {
                    proxy_pass http://backend;
                }
            }
        """.trimIndent()
        )

        val expectedTokens = listOf(
            "IDENTIFIER" to "server",
            "LBRACE" to "{",
            "IDENTIFIER" to "listen",
            "VALUE" to "80",
            "SEMICOLON" to ";",
            "LOCATION" to "location",
            "VALUE" to "/",
            "LBRACE" to "{",
            "IDENTIFIER" to "proxy_pass",
            "VALUE" to "http://backend",
            "SEMICOLON" to ";",
            "RBRACE" to "}",
            "RBRACE" to "}"
        )

        assertEquals("Token count does not match", expectedTokens.size, tokens.size)
        expectedTokens.forEachIndexed { index, (expectedType, expectedValue) ->
            assertEquals("Token type does not match at index $index", expectedType, tokens[index].first)
            assertEquals("Token value does not match at index $index", expectedValue, tokens[index].second)
        }
    }

    @Test
    fun testMapDirective() {
        val tokens = tokenize(
            """
            map ${'$'}http_host ${'$'}name {
                default "";
                example.com "main_site";
            }
        """.trimIndent()
        )

        val expectedTokens = listOf(
            "MAP" to "map",
            "VARIABLE" to "${'$'}http_host",
            "VARIABLE" to "${'$'}name",
            "LBRACE" to "{",
            "MAP_DEFAULT" to "default",
            "DQUOTE" to "\"",
            "DQUOTE" to "\"",
            "SEMICOLON" to ";",
            "VALUE" to "example.com",
            "DQUOTE" to "\"",
            "DQSTRING" to "main_site",
            "DQUOTE" to "\"",
            "SEMICOLON" to ";",
            "RBRACE" to "}"
        )

        assertEquals("Token count does not match", expectedTokens.size, tokens.size)
        expectedTokens.forEachIndexed { index, (expectedType, expectedValue) ->
            assertEquals("Token type does not match at index $index", expectedType, tokens[index].first)
            assertEquals("Token value does not match at index $index", expectedValue, tokens[index].second)
        }
    }

    @Test
    fun testComments() {
        val tokens = tokenize(
            """
            # Main server configuration
            server {
                # Listen on port 80
                listen 80;
            }
        """.trimIndent()
        )

        val expectedTokens = listOf(
            "COMMENT" to "# Main server configuration",
            "IDENTIFIER" to "server",
            "LBRACE" to "{",
            "COMMENT" to "# Listen on port 80",
            "IDENTIFIER" to "listen",
            "VALUE" to "80",
            "SEMICOLON" to ";",
            "RBRACE" to "}"
        )

        assertEquals("Token count does not match", expectedTokens.size, tokens.size)
        expectedTokens.forEachIndexed { index, (expectedType, expectedValue) ->
            assertEquals("Token type does not match at index $index", expectedType, tokens[index].first)
            assertEquals("Token value does not match at index $index", expectedValue, tokens[index].second)
        }
    }

    @Test
    fun testEscapedCharacters() {
        val tokens = tokenize(
            """
            location ~* \.(jpg|jpeg|png)$ {
                proxy_pass http://images;
            }
        """.trimIndent()
        )

        val expectedTokens = listOf(
            "LOCATION" to "location",
            "BINARY_OPERATOR" to "~*",
            "VALUE" to "\\.(jpg|jpeg|png)$",
            "LBRACE" to "{",
            "IDENTIFIER" to "proxy_pass",
            "VALUE" to "http://images",
            "SEMICOLON" to ";",
            "RBRACE" to "}"
        )

        assertEquals("Token count does not match", expectedTokens.size, tokens.size)
        expectedTokens.forEachIndexed { index, (expectedType, expectedValue) ->
            assertEquals("Token type does not match at index $index", expectedType, tokens[index].first)
            assertEquals("Token value does not match at index $index", expectedValue, tokens[index].second)
        }
    }

    @Test
    fun testIfDirective() {
        val tokens = tokenize(
            """
            if (${'$'}http_x_forwarded_proto = 'https') {
                return 301 https://${'$'}host${'$'}request_uri;
            }
        """.trimIndent()
        )

        val expectedTokens = listOf(
            "IF" to "if",
            "LPAREN" to "(",
            "VARIABLE" to "${'$'}http_x_forwarded_proto",
            "EQUAL" to "=",
            "QUOTE" to "'",
            "STRING" to "https",
            "QUOTE" to "'",
            "RPAREN" to ")",
            "LBRACE" to "{",
            "IDENTIFIER" to "return",
            "VALUE" to "301",
            "VALUE" to "https://",
            "CONCAT_JOIN" to "",
            "VARIABLE" to "${'$'}host",
            "CONCAT_JOIN" to "",
            "VARIABLE" to "${'$'}request_uri",
            "SEMICOLON" to ";",
            "RBRACE" to "}"
        )

        assertEquals("Token count does not match", expectedTokens.size, tokens.size)
        expectedTokens.forEachIndexed { index, (expectedType, expectedValue) ->
            assertEquals("Token type does not match at index $index", expectedType, tokens[index].first)
            assertEquals("Token value does not match at index $index", expectedValue, tokens[index].second)
        }
    }

    @Test
    fun testBracedVariableInValue() {
        // https://github.com/meanmail-dev/nginx-intellij-plugin/issues/45
        val tokens = tokenize(
            "ssl_certificate /etc/letsencrypt/live/\${SERVER_NAME}/fullchain.pem;"
        )

        val expectedTokens = listOf(
            "IDENTIFIER" to "ssl_certificate",
            "VALUE" to "/etc/letsencrypt/live/\${SERVER_NAME}/fullchain.pem",
            "SEMICOLON" to ";"
        )

        assertEquals("Token count does not match", expectedTokens.size, tokens.size)
        expectedTokens.forEachIndexed { index, (expectedType, expectedValue) ->
            assertEquals("Token type does not match at index $index", expectedType, tokens[index].first)
            assertEquals("Token value does not match at index $index", expectedValue, tokens[index].second)
        }
    }

    @Test
    fun testTypesDirective() {
        // https://github.com/meanmail-dev/nginx-intellij-plugin/issues/43
        val tokens = tokenize(
            """
            types {
                application/json json;
                text/html html htm;
            }
        """.trimIndent()
        )

        val expectedTokens = listOf(
            "TYPES" to "types",
            "LBRACE" to "{",
            "VALUE" to "application/json",
            "VALUE" to "json",
            "SEMICOLON" to ";",
            "VALUE" to "text/html",
            "VALUE" to "html",
            "VALUE" to "htm",
            "SEMICOLON" to ";",
            "RBRACE" to "}"
        )

        assertEquals("Token count does not match", expectedTokens.size, tokens.size)
        expectedTokens.forEachIndexed { index, (expectedType, expectedValue) ->
            assertEquals("Token type does not match at index $index", expectedType, tokens[index].first)
            assertEquals("Token value does not match at index $index", expectedValue, tokens[index].second)
        }
    }

    @Test
    fun testIfDirectiveWithNestedParentheses() {
        // https://github.com/meanmail-dev/nginx-intellij-plugin/issues/40
        val tokens = tokenize(
            """
            if (${'$'}args ~ [\&\?]stream.*?=(.*)) {
                return 403;
            }
        """.trimIndent()
        )

        val expectedTokens = listOf(
            "IF" to "if",
            "LPAREN" to "(",
            "VARIABLE" to "${'$'}args",
            "BINARY_OPERATOR" to "~",
            "VALUE" to "[\\&\\?]stream.*?=",
            "VALUE" to "(",          // nested paren treated as VALUE
            "CONCAT_JOIN" to "",
            "VALUE" to ".*",
            "VALUE" to ")",          // closing nested paren treated as VALUE
            "RPAREN" to ")",         // actual closing paren
            "LBRACE" to "{",
            "IDENTIFIER" to "return",
            "VALUE" to "403",
            "SEMICOLON" to ";",
            "RBRACE" to "}"
        )

        assertEquals("Token count does not match", expectedTokens.size, tokens.size)
        expectedTokens.forEachIndexed { index, (expectedType, expectedValue) ->
            assertEquals("Token type does not match at index $index", expectedType, tokens[index].first)
            assertEquals("Token value does not match at index $index", expectedValue, tokens[index].second)
        }
    }

    @Test
    fun testGeoDirective() {
        val tokens = tokenize(
            """
            geo ${'$'}binary_remote_addr ${'$'}geoip_country_code {
                default        ZZ;
                proxy         192.168.100.0/24;
                ranges;
                include       conf/geo.conf;
                127.0.0.1     US;
                192.168.1.0/24 RU;
            }
        """.trimIndent()
        )
        val expectedTokens = listOf(
            "GEO" to "geo",
            "VARIABLE" to "${'$'}binary_remote_addr",
            "VARIABLE" to "${'$'}geoip_country_code",
            "LBRACE" to "{",
            "GEO_DEFAULT" to "default",
            "VALUE" to "ZZ",
            "SEMICOLON" to ";",
            "GEO_PROXY" to "proxy",
            "VALUE" to "192.168.100.0/24",
            "SEMICOLON" to ";",
            "GEO_RANGES" to "ranges",
            "SEMICOLON" to ";",
            "GEO_INCLUDE" to "include",
            "VALUE" to "conf/geo.conf",
            "SEMICOLON" to ";",
            "VALUE" to "127.0.0.1",
            "VALUE" to "US",
            "SEMICOLON" to ";",
            "VALUE" to "192.168.1.0/24",
            "VALUE" to "RU",
            "SEMICOLON" to ";",
            "RBRACE" to "}"
        )
        assertEquals("Token count does not match", expectedTokens.size, tokens.size)
        expectedTokens.forEachIndexed { index, (expectedType, expectedValue) ->
            assertEquals("Token type does not match at index $index", expectedType, tokens[index].first)
            assertEquals("Token value does not match at index $index", expectedValue, tokens[index].second)
        }
    }

    @Test
    fun testMapDirectiveWithEqualsInValue() {
        // https://github.com/meanmail-dev/nginx-intellij-plugin/issues/53
        val tokens = tokenize(
            """
            map ${'$'}request_uri ${'$'}append_args {
                default &a=1;
            }
        """.trimIndent()
        )

        val expectedTokens = listOf(
            "MAP" to "map",
            "VARIABLE" to "${'$'}request_uri",
            "VARIABLE" to "${'$'}append_args",
            "LBRACE" to "{",
            "MAP_DEFAULT" to "default",
            "VALUE" to "&a=1",
            "SEMICOLON" to ";",
            "RBRACE" to "}"
        )

        assertEquals("Token count does not match", expectedTokens.size, tokens.size)
        expectedTokens.forEachIndexed { index, (expectedType, expectedValue) ->
            assertEquals("Token type does not match at index $index", expectedType, tokens[index].first)
            assertEquals("Token value does not match at index $index", expectedValue, tokens[index].second)
        }
    }

    @Test
    fun testMapDirectiveWithMultipleEqualsInValue() {
        // https://github.com/meanmail-dev/nginx-intellij-plugin/issues/53
        val tokens = tokenize(
            """
            map ${'$'}request_uri ${'$'}append_args {
                default &a=1&b=2;
                ~^/api /api?key=value;
            }
        """.trimIndent()
        )

        val expectedTokens = listOf(
            "MAP" to "map",
            "VARIABLE" to "${'$'}request_uri",
            "VARIABLE" to "${'$'}append_args",
            "LBRACE" to "{",
            "MAP_DEFAULT" to "default",
            "VALUE" to "&a=1&b=2",
            "SEMICOLON" to ";",
            "VALUE" to "~^/api",
            "VALUE" to "/api?key=value",
            "SEMICOLON" to ";",
            "RBRACE" to "}"
        )

        assertEquals("Token count does not match", expectedTokens.size, tokens.size)
        expectedTokens.forEachIndexed { index, (expectedType, expectedValue) ->
            assertEquals("Token type does not match at index $index", expectedType, tokens[index].first)
            assertEquals("Token value does not match at index $index", expectedValue, tokens[index].second)
        }
    }

    @Test
    fun testSimpleGeoDirective() {
        val tokens = tokenize(
            """
            geo ${'$'}remote_addr ${'$'}country {
                default  unknown;
                10.1.0.0/16  US;
                192.168.1.0/24  RU;
            }
        """.trimIndent()
        )
        val expectedTokens = listOf(
            "GEO" to "geo",
            "VARIABLE" to "${'$'}remote_addr",
            "VARIABLE" to "${'$'}country",
            "LBRACE" to "{",
            "GEO_DEFAULT" to "default",
            "VALUE" to "unknown",
            "SEMICOLON" to ";",
            "VALUE" to "10.1.0.0/16",
            "VALUE" to "US",
            "SEMICOLON" to ";",
            "VALUE" to "192.168.1.0/24",
            "VALUE" to "RU",
            "SEMICOLON" to ";",
            "RBRACE" to "}"
        )
        assertEquals("Token count does not match", expectedTokens.size, tokens.size)
        expectedTokens.forEachIndexed { index, (expectedType, expectedValue) ->
            assertEquals("Token type does not match at index $index", expectedType, tokens[index].first)
            assertEquals("Token value does not match at index $index", expectedValue, tokens[index].second)
        }
    }

    @Test
    fun testVariableWithQueryStringEquals() {
        // https://github.com/meanmail-dev/nginx-intellij-plugin/issues/63
        val tokens = tokenize(
            """
            server {
                location / {
                    error_page 400 ${'$'}uri?x=;
                    try_files ${'$'}uri ${'$'}uri?x=;
                }
            }
        """.trimIndent()
        )

        val expectedTokens = listOf(
            "IDENTIFIER" to "server",
            "LBRACE" to "{",
            "LOCATION" to "location",
            "VALUE" to "/",
            "LBRACE" to "{",
            "IDENTIFIER" to "error_page",
            "VALUE" to "400",
            "VARIABLE" to "${'$'}uri",
            "CONCAT_JOIN" to "",
            "VALUE" to "?x=",
            "SEMICOLON" to ";",
            "IDENTIFIER" to "try_files",
            "VARIABLE" to "${'$'}uri",
            "VARIABLE" to "${'$'}uri",
            "CONCAT_JOIN" to "",
            "VALUE" to "?x=",
            "SEMICOLON" to ";",
            "RBRACE" to "}",
            "RBRACE" to "}"
        )

        assertEquals("Token count does not match", expectedTokens.size, tokens.size)
        expectedTokens.forEachIndexed { index, (expectedType, expectedValue) ->
            assertEquals("Token type does not match at index $index", expectedType, tokens[index].first)
            assertEquals("Token value does not match at index $index", expectedValue, tokens[index].second)
        }
    }

    @Test
    fun testIfDirectiveWithEscapedParentheses() {
        // https://github.com/meanmail-dev/nginx-intellij-plugin/issues/52
        val tokens = tokenize(
            """
            if (${'$'}args ~ tt\( ) {
                return 403;
            }
        """.trimIndent()
        )

        val expectedTokens = listOf(
            "IF" to "if",
            "LPAREN" to "(",
            "VARIABLE" to "${'$'}args",
            "BINARY_OPERATOR" to "~",
            "VALUE" to "tt\\(",       // escaped paren is part of VALUE
            "RPAREN" to ")",
            "LBRACE" to "{",
            "IDENTIFIER" to "return",
            "VALUE" to "403",
            "SEMICOLON" to ";",
            "RBRACE" to "}"
        )

        assertEquals("Token count does not match", expectedTokens.size, tokens.size)
        expectedTokens.forEachIndexed { index, (expectedType, expectedValue) ->
            assertEquals("Token type does not match at index $index", expectedType, tokens[index].first)
            assertEquals("Token value does not match at index $index", expectedValue, tokens[index].second)
        }
    }
}
