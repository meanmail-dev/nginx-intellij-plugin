package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_split_clients_module.html

val streamSplitClients = Directive("split_clients")

val ngx_stream_split_clients_module = Module(
    "ngx_stream_split_clients_module",
    enabled = true,
    directives = setOf(
        streamSplitClients,
    )
)
