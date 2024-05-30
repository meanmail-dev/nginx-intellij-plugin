package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_pass_module.html

val streamPass = Directive(
    "pass",
)

val ngx_stream_pass_module = Module(
    "ngx_stream_pass_module",
    enabled = false,
    directives = setOf(
        streamPass,
    )
)
