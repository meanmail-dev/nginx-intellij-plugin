package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_limit_conn_module.html

val limitConn = Directive("limit_conn")
val limitConnDryRun = ToggleDirective("limit_conn_dry_run", false)
val limitConnLogLevel = Directive(
    "limit_conn_log_level",
    setOf("info", "notice", "warn", "error"),
    defaultValue = "error"
)
val limitConnStatus = Directive(
    "limit_conn_status",
    defaultValue = "503"
)
val limitConnZone = Directive("limit_conn_zone")
val limitZone = Directive("limit_zone")

val ngx_http_limit_conn_module = Module(
    "ngx_http_limit_conn_module",
    enabled = true,
    directives = setOf(
        limitConn,
        limitConnDryRun,
        limitConnLogLevel,
        limitConnStatus,
        limitConnZone,
        limitZone,
    )
)
