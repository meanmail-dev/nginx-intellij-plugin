package dev.meanmail.directives.catalog.nginx.stream

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/stream/ngx_stream_set_module.html

val ngx_stream_set_module = NginxModule(
    name = "ngx_stream_set_module",
    description = "Stream module for dynamically setting variables in Nginx stream processing"
)

val streamSet = Directive(
    name = "set",
    description = "Sets a value of a variable in stream context",
    context = listOf(stream, streamServer),
    module = ngx_stream_set_module
)
