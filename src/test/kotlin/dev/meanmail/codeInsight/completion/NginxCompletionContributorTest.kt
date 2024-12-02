package dev.meanmail.codeInsight.completion

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class NginxCompletionContributorTest : BasePlatformTestCase() {
    override fun getTestDataPath(): String {
        return "src/test/resources/dev/meanmail/completion"
    }

    private fun doTest(
        before: String,
        vararg completions: String,
        strict: Boolean = false
    ) {
        myFixture.configureByText("nginx.conf", before)
        val variants = myFixture.completeBasic()
        if (variants != null) {
            val strings = variants.map { it.lookupString }
            if (strict) {
                assertEquals(completions.toSet(), strings.toSet())
            } else {
                for (completion in completions) {
                    assertTrue(
                        "Expected completion: $completion not found in ${strings.joinToString()}",
                        strings.contains(completion)
                    )
                }
            }
        } else if (completions.isNotEmpty()) {
            fail("No completions found but ${completions.joinToString()} expected")
        }
    }

    fun testMainContext() {
        // В корне конфига должны быть доступны основные директивы
        doTest(
            """
            eve<caret>
        """.trimIndent(),
            "events", "gzip_comp_level", "limit_conn_log_level", "limit_req_log_level",
            strict = true
        )
    }

    fun testHttpContext() {
        // В http блоке должны быть доступны серверные директивы
        doTest(
            """
            http {
                server<caret>
            }
        """.trimIndent(),
            "server",
            "server_name_in_redirect",
            "server_names_hash_bucket_size",
            "server_names_hash_max_size",
            "server_tokens",
            "proxy_ssl_server_name",
            "ssl_prefer_server_ciphers",
            "uwsgi_ssl_server_name",
            strict = true
        )
    }

    fun testServerContext() {
        // В server блоке должны быть доступны директивы сервера
        doTest(
            """
            http {
                server {
                    limit_con<caret>
                }
            }
        """.trimIndent(),
            "limit_conn", "limit_conn_dry_run", "limit_conn_log_level", "limit_conn_status",
            strict = true
        )
    }

    fun testLocationContext() {
        // В location блоке должны быть доступны директивы location
        doTest(
            """
            http {
                server {
                    location / {
                        proxy_set<caret>
                    }
                }
            }
        """.trimIndent(),
            "proxy_set_body",
            "proxy_set_header",
            "proxy_send_timeout",
            strict = true
        )
    }

    fun testLocationIfContext() {
        // В if блоке внутри location должны быть доступны директивы if
        doTest(
            """
            http {
                server {
                    location / {
                        if (${'$'}request_method = POST) {
                            ret<caret>
                        }
                    }
                }
            }
        """.trimIndent(),
            "return", "echo_reset_timer",
            strict = true
        )
    }

    fun testEventsContext() {
        // В events блоке должны быть доступны директивы events
        doTest(
            """
            events {
                wor<caret>
            }
        """.trimIndent(),
            "worker_aio_requests", "worker_connections",
            strict = true
        )
    }

    fun testUpstreamContext() {
        // В upstream блоке должны быть доступны директивы upstream
        doTest(
            """
            http {
                upstream backend {
                    ser<caret>
                }
            }
        """.trimIndent(),
            "server", "sticky_cookie_insert",
            strict = true
        )
    }
}
