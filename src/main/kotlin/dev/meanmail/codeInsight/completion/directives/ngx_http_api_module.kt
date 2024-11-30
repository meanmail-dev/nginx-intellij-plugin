package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_api_module.html

val ngx_http_api_module = NginxModule(
    "ngx_http_api_module",
    description = "Provides an API for accessing configuration and status information",
    enabled = true
)

val api = Directive(
    "api",
    description = "Enables Nginx API for accessing configuration and status information",
    parameters = listOf(
        DirectiveParameter(
            name = "write",
            description = "Enables write access to the API",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_api_module
)

val statusZone = Directive(
    "status_zone",
    description = "Defines a shared memory zone for collecting server status information",
    parameters = listOf(
        DirectiveParameter(
            name = "zone_name",
            description = "Name of the shared memory zone for status tracking",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(server),
    module = ngx_http_api_module
)
