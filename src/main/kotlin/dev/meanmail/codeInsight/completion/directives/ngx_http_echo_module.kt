package dev.meanmail.codeInsight.completion.directives

val ngx_http_echo_module = NginxModule(
    "ngx_http_echo_module",
    description = "Echo module for Nginx, provides support for echo/sleep/time/exec and more",
    enabled = true
)

val echo = Directive(
    name = "echo",
    description = "Outputs response text, variables or both",
    parameters = listOf(
        DirectiveParameter(
            name = "text",
            description = "Text to output, can include variables",
            valueType = ValueType.STRING,
            multiple = true
        )
    ),
    context = listOf(location, locationIf),
    module = ngx_http_echo_module
)

val echo_flush = Directive(
    name = "echo_flush",
    description = "Forces output to be sent to the client immediately",
    parameters = emptyList(),
    context = listOf(location, locationIf),
    module = ngx_http_echo_module
)

val echo_sleep = Directive(
    name = "echo_sleep",
    description = "Sleeps for the specified seconds",
    parameters = listOf(
        DirectiveParameter(
            name = "seconds",
            description = "Number of seconds to sleep",
            valueType = ValueType.NUMBER,
            required = true
        )
    ),
    context = listOf(location, locationIf),
    module = ngx_http_echo_module
)

val echo_location = Directive(
    name = "echo_location",
    description = "Issues a synchronous subrequest to the specified location",
    parameters = listOf(
        DirectiveParameter(
            name = "location",
            description = "URI or named location to make subrequest to",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(location, locationIf),
    module = ngx_http_echo_module
)

val echo_location_async = Directive(
    name = "echo_location_async",
    description = "Issues an asynchronous subrequest to the specified location",
    parameters = listOf(
        DirectiveParameter(
            name = "location",
            description = "URI or named location to make subrequest to",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(location, locationIf),
    module = ngx_http_echo_module
)

val echo_subrequest = Directive(
    name = "echo_subrequest",
    description = "Issues synchronous subrequests to the specified locations",
    parameters = listOf(
        DirectiveParameter(
            name = "location",
            description = "URI or named location to make subrequest to",
            valueType = ValueType.STRING,
            required = true,
            multiple = true
        )
    ),
    context = listOf(location, locationIf),
    module = ngx_http_echo_module
)

val echo_subrequest_async = Directive(
    name = "echo_subrequest_async",
    description = "Issues asynchronous subrequests to the specified locations",
    parameters = listOf(
        DirectiveParameter(
            name = "location",
            description = "URI or named location to make subrequest to",
            valueType = ValueType.STRING,
            required = true,
            multiple = true
        )
    ),
    context = listOf(location, locationIf),
    module = ngx_http_echo_module
)

val echo_reset_timer = Directive(
    name = "echo_reset_timer",
    description = "Resets the timer used by echo_elapsed_time",
    parameters = emptyList(),
    context = listOf(location, locationIf),
    module = ngx_http_echo_module
)

val echo_read_request_body = Directive(
    name = "echo_read_request_body",
    description = "Explicitly reads the client request body",
    parameters = emptyList(),
    context = listOf(location, locationIf),
    module = ngx_http_echo_module
)
