package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_upstream_hc_module.html

val ngx_stream_upstream_hc_module = NginxModule(
    name = "ngx_stream_upstream_hc_module",
    description = "Upstream server health check module for stream connections. Provides monitoring and automatic management of backend server availability through periodic state checks",
    enabled = true
)

val streamUpstreamHealthCheck = Directive(
    name = "health_check",
    description = "Enables periodic health checks for upstream servers in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "interval",
            valueType = ValueType.TIME,
            description = "Interval between health checks (default 5 seconds)",
            required = false,
        ),
        DirectiveParameter(
            name = "jitter",
            valueType = ValueType.TIME,
            description = "Random delay time for health checks",
            required = false,
        ),
        DirectiveParameter(
            name = "fails",
            valueType = ValueType.NUMBER,
            description = "Number of consecutive failed checks to mark server as unhealthy (default 1)",
            required = false,
        ),
        DirectiveParameter(
            name = "passes",
            valueType = ValueType.NUMBER,
            description = "Number of consecutive successful checks to mark server as healthy (default 1)",
            required = false,
        ),
        DirectiveParameter(
            name = "mandatory",
            valueType = ValueType.BOOLEAN,
            description = "Sets initial 'checking' state for server until first health check",
            required = false,
        ),
        DirectiveParameter(
            name = "match",
            valueType = ValueType.STRING,
            description = "Name of match block for additional health check tests",
            required = false,
        ),
        DirectiveParameter(
            name = "port",
            valueType = ValueType.NUMBER,
            description = "Port used for health checks (default: server port)",
            required = false,
        ),
        DirectiveParameter(
            name = "udp",
            valueType = ValueType.BOOLEAN,
            description = "Use UDP protocol for health checks instead of TCP",
            required = false,
        )
    ),
    context = listOf(streamUpstreamServer),
    module = ngx_stream_upstream_hc_module
)

val streamUpstreamHealthCheckTimeout = Directive(
    name = "health_check_timeout",
    description = "Sets the timeout for server health checks in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            valueType = ValueType.TIME,
            description = "Maximum time to wait for a server response during health check",
        ),
    ),
    context = listOf(upstream),
    module = ngx_stream_upstream_hc_module
)

val streamUpstreamMatch = Directive(
    name = "match",
    description = "Defines criteria for a successful server health check in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "pattern",
            valueType = ValueType.STRING,
            description = "Pattern to validate server response during health check",
        ),
    ),
    context = listOf(upstream),
    module = ngx_stream_upstream_hc_module
)
