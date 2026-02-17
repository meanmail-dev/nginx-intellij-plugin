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

    fun testProxyPassVariable() {
        doTest(true)
    }

    fun testRewriteUrlHash() {
        doTest(true)
    }

    fun testVariableQueryEquals() {
        doTest(true)
    }

    fun testVariableTrailingEquals() {
        doTest(true)
    }

    fun testLocationHashRegex() {
        doTest(true)
    }

    fun testUnquotedHash() {
        doTest(true)
    }

    fun testCommentsWithHash() {
        doTest(true)
    }

    // --- New test cases from test project ---

    fun testHttp3() {
        doTest(true)
    }

    fun testLimitExcept() {
        doTest(true)
    }

    fun testJsModule() {
        doTest(true)
    }

    fun testGeoIp2() {
        doTest(true)
    }

    fun testNumMapHttp() {
        doTest(true)
    }

    fun testNumMapStream() {
        doTest(true)
    }

    fun testTypesDirective() {
        doTest(true)
    }

    fun testIfInLocation() {
        doTest(true)
    }

    fun testReturnInIfInServer() {
        doTest(true)
    }

    fun testListenAdvanced() {
        doTest(true)
    }

    fun testTunnelModule() {
        doTest(true)
    }

    fun testEnvVariables() {
        doTest(true)
    }

    fun testErrorPageUrl() {
        doTest(true)
    }

    fun testSetVariable() {
        doTest(true)
    }

    fun testProxyConfig() {
        doTest(true)
    }

    fun testOpenCache() {
        doTest(true)
    }

    fun testRecentBugfixes() {
        doTest(true)
    }

    // --- Lua directive tests ---

    fun testLuaDirectives() {
        doTest(true)
    }

    fun testLuaSharedDict() {
        doTest(true)
    }

    fun testLuaSslConfCommand() {
        doTest(true)
    }

    fun testContentByLua() {
        doTest(true)
    }

    fun testContentByLuaBlock() {
        doTest(true)
    }

    fun testContentByLuaFile() {
        doTest(true)
    }

    fun testAccessByLua() {
        doTest(true)
    }

    fun testAccessByLuaBlock() {
        doTest(true)
    }

    fun testRewriteByLua() {
        doTest(true)
    }

    fun testRewriteByLuaBlock() {
        doTest(true)
    }

    fun testHeaderFilterByLua() {
        doTest(true)
    }

    fun testHeaderFilterByLuaBlock() {
        doTest(true)
    }

    fun testBodyFilterByLua() {
        doTest(true)
    }

    fun testBodyFilterByLuaBlock() {
        doTest(true)
    }

    fun testLogByLua() {
        doTest(true)
    }

    fun testLogByLuaBlock() {
        doTest(true)
    }

    fun testSetByLua() {
        doTest(true)
    }

    fun testSetByLuaBlockDirective() {
        doTest(true)
    }

    fun testInitWorkerByLuaBlock() {
        doTest(true)
    }

    fun testExitWorkerByLuaBlock() {
        doTest(true)
    }

    fun testBalancerByLuaBlock() {
        doTest(true)
    }

    fun testServerRewriteByLuaBlock() {
        doTest(true)
    }

    fun testSslCertificateByLuaBlock() {
        doTest(true)
    }

    fun testSslClientHelloByLuaBlock() {
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
