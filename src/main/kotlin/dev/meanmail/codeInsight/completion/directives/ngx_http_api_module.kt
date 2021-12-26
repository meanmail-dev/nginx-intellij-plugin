package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_api_module.html

val api = Directive("api")
val statusZone = Directive("status_zone")

val ngx_http_api_module = Module(
    "ngx_http_api_module",
    enabled = true,
    directives = setOf(
        api,
        statusZone,
    )
)
