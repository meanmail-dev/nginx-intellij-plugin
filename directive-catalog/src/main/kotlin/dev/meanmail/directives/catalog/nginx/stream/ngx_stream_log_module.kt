package dev.meanmail.directives.catalog.nginx.stream

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/stream/ngx_stream_log_module.html

val ngx_stream_log_module = NginxModule(
    name = "ngx_stream_log_module",
    description = "Provides logging functionality for TCP/UDP stream connections, enabling detailed logging of client connection events"
)

val streamAccessLog = Directive(
    "access_log",
    description = "Configures logging of client connections in the stream context, allowing detailed tracking of connection events",
    context = listOf(stream, streamServer),
    module = ngx_stream_log_module
)

val streamLogFormat = Directive(
    "log_format",
    description = "Defines a custom log format for stream connections, allowing flexible and detailed logging of connection metadata",
    context = listOf(stream),
    module = ngx_stream_log_module
)

val streamOpenLogFileCache = Directive(
    "open_log_file_cache",
    description = "Configures caching of log file descriptors to improve logging performance and reduce system overhead",
    context = listOf(stream, streamServer),
    module = ngx_stream_log_module
)
