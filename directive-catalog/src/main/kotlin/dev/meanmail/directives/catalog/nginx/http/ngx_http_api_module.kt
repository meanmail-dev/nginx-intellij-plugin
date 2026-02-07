package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_api_module.html

val ngx_http_api_module = NginxModule(
    "ngx_http_api_module",
    description = "Provides an API for accessing configuration and status information"
)

val api = Directive(
    "api",
    description = "Enables Nginx API for accessing configuration and status information",
    context = listOf(http, server, location),
    module = ngx_http_api_module
)

val statusZone = Directive(
    "status_zone",
    description = "Defines a shared memory zone for collecting server status information",
    context = listOf(server),
    module = ngx_http_api_module
)
