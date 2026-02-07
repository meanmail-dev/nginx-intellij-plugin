package dev.meanmail.directives.catalog.nginx.http.limit

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule
import dev.meanmail.directives.catalog.nginx.http.http
import dev.meanmail.directives.catalog.nginx.http.location
import dev.meanmail.directives.catalog.nginx.http.server

// https://nginx.org/en/docs/http/ngx_http_limit_req_module.html

val ngx_http_limit_req_module = NginxModule(
    "ngx_http_limit_req_module",
    description = "Limits the request processing rate per a defined key, using the 'leaky bucket' method"
)

val limitReqZone = Directive(
    name = "limit_req_zone",
    description = "Defines a shared memory zone for tracking request rate limits",
    context = listOf(http, server, location),
    module = ngx_http_limit_req_module
)

val limitReq = Directive(
    name = "limit_req",
    description = "Sets the shared memory zone and maximum burst size of requests",
    context = listOf(http, server, location),
    module = ngx_http_limit_req_module
)

val limitReqDryRun = Directive(
    name = "limit_req_dry_run",
    description = "Enables dry run mode for request rate limiting without actual blocking",
    context = listOf(http, server, location),
    module = ngx_http_limit_req_module
)

val limitReqLogLevel = Directive(
    name = "limit_req_log_level",
    description = "Sets the logging level for request rate limit events",
    context = listOf(http, server, location),
    module = ngx_http_limit_req_module
)

val limitReqStatus = Directive(
    name = "limit_req_status",
    description = "Defines the HTTP status code returned when request rate limit is exceeded",
    context = listOf(http, server, location),
    module = ngx_http_limit_req_module
)
