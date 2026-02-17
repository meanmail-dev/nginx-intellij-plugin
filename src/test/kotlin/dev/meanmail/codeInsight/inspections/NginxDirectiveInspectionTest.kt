package dev.meanmail.codeInsight.inspections

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class NginxDirectiveInspectionTest : BasePlatformTestCase() {
    override fun getTestDataPath(): String {
        return "src/test/resources/dev/meanmail/inspections/directive"
    }

    private fun doTest(testName: String) {
        myFixture.enableInspections(NginxDirectiveInspection())
        myFixture.configureByFile(testName)
        myFixture.checkHighlighting(true, false, true)
    }

    fun testSelfContextLocation() {
        doTest("selfContextLocation.nginx")
    }

    fun testFileContextServer() {
        doTest("fileContextServer.nginx")
    }

    fun testFileContextMismatch() {
        doTest("fileContextMismatch.nginx")
    }

    fun testFileContextNotDetermined() {
        doTest("fileContextNotDetermined.nginx")
    }

    fun testUnknownDirective() {
        doTest("unknownDirective.nginx")
    }

    fun testDirectiveInCorrectParent() {
        doTest("directiveInCorrectParent.nginx")
    }

    fun testDirectiveInWrongParent() {
        doTest("directiveInWrongParent.nginx")
    }

    fun testFileContextLocationWithIf() {
        doTest("fileContextLocationWithIf.nginx")
    }
}
