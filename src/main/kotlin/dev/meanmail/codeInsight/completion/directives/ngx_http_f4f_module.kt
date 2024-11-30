package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_f4f_module.html

val ngx_http_f4f_module = NginxModule(
    "ngx_http_f4f_module",
    description = "Enables HTTP Dynamic Streaming (F4F) support for Adobe Flash Media Server",
    enabled = true
)

val f4f = Directive(
    name = "f4f",
    description = "Enables HTTP Dynamic Streaming (F4F) support for Adobe Flash Media Server",
    parameters = listOf(
        DirectiveParameter(
            name = "no_parameters",
            description = "This directive does not accept any parameters",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(location),
    module = ngx_http_f4f_module
)

val f4FBufferSize = Directive(
    name = "f4f_buffer_size",
    description = "Sets the buffer size for F4F (Flash) streaming",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Buffer size for F4F streaming operations",
            valueType = ValueType.SIZE,
            required = true
        )
    ),
    context = listOf(location),
    module = ngx_http_f4f_module
)
