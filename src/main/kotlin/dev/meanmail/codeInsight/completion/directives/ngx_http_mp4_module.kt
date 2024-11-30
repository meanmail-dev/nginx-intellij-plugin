package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_mp4_module.html

val ngx_http_mp4_module = NginxModule(
    name = "ngx_http_mp4_module",
    description = "Provides pseudo-streaming server-side support for MP4 files (.mp4, .m4v, .m4a)",
    enabled = true
)

val mp4 = Directive(
    name = "mp4",
    description = "Turns on module processing in a surrounding location",
    parameters = emptyList(),
    context = listOf(location),
    module = ngx_http_mp4_module
)

val mp4BufferSize = Directive(
    name = "mp4_buffer_size",
    description = "Sets the initial buffer size for processing MP4 files",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Initial buffer size for MP4 file processing",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "512K"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_mp4_module
)

val mp4MaxBufferSize = Directive(
    name = "mp4_max_buffer_size",
    description = "Sets the maximum buffer size for processing MP4 file metadata",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum buffer size for MP4 metadata processing",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "10M"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_mp4_module
)

val mp4LimitRate = Directive(
    name = "mp4_limit_rate",
    description = "Limits the rate of response transmission based on MP4 file bitrate",
    parameters = listOf(
        DirectiveParameter(
            name = "rate_limit",
            description = "Rate limit factor or on/off state",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "off",
            allowedValues = listOf("on", "off")
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_mp4_module
)

val mp4LimitRateAfter = Directive(
    name = "mp4_limit_rate_after",
    description = "Sets the initial amount of media data before rate limiting",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            description = "Initial playback time before rate limiting",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "60s"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_mp4_module
)

val mp4StartKeyFrame = Directive(
    name = "mp4_start_key_frame",
    description = "Enables prepending the video with a key frame before the start point",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            description = "Enable or disable prepending key frame",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_mp4_module
)
