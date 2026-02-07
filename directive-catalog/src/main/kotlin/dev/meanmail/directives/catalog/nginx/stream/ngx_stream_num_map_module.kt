package dev.meanmail.directives.catalog.nginx.stream

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/stream/ngx_stream_num_map_module.html

val ngx_stream_num_map_module = NginxModule(
    "ngx_stream_num_map_module",
    description = "Creates variables whose values depend on numeric values or ranges of other variables"
)

val streamNumMap = Directive(
    name = "num_map",
    description = "Describes how variable values depend on numeric values or numeric value ranges",
    context = listOf(stream),
    module = ngx_stream_num_map_module
)
