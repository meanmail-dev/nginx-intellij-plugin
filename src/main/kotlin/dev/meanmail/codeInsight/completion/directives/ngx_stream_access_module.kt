package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_access_module.html

val streamAllow = Directive("allow")
val streamDeny = Directive("deny")

val ngx_stream_access_module = Module(
    "ngx_stream_access_module",
    enabled = true,
    directives = setOf(
        streamAllow,
        streamDeny,
    )
)
