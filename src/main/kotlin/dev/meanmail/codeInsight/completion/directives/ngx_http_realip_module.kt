package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_realip_module.html

val setRealIpFrom = Directive("set_real_ip_from")
val realIpHeader = Directive(
    "real_ip_header",
    defaultValue = "X-Real-IP"
)
val realIpRecursive = ToggleDirective("real_ip_recursive", false)

val ngx_http_realip_module = Module(
    "ngx_http_realip_module",
    enabled = false,
    directives = setOf(
        realIpHeader,
        realIpRecursive,
        setRealIpFrom,
    )
)
