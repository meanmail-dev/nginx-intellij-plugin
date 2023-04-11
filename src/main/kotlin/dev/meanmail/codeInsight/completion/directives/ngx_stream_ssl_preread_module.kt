package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_ssl_preread_module.html

val streamSslPreread = ToggleDirective("ssl_preread", false)

val ngx_stream_ssl_preread_module = Module(
    "ngx_stream_ssl_preread_module",
    enabled = false,
    directives = setOf(
        streamSslPreread,
    )
)
