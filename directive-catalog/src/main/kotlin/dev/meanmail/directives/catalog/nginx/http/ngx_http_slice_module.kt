package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_slice_module.html

val ngx_http_slice_module = NginxModule(
    name = "ngx_http_slice_module",
    description = "Module for splitting responses into slices for more effective caching of big responses"
)

val slice = Directive(
    name = "slice",
    description = "Sets the size of the slice. Zero value disables splitting responses into slices",
    context = listOf(http, server, location),
    module = ngx_http_slice_module
)
