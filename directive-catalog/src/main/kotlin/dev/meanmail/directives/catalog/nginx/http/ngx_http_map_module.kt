package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_map_module.html

val ngx_http_map_module = NginxModule(
    "ngx_http_map_module",
    description = "Creates variables whose values depend on values of other variables"
)

val map = Directive(
    name = "map",
    description = "Creates a new variable whose value depends on values of one or more source variables. " +
            "Supports special mapping values like 'default' (catch-all rule) and '' (empty string mapping).",
    context = listOf(http),
    module = ngx_http_map_module
)

val mapHashBucketSize = Directive(
    name = "map_hash_bucket_size",
    description = "Sets the bucket size for the map variables hash tables",
    context = listOf(http),
    module = ngx_http_map_module
)

val mapHashMaxSize = Directive(
    name = "map_hash_max_size",
    description = "Sets the maximum size of the map variables hash tables",
    context = listOf(http),
    module = ngx_http_map_module
)
