package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_geo_module.html

val ngx_http_geo_module = NginxModule(
    "ngx_http_geo_module",
    description = "Provides a way to create variables based on client IP addresses",
    enabled = true
)

val geo = Directive(
    name = "geo",
    description = "Creates variables with values depending on the client IP address, useful for creating IP-based access controls or conditional configurations",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            description = "IP address or network range to define a specific geographical context",
            valueType = ValueType.STRING,
            required = false
        ),
        DirectiveParameter(
            name = "variable_value",
            description = "Value to assign when the client IP matches the specified address or network range",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(http),
    module = ngx_http_geo_module
)
