package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/http/ngx_http_headers_module.html

val ngx_http_headers_module = NginxModule(
    name = "ngx_http_headers_module",
    description = "HTTP headers module for adding custom headers and controlling response caching",
    enabled = true
)

val addHeader = Directive(
    name = "add_header",
    description = "Adds custom HTTP headers to responses. Allows dynamically inserting additional headers to HTTP responses.",
    context = listOf(http, server, location, locationIf),
    module = ngx_http_headers_module,
    parameters = listOf(
        DirectiveParameter(
            name = "header_name",
            description = "Name of the HTTP header to add. Can include variables. Supports multiple headers with different conditions.",
            valueType = ValueType.STRING,
            required = true,
            multiple = true
        ),
        DirectiveParameter(
            name = "header_value",
            description = "Value of the HTTP header. Can include variables. Supports conditional header insertion based on response codes.",
            valueType = ValueType.STRING,
            required = true,
            multiple = true
        ),
        DirectiveParameter(
            name = "always",
            description = "Optional flag to add headers even for unsuccessful responses (4xx, 5xx).",
            valueType = ValueType.BOOLEAN,
            required = false
        )
    )
)

val addTrailer = Directive(
    name = "add_trailer",
    description = "Adds custom HTTP trailers to responses. Allows appending additional metadata at the end of HTTP responses.",
    context = listOf(http, server, location, locationIf),
    module = ngx_http_headers_module,
    parameters = listOf(
        DirectiveParameter(
            name = "trailer_name",
            description = "Name of the HTTP trailer to add. Can include variables. Supports multiple trailers with different conditions.",
            valueType = ValueType.STRING,
            required = true,
            multiple = true
        ),
        DirectiveParameter(
            name = "trailer_value",
            description = "Value of the HTTP trailer. Can include variables. Supports conditional trailer insertion.",
            valueType = ValueType.STRING,
            required = true,
            multiple = true
        ),
        DirectiveParameter(
            name = "always",
            description = "Optional flag to add trailers even for unsuccessful responses (4xx, 5xx).",
            valueType = ValueType.BOOLEAN,
            required = false
        )
    )
)

val expires = Directive(
    name = "expires",
    description = "Controls the Expires and Cache-Control headers for responses. Manages caching behavior and content expiration.",
    context = listOf(http, server, location, locationIf),
    module = ngx_http_headers_module,
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            description = "Expiration time. Supports formats: 'off' (no caching), 'max' (maximum caching), 'epoch' (set to Unix epoch), specific time duration (e.g., '1h', '30d'), or exact date/time.",
            valueType = ValueType.STRING,
            required = false
        )
    )
)
