package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/http/ngx_http_xslt_module.html

val ngx_http_xslt_module = NginxModule(
    "ngx_http_xslt_module",
    description = "A filter that transforms XML responses using one or more XSLT stylesheets. Requires libxml2 and libxslt libraries. Not built by default, must be enabled with --with-http_xslt_module configuration parameter."
)

val xmlEntities = Directive(
    name = "xml_entities",
    description = "Specifies the DTD file that declares character entities. Compiled at configuration stage. Used instead of external XML subset for technical reasons.",
    context = listOf(http, server, location),
    module = ngx_http_xslt_module
)

val xsltLastModified = Directive(
    name = "xslt_last_modified",
    description = "Allows preserving the 'Last-Modified' header during XSLT transformations to facilitate response caching.",
    context = listOf(http, server, location),
        module = ngx_http_xslt_module
)

val xsltParam = Directive(
    name = "xslt_param",
    description = "Defines parameters for XSLT stylesheets. Value is treated as an XPath expression and can contain variables.",
    context = listOf(http, server, location),
    module = ngx_http_xslt_module
)

val xsltStringParam = Directive(
    name = "xslt_string_param",
    description = "Defines string parameters for XSLT stylesheets. XPath expressions in the value are not interpreted.",
    context = listOf(http, server, location),
    module = ngx_http_xslt_module
)

val xsltStylesheet = Directive(
    name = "xslt_stylesheet",
    description = "Defines XSLT stylesheet and optional parameters. Stylesheet is compiled at configuration stage. Multiple stylesheets can be applied sequentially.",
    context = listOf(location),
    module = ngx_http_xslt_module
)

val xsltTypes = Directive(
    name = "xslt_types",
    description = "Enables transformations for specified MIME types. Special value '*' matches any MIME type. HTML responses changed to 'text/html'.",
    context = listOf(http, server, location),
    module = ngx_http_xslt_module
)
