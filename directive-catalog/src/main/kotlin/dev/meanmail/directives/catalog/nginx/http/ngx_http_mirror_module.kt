package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_mirror_module.html

val ngx_http_mirror_module = NginxModule(
    name = "ngx_http_mirror_module",
    description = "Implements mirroring of an original request by creating background mirror subrequests"
)

val mirror = Directive(
    name = "mirror",
    description = "Sets the URI to which an original request will be mirrored",
    context = listOf(http, server, location),
    module = ngx_http_mirror_module
)

val mirrorRequestBody = Directive(
    name = "mirror_request_body",
    description = "Controls whether the client request body is mirrored",
    context = listOf(http, server, location),
    module = ngx_http_mirror_module
)
