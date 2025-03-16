package dev.meanmail.directives.openresty.http.lua

import dev.meanmail.directives.*
import dev.meanmail.directives.nginx.http.*
import dev.meanmail.directives.nginx.http.upstream.upstream

val lua_nginx_module = NginxModule(
    "lua_nginx_module",
    description = "Lua module for Nginx",
    enabled = true
)

val access_by_lua_block = Directive(
    "access_by_lua_block",
    "Executes Lua code during the access phase",
    emptyList(),
    listOf(http, location, limitExcept),
    lua_nginx_module
)

val balancer_by_lua_block = Directive(
    "balancer_by_lua_block",
    "Executes Lua code for upstream balancing",
    emptyList(),
    listOf(upstream),
    lua_nginx_module
)

val body_filter_by_lua_block = Directive(
    "body_filter_by_lua_block",
    "Executes Lua code for each response body chunk",
    emptyList(),
    listOf(http, server, location, locationIf),
    lua_nginx_module
)

val content_by_lua_block = Directive(
    "content_by_lua_block",
    "Executes Lua code as content handler",
    emptyList(),
    listOf(location, locationIf),
    lua_nginx_module
)

val header_filter_by_lua_block = Directive(
    "header_filter_by_lua_block",
    "Executes Lua code for each response header",
    emptyList(),
    listOf(http, server, location, locationIf),
    lua_nginx_module
)

val init_by_lua_block = Directive(
    "init_by_lua_block",
    "Executes Lua code when Nginx starts up",
    emptyList(),
    listOf(http),
    lua_nginx_module
)

val init_worker_by_lua_block = Directive(
    "init_worker_by_lua_block",
    "Executes Lua code when a worker process starts",
    emptyList(),
    listOf(http),
    lua_nginx_module
)

val log_by_lua_block = Directive(
    "log_by_lua_block",
    "Executes Lua code during the logging phase",
    emptyList(),
    listOf(http, server, location, locationIf),
    lua_nginx_module
)

val rewrite_by_lua_block = Directive(
    "rewrite_by_lua_block",
    "Executes Lua code during the rewrite phase",
    emptyList(),
    listOf(http, server, location, locationIf),
    lua_nginx_module
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
    lua_nginx_module
)

val ssl_certificate_by_lua_block = Directive(
    "ssl_certificate_by_lua_block",
    "Executes Lua code during the SSL certificate serving phase",
    emptyList(),
    listOf(http, server),
    lua_nginx_module
)

val ssl_session_fetch_by_lua_block = Directive(
    "ssl_session_fetch_by_lua_block",
    "Executes Lua code during the SSL session fetching phase",
    emptyList(),
    listOf(http, server),
    lua_nginx_module
)

val ssl_session_store_by_lua_block = Directive(
    "ssl_session_store_by_lua_block",
    "Executes Lua code during the SSL session storing phase",
    emptyList(),
    listOf(http, server),
    lua_nginx_module
)
