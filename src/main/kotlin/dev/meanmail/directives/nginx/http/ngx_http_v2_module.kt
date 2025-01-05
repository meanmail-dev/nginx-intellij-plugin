package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.*

// https://nginx.org/en/docs/http/ngx_http_v2_module.html

val ngx_http_v2_module = NginxModule(
    "ngx_http_v2_module",
    description = "Provides support for HTTP/2 protocol",
    enabled = false
)

val http2 = ToggleDirective(
    name = "http2",
    description = "Enables the HTTP/2 protocol",
    enabled = false,
    context = listOf(http, server),
    module = ngx_http_v2_module
)

val http2BodyPrereadSize = Directive(
    name = "http2_body_preread_size",
    description = "Sets the buffer size for saving request body before processing",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Buffer size for request body preread",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "64k"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_v2_module
)

val http2ChunkSize = Directive(
    name = "http2_chunk_size",
    description = "Sets the maximum size of response body chunks",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum chunk size for response body",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "8k"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_v2_module
)

val http2IdleTimeout = Directive(
    name = "http2_idle_timeout",
    description = "Sets the timeout of inactivity before connection closure (obsolete since 1.19.7)",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            description = "Inactivity timeout duration",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "3m"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_v2_module
)

val http2MaxConcurrentStreams = Directive(
    name = "http2_max_concurrent_streams",
    description = "Sets the maximum number of concurrent HTTP/2 streams in a connection",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Maximum number of concurrent streams",
            valueType = ValueType.INTEGER,
            required = false,
            defaultValue = "128"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_v2_module
)

val http2MaxFieldSize = Directive(
    name = "http2_max_field_size",
    description = "Limits the maximum size of an HTTP/2 header field (obsolete since 1.19.7)",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum header field size",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "4k"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_v2_module
)

val http2MaxHeaderSize = Directive(
    name = "http2_max_header_size",
    description = "Sets the maximum size of HTTP/2 headers",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum headers size",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "16k"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_v2_module
)

val http2MaxRequests = Directive(
    name = "http2_max_requests",
    description = "Sets the maximum number of requests that can be served over a single HTTP/2 connection",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Maximum number of requests per connection",
            valueType = ValueType.INTEGER,
            required = false,
            defaultValue = "1000"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_v2_module
)

val http2Push = Directive(
    name = "http2_push",
    description = "Configures server push for HTTP/2 connections",
    parameters = listOf(
        DirectiveParameter(
            name = "resource",
            description = "Resource to be pushed",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_v2_module
)

val http2PushPreload = ToggleDirective(
    name = "http2_push_preload",
    description = "Enables or disables automatic HTTP/2 server push for preload links",
    enabled = false,
    context = listOf(http, server, location),
    module = ngx_http_v2_module
)

val http2RecvBufferSize = Directive(
    name = "http2_recv_buffer_size",
    description = "Sets the size of the receive buffer for HTTP/2 connections",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Receive buffer size",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "256k"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_v2_module
)

val http2RecvTimeout = Directive(
    name = "http2_recv_timeout",
    description = "Sets the timeout for receiving data in HTTP/2 connections",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            description = "Receive timeout duration",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "30s"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_v2_module
)
