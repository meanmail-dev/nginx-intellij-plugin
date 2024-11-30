package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_geo_module.html


val ngx_stream_geo_module = NginxModule(
    name = "ngx_stream_geo_module",
    enabled = true,
    description = "Advanced stream module for creating dynamic geolocation variables based on client IP addresses, supporting complex routing and content delivery strategies",
)

val streamGeo = Directive(
    name = "geo",
    description = "Defines a geolocation variable based on the client IP address in stream context, enabling dynamic content and routing decisions",
    parameters = listOf(
        DirectiveParameter(
            name = "address_variable",
            description = "Optional variable for IP address (default: \$remote_addr)",
            valueType = ValueType.STRING,
            required = false
        ),
        DirectiveParameter(
            name = "result_variable",
            description = "Variable to store geolocation result",
            valueType = ValueType.STRING
        )
    ),
    module = ngx_stream_geo_module,
    context = listOf(stream)
)
