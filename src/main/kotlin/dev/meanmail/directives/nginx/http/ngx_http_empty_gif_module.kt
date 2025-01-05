package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/http/ngx_http_empty_gif_module.html

val ngx_http_empty_gif_module = NginxModule(
    "ngx_http_empty_gif_module",
    description = "Provides a location that always returns a 1x1 transparent GIF image",
    enabled = true
)

val emptyGif = Directive(
    name = "empty_gif",
    description = "Provides a location that always returns a 1x1 transparent GIF image",
    parameters = listOf(
        DirectiveParameter(
            name = "no_parameters",
            description = "This directive does not accept any parameters",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(location),
    module = ngx_http_empty_gif_module
)
