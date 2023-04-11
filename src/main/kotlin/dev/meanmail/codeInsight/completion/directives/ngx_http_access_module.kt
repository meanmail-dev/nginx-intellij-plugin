package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_access_module.html

val allow = Directive("allow")
val deny = Directive("deny")

val ngx_http_access_module = Module(
    "ngx_http_access_module",
    enabled = true,
    directives = setOf(
        allow,
        deny,
    )
)
