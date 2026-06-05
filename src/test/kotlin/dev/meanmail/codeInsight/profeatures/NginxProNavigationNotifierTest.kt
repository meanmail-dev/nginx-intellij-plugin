package dev.meanmail.codeInsight.profeatures

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import dev.meanmail.NginxFileType

class NginxProNavigationNotifierTest : BasePlatformTestCase() {

    fun testVariableUnderCaretIsRecognized() {
        myFixture.configureByText(
            NginxFileType.INSTANCE,
            """
            http {
                server {
                    return 200 ${'$'}uri;
                }
            }
            """.trimIndent()
        )
        val offset = myFixture.file.text.indexOf("${'$'}uri")
        val element = myFixture.file.findElementAt(offset)
        assertTrue(
            "A variable leaf should be a high-intent navigation target",
            NginxProNavigationNotifier.isVariableReference(element)
        )
    }

    fun testPlainValueIsNotRecognized() {
        myFixture.configureByText(
            NginxFileType.INSTANCE,
            """
            http {
                server {
                    server_name example.com;
                }
            }
            """.trimIndent()
        )
        val offset = myFixture.file.text.indexOf("example")
        val element = myFixture.file.findElementAt(offset)
        assertFalse(
            "A plain directive value should not trigger the navigation prompt",
            NginxProNavigationNotifier.isVariableReference(element)
        )
    }

    fun testNullElementIsNotRecognized() {
        assertFalse(NginxProNavigationNotifier.isVariableReference(null))
    }
}
