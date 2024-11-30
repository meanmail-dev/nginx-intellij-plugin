package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_autoindex_module.html

val ngx_http_autoindex_module = NginxModule(
    name = "ngx_http_autoindex_module",
    description = "Enables or disables directory listing",
    enabled = true
)

val autoindex = ToggleDirective(
    name = "autoindex",
    description = "Enables or disables directory listing",
    enabled = false,
    context = listOf(http, server, location),
    module = ngx_http_autoindex_module
)

val autoindexExactSize = ToggleDirective(
    name = "autoindex_exact_size",
    description = "Controls whether file sizes are displayed in exact bytes or human-readable format",
    enabled = true,
    context = listOf(http, server, location),
    module = ngx_http_autoindex_module
)

val autoindexFormat = Directive(
    name = "autoindex_format",
    description = "Sets the output format for directory listing",
    parameters = listOf(
        DirectiveParameter(
            name = "format",
            description = "Format of the directory listing",
            valueType = ValueType.ENUM,
            allowedValues = listOf("html", "xml", "json", "jsonp"),
            required = false,
            defaultValue = "html"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_autoindex_module
)

val autoindexLocaltime = ToggleDirective(
    name = "autoindex_localtime",
    description = "Controls whether to display file modification times in local time or UTC",
    enabled = false,
    context = listOf(http, server, location),
    module = ngx_http_autoindex_module
)
