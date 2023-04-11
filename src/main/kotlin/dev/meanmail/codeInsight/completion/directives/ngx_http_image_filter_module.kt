package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_image_filter_module.html

val imageFilter = Directive(
    "image_filter",
    defaultValue = "off"
)
val imageFilterBuffer = Directive(
    "image_filter_buffer",
    defaultValue = "1M"
)
val imageFilterInterlace = ToggleDirective("image_filter_interlace", false)
val imageFilterJpegQuality = Directive(
    "image_filter_jpeg_quality",
    defaultValue = "75"
)
val imageFilterSharpen = Directive(
    "image_filter_sharpen",
    defaultValue = "0"
)
val imageFilterTransparency = ToggleDirective("image_filter_transparency", true)
val imageFilterWebpQuality = Directive(
    "image_filter_webp_quality",
    defaultValue = "80"
)

val ngx_http_image_filter_module = Module(
    "ngx_http_image_filter_module",
    enabled = false,
    directives = setOf(
        imageFilter,
        imageFilterBuffer,
        imageFilterInterlace,
        imageFilterJpegQuality,
        imageFilterSharpen,
        imageFilterTransparency,
        imageFilterWebpQuality,
    )
)
