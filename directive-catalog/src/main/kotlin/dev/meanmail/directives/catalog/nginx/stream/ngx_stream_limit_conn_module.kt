package dev.meanmail.directives.catalog.nginx.stream

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/stream/ngx_stream_limit_conn_module.html

val ngx_stream_limit_conn_module = NginxModule(
    "ngx_stream_limit_conn_module",
    description = "Limits the number of concurrent connections per defined key in stream context"
)

val streamLimitConn = Directive(
    "limit_conn",
    description = "Limits the number of concurrent connections per defined key",
    context = listOf(stream, streamServer),
    module = ngx_stream_limit_conn_module
)

val streamLimitConnDryRun = Directive(
    "limit_conn_dry_run",
    description = "Enables the dry run mode for limit_conn module without actually limiting connections",
    context = listOf(stream, streamServer),
    module = ngx_stream_limit_conn_module
)

val streamLimitConnLogLevel = Directive(
    "limit_conn_log_level",
    description = "Sets the logging level for connection limit events",
    context = listOf(stream, streamServer),
    module = ngx_stream_limit_conn_module
)

val streamLimitConnZone = Directive(
    "limit_conn_zone",
    description = "Defines a shared memory zone for connection limiting",
    context = listOf(stream),
    module = ngx_stream_limit_conn_module
)
