package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_dav_module.html

val ngx_http_dav_module = NginxModule(
    "ngx_http_dav_module",
    description = "The Nginx HTTP DAV module",
    enabled = true
)

val createFullPutPath = ToggleDirective(
    "create_full_put_path",
    "Enables creation of intermediate directories during PUT requests",
    false,
    context = listOf(location),
    module = ngx_http_dav_module
)

val davAccess = Directive(
    name = "dav_access",
    description = "Sets the access permissions for created files and directories",
    parameters = listOf(
        DirectiveParameter(
            name = "permissions",
            description = "Access permissions in user:mode format",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "user:rw group:r all:r"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_dav_module
)

val davMethods = Directive(
    name = "dav_methods",
    description = "Enables WebDAV HTTP methods for the location",
    parameters = listOf(
        DirectiveParameter(
            name = "methods",
            description = "List of WebDAV methods to enable",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "PUT DELETE MKCOL COPY MOVE"
        )
    ),
    context = listOf(location),
    module = ngx_http_dav_module
)

val minDeleteDepth = Directive(
    name = "min_delete_depth",
    description = "Sets the minimum directory depth allowed for DELETE requests",
    parameters = listOf(
        DirectiveParameter(
            name = "depth",
            description = "Minimum directory depth for DELETE operations",
            valueType = ValueType.NUMBER,
            required = false,
            defaultValue = "0"
        )
    ),
    context = listOf(location),
    module = ngx_http_dav_module
)
