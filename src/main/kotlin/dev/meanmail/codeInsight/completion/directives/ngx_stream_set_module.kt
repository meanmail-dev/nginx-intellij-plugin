package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_set_module.html

val streamSet = Directive("set")

val ngx_stream_set_module = Module(
    "ngx_stream_set_module",
    enabled = true,
    directives = setOf(
        streamSet,
    )
)
