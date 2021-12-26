package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_limit_conn_module.html

val streamLimitConn = Directive("limit_conn")
val streamLimitConnDryRun = ToggleDirective("limit_conn_dry_run", false)
val streamLimitConnLogLevel = Directive(
    "limit_conn_log_level",
    defaultValue = "error"
)
val streamLimitConnZone = Directive("limit_conn_zone")

val ngx_stream_limit_conn_module = Module(
    "ngx_stream_limit_conn_module",
    enabled = true,
    directives = setOf(
        streamLimitConn,
        streamLimitConnDryRun,
        streamLimitConnLogLevel,
        streamLimitConnZone,
    )
)
