package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_gzip_module.html

val gzip = ToggleDirective("gzip", false)
val gzipBuffers = Directive("gzip_buffers")
val gzipCompLevel = Directive(
    "gzip_comp_level",
    defaultValue = "1"
)
val gzipDisable = Directive("gzip_disable")
val gzipHttpVersion = Directive(
    "gzip_http_version",
    defaultValue = "1.1"
)
val gzipMinLength = Directive(
    "gzip_min_length",
    defaultValue = "20"
)
val gzipProxied = Directive(
    "gzip_proxied",
    defaultValue = "off"
)
val gzipTypes = Directive(
    "gzip_types",
    defaultValue = "text/html"
)
val gzipVary = ToggleDirective("gzip_vary", false)

val ngx_http_gzip_module = Module(
    "ngx_http_gzip_module",
    enabled = true,
    directives = setOf(
        gzip,
        gzipBuffers,
        gzipCompLevel,
        gzipDisable,
        gzipHttpVersion,
        gzipMinLength,
        gzipProxied,
        gzipTypes,
        gzipVary,
    )
)
