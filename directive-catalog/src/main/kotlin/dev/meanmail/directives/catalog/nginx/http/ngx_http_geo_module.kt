package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_geo_module.html

val ngx_http_geo_module = NginxModule(
    "ngx_http_geo_module",
    description = "Provides a way to create variables based on client IP addresses"
)

val geo = Directive(
    name = "geo",
    description = "Creates variables with values depending on the client IP address, useful for creating IP-based access controls or conditional configurations",
    context = listOf(http),
    module = ngx_http_geo_module
)
