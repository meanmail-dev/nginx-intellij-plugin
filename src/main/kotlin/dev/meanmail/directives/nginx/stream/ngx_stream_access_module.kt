package dev.meanmail.directives.nginx.stream

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/stream/ngx_stream_access_module.html

val ngx_stream_access_module = NginxModule(
    name = "ngx_stream_access_module",
    description = "Comprehensive stream module for fine-grained access control based on client IP addresses, networks, and UNIX-domain sockets",
    enabled = true
)

val streamAllow = Directive(
    name = "allow",
    description = "Allows access for specific IP addresses, networks, or UNIX-domain sockets",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            description = "IP address, network range, or UNIX-domain socket",
            valueType = ValueType.STRING
        ),
        DirectiveParameter(
            name = "type",
            description = "Optional type of address (CIDR notation, IPv4/IPv6)",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    module = ngx_stream_access_module,
    context = listOf(stream, streamServer)
)

val streamDeny = Directive(
    name = "deny",
    description = "Denies access for specific IP addresses, networks, or UNIX-domain sockets",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            description = "IP address, network range, or UNIX-domain socket",
            valueType = ValueType.STRING
        ),
        DirectiveParameter(
            name = "type",
            description = "Optional type of address (CIDR notation, IPv4/IPv6)",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    module = ngx_stream_access_module,
    context = listOf(stream, streamServer)
)
