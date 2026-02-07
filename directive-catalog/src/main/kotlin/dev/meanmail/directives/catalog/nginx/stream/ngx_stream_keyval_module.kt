package dev.meanmail.directives.catalog.nginx.stream

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/stream/ngx_stream_keyval_module.html

val ngx_stream_keyval_module = NginxModule(
    name = "ngx_stream_keyval_module",
    description = "Advanced stream module for dynamic key-value storage and lookup, enabling flexible runtime configuration, data sharing, and conditional processing"
)

val streamKeyval = Directive(
    name = "keyval",
    description = "Creates a variable whose value is looked up by the key in the key-value database",
    context = listOf(stream),
    module = ngx_stream_keyval_module
)

val streamKeyvalZone = Directive(
    name = "keyval_zone",
    description = "Sets the name, size, and configuration of the shared memory zone for key-value database",
    context = listOf(stream),
    module = ngx_stream_keyval_module
)
