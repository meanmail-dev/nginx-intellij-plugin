package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_empty_gif_module.html

val ngx_http_empty_gif_module = NginxModule(
    "ngx_http_empty_gif_module",
    description = "Provides a location that always returns a 1x1 transparent GIF image"
)

val emptyGif = Directive(
    name = "empty_gif",
    description = "Provides a location that always returns a 1x1 transparent GIF image",
    context = listOf(location),
    module = ngx_http_empty_gif_module
)
