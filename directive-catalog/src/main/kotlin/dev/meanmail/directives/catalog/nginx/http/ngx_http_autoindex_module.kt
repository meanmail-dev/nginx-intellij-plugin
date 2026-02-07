package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/http/ngx_http_autoindex_module.html

val ngx_http_autoindex_module = NginxModule(
    name = "ngx_http_autoindex_module",
    description = "Enables or disables directory listing"
)

val autoindex = Directive(
    name = "autoindex",
    description = "Enables or disables directory listing",
        context = listOf(http, server, location),
    module = ngx_http_autoindex_module
)

val autoindexExactSize = Directive(
    name = "autoindex_exact_size",
    description = "Controls whether file sizes are displayed in exact bytes or human-readable format",
        context = listOf(http, server, location),
    module = ngx_http_autoindex_module
)

val autoindexFormat = Directive(
    name = "autoindex_format",
    description = "Sets the output format for directory listing",
    context = listOf(http, server, location),
    module = ngx_http_autoindex_module
)

val autoindexLocaltime = Directive(
    name = "autoindex_localtime",
    description = "Controls whether to display file modification times in local time or UTC",
        context = listOf(http, server, location),
    module = ngx_http_autoindex_module
)
