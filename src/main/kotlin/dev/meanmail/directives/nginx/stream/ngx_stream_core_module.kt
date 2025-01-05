package dev.meanmail.directives.nginx.stream

import dev.meanmail.directives.*

// https://nginx.org/en/docs/stream/ngx_stream_core_module.html

val ngx_stream_core_module = NginxModule(
    name = "ngx_stream_core_module",
    description = "Provides core functionality for handling stream connections",
    enabled = false
)

val stream = Directive(
    "stream",
    description = "Defines a stream context for handling stream-level configurations",
    parameters = emptyList(),
    module = ngx_stream_core_module,
    context = listOf(main)
)

val streamServer = Directive(
    name = "server",
    description = "Defines a stream server block with configuration for handling stream connections",
    parameters = emptyList(),
    module = ngx_stream_core_module,
    context = listOf(stream)
)

val streamListen = Directive(
    name = "listen",
    description = "Configures the address and port or UNIX-domain socket for the server to accept stream connections",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            valueType = ValueType.STRING,
            description = "IP address or UNIX-domain socket path",
        ),
        DirectiveParameter(
            name = "port",
            valueType = ValueType.NUMBER,
            description = "Port number for TCP connections",
        ),
        DirectiveParameter(
            name = "options",
            valueType = ValueType.STRING,
            description = "Additional socket configuration options",
            required = false,
        )
    ),
    module = ngx_stream_core_module,
    context = listOf(streamServer)
)

val streamPrereadBufferSize = Directive(
    name = "preread_buffer_size",
    description = "Sets the buffer size for reading initial data from the proxied server before processing",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            valueType = ValueType.SIZE,
            description = "Buffer size in bytes or with size units",
        )
    ),
    module = ngx_stream_core_module,
    context = listOf(stream, streamServer)
)

val streamPrereadTimeout = Directive(
    name = "preread_timeout",
    description = "Sets the timeout for reading initial data from the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            valueType = ValueType.TIME,
            description = "Timeout duration for preread operation",
        )
    ),
    module = ngx_stream_core_module,
    context = listOf(stream, streamServer)
)

val streamProxyProtocolTimeout = Directive(
    name = "proxy_protocol_timeout",
    description = "Sets the timeout for reading the PROXY protocol header from the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            valueType = ValueType.TIME,
            description = "Timeout duration for PROXY protocol header reading",
        )
    ),
    module = ngx_stream_core_module,
    context = listOf(stream, streamServer)
)

val streamResolver = Directive(
    name = "resolver",
    description = "Configures DNS servers for resolving hostnames to IP addresses",
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
    module = ngx_stream_core_module,
    context = listOf(stream, streamServer)
)

val streamResolverTimeout = Directive(
    name = "resolver_timeout",
    description = "Sets the timeout for resolving hostnames to IP addresses",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            valueType = ValueType.TIME,
            description = "Timeout duration for hostname resolution",
        )
    ),
    module = ngx_stream_core_module,
    context = listOf(stream, streamServer)
)

val streamTcpNodelay = Directive(
    name = "tcp_nodelay",
    description = "Enables or disables the TCP_NODELAY socket option to reduce network latency",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            valueType = ValueType.BOOLEAN,
            description = "TCP_NODELAY state",
            allowedValues = listOf("on", "off"),
            required = false
        )
    ),
    module = ngx_stream_core_module,
    context = listOf(stream, streamServer)
)

val streamVariablesHashBucketSize = Directive(
    name = "variables_hash_bucket_size",
    description = "Sets the size of the variables hash bucket for efficient variable lookup",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            valueType = ValueType.SIZE,
            description = "Size of variables hash bucket",
            required = false
        )
    ),
    module = ngx_stream_core_module,
    context = listOf(stream)
)

val streamVariablesHashMaxSize = Directive(
    name = "variables_hash_max_size",
    description = "Sets the maximum size of the variables hash table for efficient variable lookup",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            valueType = ValueType.NUMBER,
            description = "Maximum size of variables hash table",
            required = false
        )
    ),
    module = ngx_stream_core_module,
    context = listOf(stream)
)
