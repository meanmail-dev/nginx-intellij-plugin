package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_empty_gif_module.html

val emptyGif = Directive("empty_gif")

val ngx_http_empty_gif_module = Module(
    "ngx_http_empty_gif_module",
    enabled = true,
    directives = setOf(
        emptyGif,
    )
)
