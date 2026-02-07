package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_mp4_module.html

val ngx_http_mp4_module = NginxModule(
    name = "ngx_http_mp4_module",
    description = "Provides pseudo-streaming server-side support for MP4 files (.mp4, .m4v, .m4a)"
)

val mp4 = Directive(
    name = "mp4",
    description = "Turns on module processing in a surrounding location",

    context = listOf(location),
    module = ngx_http_mp4_module
)

val mp4BufferSize = Directive(
    name = "mp4_buffer_size",
    description = "Sets the initial buffer size for processing MP4 files",
    context = listOf(http, server, location),
    module = ngx_http_mp4_module
)

val mp4MaxBufferSize = Directive(
    name = "mp4_max_buffer_size",
    description = "Sets the maximum buffer size for processing MP4 file metadata",
    context = listOf(http, server, location),
    module = ngx_http_mp4_module
)

val mp4StartKeyFrame = Directive(
    name = "mp4_start_key_frame",
    description = "Enables prepending the video with a key frame before the start point",
    context = listOf(http, server, location),
    module = ngx_http_mp4_module
)
