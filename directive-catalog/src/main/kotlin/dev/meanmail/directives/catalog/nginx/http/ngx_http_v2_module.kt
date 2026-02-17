package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/http/ngx_http_v2_module.html

val ngx_http_v2_module = NginxModule(
    "ngx_http_v2_module",
    description = "Provides support for HTTP/2 protocol"
)

val http2 = Directive(
    name = "http2",
    description = "Enables the HTTP/2 protocol",
        context = listOf(http, server),
    module = ngx_http_v2_module
)

val http2BodyPrereadSize = Directive(
    name = "http2_body_preread_size",
    description = "Sets the buffer size for saving request body before processing",
    context = listOf(http, server),
    module = ngx_http_v2_module
)

val http2ChunkSize = Directive(
    name = "http2_chunk_size",
    description = "Sets the maximum size of response body chunks",
    context = listOf(http, server, location),
    module = ngx_http_v2_module
)

val http2IdleTimeout = Directive(
    name = "http2_idle_timeout",
    description = "Sets the timeout of inactivity before connection closure (obsolete since 1.19.7)",
    context = listOf(http, server),
    module = ngx_http_v2_module
)

val http2MaxConcurrentStreams = Directive(
    name = "http2_max_concurrent_streams",
    description = "Sets the maximum number of concurrent HTTP/2 streams in a connection",
    context = listOf(http, server),
    module = ngx_http_v2_module
)

val http2MaxFieldSize = Directive(
    name = "http2_max_field_size",
    description = "Limits the maximum size of an HTTP/2 header field (obsolete since 1.19.7)",
    context = listOf(http, server),
    module = ngx_http_v2_module
)

val http2MaxHeaderSize = Directive(
    name = "http2_max_header_size",
    description = "Sets the maximum size of HTTP/2 headers",
    context = listOf(http, server),
    module = ngx_http_v2_module
)

val http2MaxRequests = Directive(
    name = "http2_max_requests",
    description = "Sets the maximum number of requests that can be served over a single HTTP/2 connection",
    context = listOf(http, server),
    module = ngx_http_v2_module
)

val http2Push = Directive(
    name = "http2_push",
    description = "Configures server push for HTTP/2 connections",
    context = listOf(http, server, location),
    module = ngx_http_v2_module
)

val http2PushPreload = Directive(
    name = "http2_push_preload",
    description = "Enables or disables automatic HTTP/2 server push for preload links",
        context = listOf(http, server, location),
    module = ngx_http_v2_module
)

val http2RecvBufferSize = Directive(
    name = "http2_recv_buffer_size",
    description = "Sets the size of the receive buffer for HTTP/2 connections",
    context = listOf(http),
    module = ngx_http_v2_module
)

val http2RecvTimeout = Directive(
    name = "http2_recv_timeout",
    description = "Sets the timeout for receiving data in HTTP/2 connections",
    context = listOf(http, server),
    module = ngx_http_v2_module
)

val http2MaxConcurrentPushes = Directive(
    name = "http2_max_concurrent_pushes",
    description = "Limits the maximum number of concurrent push requests in a connection (obsolete since 1.25.1)",
    context = listOf(http, server),
    module = ngx_http_v2_module
)
