package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_return_module.html

val streamReturn = Directive("return")

val ngx_stream_return_module = Module(
    "ngx_stream_return_module",
    enabled = true,
    directives = setOf(
        streamReturn,
    )
)
