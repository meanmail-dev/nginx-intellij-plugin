package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_session_log_module.html

val sessionLog = Directive(
    "session_log",
    defaultValue = "off"
)
val sessionLogFormat = Directive(
    "session_log_format",
    defaultValue = "combined \"...\""
)
val sessionLogZone = Directive("session_log_zone")

val ngx_http_session_log_module = Module(
    "ngx_http_session_log_module",
    enabled = true,
    directives = setOf(
        sessionLog,
        sessionLogFormat,
        sessionLogZone,
    )
)
