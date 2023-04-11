package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_split_clients_module.html

val splitClients = Directive("split_clients")

val ngx_http_split_clients_module = Module(
    "ngx_http_split_clients_module",
    enabled = true,
    directives = setOf(
        splitClients,
    )
)
