package dev.meanmail.codeInsight.inspections

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class NginxLuaInspectionTest : BasePlatformTestCase() {

    override fun getTestDataPath(): String {
        return "src/test/resources/dev/meanmail/codeInsight/inspections/testData"
    }

    override fun setUp() {
        super.setUp()
        myFixture.enableInspections(NginxDirectiveInspection::class.java)
    }

    fun testContentByLuaBlock() {
        myFixture.configureByText(
            "test.nginx.conf",
            """
            http {
                server {
                    location / {
                        content_by_lua_block {
                            ngx.say("Hello, World!")
                        }
                    }
                }
            }
            """.trimIndent()
        )
        myFixture.checkHighlighting()
    }

    fun testAccessByLuaBlock() {
        myFixture.configureByText(
            "test.nginx.conf",
            """
            http {
                server {
                    location / {
                        access_by_lua_block {
                            if ngx.var.remote_addr == "127.0.0.1" then
                                return
                            end
                            ngx.exit(ngx.HTTP_FORBIDDEN)
                        }
                    }
                }
            }
            """.trimIndent()
        )
        myFixture.checkHighlighting()
    }

    fun testRewriteByLuaBlock() {
        myFixture.configureByText(
            "test.nginx.conf",
            """
            http {
                server {
                    location / {
                        rewrite_by_lua_block {
                            if ngx.var.uri == "/old" then
                                ngx.redirect("/new")
                            end
                        }
                    }
                }
            }
            """.trimIndent()
        )
        myFixture.checkHighlighting()
    }

    fun testSetByLuaBlock() {
        myFixture.configureByText(
            "test.nginx.conf",
            """
            http {
                server {
                    location / {
                        set_by_lua_block ${'$'}foo {
                            return "bar"
                        }
                    }
                }
            }
            """.trimIndent()
        )
        myFixture.checkHighlighting()
    }

    fun testInitByLuaBlock() {
        myFixture.configureByText(
            "test.nginx.conf",
            """
            http {
                init_by_lua_block {
                    require "cjson"
                    require "redis"
                }
            }
            """.trimIndent()
        )
        myFixture.checkHighlighting()
    }

    fun testBalancerByLuaBlock() {
        myFixture.configureByText(
            "test.nginx.conf",
            """
            http {
                upstream backend {
                    server 127.0.0.1:8080;
                    balancer_by_lua_block {
                        local balancer = require "ngx.balancer"
                        balancer.set_current_peer("127.0.0.1", 8080)
                    }
                }
            }
            """.trimIndent()
        )
        myFixture.checkHighlighting()
    }

    fun testHeaderFilterByLuaBlock() {
        myFixture.configureByText(
            "test.nginx.conf",
            """
            http {
                server {
                    location / {
                        header_filter_by_lua_block {
                            ngx.header["X-Custom"] = "value"
                        }
                    }
                }
            }
            """.trimIndent()
        )
        myFixture.checkHighlighting()
    }

    fun testBodyFilterByLuaBlock() {
        myFixture.configureByText(
            "test.nginx.conf",
            """
            http {
                server {
                    location / {
                        body_filter_by_lua_block {
                            local chunk = ngx.arg[1]
                            if chunk then
                                ngx.arg[1] = string.upper(chunk)
                            end
                        }
                    }
                }
            }
            """.trimIndent()
        )
        myFixture.checkHighlighting()
    }

    fun testLogByLuaBlock() {
        myFixture.configureByText(
            "test.nginx.conf",
            """
            http {
                server {
                    location / {
                        log_by_lua_block {
                            ngx.log(ngx.INFO, "Request processed")
                        }
                    }
                }
            }
            """.trimIndent()
        )
        myFixture.checkHighlighting()
    }

    fun testSslCertificateByLuaBlock() {
        myFixture.configureByText(
            "test.nginx.conf",
            """
            http {
                server {
                    ssl_certificate_by_lua_block {
                        local ssl = require "ngx.ssl"
                        local cert = ssl.parse_pem_cert(cert_data)
                        ssl.set_cert(cert)
                    }
                }
            }
            """.trimIndent()
        )
        myFixture.checkHighlighting()
    }
}
