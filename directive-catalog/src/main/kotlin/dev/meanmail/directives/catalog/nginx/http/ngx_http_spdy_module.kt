package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_spdy_module.html
// Note: This module was superseded by ngx_http_v2_module in 1.9.5

val ngx_http_spdy_module = NginxModule(
    name = "ngx_http_spdy_module",
    description = "DEPRECATED: SPDY module superseded by HTTP/2 module (ngx_http_v2_module)"
)

val spdyChunkSize = Directive(
    name = "spdy_chunk_size",
    description = "Sets the size of chunks for SPDY responses (DEPRECATED)",
    context = listOf(http, server),
    module = ngx_http_spdy_module
)

val spdyHeadersComp = Directive(
    name = "spdy_headers_comp",
    description = "Sets the compression level for SPDY headers (DEPRECATED)",
    context = listOf(http, server),
    module = ngx_http_spdy_module
)
