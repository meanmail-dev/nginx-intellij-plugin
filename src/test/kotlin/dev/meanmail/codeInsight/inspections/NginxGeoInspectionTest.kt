package dev.meanmail.codeInsight.inspections

import com.intellij.testFramework.fixtures.BasePlatformTestCase

class NginxGeoInspectionTest : BasePlatformTestCase() {
    override fun getTestDataPath(): String {
        return "src/test/resources/dev/meanmail/inspections/geo"
    }

    private fun doTest(testName: String) {
        myFixture.enableInspections(NginxGeoInspection())
        myFixture.configureByFile(testName)
        myFixture.checkHighlighting(true, false, true)
    }

    fun testGeoOutsideContext() {
        doTest("geoOutsideContext.nginx")
    }

    fun testHttpGeoWithProxy() {
        doTest("httpGeoWithProxy.nginx")
    }

    fun testStreamGeoWithProxy() {
        doTest("streamGeoWithProxy.nginx")
    }

    fun testGeoWithDelete() {
        doTest("geoWithDelete.nginx")
    }

    fun testStreamGeoWithDelete() {
        doTest("streamGeoWithDelete.nginx")
    }

    fun testGeoWithoutDefault() {
        doTest("geoWithoutDefault.nginx")
    }

    fun testGeoWithRangesInStream() {
        doTest("geoWithRangesInStream.nginx")
    }

    fun testGeoWithInclude() {
        doTest("geoWithInclude.nginx")
    }

    fun testGeoWithSingleVariable() {
        doTest("geoWithSingleVariable.nginx")
    }
}
