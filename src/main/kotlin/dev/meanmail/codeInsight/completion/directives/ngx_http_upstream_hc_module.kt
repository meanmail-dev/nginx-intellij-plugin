package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_upstream_hc_module.html

val ngx_http_upstream_hc_module = NginxModule(
    name = "ngx_http_upstream_hc_module",
    description = """
        Allows enabling periodic health checks of the servers in an upstream group.
        
        Features:
        - Periodic health checks of upstream servers
        - Configurable test criteria for responses
        - Support for response status, headers, and body content checks
        
        Notes:
        - Server group must reside in shared memory
        - Most variables will have empty values when used with health checks
        - Available as part of commercial subscription
    """.trimIndent(),
    enabled = true
)

val health_check = Directive(
    name = "health_check",
    description = """
        Enables periodic health checks of the servers in an upstream group referenced 
        in the surrounding location.
        
        If a health check fails, the server will be considered unhealthy. Client requests 
        are not passed to unhealthy servers and servers in the "checking" state.
        
        Multiple health checks for the same group: a single failure of any check will 
        make the corresponding server be considered unhealthy.
    """.trimIndent(),
    parameters = listOf(
        DirectiveParameter(
            name = "interval",
            description = "Interval between two consecutive health checks",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "5s"
        ),
        DirectiveParameter(
            name = "jitter",
            description = "Time within which each health check will be randomly delayed",
            valueType = ValueType.TIME,
            required = false
        ),
        DirectiveParameter(
            name = "fails",
            description = "Number of consecutive failed health checks to consider server unhealthy",
            valueType = ValueType.INTEGER,
            required = false,
            defaultValue = "1"
        ),
        DirectiveParameter(
            name = "passes",
            description = "Number of consecutive passed health checks to consider server healthy",
            valueType = ValueType.INTEGER,
            required = false,
            defaultValue = "1"
        ),
        DirectiveParameter(
            name = "uri",
            description = "URI used in health check requests",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "/"
        ),
        DirectiveParameter(
            name = "match",
            description = "Name of match block configuring response tests",
            valueType = ValueType.STRING,
            required = false
        ),
        DirectiveParameter(
            name = "port",
            description = "Port used when connecting to a server for health check",
            valueType = ValueType.INTEGER,
            required = false
        ),
        DirectiveParameter(
            name = "mandatory",
            description = "Sets initial checking state until first health check is completed",
            valueType = ValueType.BOOLEAN,
            required = false
        ),
        DirectiveParameter(
            name = "persistent",
            description = "Sets initial 'up' state after reload if server was healthy before reload",
            valueType = ValueType.BOOLEAN,
            required = false
        )
    ),
    context = listOf(location),
    module = ngx_http_upstream_hc_module
)

val match = Directive(
    name = "match",
    description = """
        Defines the named test set used to verify responses to health check requests.
        
        Can test:
        - Response status codes (e.g., status 200 or status 200-399)
        - Header presence and values (e.g., header Content-Type = text/html)
        - Response body content (using regular expressions)
    """.trimIndent(),
    parameters = listOf(
        DirectiveParameter(
            name = "name",
            description = "Name of the match block",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http),
    module = ngx_http_upstream_hc_module
)
