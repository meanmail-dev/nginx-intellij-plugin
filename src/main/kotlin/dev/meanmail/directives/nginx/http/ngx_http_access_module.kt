package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/http/ngx_http_access_module.html

val ngx_http_access_module = NginxModule(
    name = "ngx_http_access_module",
    description = "Permits or denies access based on IP addresses or networks",
    enabled = true
)

val allow = Directive(
    "allow",
    description = "Allows access for specified IP addresses or networks",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            description = "IP address, network, or special value (all, unix:)",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_access_module
)

val deny = Directive(
    "deny",
    description = "Denies access for specified IP addresses or networks",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            description = "IP address, network, or special value (all, unix:)",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_access_module
)
