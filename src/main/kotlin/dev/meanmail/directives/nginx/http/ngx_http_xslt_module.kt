package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.*

// https://nginx.org/en/docs/http/ngx_http_xslt_module.html

val ngx_http_xslt_module = NginxModule(
    "ngx_http_xslt_module",
    description = "A filter that transforms XML responses using one or more XSLT stylesheets. Requires libxml2 and libxslt libraries. Not built by default, must be enabled with --with-http_xslt_module configuration parameter.",
    enabled = false
)

val xmlEntities = Directive(
    name = "xml_entities",
    description = "Specifies the DTD file that declares character entities. Compiled at configuration stage. Used instead of external XML subset for technical reasons.",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to DTD file declaring character entities",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_xslt_module
)

val xsltLastModified = ToggleDirective(
    name = "xslt_last_modified",
    description = "Allows preserving the 'Last-Modified' header during XSLT transformations to facilitate response caching.",
    context = listOf(http, server, location),
    enabled = false,
    module = ngx_http_xslt_module
)

val xsltParam = Directive(
    name = "xslt_param",
    description = "Defines parameters for XSLT stylesheets. Value is treated as an XPath expression and can contain variables.",
    parameters = listOf(
        DirectiveParameter(
            name = "parameter",
            description = "XSLT parameter name",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "value",
            description = "XSLT parameter value as XPath expression",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_xslt_module
)

val xsltStringParam = Directive(
    name = "xslt_string_param",
    description = "Defines string parameters for XSLT stylesheets. XPath expressions in the value are not interpreted.",
    parameters = listOf(
        DirectiveParameter(
            name = "parameter",
            description = "XSLT string parameter name",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "value",
            description = "XSLT string parameter value",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_xslt_module
)

val xsltStylesheet = Directive(
    name = "xslt_stylesheet",
    description = "Defines XSLT stylesheet and optional parameters. Stylesheet is compiled at configuration stage. Multiple stylesheets can be applied sequentially.",
    parameters = listOf(
        DirectiveParameter(
            name = "stylesheet",
            description = "Path to XSLT stylesheet",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "parameters",
            description = "Optional stylesheet parameters. Can use ':' delimiter. Escape ':' as '%3A'.",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(location),
    module = ngx_http_xslt_module
)

val xsltTypes = Directive(
    name = "xslt_types",
    description = "Enables transformations for specified MIME types. Special value '*' matches any MIME type. HTML responses changed to 'text/html'.",
    parameters = listOf(
        DirectiveParameter(
            name = "mime_type",
            description = "MIME type for XSLT processing",
            valueType = ValueType.STRING,
            required = true,
            defaultValue = "text/xml"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_xslt_module
)
