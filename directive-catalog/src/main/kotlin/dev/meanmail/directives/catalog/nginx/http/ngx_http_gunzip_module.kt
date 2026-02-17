package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/http/ngx_http_gunzip_module.html

val ngx_http_gunzip_module = NginxModule(
    "ngx_http_gunzip_module",
    description = "Provides support for decompressing gzipped responses for clients that do not support gzip encoding"
)

val gunzip = Directive(
    name = "gunzip",
    description = "Enables or disables decompression of gzipped responses for clients that do not support gzip encoding. When enabled, NGINX will decompress gzip-encoded responses before sending them to clients that do not support gzip compression.",
    context = listOf(location),
    module = ngx_http_gunzip_module
)

val gunzipBuffers = Directive(
    name = "gunzip_buffers",
    description = "Configures the number and size of buffers used for decompressing gzipped responses. This directive allows fine-tuning memory allocation for gunzip operations.",
    context = listOf(http, server, location),
    module = ngx_http_gunzip_module
)
