package dev.meanmail.directives.catalog.nginx.stream

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/stream/ngx_stream_return_module.html

val ngx_stream_return_module = NginxModule(
    name = "ngx_stream_return_module",
    description = "A module to return the specified value in response to a stream request"
)

val streamReturn = Directive(
    name = "return",
    description = "Sends a specified value to the client and closes the connection",
    context = listOf(streamServer),
    module = ngx_stream_return_module
)
