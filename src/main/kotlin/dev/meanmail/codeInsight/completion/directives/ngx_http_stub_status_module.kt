package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_stub_status_module.html

val stubStatus = Directive("stub_status")

val ngx_http_stub_status_module = Module(
    "ngx_http_stub_status_module",
    enabled = false,
    directives = setOf(
        stubStatus,
    )
)
