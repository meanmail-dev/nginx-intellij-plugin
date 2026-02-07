package dev.meanmail.directives.catalog.nginx.stream

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/stream/ngx_stream_core_module.html

val ngx_stream_core_module = NginxModule(
    name = "ngx_stream_core_module",
    description = "Provides core functionality for handling stream connections"
)

val stream = Directive(
    "stream",
    description = "Defines a stream context for handling stream-level configurations",

    module = ngx_stream_core_module,
    context = listOf(main)
)

val streamServer = Directive(
    name = "server",
    description = "Defines a stream server block with configuration for handling stream connections",

    module = ngx_stream_core_module,
    context = listOf(stream)
)

val streamListen = Directive(
    name = "listen",
    description = "Configures the address and port or UNIX-domain socket for the server to accept stream connections",
    module = ngx_stream_core_module,
    context = listOf(streamServer)
)

val streamPrereadBufferSize = Directive(
    name = "preread_buffer_size",
    description = "Sets the buffer size for reading initial data from the proxied server before processing",
    module = ngx_stream_core_module,
    context = listOf(stream, streamServer)
)

val streamPrereadTimeout = Directive(
    name = "preread_timeout",
    description = "Sets the timeout for reading initial data from the proxied server",
    module = ngx_stream_core_module,
    context = listOf(stream, streamServer)
)

val streamProxyProtocolTimeout = Directive(
    name = "proxy_protocol_timeout",
    description = "Sets the timeout for reading the PROXY protocol header from the proxied server",
    module = ngx_stream_core_module,
    context = listOf(stream, streamServer)
)

val streamResolver = Directive(
    name = "resolver",
    description = "Configures DNS servers for resolving hostnames to IP addresses",
    module = ngx_stream_core_module,
    context = listOf(stream, streamServer)
)

val streamResolverTimeout = Directive(
    name = "resolver_timeout",
    description = "Sets the timeout for resolving hostnames to IP addresses",
    module = ngx_stream_core_module,
    context = listOf(stream, streamServer)
)

val streamTcpNodelay = Directive(
    name = "tcp_nodelay",
    description = "Enables or disables the TCP_NODELAY socket option to reduce network latency",
    module = ngx_stream_core_module,
    context = listOf(stream, streamServer)
)

val streamVariablesHashBucketSize = Directive(
    name = "variables_hash_bucket_size",
    description = "Sets the size of the variables hash bucket for efficient variable lookup",
    module = ngx_stream_core_module,
    context = listOf(stream)
)

val streamVariablesHashMaxSize = Directive(
    name = "variables_hash_max_size",
    description = "Sets the maximum size of the variables hash table for efficient variable lookup",
    module = ngx_stream_core_module,
    context = listOf(stream)
)
