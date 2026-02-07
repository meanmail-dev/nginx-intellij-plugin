package dev.meanmail.directives.catalog.nginx.stream

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/stream/ngx_stream_split_clients_module.html

val ngx_stream_split_clients_module = NginxModule(
    name = "ngx_stream_split_clients_module",
    description = "Stream module for distributing client connections across multiple backend servers using percentage-based or weighted algorithms"
)

val streamSplitClients = Directive(
    name = "split_clients",
    description = "Creates a variable for A/B testing by hashing the input string and distributing clients across different groups",
    context = listOf(stream),
    module = ngx_stream_split_clients_module
)
