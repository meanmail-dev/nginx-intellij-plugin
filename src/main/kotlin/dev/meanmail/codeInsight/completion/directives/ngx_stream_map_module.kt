package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_map_module.html


val streamMap = Directive("map")
val streamMapHashBucketSize = Directive("map_hash_bucket_size")
val streamMapHashMaxSize = Directive(
    "map_hash_max_size",
    defaultValue = "2048"
)

val ngx_stream_map_module = Module(
    "ngx_stream_map_module",
    enabled = true,
    directives = setOf(
        streamMap,
        streamMapHashBucketSize,
        streamMapHashMaxSize,
    )
)
