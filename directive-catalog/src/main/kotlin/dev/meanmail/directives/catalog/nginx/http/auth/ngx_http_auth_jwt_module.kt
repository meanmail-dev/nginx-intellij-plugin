package dev.meanmail.directives.catalog.nginx.http.auth

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule
import dev.meanmail.directives.catalog.nginx.http.http
import dev.meanmail.directives.catalog.nginx.http.location
import dev.meanmail.directives.catalog.nginx.http.server

// https://nginx.org/en/docs/http/ngx_http_auth_jwt_module.html

val ngx_http_auth_jwt_module = NginxModule(
    name = "ngx_http_auth_jwt_module",
    description = "HTTP module for JSON Web Token (JWT) authentication and authorization"
)

val authJwt = Directive(
    name = "auth_jwt",
    description = "Enables JWT (JSON Web Token) authentication",
    context = listOf(http, server, location),
    module = ngx_http_auth_jwt_module
)

val authJwtClaimSet = Directive(
    name = "auth_jwt_claim_set",
    description = "Sets a variable based on a JWT claim",
    context = listOf(http, server, location),
    module = ngx_http_auth_jwt_module
)

val authJwtHeaderSet = Directive(
    name = "auth_jwt_header_set",
    description = "Sets a variable based on a JWT header",
    context = listOf(http, server, location),
    module = ngx_http_auth_jwt_module
)

val authJwtKeyFile = Directive(
    name = "auth_jwt_key_file",
    description = "Specifies the file containing the key for JWT verification",
    context = listOf(http, server, location),
    module = ngx_http_auth_jwt_module
)

val authJwtKeyRequest = Directive(
    name = "auth_jwt_key_request",
    description = "Specifies the location for retrieving the JWT verification key",
    context = listOf(http, server, location),
    module = ngx_http_auth_jwt_module
)

val authJwtLeeway = Directive(
    name = "auth_jwt_leeway",
    description = "Sets the leeway time for JWT token validation",
    context = listOf(http, server, location),
    module = ngx_http_auth_jwt_module
)

val authJwtRequire = Directive(
    name = "auth_jwt_require",
    description = "Defines additional requirements for JWT validation",
    context = listOf(http, server, location),
    module = ngx_http_auth_jwt_module
)

val authJwtType = Directive(
    name = "auth_jwt_type",
    description = "Specifies the JWT validation type",
    context = listOf(http, server, location),
    module = ngx_http_auth_jwt_module
)

val authJwtKeyCache = Directive(
    name = "auth_jwt_key_cache",
    description = "Enables or disables caching of keys obtained from a file or from a subrequest",
    context = listOf(http, server, location),
    module = ngx_http_auth_jwt_module
)
