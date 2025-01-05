package dev.meanmail.directives.nginx.http.auth

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType
import dev.meanmail.directives.nginx.http.http
import dev.meanmail.directives.nginx.http.location
import dev.meanmail.directives.nginx.http.server

// https://nginx.org/en/docs/http/ngx_http_auth_request_module.html

val ngx_http_auth_request_module = NginxModule(
    "ngx_http_auth_request_module",
    description = "Enables external authorization request for client access",
    enabled = false
)

val authRequest = Directive(
    name = "auth_request",
    description = "Enables external authorization request for client access",
    parameters = listOf(
        DirectiveParameter(
            name = "uri",
            description = "URI of the authorization server or location",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_auth_request_module
)

val authRequestSet = Directive(
    name = "auth_request_set",
    description = "Sets a variable based on the authorization request response",
    parameters = listOf(
        DirectiveParameter(
            name = "variable",
            description = "Name of the variable to set",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "value",
            description = "Value to assign to the variable based on the authorization response",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_auth_request_module
)
