package dev.meanmail.directives.catalog.nginx.http.auth

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule
import dev.meanmail.directives.catalog.nginx.http.http
import dev.meanmail.directives.catalog.nginx.http.location
import dev.meanmail.directives.catalog.nginx.http.server

// https://nginx.org/en/docs/http/ngx_http_auth_request_module.html

val ngx_http_auth_request_module = NginxModule(
    "ngx_http_auth_request_module",
    description = "Enables external authorization request for client access"
)

val authRequest = Directive(
    name = "auth_request",
    description = "Enables external authorization request for client access",
    context = listOf(http, server, location),
    module = ngx_http_auth_request_module
)

val authRequestSet = Directive(
    name = "auth_request_set",
    description = "Sets a variable based on the authorization request response",
    context = listOf(http, server, location),
    module = ngx_http_auth_request_module
)
