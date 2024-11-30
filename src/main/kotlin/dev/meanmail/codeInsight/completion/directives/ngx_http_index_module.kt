package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_index_module.html

val ngx_http_index_module = NginxModule(
    name = "ngx_http_index_module",
    description = "Processes requests ending with slash and defines index files",
    enabled = true
)

val index = Directive(
    name = "index",
    description = "Defines files that will be used as an index when a directory is requested",
    parameters = listOf(
        DirectiveParameter(
            name = "index_files",
            description = "List of index files to search for, in order of priority. Can contain variables and absolute paths.",
            valueType = ValueType.LIST,
            required = true,
            defaultValue = "index.html"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_index_module
)
