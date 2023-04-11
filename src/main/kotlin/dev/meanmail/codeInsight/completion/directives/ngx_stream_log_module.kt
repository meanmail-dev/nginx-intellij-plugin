package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_log_module.html

val streamAccessLog = Directive(
    "access_log",
    defaultValue = "off"
)
val streamLogFormat = Directive("log_format")
val streamOpenLogFileCache = Directive(
    "open_log_file_cache",
    defaultValue = "off"
)

val ngx_stream_log_module = Module(
    "ngx_stream_log_module",
    enabled = true,
    directives = setOf(
        streamAccessLog,
        streamLogFormat,
        streamOpenLogFileCache,
    )
)
