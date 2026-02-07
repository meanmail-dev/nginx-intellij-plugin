package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/http/ngx_http_sub_module.html

val ngx_http_sub_module = NginxModule(
    name = "ngx_http_sub_module",
    description = """
        A filter module that modifies a response by replacing one specified string by another.
        
        Features:
        - Case-insensitive string replacement
        - Support for variables in strings (since 1.9.4)
        - Multiple sub_filter directives on the same level (since 1.9.4)
        
        Note: Not built by default, requires --with-http_sub_module
    """.trimIndent()
)

val subFilter = Directive(
    name = "sub_filter",
    description = """
        Sets a string to replace and a replacement string.
        
        Features:
        - Case-insensitive matching
        - Variables support in both strings (since 1.9.4)
        - Multiple directives can be specified on same level (since 1.9.4)
        - Inherited from previous level if no directives on current level
    """.trimIndent(),
    context = listOf(http, server, location),
    module = ngx_http_sub_module
)

val subFilterLastModified = Directive(
    name = "sub_filter_last_modified",
    description = """
        Allows preserving the "Last-Modified" header field from the original response during replacement.
        
        Note: 
        - By default, the header is removed as response content is modified
        - Available since version 1.5.1
    """.trimIndent(),
        context = listOf(http, server, location),
    module = ngx_http_sub_module
)

val subFilterOnce = Directive(
    name = "sub_filter_once",
    description = """
        Indicates whether to look for each string to replace once or repeatedly.
        When 'off', replacement continues throughout the whole response.
    """.trimIndent(),
        context = listOf(http, server, location),
    module = ngx_http_sub_module
)

val subFilterTypes = Directive(
    name = "sub_filter_types",
    description = """
        Enables string replacement in responses with the specified MIME types.
        
        Notes:
        - Default type is "text/html"
        - Special value "*" matches any MIME type (since 0.8.29)
        - Multiple types can be specified
    """.trimIndent(),
    context = listOf(http, server, location),
    module = ngx_http_sub_module
)
