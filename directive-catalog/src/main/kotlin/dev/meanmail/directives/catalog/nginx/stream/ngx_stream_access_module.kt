package dev.meanmail.directives.catalog.nginx.stream

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/stream/ngx_stream_access_module.html

val ngx_stream_access_module = NginxModule(
    name = "ngx_stream_access_module",
    description = "Comprehensive stream module for fine-grained access control based on client IP addresses, networks, and UNIX-domain sockets"
)

val streamAllow = Directive(
    name = "allow",
    description = "Allows access for specific IP addresses, networks, or UNIX-domain sockets",
    module = ngx_stream_access_module,
    context = listOf(stream, streamServer)
)

val streamDeny = Directive(
    name = "deny",
    description = "Denies access for specific IP addresses, networks, or UNIX-domain sockets",
    module = ngx_stream_access_module,
    context = listOf(stream, streamServer)
)
