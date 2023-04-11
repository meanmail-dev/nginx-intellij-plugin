package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_hls_module.html

val hls = Directive("hls")
val hlsBuffers = Directive(
    "hls_buffers",
    defaultValue = "8 2m"
)
val hlsForwardArgs = ToggleDirective("hls_forward_args", false)
val hlsFragment = Directive(
    "hls_fragment",
    defaultValue = "5s"
)
val hlsMp4BufferSize = Directive(
    "hls_mp4_buffer_size",
    defaultValue = "512k"
)
val hlsMp4MaxBufferSize = Directive(
    "hls_mp4_max_buffer_size",
    defaultValue = "10m"
)

val ngx_http_hls_module = Module(
    "ngx_http_hls_module",
    enabled = true,
    directives = setOf(
        hls,
        hlsBuffers,
        hlsForwardArgs,
        hlsFragment,
        hlsMp4BufferSize,
        hlsMp4MaxBufferSize,
    )
)
