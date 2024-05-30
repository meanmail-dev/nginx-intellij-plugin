package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_mp4_module.html

val mp4 = Directive("mp4")
val mp4BufferSize = Directive(
    "mp4_buffer_size",
    defaultValue = "512K"
)
val mp4MaxBufferSize = Directive(
    "mp4_max_buffer_size",
    defaultValue = "10M"
)
val mp4LimitRate = Directive(
    "mp4_limit_rate",
    defaultValue = "off"
)
val mp4LimitRateAfter = Directive(
    "mp4_limit_rate_after",
    defaultValue = "60s"
)
val mp4StartKeyFrame = ToggleDirective("mp4_start_key_frame", false)

val ngx_http_mp4_module = Module(
    "ngx_http_mp4_module",
    enabled = false,
    directives = setOf(
        mp4BufferSize,
        mp4LimitRate,
        mp4LimitRateAfter,
        mp4MaxBufferSize,
        mp4StartKeyFrame,
        mp4,
    )
)
