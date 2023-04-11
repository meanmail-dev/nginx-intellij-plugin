package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_gunzip_module.html

val gunzip = ToggleDirective("gunzip", false)
val gunzipBuffers = Directive("gunzip_buffers")

val ngx_http_gunzip_module = Module(
    "ngx_http_gunzip_module",
    enabled = false,
    directives = setOf(
        gunzip,
        gunzipBuffers,
    )
)
