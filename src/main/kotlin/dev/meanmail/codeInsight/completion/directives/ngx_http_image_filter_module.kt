package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_image_filter_module.html

val ngx_http_image_filter_module = NginxModule(
    name = "ngx_http_image_filter_module",
    description = "Transforms images in JPEG, GIF, PNG, and WebP formats",
    enabled = false
)

val imageFilter = Directive(
    name = "image_filter",
    description = "Sets the type of transformation to perform on images",
    parameters = listOf(
        DirectiveParameter(
            name = "operation",
            description = "Image processing operation: off, test, size, rotate, resize, crop",
            valueType = ValueType.STRING,
            required = true,
            defaultValue = "off",
            allowedValues = listOf("off", "test", "size", "rotate", "resize", "crop")
        ),
        DirectiveParameter(
            name = "params",
            description = "Additional parameters for rotate, resize, and crop operations",
            valueType = ValueType.STRING_LIST,
            required = false
        )
    ),
    context = listOf(location),
    module = ngx_http_image_filter_module
)

val imageFilterBuffer = Directive(
    name = "image_filter_buffer",
    description = "Sets the maximum size of the buffer used for reading images",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum buffer size for image processing",
            valueType = ValueType.SIZE,
            required = true,
            defaultValue = "1M"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_image_filter_module
)

val imageFilterInterlace = Directive(
    name = "image_filter_interlace",
    description = "Enables or disables interlaced processing of images",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            description = "Enable or disable interlace/progressive image processing",
            valueType = ValueType.BOOLEAN,
            required = true,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_image_filter_module
)

val imageFilterJpegQuality = Directive(
    name = "image_filter_jpeg_quality",
    description = "Sets the quality of the transformed JPEG images",
    parameters = listOf(
        DirectiveParameter(
            name = "quality",
            description = "JPEG quality level (1-100, max recommended 95)",
            valueType = ValueType.NUMBER,
            required = true,
            defaultValue = "75"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_image_filter_module
)

val imageFilterSharpen = Directive(
    name = "image_filter_sharpen",
    description = "Increases sharpness of the final image",
    parameters = listOf(
        DirectiveParameter(
            name = "percent",
            description = "Sharpness percentage (0 disables sharpening)",
            valueType = ValueType.NUMBER,
            required = true,
            defaultValue = "0"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_image_filter_module
)

val imageFilterTransparency = Directive(
    name = "image_filter_transparency",
    description = "Defines whether transparency should be preserved in image transformations",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            description = "Enable or disable transparency preservation",
            valueType = ValueType.BOOLEAN,
            required = true,
            defaultValue = "on"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_image_filter_module
)

val imageFilterWebpQuality = Directive(
    name = "image_filter_webp_quality",
    description = "Sets the quality of the transformed WebP images",
    parameters = listOf(
        DirectiveParameter(
            name = "quality",
            description = "WebP quality level (1-100)",
            valueType = ValueType.NUMBER,
            required = true,
            defaultValue = "75"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_image_filter_module
)
