package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_auth_request_module.html

val authRequest = Directive(
    "auth_request",
    defaultValue = "off"
)
val authRequestSet = Directive("auth_request_set")

val ngx_http_auth_request_module = Module(
    "ngx_http_auth_request_module",
    enabled = false,
    directives = setOf(
        authRequest,
        authRequestSet,
    )
)
