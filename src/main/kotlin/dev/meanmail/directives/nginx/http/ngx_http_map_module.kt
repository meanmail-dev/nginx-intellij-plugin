package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/http/ngx_http_map_module.html

val ngx_http_map_module = NginxModule(
    "ngx_http_map_module",
    description = "Creates variables whose values depend on values of other variables",
    enabled = true
)

val map = Directive(
    name = "map",
    description = "Creates a new variable whose value depends on values of one or more source variables. " +
            "Supports special mapping values like 'default' (catch-all rule) and '' (empty string mapping).",
    parameters = listOf(
        DirectiveParameter(
            name = "source_variable",
            description = "Source variable to use for mapping (can be a string or regular expression)",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "result_variable",
            description = "Target variable to store the mapped result",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http),
    module = ngx_http_map_module
)

val mapHashBucketSize = Directive(
    name = "map_hash_bucket_size",
    description = "Sets the bucket size for the map variables hash tables",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Size of hash table bucket in bytes (depends on processor's cache line size)",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "32|64|128"
        )
    ),
    context = listOf(http),
    module = ngx_http_map_module
)

val mapHashMaxSize = Directive(
    name = "map_hash_max_size",
    description = "Sets the maximum size of the map variables hash tables",
    parameters = listOf(
        DirectiveParameter(
            name = "max_size",
            description = "Maximum number of elements in the hash table",
            valueType = ValueType.NUMBER,
            required = false,
            defaultValue = "2048"
        )
    ),
    context = listOf(http),
    module = ngx_http_map_module
)
