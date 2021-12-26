package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_limit_req_module.html

val limitReq = Directive("limit_req")
val limitReqDryRun = ToggleDirective("limit_req_dry_run", false)
val limitReqLogLevel = Directive(
    "limit_req_log_level",
    setOf("info", "notice", "warn", "error"),
    defaultValue = "error"
)
val limitReqStatus = Directive(
    "limit_req_status",
    defaultValue = "503"
)
val limitReqZone = Directive("limit_req_zone")

val ngx_http_limit_req_module = Module(
    "ngx_http_limit_req_module",
    enabled = true,
    directives = setOf(
        limitReq,
        limitReqDryRun,
        limitReqLogLevel,
        limitReqStatus,
        limitReqZone,
    )
)
