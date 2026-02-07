package dev.meanmail.directives.catalog.nginx.stream

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/stream/ngx_stream_realip_module.html

val ngx_stream_realip_module = NginxModule(
    name = "ngx_stream_realip_module",
    description = "Stream module for determining the real client IP address when using proxies or load balancers"
)

val streamSetRealIpFrom = Directive(
    name = "set_real_ip_from",
    description = "Defines trusted IP addresses or networks for determining the real client IP address in stream context",
    context = listOf(stream, streamServer),
    module = ngx_stream_realip_module
)
