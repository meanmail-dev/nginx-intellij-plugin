package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_limit_conn_module.html

val ngx_http_limit_conn_module = NginxModule(
    "ngx_http_limit_conn_module",
    description = "Limits the number of connections per defined key, such as connections from a single IP address",
    enabled = true
)

val limitConnZone = Directive(
    name = "limit_conn_zone",
    description = "Defines a shared memory zone to store the state of connections",
    parameters = listOf(
        DirectiveParameter(
            name = "key",
            description = "Defines the key for limiting connections (e.g., \$binary_remote_addr)",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "zone",
            description = "Name and size of the shared memory zone",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http),
    module = ngx_http_limit_conn_module
)

val limitConn = Directive(
    name = "limit_conn",
    description = "Sets the maximum allowed number of connections for a given key value",
    parameters = listOf(
        DirectiveParameter(
            name = "zone",
            description = "Name of the shared memory zone defined by limit_conn_zone",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "number",
            description = "Maximum number of allowed connections per key",
            valueType = ValueType.NUMBER,
            required = true
        )
    ),
    context = listOf(server, location, http),
    module = ngx_http_limit_conn_module
)

val limitConnDryRun = Directive(
    name = "limit_conn_dry_run",
    description = "Enables dry run mode for connection limiting",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            description = "Enables or disables dry run mode",
            valueType = ValueType.BOOLEAN,
            required = true,
            defaultValue = "off"
        )
    ),
    context = listOf(server, location, http),
    module = ngx_http_limit_conn_module
)

val limitConnLogLevel = Directive(
    name = "limit_conn_log_level",
    description = "Sets the logging level for connection limit events",
    parameters = listOf(
        DirectiveParameter(
            name = "level",
            description = "Logging level for connection limit events",
            valueType = ValueType.ENUM,
            allowedValues = listOf("info", "notice", "warn", "error"),
            required = true,
            defaultValue = "error"
        )
    ),
    context = listOf(server, location, http),
    module = ngx_http_limit_conn_module
)

val limitConnStatus = Directive(
    name = "limit_conn_status",
    description = "Sets the HTTP status code returned when the connection limit is exceeded",
    parameters = listOf(
        DirectiveParameter(
            name = "code",
            description = "HTTP status code to return when connection limit is exceeded",
            valueType = ValueType.NUMBER,
            required = true,
            defaultValue = "503"
        )
    ),
    context = listOf(server, location, http),
    module = ngx_http_limit_conn_module
)
