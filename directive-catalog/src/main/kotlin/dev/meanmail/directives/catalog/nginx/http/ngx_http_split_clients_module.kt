package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_split_clients_module.html

val ngx_http_split_clients_module = NginxModule(
    name = "ngx_http_split_clients_module",
    description = "Module for creating variables suitable for A/B testing using client hash distribution"
)

val splitClients = Directive(
    name = "split_clients",
    description = "Creates a variable for A/B testing by hashing a given string and distributing clients into percentage-based groups",
    context = listOf(http),
    module = ngx_http_split_clients_module
)
