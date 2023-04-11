package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_geo_module.html

val geo = Directive("geo")

val ngx_http_geo_module = Module(
    "ngx_http_geo_module",
    enabled = true,
    directives = setOf(
        geo,
    )
)
