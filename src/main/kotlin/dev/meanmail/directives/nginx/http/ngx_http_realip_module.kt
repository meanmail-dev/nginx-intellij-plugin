package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.*

// https://nginx.org/en/docs/http/ngx_http_realip_module.html

val ngx_http_realip_module = NginxModule(
    "ngx_http_realip_module",
    description = "Provides a way to obtain the client's IP address from a proxy or a load balancer",
    enabled = false
)

val setRealIpFrom = Directive(
    name = "set_real_ip_from",
    description = "Defines a network or IP address from which the real client IP should be obtained",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            description = "IP address or CIDR range of trusted proxy or load balancer",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_realip_module
)

val realIpHeader = Directive(
    name = "real_ip_header",
    description = "Specifies the header field used to obtain the real client IP address",
    parameters = listOf(
        DirectiveParameter(
            name = "header",
            description = "Name of the header containing the real client IP (e.g., X-Forwarded-For, X-Real-IP)",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_realip_module
)

val realIpRecursive = ToggleDirective(
    name = "real_ip_recursive",
    description = "Enables recursive search for the real client IP when multiple proxy servers are involved",
    context = listOf(http, server, location),
    module = ngx_http_realip_module,
    enabled = false
)
