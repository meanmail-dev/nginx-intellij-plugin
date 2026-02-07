package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_headers_module.html

val ngx_http_headers_module = NginxModule(
    name = "ngx_http_headers_module",
    description = "HTTP headers module for adding custom headers and controlling response caching"
)

val addHeader = Directive(
    name = "add_header",
    description = "Adds custom HTTP headers to responses. Allows dynamically inserting additional headers to HTTP responses.",
    context = listOf(http, server, location, locationIf),
    module = ngx_http_headers_module
)

val addTrailer = Directive(
    name = "add_trailer",
    description = "Adds custom HTTP trailers to responses. Allows appending additional metadata at the end of HTTP responses.",
    context = listOf(http, server, location, locationIf),
    module = ngx_http_headers_module
)

val expires = Directive(
    name = "expires",
    description = "Controls the Expires and Cache-Control headers for responses. Manages caching behavior and content expiration.",
    context = listOf(http, server, location, locationIf),
    module = ngx_http_headers_module
)

val addHeaderInherit = Directive(
    name = "add_header_inherit",
    description = "Allows altering inheritance rules for add_header directives",
    context = listOf(http, server, location, locationIf),
    module = ngx_http_headers_module
)

val addTrailerInherit = Directive(
    name = "add_trailer_inherit",
    description = "Allows altering inheritance rules for add_trailer directives",
    context = listOf(http, server, location, locationIf),
    module = ngx_http_headers_module
)
