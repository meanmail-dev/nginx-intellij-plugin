package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_log_module.html

val accessLog = Directive(
    "access_log",
    defaultValue = "logs/access.log combined"
)
val logFormat = Directive(
    "log_format",
    defaultValue = "combined \"...\""
)
val openLogFileCache = Directive(
    "open_log_file_cache",
    defaultValue = "off"
)

val ngx_http_log_module = Module(
    "ngx_http_log_module",
    enabled = true,
    directives = setOf(
        accessLog,
        logFormat,
        openLogFileCache,
    )
)
