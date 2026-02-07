package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/http/ngx_http_realip_module.html

val ngx_http_realip_module = NginxModule(
    "ngx_http_realip_module",
    description = "Provides a way to obtain the client's IP address from a proxy or a load balancer"
)

val setRealIpFrom = Directive(
    name = "set_real_ip_from",
    description = "Defines a network or IP address from which the real client IP should be obtained",
    context = listOf(http, server, location),
    module = ngx_http_realip_module
)

val realIpHeader = Directive(
    name = "real_ip_header",
    description = "Specifies the header field used to obtain the real client IP address",
    context = listOf(http, server, location),
    module = ngx_http_realip_module
)

val realIpRecursive = Directive(
    name = "real_ip_recursive",
    description = "Enables recursive search for the real client IP when multiple proxy servers are involved",
    context = listOf(http, server, location),
    module = ngx_http_realip_module
)
