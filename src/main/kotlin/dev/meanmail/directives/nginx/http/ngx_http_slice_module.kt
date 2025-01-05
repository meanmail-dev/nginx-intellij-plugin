package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/http/ngx_http_slice_module.html

val ngx_http_slice_module = NginxModule(
    name = "ngx_http_slice_module",
    description = "Module for splitting responses into slices for more effective caching of big responses",
    enabled = false
)

val slice = Directive(
    name = "slice",
    description = "Sets the size of the slice. Zero value disables splitting responses into slices",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Size of each slice chunk. A too low value may result in excessive memory usage and opening a large number of files",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "0"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_slice_module
)
