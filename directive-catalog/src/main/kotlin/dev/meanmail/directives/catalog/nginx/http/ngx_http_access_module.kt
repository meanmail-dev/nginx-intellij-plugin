package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_access_module.html

val ngx_http_access_module = NginxModule(
    name = "ngx_http_access_module",
    description = "Permits or denies access based on IP addresses or networks"
)

val allow = Directive(
    "allow",
    description = "Allows access for specified IP addresses or networks",
    context = listOf(http, server, location, limitExcept),
    module = ngx_http_access_module
)

val deny = Directive(
    "deny",
    description = "Denies access for specified IP addresses or networks",
    context = listOf(http, server, location, limitExcept),
    module = ngx_http_access_module
)
