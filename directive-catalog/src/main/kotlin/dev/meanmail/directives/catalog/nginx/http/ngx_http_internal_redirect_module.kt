package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_internal_redirect_module.html

val ngx_http_internal_redirect_module = NginxModule(
    "ngx_http_internal_redirect_module",
    description = "Allows making an internal redirect for HTTP requests"
)

val internalRedirect = Directive(
    name = "internal_redirect",
    description = "Sets the URI for internal redirection of the request",
    context = listOf(server, location),
    module = ngx_http_internal_redirect_module
)
