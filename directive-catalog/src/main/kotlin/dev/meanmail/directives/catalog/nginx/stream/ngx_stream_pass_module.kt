package dev.meanmail.directives.catalog.nginx.stream

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/stream/ngx_stream_pass_module.html

val ngx_stream_pass_module = NginxModule(
    name = "ngx_stream_pass_module",
    description = "Provides routing and proxying functionality for TCP/UDP stream connections to backend servers"
)

val streamPass = Directive(
    "pass",
    description = "Redirects the incoming stream connection to a specified backend server or server group",
    context = listOf(stream, streamServer),
    module = ngx_stream_pass_module
)
