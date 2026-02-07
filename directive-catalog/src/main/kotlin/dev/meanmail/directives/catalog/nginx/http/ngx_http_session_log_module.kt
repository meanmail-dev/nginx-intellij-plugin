package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_session_log_module.html

val ngx_http_session_log_module = NginxModule(
    name = "ngx_http_session_log_module",
    description = "The session log module for NGINX"
)

val sessionLog = Directive(
    name = "session_log",
    description = "Enables or configures session logging",
    context = listOf(http, server, location),
    module = ngx_http_session_log_module
)

val sessionLogFormat = Directive(
    name = "session_log_format",
    description = "Defines a custom format for session logging",
    context = listOf(http),
    module = ngx_http_session_log_module
)

val sessionLogZone = Directive(
    name = "session_log_zone",
    description = "Defines a shared memory zone for session logging",
    context = listOf(http),
    module = ngx_http_session_log_module
)
