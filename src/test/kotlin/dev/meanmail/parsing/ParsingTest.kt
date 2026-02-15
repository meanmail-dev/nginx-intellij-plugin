package dev.meanmail.parsing

import com.intellij.testFramework.ParsingTestCase
import dev.meanmail.NginxParserDefinition

class ParsingTest : ParsingTestCase(
    "testData", "nginx.conf",
    NginxParserDefinition()
) {
    fun testSample() {
        doTest(true)
    }

    fun testSample2() {
        doTest(true)
    }

    fun testLua() {
        doTest(true)
    }

    fun testNestedLocation() {
        doTest(true)
    }

    fun testUpstream() {
        doTest(true)
    }

    fun testLocation() {
        doTest(true)
    }

    fun testSSL() {
        doTest(true)
    }

    fun testLogging() {
        doTest(true)
    }

    fun testRateLimiting() {
        doTest(true)
    }

    fun testUpstream_1_27_3() {
        doTest(true)
    }

    fun testSetByLuaBlock() {
        doTest(true)
    }

    fun testGeoDirective() {
        doTest(true)
    }

    fun testIfRegexNestedParens() {
        doTest(true)
    }

    fun testErrorPage() {
        doTest(true)
    }

    fun testTryFiles() {
        doTest(true)
    }

    fun testMapEqualsValue() {
        doTest(true)
    }

    fun testIfEscapedParens() {
        doTest(true)
    }

    override fun getTestDataPath(): String {
        return "src/test/resources/" +
                this.javaClass.packageName.replace(".", "/")
    }

    override fun skipSpaces(): Boolean {
        return false
    }

    override fun includeRanges(): Boolean {
        return true
    }
}
