package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_auth_basic_module.html

val authBasic = Directive("auth_basic")
val authBasicUserFile = Directive("auth_basic_user_file")

val ngx_http_auth_basic_module = Module(
    "ngx_http_auth_basic_module",
    enabled = true,
    directives = setOf(
        authBasic,
        authBasicUserFile,
    )
)
