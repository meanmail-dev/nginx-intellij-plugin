package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_auth_jwt_module.html

val authJwt = Directive(
    "auth_jwt",
    defaultValue = "off"
)
val authJwtClaimSet = Directive("auth_jwt_claim_set")
val authJwtHeaderSet = Directive("auth_jwt_header_set")
val authJwtKeyFile = Directive("auth_jwt_key_file")
val authJwtKeyRequest = Directive("auth_jwt_key_request")
val authJwtLeeway = Directive(
    "auth_jwt_leeway",
    defaultValue = "0s"
)
val authJwtRequire = Directive("auth_jwt_require")
val authJwtType = Directive(
    "auth_jwt_type",
    setOf("signed", "encrypted", "nested"),
    defaultValue = "signed"
)

val ngx_http_auth_jwt_module = Module(
    "ngx_http_auth_jwt_module",
    enabled = true,
    directives = setOf(
        authJwt,
        authJwtClaimSet,
        authJwtHeaderSet,
        authJwtKeyFile,
        authJwtKeyRequest,
        authJwtLeeway,
        authJwtRequire,
        authJwtType,
    )
)
