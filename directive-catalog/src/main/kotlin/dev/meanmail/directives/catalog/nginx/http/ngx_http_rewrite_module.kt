package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/http/ngx_http_rewrite_module.html

val ngx_http_rewrite_module = NginxModule(
    name = "ngx_http_rewrite_module",
    description = "Provides URI transformation, conditional configuration selection, and request processing control using PCRE regular expressions"
)

val locationIf = Directive(
    name = "if",
    description = "Creates a conditional block within a location context, executing directives when the specified condition is true",
    context = listOf(location, self),
    module = ngx_http_rewrite_module
)

val `if` = Directive(
    name = "if",
    description = "Creates a conditional configuration block that executes directives when the specified condition is true",
    context = listOf(server, location, self),
    module = ngx_http_rewrite_module
)

val `break` = Directive(
    name = "break",
    description = "Stops processing the current set of rewrite module directives and continues request processing in the current location",

    context = listOf(server, location, `if`),
    module = ngx_http_rewrite_module
)

val `return` = Directive(
    name = "return",
    description = "Stops request processing and returns a specified HTTP status code or redirects to another URL",
    context = listOf(server, location, `if`),
    module = ngx_http_rewrite_module
)

val rewrite = Directive(
    name = "rewrite",
    description = "Modifies the request URI using PCRE regular expressions, potentially changing the request processing path",
    context = listOf(server, location, `if`),
    module = ngx_http_rewrite_module
)

val rewriteLog = Directive(
    name = "rewrite_log",
    description = "Enables or disables logging of rewrite module directive processing for debugging",
    context = listOf(http, server, location, `if`),
    module = ngx_http_rewrite_module
)

val set = Directive(
    name = "set",
    description = "Assigns a value to a specified NGINX variable for dynamic request processing",
    context = listOf(server, location, `if`),
    module = ngx_http_rewrite_module
)

val uninitializedVariableWarn = Directive(
    name = "uninitialized_variable_warn",
    description = "Controls logging of warnings when uninitialized variables are encountered during request processing",
    context = listOf(http, server, location, `if`),
    module = ngx_http_rewrite_module
)
