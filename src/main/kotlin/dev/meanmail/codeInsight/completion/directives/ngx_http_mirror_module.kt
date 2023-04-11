package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_mirror_module.html

val mirror = Directive(
    "mirror",
    defaultValue = "off"
)
val mirrorRequestBody = ToggleDirective("mirror_request_body", true)

val ngx_http_mirror_module = Module(
    "ngx_http_mirror_module",
    enabled = true,
    directives = setOf(
        mirror,
        mirrorRequestBody,
    )
)
