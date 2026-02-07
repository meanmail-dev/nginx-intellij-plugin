package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_f4f_module.html

val ngx_http_f4f_module = NginxModule(
    "ngx_http_f4f_module",
    description = "Enables HTTP Dynamic Streaming (F4F) support for Adobe Flash Media Server"
)

val f4f = Directive(
    name = "f4f",
    description = "Enables HTTP Dynamic Streaming (F4F) support for Adobe Flash Media Server",
    context = listOf(location),
    module = ngx_http_f4f_module
)

val f4FBufferSize = Directive(
    name = "f4f_buffer_size",
    description = "Sets the buffer size for F4F (Flash) streaming",
    context = listOf(location),
    module = ngx_http_f4f_module
)
