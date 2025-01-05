package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/http/ngx_http_split_clients_module.html

val ngx_http_split_clients_module = NginxModule(
    name = "ngx_http_split_clients_module",
    description = "Module for creating variables suitable for A/B testing using client hash distribution",
    enabled = true
)

val splitClients = Directive(
    name = "split_clients",
    description = "Creates a variable for A/B testing by hashing a given string and distributing clients into percentage-based groups",
    parameters = listOf(
        DirectiveParameter(
            name = "string",
            description = "Original string used for hashing (e.g., \${remote_addr}AAA) to generate distribution",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "variable",
            description = "Variable name to store the distribution result, which will contain the matching group value",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http),
    module = ngx_http_split_clients_module
)
