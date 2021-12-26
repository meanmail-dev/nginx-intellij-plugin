package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_realip_module.html

val streamSetRealIpFrom = Directive("set_real_ip_from")

val ngx_stream_realip_module = Module(
    "ngx_stream_realip_module",
    enabled = false,
    directives = setOf(
        streamSetRealIpFrom,
    )
)
