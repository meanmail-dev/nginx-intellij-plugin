package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_spdy_module.html

val spdyChunkSize = Directive(
    "spdy_chunk_size",
    defaultValue = "8k"
)
val spdyHeadersComp = Directive(
    "spdy_headers_comp",
    defaultValue = "0"
)

val ngx_http_spdy_module = Module(
    "ngx_http_spdy_module",
    enabled = false,
    directives = setOf(
        spdyChunkSize,
        spdyHeadersComp,
    )
)
