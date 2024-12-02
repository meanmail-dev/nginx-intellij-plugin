package dev.meanmail.codeInsight.inspections

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class NginxIfInspectionTest : BasePlatformTestCase() {
    override fun getTestDataPath(): String {
        return "src/test/resources/dev/meanmail/inspections/if"
    }

    private fun doTest(testName: String) {
        myFixture.configureByFile(testName)
        myFixture.checkHighlighting(true, false, true)
    }

    fun testIfWithEqual() {
        doTest("ifWithEqual.nginx")
    }

    fun testIfWithNotEqual() {
        doTest("ifWithNotEqual.nginx")
    }

    fun testIfWithRegex() {
        doTest("ifWithRegex.nginx")
    }

    fun testIfWithFile() {
        doTest("ifWithFile.nginx")
    }
}
