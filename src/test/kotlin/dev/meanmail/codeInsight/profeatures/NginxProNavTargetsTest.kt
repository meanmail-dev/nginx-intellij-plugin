package dev.meanmail.codeInsight.profeatures

import com.intellij.psi.impl.source.PsiFileImpl
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import dev.meanmail.NginxFileType

class NginxProNavTargetsTest : BasePlatformTestCase() {

    fun testVariableIsNavigableProSymbol() {
        val element = elementAt(
            """
            http {
                server {
                    return 200 ${'$'}uri;
                }
            }
            """.trimIndent(),
            "${'$'}uri"
        )
        assertTrue(NginxProNavTargets.isVariable(element))
        assertTrue(NginxProNavTargets.isNavigableProSymbol(element))
    }

    fun testUpstreamPassReferenceIsNavigable() {
        val element = elementAt(
            """
            http {
                upstream backend { server 127.0.0.1:8080; }
                server {
                    location / {
                        proxy_pass http://backend;
                    }
                }
            }
            """.trimIndent(),
            "backend;"
        )
        assertTrue(NginxProNavTargets.isUpstreamReference(element))
        assertTrue(NginxProNavTargets.isNavigableProSymbol(element))
    }

    fun testPlainValueIsNotNavigable() {
        val element = elementAt(
            """
            http {
                server {
                    server_name example.com;
                }
            }
            """.trimIndent(),
            "example"
        )
        assertFalse(NginxProNavTargets.isNavigableProSymbol(element))
    }

    fun testNullIsNotNavigable() {
        assertFalse(NginxProNavTargets.isNavigableProSymbol(null))
    }

    fun testForeignLanguageElementIsNotNavigable() {
        // The platform queries every FindUsagesHandlerFactory for elements of any
        // language. We must never touch a non-Nginx element's AST (doing so forced
        // foreign-file AST loads and crashed on a Vue/JS stub mismatch). A plain
        // text element must be rejected without inspecting its node.
        val element = myFixture.configureByText("foreign.txt", "backend variable")
            .let { it.findElementAt(0) }
        assertFalse(NginxProNavTargets.isVariable(element))
        assertFalse(NginxProNavTargets.isUpstreamReference(element))
        assertFalse(NginxProNavTargets.isNavigableProSymbol(element))
    }

    fun testFileElementIsRejectedWithoutLoadingAst() {
        // The platform queries every FindUsagesHandlerFactory with the element being
        // operated on. Safe Delete of a config file passes the whole PsiFile here.
        // Touching its .node forced the entire file to parse (decoding bytes) on the
        // EDT, freezing the IDE. A file is never a variable, so reject it without
        // loading the AST.
        val psiFile = myFixture.addFileToProject("freeze-check.nginx", "server { listen 80; }")
        val fileImpl = psiFile as PsiFileImpl
        assertFalse("precondition: AST must not be loaded yet", fileImpl.isContentsLoaded)

        assertFalse(NginxProNavTargets.isVariable(psiFile))
        assertFalse(NginxProNavTargets.isNavigableProSymbol(psiFile))

        assertFalse("checking for a variable must not force the file AST to load", fileImpl.isContentsLoaded)
    }

    fun testExtractUpstreamNameSkipsAddressesAndDomains() {
        assertEquals("backend", NginxProNavTargets.extractUpstreamName("http://backend"))
        assertEquals("backend", NginxProNavTargets.extractUpstreamName("https://backend:8080/path"))
        assertEquals("backend", NginxProNavTargets.extractUpstreamName("backend"))
        assertNull(NginxProNavTargets.extractUpstreamName("http://127.0.0.1:8080"))
        assertNull(NginxProNavTargets.extractUpstreamName("http://example.com"))
        assertNull(NginxProNavTargets.extractUpstreamName("http://localhost"))
        assertNull(NginxProNavTargets.extractUpstreamName("unix:/var/run/php.sock"))
    }

    private fun elementAt(config: String, marker: String) =
        myFixture.configureByText(NginxFileType.INSTANCE, config)
            .let { it.findElementAt(it.text.indexOf(marker)) }
}
