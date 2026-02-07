package dev.meanmail.directives.catalog.nginx.stream.upstream

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/stream/ngx_stream_upstream_hc_module.html

val ngx_stream_upstream_hc_module = NginxModule(
    name = "ngx_stream_upstream_hc_module",
    description = "Upstream server health check module for stream connections. Provides monitoring and automatic management of backend server availability through periodic state checks"
)

val streamUpstreamHealthCheck = Directive(
    name = "health_check",
    description = "Enables periodic health checks for upstream servers in stream context",
    context = listOf(streamUpstreamServer),
    module = ngx_stream_upstream_hc_module
)

val streamUpstreamHealthCheckTimeout = Directive(
    name = "health_check_timeout",
    description = "Sets the timeout for server health checks in stream context",
    context = listOf(streamUpstream),
    module = ngx_stream_upstream_hc_module
)

val streamUpstreamMatch = Directive(
    name = "match",
    description = "Defines criteria for a successful server health check in stream context",
    context = listOf(streamUpstream),
    module = ngx_stream_upstream_hc_module
)
