package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_index_module.html

val index = Directive(
    "index",
    defaultValue = "index.html"
)

val ngx_http_index_module = Module(
    "ngx_http_index_module",
    enabled = true,
    directives = setOf(
        index,
    )
)
