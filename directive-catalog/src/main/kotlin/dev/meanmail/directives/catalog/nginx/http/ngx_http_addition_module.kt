package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_addition_module.html

val ngx_http_addition_module = NginxModule(
    "ngx_http_addition_module",
    description = "Provides content addition capabilities for HTTP responses"
)

val addAfterBody = Directive(
    "add_after_body",
    description = "Adds content after the response body",
    context = listOf(http, server, location),
    module = ngx_http_addition_module
)

val addBeforeBody = Directive(
    "add_before_body",
    description = "Adds content before the response body",
    context = listOf(http, server, location),
    module = ngx_http_addition_module
)

val additionTypes = Directive(
    "addition_types",
    description = "Specifies MIME types for which content addition is performed",
    context = listOf(http, server, location),
    module = ngx_http_addition_module
)
