package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/http/ngx_http_charset_module.html

val ngx_http_charset_module = NginxModule(
    "ngx_http_charset_module",
    description = "Enables character set conversion for responses"
)

val charset = Directive(
    name = "charset",
    description = "Sets the character set for responses",
    context = listOf(http, server, location),
    module = ngx_http_charset_module
)

val charsetMap = Directive(
    name = "charset_map",
    description = "Defines a mapping between character sets",
    context = listOf(http),
    module = ngx_http_charset_module
)

val charsetTypes = Directive(
    name = "charset_types",
    description = "Specifies MIME types for which character set conversion is performed",
    context = listOf(http, server, location),
    module = ngx_http_charset_module
)

val overrideCharset = Directive(
    "override_charset",
    "Controls whether to override the client-specified character set",
        context = listOf(http, server, location),
    module = ngx_http_charset_module
)

val sourceCharset = Directive(
    name = "source_charset",
    description = "Specifies the source character set for conversion",
    context = listOf(http, server, location),
    module = ngx_http_charset_module
)
