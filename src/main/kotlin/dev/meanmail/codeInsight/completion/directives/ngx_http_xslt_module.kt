package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_xslt_module.html

val xmlEntities = Directive("xml_entities")
val xsltLastModified = ToggleDirective("xslt_last_modified", false)
val xsltParam = Directive("xslt_param")
val xsltStringParam = Directive("xslt_string_param")
val xsltStylesheet = Directive("xslt_stylesheet")
val xsltTypes = Directive(
    "xslt_types",
    defaultValue = "text/xml"
)

val ngx_http_xslt_module = Module(
    "ngx_http_xslt_module",
    enabled = false,
    directives = setOf(
        xmlEntities,
        xsltLastModified,
        xsltParam,
        xsltStringParam,
        xsltStylesheet,
        xsltTypes,
    )
)
