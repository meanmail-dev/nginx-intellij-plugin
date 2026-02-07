package dev.meanmail.directives.catalog.nginx.http.auth

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule
import dev.meanmail.directives.catalog.nginx.http.http
import dev.meanmail.directives.catalog.nginx.http.limitExcept
import dev.meanmail.directives.catalog.nginx.http.location
import dev.meanmail.directives.catalog.nginx.http.server

// https://nginx.org/en/docs/http/ngx_http_auth_require_module.html

val ngx_http_auth_require_module = NginxModule(
    name = "ngx_http_auth_require_module",
    description = "HTTP module for authorization based on specified variables"
)

val authRequire = Directive(
    name = "auth_require",
    description = "Enables authorization based on the specified variables",
    context = listOf(http, server, location, limitExcept),
    module = ngx_http_auth_require_module
)
