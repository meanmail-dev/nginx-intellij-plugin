package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_log_module.html

val ngx_http_log_module = NginxModule(
    name = "ngx_http_log_module",
    description = "Writes request logs in the specified format"
)

val accessLog = Directive(
    name = "access_log",
    description = "Sets the path, format, and configuration for a buffered log write",
    context = listOf(http, server, location, locationIf, limitExcept),
    module = ngx_http_log_module
)

val logFormat = Directive(
    name = "log_format",
    description = "Specifies log format with optional character escaping",
    context = listOf(http),
    module = ngx_http_log_module
)

val openLogFileCache = Directive(
    name = "open_log_file_cache",
    description = "Configures caching of log file descriptors to improve performance",
    context = listOf(http, server, location),
    module = ngx_http_log_module
)
