package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_gzip_static_module.html

val gzipStatic = Directive(
    "gzip_static",
    setOf("on", "off", "always"),
    defaultValue = "off"
)

val ngx_http_gzip_static_module = Module(
    "ngx_http_gzip_static_module",
    enabled = false,
    directives = setOf(
        gzipStatic,
    )
)
