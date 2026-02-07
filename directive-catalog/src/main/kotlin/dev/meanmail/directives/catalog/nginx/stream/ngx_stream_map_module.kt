package dev.meanmail.directives.catalog.nginx.stream

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/stream/ngx_stream_map_module.html

val ngx_stream_map_module = NginxModule(
    name = "ngx_stream_map_module",
    description = "Provides dynamic variable mapping functionality in stream context, enabling flexible transformation of variable values"
)

val streamMap = Directive(
    name = "map",
    description = "Creates a new variable based on values of another variable in stream context, supporting complex transformation rules",
    context = listOf(stream),
    module = ngx_stream_map_module
)

val streamMapHashBucketSize = Directive(
    name = "map_hash_bucket_size",
    description = "Sets the hash table bucket size for map directives in stream context, optimizing mapping performance",
    context = listOf(stream),
    module = ngx_stream_map_module
)

val streamMapHashMaxSize = Directive(
    name = "map_hash_max_size",
    description = "Sets the maximum hash table size for map directives in stream context, controlling memory utilization",
    context = listOf(stream),
    module = ngx_stream_map_module
)
