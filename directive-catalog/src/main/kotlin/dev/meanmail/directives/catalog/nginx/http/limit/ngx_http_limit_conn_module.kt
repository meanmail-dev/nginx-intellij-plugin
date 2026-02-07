package dev.meanmail.directives.catalog.nginx.http.limit

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule
import dev.meanmail.directives.catalog.nginx.http.http
import dev.meanmail.directives.catalog.nginx.http.location
import dev.meanmail.directives.catalog.nginx.http.server

// https://nginx.org/en/docs/http/ngx_http_limit_conn_module.html

val ngx_http_limit_conn_module = NginxModule(
    "ngx_http_limit_conn_module",
    description = "Limits the number of connections per defined key, such as connections from a single IP address"
)

val limitConnZone = Directive(
    name = "limit_conn_zone",
    description = "Defines a shared memory zone to store the state of connections",
    context = listOf(http),
    module = ngx_http_limit_conn_module
)

val limitConn = Directive(
    name = "limit_conn",
    description = "Sets the maximum allowed number of connections for a given key value",
    context = listOf(server, location, http),
    module = ngx_http_limit_conn_module
)

val limitConnDryRun = Directive(
    name = "limit_conn_dry_run",
    description = "Enables dry run mode for connection limiting",
    context = listOf(server, location, http),
    module = ngx_http_limit_conn_module
)

val limitConnLogLevel = Directive(
    name = "limit_conn_log_level",
    description = "Sets the logging level for connection limit events",
    context = listOf(server, location, http),
    module = ngx_http_limit_conn_module
)

val limitConnStatus = Directive(
    name = "limit_conn_status",
    description = "Sets the HTTP status code returned when the connection limit is exceeded",
    context = listOf(server, location, http),
    module = ngx_http_limit_conn_module
)

val limitZone = Directive(
    name = "limit_zone",
    description = "Sets parameters for a shared memory zone (obsolete since 1.1.8, use limit_conn_zone instead)",
    context = listOf(http),
    module = ngx_http_limit_conn_module
)
