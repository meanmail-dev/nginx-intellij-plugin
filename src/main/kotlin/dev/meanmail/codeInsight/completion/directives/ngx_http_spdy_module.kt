package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_spdy_module.html
// Note: This module was superseded by ngx_http_v2_module in 1.9.5

val ngx_http_spdy_module = NginxModule(
    name = "ngx_http_spdy_module",
    description = "DEPRECATED: SPDY module superseded by HTTP/2 module (ngx_http_v2_module)",
    enabled = false
)

val spdyChunkSize = Directive(
    name = "spdy_chunk_size",
    description = "Sets the size of chunks for SPDY responses (DEPRECATED)",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Size of chunks in bytes (DEPRECATED)",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "8k"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_spdy_module
)

val spdyHeadersComp = Directive(
    name = "spdy_headers_comp",
    description = "Sets the compression level for SPDY headers (DEPRECATED)",
    parameters = listOf(
        DirectiveParameter(
            name = "level",
            description = "Compression level (0-9) (DEPRECATED)",
            valueType = ValueType.NUMBER,
            required = false,
            defaultValue = "0"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_spdy_module
)
