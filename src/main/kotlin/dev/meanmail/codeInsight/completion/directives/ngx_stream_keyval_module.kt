package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_keyval_module.html

val streamKeyval = Directive("keyval")
val streamKeyvalZone = Directive("keyval_zone")

val ngx_stream_keyval_module = Module(
    "ngx_stream_keyval_module",
    enabled = true,
    directives = setOf(
        streamKeyval,
        streamKeyvalZone,
    )
)
