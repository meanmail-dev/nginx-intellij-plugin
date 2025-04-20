package dev.meanmail.reference

import com.intellij.psi.PsiElement
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import dev.meanmail.NginxFileType
import dev.meanmail.psi.ValueStmt

class NginxReferenceTest : BasePlatformTestCase() {

    fun testFileReferenceResolution() {
        // Create test files
        myFixture.tempDirFixture.findOrCreateDir("conf.d")
        val serverConf = myFixture.addFileToProject(
            "conf.d/server.conf",
            """
            server {
                listen 80;
                server_name example.com;
            }
            """.trimIndent()
        )

        // Create main config with include directive
        val mainConfig = myFixture.configureByText(
            NginxFileType.INSTANCE,
            """
            http {
                include conf.d/server.conf;
            }
            """.trimIndent()
        )

        // Find the value statement
        val valueStmt = findValueStmt(mainConfig)
        assertNotNull("Should find value statement", valueStmt)

        // Check reference resolution
        val references = valueStmt!!.references
        assertTrue("Should have references", references.isNotEmpty())

        val resolved = references[0].resolve()
        assertNotNull("Reference should resolve", resolved)
        assertEquals("Should resolve to server.conf", serverConf, resolved)
    }

    fun testAbsolutePathReference() {
        // Create test files
        myFixture.tempDirFixture.findOrCreateDir("conf.d")
        val serverConf = myFixture.addFileToProject(
            "conf.d/server.conf",
            """
            server {
                listen 80;
            }
            """.trimIndent()
        )

        val basePath = serverConf.virtualFile.parent.parent.path

        // Create config with absolute path
        val mainConfig = myFixture.configureByText(
            NginxFileType.INSTANCE,
            """
            http {
                include $basePath/conf.d/server.conf;
            }
            """.trimIndent()
        )

        val valueStmt = findValueStmt(mainConfig)
        assertNotNull("Should find value statement", valueStmt)
        val references = valueStmt!!.references
        assertTrue("Should have references", references.isNotEmpty())
        val resolved = references[0].resolve()

        assertNotNull("Should resolve absolute path", resolved)
        assertEquals("Should resolve to correct file", serverConf, resolved)
    }

    fun testNonExistentFileReference() {
        val config = myFixture.configureByText(
            NginxFileType.INSTANCE,
            """
            http {
                include conf.d/nonexistent.conf;
            }
            """.trimIndent()
        )

        val valueStmt = findValueStmt(config)
        assertNotNull("Should find value statement", valueStmt)
        val references = valueStmt!!.references
        assertTrue("Should have not references", references.isEmpty())
    }

    fun testNestedPathReference() {
        // Create nested directory structure
        myFixture.tempDirFixture.findOrCreateDir("conf.d/nested")
        val nestedConf = myFixture.addFileToProject(
            "conf.d/nested/app.conf",
            """
            location /app {
                proxy_pass http://backend;
            }
            """.trimIndent()
        )

        val config = myFixture.configureByText(
            NginxFileType.INSTANCE,
            """
            http {
                include conf.d/nested/app.conf;
            }
            """.trimIndent()
        )

        val valueStmt = findValueStmt(config)
        assertNotNull("Should find value statement", valueStmt)
        val references = valueStmt!!.references
        assertTrue("Should have references", references.isNotEmpty())
        val resolved = references[0].resolve()

        assertNotNull("Should resolve nested path", resolved)
        assertEquals("Should resolve to correct nested file", nestedConf, resolved)
    }

    private fun findValueStmt(element: PsiElement): PsiElement? {
        var result: PsiElement? = null
        element.accept(object : com.intellij.psi.PsiRecursiveElementVisitor() {
            override fun visitElement(element: PsiElement) {
                if (element is ValueStmt) {
                    result = element
                    return
                }
                super.visitElement(element)
            }
        })
        return result
    }

    override fun getTestDataPath(): String {
        return "src/test/testData"
    }
}
