package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_upstream_module.html

val ngx_stream_upstream_module = NginxModule(
    name = "ngx_stream_upstream_module",
    description = "Comprehensive stream module for advanced load balancing, server health checks, and dynamic upstream configuration in TCP/UDP proxying",
    enabled = true
)

val streamUpstreamServer = Directive(
    name = "server",
    description = "Defines a server in an upstream group for load balancing in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            valueType = ValueType.STRING,
            description = "IP address or domain name of the server",
        ),
        DirectiveParameter(
            name = "port",
            valueType = ValueType.NUMBER,
            description = "Port of the server",
            required = false,
        ),
        DirectiveParameter(
            name = "weight",
            valueType = ValueType.NUMBER,
            description = "Weight for server in load balancing",
            required = false,
        ),
        DirectiveParameter(
            name = "max_conns",
            valueType = ValueType.NUMBER,
            description = "Maximum number of concurrent connections",
            required = false,
        ),
        DirectiveParameter(
            name = "max_fails",
            valueType = ValueType.NUMBER,
            description = "Number of failed attempts before marking server unavailable",
            required = false,
        ),
        DirectiveParameter(
            name = "fail_timeout",
            valueType = ValueType.TIME,
            description = "Duration to consider server unavailable after max_fails",
            required = false,
        )
    ),
    context = listOf(upstream),
    module = ngx_stream_upstream_module
)

val streamUpstreamZone = Directive(
    name = "zone",
    description = "Defines a shared memory zone for upstream servers in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "name",
            valueType = ValueType.STRING,
            description = "Name of the shared memory zone",
        ),
        DirectiveParameter(
            name = "size",
            valueType = ValueType.SIZE,
            description = "Size of the shared memory zone",
        )
    ),
    context = listOf(upstream),
    module = ngx_stream_upstream_module
)

val streamUpstreamState = Directive(
    name = "state",
    description = "Specifies the file to store the state of upstream servers in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            valueType = ValueType.PATH,
            description = "Path to the state file",
        )
    ),
    context = listOf(upstream),
    module = ngx_stream_upstream_module
)

val streamUpstreamHash = Directive(
    name = "hash",
    description = "Configures hash-based load balancing method in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "key",
            valueType = ValueType.STRING,
            description = "Variable used for hash-based distribution",
        ),
        DirectiveParameter(
            name = "consistent",
            valueType = ValueType.BOOLEAN,
            description = "Enables consistent hash distribution",
            required = false,
        )
    ),
    context = listOf(upstream),
    module = ngx_stream_upstream_module
)

val streamUpstreamLeastConn = Directive(
    name = "least_conn",
    description = "Selects the server with the least number of active connections in stream context",
    parameters = emptyList(),
    context = listOf(upstream),
    module = ngx_stream_upstream_module
)

val streamUpstreamLeastTime = Directive(
    name = "least_time",
    description = "Selects the server with the least average response time in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "method",
            valueType = ValueType.STRING,
            description = "Method for calculating least time (connect, first_byte, last_byte)",
            allowedValues = listOf("connect", "first_byte", "last_byte"),
        ),
        DirectiveParameter(
            name = "header",
            valueType = ValueType.BOOLEAN,
            description = "Optional header for least time calculation",
            required = false,
        )
    ),
    context = listOf(upstream),
    module = ngx_stream_upstream_module
)

val streamUpstreamRandom = Directive(
    name = "random",
    description = "Configures random load balancing method in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "two",
            valueType = ValueType.BOOLEAN,
            description = "Selects two servers for random choice",
            required = false,
        ),
        DirectiveParameter(
            name = "method",
            valueType = ValueType.STRING,
            description = "Method for selecting between two servers",
            allowedValues = listOf("least_conn", "least_time"),
            required = false,
        )
    ),
    context = listOf(upstream),
    module = ngx_stream_upstream_module
)

val streamUpstreamResolver = Directive(
    name = "resolver",
    description = "Configures DNS servers for upstream server resolution in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            valueType = ValueType.STRING,
            description = "IP address of DNS server",
        ),
        DirectiveParameter(
            name = "valid",
            valueType = ValueType.TIME,
            description = "Caching time for DNS records",
            required = false,
        ),
        DirectiveParameter(
            name = "ipv6",
            valueType = ValueType.BOOLEAN,
            description = "Enable IPv6 resolution",
            required = false,
        )
    ),
    context = listOf(upstream),
    module = ngx_stream_upstream_module
)

val streamUpstreamResolverTimeout = Directive(
    name = "resolver_timeout",
    description = "Sets the timeout for DNS server resolution in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            valueType = ValueType.TIME,
            description = "Timeout duration for DNS resolution",
        )
    ),
    context = listOf(upstream),
    module = ngx_stream_upstream_module
)

val streamUpstream = Directive(
    name = "upstream",
    description = "Defines a group of servers for load balancing in stream context",
    parameters = emptyList(),
    context = listOf(stream),
    module = ngx_stream_upstream_module
)
