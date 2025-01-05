package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/http/ngx_http_mirror_module.html

val ngx_http_mirror_module = NginxModule(
    name = "ngx_http_mirror_module",
    description = "Implements mirroring of an original request by creating background mirror subrequests",
    enabled = true
)

val mirror = Directive(
    name = "mirror",
    description = "Sets the URI to which an original request will be mirrored",
    parameters = listOf(
        DirectiveParameter(
            name = "uri",
            description = "URI for mirroring the original request, can be 'off'",
            valueType = ValueType.STRING,
            required = true,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_mirror_module
)

val mirrorRequestBody = Directive(
    name = "mirror_request_body",
    description = "Controls whether the client request body is mirrored",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            description = "Enable or disable mirroring of client request body",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "on"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_mirror_module
)
