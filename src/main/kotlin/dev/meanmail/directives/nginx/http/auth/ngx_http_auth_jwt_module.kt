package dev.meanmail.directives.nginx.http.auth

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType
import dev.meanmail.directives.nginx.http.http
import dev.meanmail.directives.nginx.http.location
import dev.meanmail.directives.nginx.http.server

// https://nginx.org/en/docs/http/ngx_http_auth_jwt_module.html

val ngx_http_auth_jwt_module = NginxModule(
    name = "ngx_http_auth_jwt_module",
    description = "HTTP module for JSON Web Token (JWT) authentication and authorization",
    enabled = true
)

val authJwt = Directive(
    name = "auth_jwt",
    description = "Enables JWT (JSON Web Token) authentication",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            description = "Enables or disables JWT authentication",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_auth_jwt_module
)

val authJwtClaimSet = Directive(
    name = "auth_jwt_claim_set",
    description = "Sets a variable based on a JWT claim",
    parameters = listOf(
        DirectiveParameter(
            name = "variable",
            description = "Name of the variable to set",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "claim",
            description = "Name of the JWT claim to extract",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_auth_jwt_module
)

val authJwtHeaderSet = Directive(
    name = "auth_jwt_header_set",
    description = "Sets a variable based on a JWT header",
    parameters = listOf(
        DirectiveParameter(
            name = "variable",
            description = "Name of the variable to set",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "header",
            description = "Name of the JWT header to extract",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_auth_jwt_module
)

val authJwtKeyFile = Directive(
    name = "auth_jwt_key_file",
    description = "Specifies the file containing the key for JWT verification",
    parameters = listOf(
        DirectiveParameter(
            name = "file_path",
            description = "Path to the file containing the verification key",
            valueType = ValueType.PATH,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_auth_jwt_module
)

val authJwtKeyRequest = Directive(
    name = "auth_jwt_key_request",
    description = "Specifies the location for retrieving the JWT verification key",
    parameters = listOf(
        DirectiveParameter(
            name = "location",
            description = "URI or named location to request the verification key",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_auth_jwt_module
)

val authJwtLeeway = Directive(
    name = "auth_jwt_leeway",
    description = "Sets the leeway time for JWT token validation",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            description = "Leeway time for token validation",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "0"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_auth_jwt_module
)

val authJwtRequire = Directive(
    name = "auth_jwt_require",
    description = "Defines additional requirements for JWT validation",
    parameters = listOf(
        DirectiveParameter(
            name = "condition",
            description = "Condition that must be met for JWT to be valid",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_auth_jwt_module
)

val authJwtType = Directive(
    name = "auth_jwt_type",
    description = "Specifies the JWT validation type",
    parameters = listOf(
        DirectiveParameter(
            name = "type",
            description = "JWT type for validation",
            valueType = ValueType.ENUM,
            allowedValues = listOf("signed", "encrypted", "nested"),
            required = false,
            defaultValue = "signed"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_auth_jwt_module
)
