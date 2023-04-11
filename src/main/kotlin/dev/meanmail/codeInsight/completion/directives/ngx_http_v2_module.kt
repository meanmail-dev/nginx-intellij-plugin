package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_v2_module.html

val http2BodyPrereadSize = Directive(
    "http2_body_preread_size",
    defaultValue = "64k"
)
val http2ChunkSize = Directive(
    "http2_chunk_size",
    defaultValue = "8k"
)
val http2IdleTimeout = Directive(
    "http2_idle_timeout",
    defaultValue = "3m"
)
val http2MaxConcurrentPushes = Directive(
    "http2_max_concurrent_pushes",
    defaultValue = "10"
)
val http2MaxConcurrentStreams = Directive(
    "http2_max_concurrent_streams",
    defaultValue = "128"
)
val http2MaxFieldSize = Directive(
    "http2_max_field_size",
    defaultValue = "4k"
)
val http2MaxHeaderSize = Directive(
    "http2_max_header_size",
    defaultValue = "16k"
)
val http2MaxRequests = Directive(
    "http2_max_requests",
    defaultValue = "1000"
)
val http2Push = Directive(
    "http2_push",
    defaultValue = "off"
)
val http2PushPreload = ToggleDirective("http2_push_preload", false)
val http2RecvBufferSize = Directive(
    "http2_recv_buffer_size",
    defaultValue = "256k"
)
val http2RecvTimeout = Directive(
    "http2_recv_timeout",
    defaultValue = "30s"
)

val ngx_http_v2_module = Module(
    "ngx_http_v2_module",
    enabled = false,
    directives = setOf(
        http2BodyPrereadSize,
        http2ChunkSize,
        http2IdleTimeout,
        http2MaxConcurrentPushes,
        http2MaxConcurrentStreams,
        http2MaxFieldSize,
        http2MaxHeaderSize,
        http2MaxRequests,
        http2Push,
        http2PushPreload,
        http2RecvBufferSize,
        http2RecvTimeout,
    )
)
