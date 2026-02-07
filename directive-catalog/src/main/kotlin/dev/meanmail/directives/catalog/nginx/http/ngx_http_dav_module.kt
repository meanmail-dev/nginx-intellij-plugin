package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/http/ngx_http_dav_module.html

val ngx_http_dav_module = NginxModule(
    "ngx_http_dav_module",
    description = "The Nginx HTTP DAV module"
)

val createFullPutPath = Directive(
    "create_full_put_path",
    "Enables creation of intermediate directories during PUT requests",
    context = listOf(location),
    module = ngx_http_dav_module
)

val davAccess = Directive(
    name = "dav_access",
    description = "Sets the access permissions for created files and directories",
    context = listOf(http, server, location),
    module = ngx_http_dav_module
)

val davMethods = Directive(
    name = "dav_methods",
    description = "Enables WebDAV HTTP methods for the location",
    context = listOf(location),
    module = ngx_http_dav_module
)

val minDeleteDepth = Directive(
    name = "min_delete_depth",
    description = "Sets the minimum directory depth allowed for DELETE requests",
    context = listOf(location),
    module = ngx_http_dav_module
)
