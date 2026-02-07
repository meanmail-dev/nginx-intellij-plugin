package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_keyval_module.html

val ngx_http_keyval_module = NginxModule(
    "ngx_http_keyval_module",
    description = "Creates variables with values from key-value pairs managed by API"
)

val keyvalZone = Directive(
    name = "keyval_zone",
    description = "Sets name, size, and configuration of shared memory zone for key-value database",
    context = listOf(http),
    module = ngx_http_keyval_module
)

val keyval = Directive(
    name = "keyval",
    description = "Creates a variable whose value is looked up by key in the key-value database",
    context = listOf(http),
    module = ngx_http_keyval_module
)
