package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_flv_module.html

val ngx_http_flv_module = NginxModule(
    "ngx_http_flv_module",
    description = "Enables pseudo-streaming support for Flash Video (FLV) files",
    enabled = true
)

val flv = Directive(
    name = "flv",
    description = "Enables pseudo-streaming support for Flash Video (FLV) files, allowing clients to start playing a video from a specified time position",
    parameters = emptyList(),
    context = listOf(location),
    module = ngx_http_flv_module
)
