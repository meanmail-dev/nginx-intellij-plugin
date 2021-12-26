package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_geo_module.html

val streamGeo = Directive("geo")

val ngx_stream_geo_module = Module(
    "ngx_stream_geo_module",
    enabled = true,
    directives = setOf(
        streamGeo,
    )
)
