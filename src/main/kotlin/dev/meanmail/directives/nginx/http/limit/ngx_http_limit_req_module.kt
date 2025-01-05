package dev.meanmail.directives.nginx.http.limit

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType
import dev.meanmail.directives.nginx.http.http
import dev.meanmail.directives.nginx.http.location
import dev.meanmail.directives.nginx.http.server

// https://nginx.org/en/docs/http/ngx_http_limit_req_module.html

val ngx_http_limit_req_module = NginxModule(
    "ngx_http_limit_req_module",
    description = "Limits the request processing rate per a defined key, using the 'leaky bucket' method",
    enabled = true
)

val limitReqZone = Directive(
    name = "limit_req_zone",
    description = "Defines a shared memory zone for tracking request rate limits",
    parameters = listOf(
        DirectiveParameter(
            name = "key",
            description = "Defines the key for tracking request rate (e.g., \$binary_remote_addr)",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "zone_name",
            description = "Name and size of the shared memory zone for storing request rate counters",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "rate",
            description = "Maximum request rate allowed (requests per second)",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_limit_req_module
)

val limitReq = Directive(
    name = "limit_req",
    description = "Sets the shared memory zone and maximum burst size of requests",
    parameters = listOf(
        DirectiveParameter(
            name = "zone_name",
            description = "Name of the request rate limit zone",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "burst",
            description = "Maximum burst size of requests",
            valueType = ValueType.NUMBER,
            required = false,
            defaultValue = "0"
        ),
        DirectiveParameter(
            name = "nodelay",
            description = "Enables immediate processing of requests instead of delaying",
            valueType = ValueType.BOOLEAN,
            required = false
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_limit_req_module
)

val limitReqDryRun = Directive(
    name = "limit_req_dry_run",
    description = "Enables dry run mode for request rate limiting without actual blocking",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            description = "Enables or disables dry run mode",
            valueType = ValueType.BOOLEAN,
            required = true,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_limit_req_module
)

val limitReqLogLevel = Directive(
    name = "limit_req_log_level",
    description = "Sets the logging level for request rate limit events",
    parameters = listOf(
        DirectiveParameter(
            name = "log_level",
            description = "Logging level for request rate limit events",
            valueType = ValueType.ENUM,
            allowedValues = listOf("info", "notice", "warn", "error"),
            required = true,
            defaultValue = "error"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_limit_req_module
)

val limitReqStatus = Directive(
    name = "limit_req_status",
    description = "Defines the HTTP status code returned when request rate limit is exceeded",
    parameters = listOf(
        DirectiveParameter(
            name = "status_code",
            description = "HTTP status code to return when request rate limit is reached",
            valueType = ValueType.NUMBER,
            required = true,
            defaultValue = "503"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_limit_req_module
)
