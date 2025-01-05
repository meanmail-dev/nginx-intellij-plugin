package dev.meanmail.directives.nginx.stream

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/stream/ngx_stream_realip_module.html

val ngx_stream_realip_module = NginxModule(
    name = "ngx_stream_realip_module",
    description = "Stream module for determining the real client IP address when using proxies or load balancers",
    enabled = false
)

val streamSetRealIpFrom = Directive(
    name = "set_real_ip_from",
    description = "Defines trusted IP addresses or networks for determining the real client IP address in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            valueType = ValueType.STRING,
            description = "IP address, network range (CIDR), or 'unix:' to trust all UNIX-domain sockets",
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_realip_module
)
