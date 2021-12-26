package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_keyval_module.html

val keyval = Directive("keyval")
val keyvalZone = Directive("keyval_zone")

val ngx_http_keyval_module = Module(
    "ngx_http_keyval_module",
    enabled = true,
    directives = setOf(
        keyval,
        keyvalZone,
    )
)
