package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_f4f_module.html

val f4f = Directive("f4f")
val f4FBufferSize = Directive(
    "f4f_buffer_size",
    defaultValue = "512k"
)

val ngx_http_f4f_module = Module(
    "ngx_http_f4f_module",
    enabled = true,
    directives = setOf(
        f4f,
        f4FBufferSize,
    )
)
