package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_hls_module.html

val ngx_http_hls_module = NginxModule(
    name = "ngx_http_hls_module",
    description = "HTTP Live Streaming (HLS) server-side support for MP4 and MOV media files"
)

val hls = Directive(
    name = "hls",
    description = "Turns on HLS streaming in the surrounding location",

    context = listOf(location),
    module = ngx_http_hls_module
)

val hlsBuffers = Directive(
    name = "hls_buffers",
    description = "Sets the maximum number and size of buffers for reading and writing data frames",
    context = listOf(http, server, location),
    module = ngx_http_hls_module
)

val hlsForwardArgs = Directive(
    name = "hls_forward_args",
    description = "Adds arguments from a playlist request to URIs of fragments",
    context = listOf(http, server, location),
    module = ngx_http_hls_module
)

val hlsFragment = Directive(
    name = "hls_fragment",
    description = "Defines the default fragment length for playlist URIs requested without the 'len' argument",
    context = listOf(http, server, location),
    module = ngx_http_hls_module
)

val hlsMp4BufferSize = Directive(
    name = "hls_mp4_buffer_size",
    description = "Sets the initial size of the buffer used for processing MP4 and MOV files",
    context = listOf(http, server, location),
    module = ngx_http_hls_module
)

val hlsMp4MaxBufferSize = Directive(
    name = "hls_mp4_max_buffer_size",
    description = "Sets the maximum size of the buffer used for processing MP4 and MOV files",
    context = listOf(http, server, location),
    module = ngx_http_hls_module
)
