package dev.meanmail.directives.catalog.nginx.stream.upstream

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule
import dev.meanmail.directives.catalog.nginx.stream.stream

// https://nginx.org/en/docs/stream/ngx_stream_upstream_module.html

val ngx_stream_upstream_module = NginxModule(
    name = "ngx_stream_upstream_module",
    description = "Comprehensive stream module for advanced load balancing, server health checks, and dynamic upstream configuration in TCP/UDP proxying"
)

val streamUpstream = Directive(
    name = "upstream",
    description = "Defines a group of servers for load balancing in stream context",
    context = listOf(stream),
    module = ngx_stream_upstream_module
)

val streamUpstreamServer = Directive(
    name = "server",
    description = "Defines a server in an upstream group for load balancing in stream context",
    context = listOf(streamUpstream),
    module = ngx_stream_upstream_module
)

val streamUpstreamZone = Directive(
    name = "zone",
    description = "Defines a shared memory zone for upstream servers in stream context",
    context = listOf(streamUpstream),
    module = ngx_stream_upstream_module
)

val streamUpstreamHash = Directive(
    name = "hash",
    description = "Configures hash-based load balancing method in stream context",
    context = listOf(streamUpstream),
    module = ngx_stream_upstream_module
)

val streamUpstreamLeastConn = Directive(
    name = "least_conn",
    description = "Selects the server with the least number of active connections in stream context",
    context = listOf(streamUpstream),
    module = ngx_stream_upstream_module
)

val streamUpstreamRandom = Directive(
    name = "random",
    description = "Configures random load balancing method in stream context",
    context = listOf(streamUpstream),
    module = ngx_stream_upstream_module
)

val streamUpstreamResolver = Directive(
    name = "resolver",
    description = "Configures DNS servers for upstream server resolution in stream context",
    context = listOf(streamUpstream),
    module = ngx_stream_upstream_module
)

val streamUpstreamResolverTimeout = Directive(
    name = "resolver_timeout",
    description = "Sets the timeout for DNS server resolution in stream context",
    context = listOf(streamUpstream),
    module = ngx_stream_upstream_module
)
