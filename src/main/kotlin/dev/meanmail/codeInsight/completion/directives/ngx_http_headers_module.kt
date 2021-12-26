package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_headers_module.html

val addHeader = Directive("add_header")
val addTrailer = Directive("add_trailer")
val expires = Directive(
    "expires",
    defaultValue = "off"
)

val ngx_http_headers_module = Module(
    "ngx_http_headers_module",
    enabled = true,
    directives = setOf(
        addHeader,
        addTrailer,
        expires,
    )
)
