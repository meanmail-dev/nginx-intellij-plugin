package dev.meanmail.directives.nginx.stream

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/stream/ngx_stream_split_clients_module.html

val ngx_stream_split_clients_module = NginxModule(
    name = "ngx_stream_split_clients_module",
    description = "Stream module for distributing client connections across multiple backend servers using percentage-based or weighted algorithms",
    enabled = true
)

val streamSplitClients = Directive(
    name = "split_clients",
    description = "Creates a variable for A/B testing by hashing the input string and distributing clients across different groups",
    parameters = listOf(
        DirectiveParameter(
            name = "string",
            valueType = ValueType.STRING,
            description = "Input string to be hashed for client distribution (e.g., \${remote_addr}AAA)",
        ),
        DirectiveParameter(
            name = "variable",
            valueType = ValueType.STRING,
            description = "Variable to store the result of client distribution",
        )
    ),
    context = listOf(stream),
    module = ngx_stream_split_clients_module
)
