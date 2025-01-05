package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.*

// https://nginx.org/en/docs/http/ngx_http_charset_module.html

val ngx_http_charset_module = NginxModule(
    "ngx_http_charset_module",
    description = "Enables character set conversion for responses",
    enabled = true
)

val charset = Directive(
    name = "charset",
    description = "Sets the character set for responses",
    parameters = listOf(
        DirectiveParameter(
            name = "charset_name",
            description = "Character set to be used for responses",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "utf-8"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_charset_module
)

val charsetMap = Directive(
    name = "charset_map",
    description = "Defines a mapping between character sets",
    parameters = listOf(
        DirectiveParameter(
            name = "source_charset",
            description = "Source character set",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "destination_charset",
            description = "Destination character set",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http),
    module = ngx_http_charset_module
)

val charsetTypes = Directive(
    name = "charset_types",
    description = "Specifies MIME types for which character set conversion is performed",
    parameters = listOf(
        DirectiveParameter(
            name = "mime_types",
            description = "List of MIME types for character set conversion",
            valueType = ValueType.LIST,
            allowedValues = listOf("application/javascript", "application/rss+xml"),
            required = false,
            defaultValue = "text/html text/css text/xml text/plain"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_charset_module
)

val overrideCharset = ToggleDirective(
    "override_charset",
    "Controls whether to override the client-specified character set",
    enabled = false,
    context = listOf(http, server, location),
    module = ngx_http_charset_module
)

val sourceCharset = Directive(
    name = "source_charset",
    description = "Specifies the source character set for conversion",
    parameters = listOf(
        DirectiveParameter(
            name = "charset_name",
            description = "Source character set for content conversion",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_charset_module
)
