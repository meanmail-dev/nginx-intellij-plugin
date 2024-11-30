package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_session_log_module.html

val ngx_http_session_log_module = NginxModule(
    name = "ngx_http_session_log_module",
    description = "The session log module for NGINX",
    enabled = true
)

val sessionLog = Directive(
    name = "session_log",
    description = "Enables or configures session logging",
    parameters = listOf(
        DirectiveParameter(
            name = "zone",
            description = "Name of the shared memory zone for session logging",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_session_log_module
)

val sessionLogFormat = Directive(
    name = "session_log_format",
    description = "Defines a custom format for session logging",
    parameters = listOf(
        DirectiveParameter(
            name = "name",
            description = "Name of the log format",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "format",
            description = "Detailed format string for session logging",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http),
    module = ngx_http_session_log_module
)

val sessionLogZone = Directive(
    name = "session_log_zone",
    description = "Defines a shared memory zone for session logging",
    parameters = listOf(
        DirectiveParameter(
            name = "name",
            description = "Name of the shared memory zone",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "size",
            description = "Size of the shared memory zone",
            valueType = ValueType.SIZE,
            required = true
        )
    ),
    context = listOf(http),
    module = ngx_http_session_log_module
)
