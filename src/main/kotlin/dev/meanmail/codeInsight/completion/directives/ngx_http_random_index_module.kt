package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_random_index_module.html

val randomIndex = ToggleDirective("random_index", false)

val ngx_http_random_index_module = Module(
    "ngx_http_random_index_module",
    enabled = false,
    directives = setOf(
        randomIndex,
    )
)
