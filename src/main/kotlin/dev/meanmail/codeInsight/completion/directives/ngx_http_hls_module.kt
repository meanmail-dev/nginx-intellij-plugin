package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_hls_module.html

val ngx_http_hls_module = NginxModule(
    name = "ngx_http_hls_module",
    description = "HTTP Live Streaming (HLS) server-side support for MP4 and MOV media files",
    enabled = false
)

val hls = Directive(
    name = "hls",
    description = "Turns on HLS streaming in the surrounding location",
    parameters = listOf(),
    context = listOf(location),
    module = ngx_http_hls_module
)

val hlsBuffers = Directive(
    name = "hls_buffers",
    description = "Sets the maximum number and size of buffers for reading and writing data frames",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Maximum number of buffers",
            valueType = ValueType.INTEGER,
            required = true,
            defaultValue = "8"
        ),
        DirectiveParameter(
            name = "size",
            description = "Size of each buffer",
            valueType = ValueType.SIZE,
            required = true,
            defaultValue = "2m"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_hls_module
)

val hlsForwardArgs = Directive(
    name = "hls_forward_args",
    description = "Adds arguments from a playlist request to URIs of fragments",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            description = "Enables or disables forwarding of original request arguments",
            valueType = ValueType.BOOLEAN,
            required = true,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_hls_module
)

val hlsFragment = Directive(
    name = "hls_fragment",
    description = "Defines the default fragment length for playlist URIs requested without the 'len' argument",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            description = "Default fragment length",
            valueType = ValueType.TIME,
            required = true,
            defaultValue = "5s"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_hls_module
)

val hlsMp4BufferSize = Directive(
    name = "hls_mp4_buffer_size",
    description = "Sets the initial size of the buffer used for processing MP4 and MOV files",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Initial buffer size for MP4 and MOV file processing",
            valueType = ValueType.SIZE,
            required = true,
            defaultValue = "512k"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_hls_module
)

val hlsMp4MaxBufferSize = Directive(
    name = "hls_mp4_max_buffer_size",
    description = "Sets the maximum size of the buffer used for processing MP4 and MOV files",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum buffer size for MP4 and MOV file processing",
            valueType = ValueType.SIZE,
            required = true,
            defaultValue = "10m"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_hls_module
)
