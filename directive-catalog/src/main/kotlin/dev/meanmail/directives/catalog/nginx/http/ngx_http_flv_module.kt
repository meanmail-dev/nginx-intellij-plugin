package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_flv_module.html

val ngx_http_flv_module = NginxModule(
    "ngx_http_flv_module",
    description = "Enables pseudo-streaming support for Flash Video (FLV) files"
)

val flv = Directive(
    name = "flv",
    description = "Enables pseudo-streaming support for Flash Video (FLV) files, allowing clients to start playing a video from a specified time position",

    context = listOf(location),
    module = ngx_http_flv_module
)
