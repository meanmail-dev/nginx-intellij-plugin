package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_image_filter_module.html

val ngx_http_image_filter_module = NginxModule(
    name = "ngx_http_image_filter_module",
    description = "Transforms images in JPEG, GIF, PNG, and WebP formats"
)

val imageFilter = Directive(
    name = "image_filter",
    description = "Sets the type of transformation to perform on images",
    context = listOf(location),
    module = ngx_http_image_filter_module
)

val imageFilterBuffer = Directive(
    name = "image_filter_buffer",
    description = "Sets the maximum size of the buffer used for reading images",
    context = listOf(http, server, location),
    module = ngx_http_image_filter_module
)

val imageFilterInterlace = Directive(
    name = "image_filter_interlace",
    description = "Enables or disables interlaced processing of images",
    context = listOf(http, server, location),
    module = ngx_http_image_filter_module
)

val imageFilterJpegQuality = Directive(
    name = "image_filter_jpeg_quality",
    description = "Sets the quality of the transformed JPEG images",
    context = listOf(http, server, location),
    module = ngx_http_image_filter_module
)

val imageFilterSharpen = Directive(
    name = "image_filter_sharpen",
    description = "Increases sharpness of the final image",
    context = listOf(http, server, location),
    module = ngx_http_image_filter_module
)

val imageFilterTransparency = Directive(
    name = "image_filter_transparency",
    description = "Defines whether transparency should be preserved in image transformations",
    context = listOf(http, server, location),
    module = ngx_http_image_filter_module
)

val imageFilterWebpQuality = Directive(
    name = "image_filter_webp_quality",
    description = "Sets the quality of the transformed WebP images",
    context = listOf(http, server, location),
    module = ngx_http_image_filter_module
)
