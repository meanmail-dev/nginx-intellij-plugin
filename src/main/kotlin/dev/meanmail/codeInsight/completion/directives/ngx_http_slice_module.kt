package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_slice_module.html

val slice = Directive(
    "slice",
    defaultValue = "0"
)

val ngx_http_slice_module = Module(
    "ngx_http_slice_module",
    enabled = false,
    directives = setOf(
        slice,
    )
)
