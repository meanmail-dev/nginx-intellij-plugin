package dev.meanmail.directives.catalog.nginx.http.auth

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule
import dev.meanmail.directives.catalog.nginx.http.http
import dev.meanmail.directives.catalog.nginx.http.limitExcept
import dev.meanmail.directives.catalog.nginx.http.location
import dev.meanmail.directives.catalog.nginx.http.server

// https://nginx.org/en/docs/http/ngx_http_auth_basic_module.html

val ngx_http_auth_basic_module = NginxModule(
    "ngx_http_auth_basic_module",
    description = "HTTP basic authentication module"
)

val authBasic = Directive(
    name = "auth_basic",
    description = "Enables HTTP basic authentication and specifies the authentication realm",
    context = listOf(http, server, location, limitExcept),
    module = ngx_http_auth_basic_module
)

val authBasicUserFile = Directive(
    name = "auth_basic_user_file",
    description = "Specifies the path to the file containing user credentials for basic authentication",
    context = listOf(http, server, location, limitExcept),
    module = ngx_http_auth_basic_module
)
