package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_upstream_hc_module.html

val healthCheck = Directive("health_check")
val match = Directive("match")

val ngx_http_upstream_hc_module = Module(
    "ngx_http_upstream_hc_module",
    enabled = true,
    directives = setOf(
        healthCheck,
        match,
    )
)
