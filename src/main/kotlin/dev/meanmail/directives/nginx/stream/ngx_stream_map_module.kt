package dev.meanmail.directives.nginx.stream

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/stream/ngx_stream_map_module.html

val ngx_stream_map_module = NginxModule(
    name = "ngx_stream_map_module",
    description = "Provides dynamic variable mapping functionality in stream context, enabling flexible transformation of variable values",
    enabled = true
)

val streamMap = Directive(
    name = "map",
    description = "Creates a new variable based on values of another variable in stream context, supporting complex transformation rules",
    parameters = listOf(
        DirectiveParameter(
            name = "source",
            valueType = ValueType.STRING,
            description = "Source variable for mapping. Can contain built-in NGINX variables",
            required = true
        ),
        DirectiveParameter(
            name = "variable",
            valueType = ValueType.STRING,
            description = "Target variable to store the transformed value. Starts with '$' symbol",
            required = true
        ),
        DirectiveParameter(
            name = "mapping",
            valueType = ValueType.STRING,
            description = "Key-value mapping rules for variable transformation. Supports wildcards and regular expressions",
            required = true
        )
    ),
    context = listOf(stream),
    module = ngx_stream_map_module
)

val streamMapHashBucketSize = Directive(
    name = "map_hash_bucket_size",
    description = "Sets the hash table bucket size for map directives in stream context, optimizing mapping performance",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            valueType = ValueType.SIZE,
            description = "Size of the hash table bucket in bytes. Affects search efficiency and memory usage",
            required = false,
            defaultValue = "64",
            minValue = 32,
            maxValue = 128
        )
    ),
    context = listOf(stream),
    module = ngx_stream_map_module
)

val streamMapHashMaxSize = Directive(
    name = "map_hash_max_size",
    description = "Sets the maximum hash table size for map directives in stream context, controlling memory utilization",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            valueType = ValueType.NUMBER,
            description = "Maximum size of the hash table. Determines the number of elements that can be efficiently processed",
            required = false,
            defaultValue = "1024",
            minValue = 128,
            maxValue = 65536
        )
    ),
    context = listOf(stream),
    module = ngx_stream_map_module
)
