package dev.meanmail.parsing

import com.intellij.testFramework.ParsingTestCase
import dev.meanmail.NginxParserDefinition

class ParsingTest : ParsingTestCase("testData", "nginx.conf",
        NginxParserDefinition()) {
    fun testSample() {
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
