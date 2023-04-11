package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_flv_module.html

val flv = Directive("flv")

val ngx_http_flv_module = Module(
    "ngx_http_flv_module",
    enabled = false,
    directives = setOf(
        flv,
    )
)
