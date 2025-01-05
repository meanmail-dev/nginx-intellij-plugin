package dev.meanmail.structure

import com.intellij.navigation.NavigationItem
import com.intellij.psi.NavigatablePsiElement
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import dev.meanmail.NginxFileType

class NginxStructureViewElementTest : BasePlatformTestCase() {

    fun testEmptyFile() {
        myFixture.configureByText(
            NginxFileType,
            ""
        )

        val element = NginxStructureViewElement(myFixture.file as NavigatablePsiElement)
        val children = element.children

        assertEquals(0, children.size)
    }

    fun testSimpleDirective() {
        myFixture.configureByText(
            NginxFileType,
            """
            worker_processes 1;
            """.trimIndent()
        )

        val element = NginxStructureViewElement(myFixture.file as NavigatablePsiElement)
        val children = element.children

        assertEquals(1, children.size)
        assertTrue(children[0] is NginxStructureViewElement)
        assertEquals("worker_processes", children[0].presentation.presentableText)
    }

    fun testNestedDirectives() {
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

        val element = NginxStructureViewElement(myFixture.file as NavigatablePsiElement)
        val children = element.children

        // Check root level
        assertEquals(1, children.size)
        assertTrue(children[0] is NginxStructureViewElement)
        assertEquals("http", children[0].presentation.presentableText)

        // Check http level
        val httpChildren = children[0].children
        assertEquals(1, httpChildren.size)
        assertTrue(httpChildren[0] is NginxStructureViewElement)
        assertEquals("server", httpChildren[0].presentation.presentableText)

        // Check server level
        val serverChildren = httpChildren[0].children
        assertEquals(2, serverChildren.size)
        assertTrue(serverChildren.all { it is NginxStructureViewElement })
        assertEquals("listen", serverChildren[0].presentation.presentableText)
        assertEquals("server_name", serverChildren[1].presentation.presentableText)
    }

    fun testLocationDirective() {
        myFixture.configureByText(
            NginxFileType,
            """
            http {
                server {
                    location / {
                        root /usr/share/nginx/html;
                        index index.html;
                    }
                }
            }
            """.trimIndent()
        )

        val element = NginxStructureViewElement(myFixture.file as NavigatablePsiElement)
        val locationElement = element.children[0].children[0].children[0]

        assertEquals("location", locationElement.presentation.presentableText)

        val locationChildren = locationElement.children
        assertEquals(2, locationChildren.size)
        assertEquals("root", locationChildren[0].presentation.presentableText)
        assertEquals("index", locationChildren[1].presentation.presentableText)
    }

    fun testIfDirective() {
        myFixture.configureByText(
            NginxFileType,
            """
            http {
                server {
                    if (${'$'}request_method = POST) {
                        return 405;
                    }
                }
            }
            """.trimIndent()
        )

        val element = NginxStructureViewElement(myFixture.file as NavigatablePsiElement)
        val ifElement = element.children[0].children[0].children[0]

        assertEquals("if", ifElement.presentation.presentableText)

        val ifChildren = ifElement.children
        assertEquals(1, ifChildren.size)
        assertEquals("return", ifChildren[0].presentation.presentableText)
    }

    fun testNavigationAndPresentation() {
        myFixture.configureByText(
            NginxFileType,
            """
            http {
                server {
                    listen 80;
                }
            }
            """.trimIndent()
        )

        val element = NginxStructureViewElement(myFixture.file as NavigatablePsiElement)
        val httpElement = element.children[0] as NginxStructureViewElement
        val serverElement = httpElement.children[0] as NginxStructureViewElement
        val listenElement = serverElement.children[0] as NginxStructureViewElement

        // Check navigation
        assertTrue((httpElement.value as NavigationItem).canNavigate())
        assertTrue((httpElement.value as NavigationItem).canNavigateToSource())

        // Check presentation
        assertEquals("http", httpElement.presentation.presentableText)
        assertEquals("server", serverElement.presentation.presentableText)
        assertEquals("listen", listenElement.presentation.presentableText)

        // Check alpha sort key
        assertEquals("http", (httpElement.value as NavigationItem).name)
        assertEquals("server", (serverElement.value as NavigationItem).name)
        assertEquals("listen", (listenElement.value as NavigationItem).name)
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

        val element = NginxStructureViewElement(myFixture.file as NavigatablePsiElement)
        val children = element.children

        // Check root level - http should still be visible
        assertEquals(1, children.size)
        assertTrue(children[0] is NginxStructureViewElement)
        assertEquals("http", children[0].presentation.presentableText)

        // Check http level - server should be visible
        val httpChildren = children[0].children
        assertEquals(1, httpChildren.size)
        assertTrue(httpChildren[0] is NginxStructureViewElement)
        assertEquals("server", httpChildren[0].presentation.presentableText)

        // Check server level - location should be visible
        val serverChildren = httpChildren[0].children
        assertEquals(1, serverChildren.size)
        assertTrue(serverChildren[0] is NginxStructureViewElement)
        assertEquals("location", serverChildren[0].presentation.presentableText)

        // Check location level - root should be visible
        val locationChildren = serverChildren[0].children
        assertEquals(1, locationChildren.size)
        assertTrue(locationChildren[0] is NginxStructureViewElement)
        assertEquals("root", locationChildren[0].presentation.presentableText)
    }
}
