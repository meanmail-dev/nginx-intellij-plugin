package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_map_module.html

val map = Directive("map")
val mapHashBucketSize = Directive("map_hash_bucket_size")
val mapHashMaxSize = Directive(
    "map_hash_max_size",
    defaultValue = "2048"
)

val ngx_http_map_module = Module(
    "ngx_http_map_module",
    enabled = true,
    directives = setOf(
        map,
        mapHashBucketSize,
        mapHashMaxSize,
    )
)
