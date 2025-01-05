package dev.meanmail.directives.openresty.http.lua

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType
import dev.meanmail.directives.nginx.http.*
import dev.meanmail.directives.nginx.http.upstream.upstream

val ngx_http_lua_module = NginxModule(
    "ngx_http_lua_module",
    description = "Lua module for Nginx",
    enabled = true
)

val access_by_lua_block = Directive(
    "access_by_lua_block",
    "Executes Lua code during the access phase",
    emptyList(),
    listOf(http, location, limitExcept),
    ngx_http_lua_module
)

val balancer_by_lua_block = Directive(
    "balancer_by_lua_block",
    "Executes Lua code for upstream balancing",
    emptyList(),
    listOf(upstream),
    ngx_http_lua_module
)

val body_filter_by_lua_block = Directive(
    "body_filter_by_lua_block",
    "Executes Lua code for each response body chunk",
    emptyList(),
    listOf(http, server, location, locationIf),
    ngx_http_lua_module
)

val content_by_lua_block = Directive(
    "content_by_lua_block",
    "Executes Lua code as content handler",
    emptyList(),
    listOf(location, locationIf),
    ngx_http_lua_module
)

val header_filter_by_lua_block = Directive(
    "header_filter_by_lua_block",
    "Executes Lua code for each response header",
    emptyList(),
    listOf(http, server, location, locationIf),
    ngx_http_lua_module
)

val init_by_lua_block = Directive(
    "init_by_lua_block",
    "Executes Lua code when Nginx starts up",
    emptyList(),
    listOf(http),
    ngx_http_lua_module
)

val init_worker_by_lua_block = Directive(
    "init_worker_by_lua_block",
    "Executes Lua code when a worker process starts",
    emptyList(),
    listOf(http),
    ngx_http_lua_module
)

val log_by_lua_block = Directive(
    "log_by_lua_block",
    "Executes Lua code during the logging phase",
    emptyList(),
    listOf(http, server, location, locationIf),
    ngx_http_lua_module
)

val rewrite_by_lua_block = Directive(
    "rewrite_by_lua_block",
    "Executes Lua code during the rewrite phase",
    emptyList(),
    listOf(http, server, location, locationIf),
    ngx_http_lua_module
)

val set_by_lua_block = Directive(
    "set_by_lua_block",
    "Executes Lua code and sets a variable",
    listOf(
        DirectiveParameter(
            name = "variable",
            description = "Variable to set",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    listOf(http, server, location, locationIf),
    ngx_http_lua_module
)

val ssl_certificate_by_lua_block = Directive(
    "ssl_certificate_by_lua_block",
    "Executes Lua code during the SSL certificate serving phase",
    emptyList(),
    listOf(http, server),
    ngx_http_lua_module
)

val ssl_session_fetch_by_lua_block = Directive(
    "ssl_session_fetch_by_lua_block",
    "Executes Lua code during the SSL session fetching phase",
    emptyList(),
    listOf(http, server),
    ngx_http_lua_module
)

val ssl_session_store_by_lua_block = Directive(
    "ssl_session_store_by_lua_block",
    "Executes Lua code during the SSL session storing phase",
    emptyList(),
    listOf(http, server),
    ngx_http_lua_module
)
