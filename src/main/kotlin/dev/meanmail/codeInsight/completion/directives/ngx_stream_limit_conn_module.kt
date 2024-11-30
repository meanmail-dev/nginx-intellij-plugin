package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_limit_conn_module.html

val ngx_stream_limit_conn_module = NginxModule(
    "ngx_stream_limit_conn_module",
    description = "Limits the number of concurrent connections per defined key in stream context",
    enabled = true
)

val streamLimitConn = Directive(
    "limit_conn",
    description = "Limits the number of concurrent connections per defined key",
    parameters = listOf(
        DirectiveParameter(
            "zone",
            "Name of the zone defining the limit",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            "number",
            "Maximum number of concurrent connections",
            valueType = ValueType.NUMBER,
            required = true
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_limit_conn_module
)

val streamLimitConnDryRun = Directive(
    "limit_conn_dry_run",
    description = "Enables the dry run mode for limit_conn module without actually limiting connections",
    parameters = listOf(
        DirectiveParameter(
            "state",
            "Enables or disables dry run mode",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_limit_conn_module
)

val streamLimitConnLogLevel = Directive(
    "limit_conn_log_level",
    description = "Sets the logging level for connection limit events",
    parameters = listOf(
        DirectiveParameter(
            "log_level",
            "Logging level for connection limit events",
            valueType = ValueType.STRING,
            required = false,
            allowedValues = listOf("info", "notice", "warn", "error"),
            defaultValue = "error"
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_limit_conn_module
)

val streamLimitConnZone = Directive(
    "limit_conn_zone",
    description = "Defines a shared memory zone for connection limiting",
    parameters = listOf(
        DirectiveParameter(
            "key",
            "Defines the key for connection limiting (e.g., \$remote_addr)",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            "zone",
            "Name and size of the shared memory zone (name:size)",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(stream),
    module = ngx_stream_limit_conn_module
)
