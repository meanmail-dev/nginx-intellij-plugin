package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_num_map_module.html

val ngx_http_num_map_module = NginxModule(
    "ngx_http_num_map_module",
    description = "Creates variables whose values depend on numeric values or ranges of other variables"
)

val httpNumMap = Directive(
    name = "num_map",
    description = "Describes how variable values depend on numeric values or numeric value ranges",
    context = listOf(http),
    module = ngx_http_num_map_module
)
