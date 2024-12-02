package dev.meanmail.folding

import com.intellij.openapi.util.TextRange
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import dev.meanmail.NginxFileType

class NginxFoldingBuilderTest : BasePlatformTestCase() {
    
    override fun getTestDataPath(): String {
        return "src/test/testData/folding"
    }

    fun testSimpleBlockFolding() {
        myFixture.configureByText(
            NginxFileType,
            """
            http {
                server {
                    listen 80;
                    server_name localhost;
                }
            }
            """.trimIndent()
        )
        
        myFixture.doHighlighting() // Required for folding initialization
        val foldingModel = myFixture.editor.foldingModel
        val foldingRegions = foldingModel.allFoldRegions
        assertEquals(2, foldingRegions.size)
        
        // Check inner server block
        val serverBlock = foldingRegions.find { 
            it.startOffset == myFixture.editor.document.text.indexOf('{', myFixture.editor.document.text.indexOf("server")) + 1 
        }
        assertNotNull(serverBlock)
        
        // Check outer http block
        val httpBlock = foldingRegions.find { 
            it.startOffset == myFixture.editor.document.text.indexOf('{') + 1 
        }
        assertNotNull(httpBlock)
    }

    fun testLuaBlockFolding() {
        myFixture.configureByText(
            NginxFileType,
            """
            http {
                server {
                    location / {
                        content_by_lua_block {
                            ngx.say("Hello World!")
                        }
                    }
                }
            }
            """.trimIndent()
        )
        
        myFixture.doHighlighting() // Required for folding initialization
        val foldingModel = myFixture.editor.foldingModel
        val foldingRegions = foldingModel.allFoldRegions
        assertEquals(4, foldingRegions.size)
        
        // Check lua block
        val luaBlock = foldingRegions.find { 
            it.startOffset == myFixture.editor.document.text.indexOf('{', myFixture.editor.document.text.indexOf("content_by_lua_block")) + 1 
        }
        assertNotNull(luaBlock)
    }

    fun testEmptyBlockNoFolding() {
        myFixture.configureByText(
            NginxFileType,
            """
            http {
                server {}
            }
            """.trimIndent()
        )
        
        myFixture.doHighlighting() // Required for folding initialization
        val foldingModel = myFixture.editor.foldingModel
        val foldingRegions = foldingModel.allFoldRegions
        assertEquals(1, foldingRegions.size) // Only for http block
        
        // Check that empty server block has no folding
        val serverBlock = foldingRegions.find { 
            it.startOffset == myFixture.editor.document.text.indexOf('{', myFixture.editor.document.text.indexOf("server")) + 1 
        }
        assertNull(serverBlock)
    }

    fun testMissingClosingBrace() {
        myFixture.configureByText(
            NginxFileType,
            """
            http {
                server {
                    location / {
                        root /usr/share/nginx/html;
                    # Missing closing brace for server and http
            """.trimIndent()
        )

        val foldingDescriptors = NginxFoldingBuilder().buildFoldRegions(
            myFixture.file,
            myFixture.editor.document,
            false
        )

        // Should still create folding regions for each block even with missing braces
        assertEquals(3, foldingDescriptors.size)

        // Print debug info
        foldingDescriptors.forEachIndexed { index, descriptor ->
            val text = myFixture.editor.document.getText(TextRange(descriptor.range.startOffset, descriptor.range.endOffset))
            println("Region $index: start=${descriptor.range.startOffset}, end=${descriptor.range.endOffset}, length=${text.length}")
            println("Content: '$text'")
        }

        // Verify that each folding region has non-zero size
        foldingDescriptors.forEach { descriptor ->
            assertTrue(
                "Folding region should have non-zero size",
                descriptor.range.endOffset - descriptor.range.startOffset > 0
            )
        }

        // Verify that regions are nested (each region should start after the previous one)
        for (i in 1 until foldingDescriptors.size) {
            assertTrue(
                "Region $i should start after region ${i-1}",
                foldingDescriptors[i].range.startOffset > foldingDescriptors[i-1].range.startOffset
            )
        }

        // Verify that each region contains some expected text
        foldingDescriptors.forEach { descriptor ->
            val regionText = myFixture.editor.document.getText(TextRange(descriptor.range.startOffset, descriptor.range.endOffset))
            assertTrue(
                "Region should contain some content",
                regionText.contains("root") || regionText.contains("location") || regionText.contains("server")
            )
        }
    }
}
