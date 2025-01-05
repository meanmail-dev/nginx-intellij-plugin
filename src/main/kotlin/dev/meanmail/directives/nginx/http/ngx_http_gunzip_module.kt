package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.*

// https://nginx.org/en/docs/http/ngx_http_gunzip_module.html

val ngx_http_gunzip_module = NginxModule(
    "ngx_http_gunzip_module",
    description = "Provides support for decompressing gzipped responses for clients that do not support gzip encoding",
    enabled = false
)

val gunzip = ToggleDirective(
    name = "gunzip",
    description = "Enables or disables decompression of gzipped responses for clients that do not support gzip encoding. When enabled, NGINX will decompress gzip-encoded responses before sending them to clients that do not support gzip compression.",
    context = listOf(location),
    module = ngx_http_gunzip_module,
    enabled = false
)

val gunzipBuffers = Directive(
    name = "gunzip_buffers",
    description = "Configures the number and size of buffers used for decompressing gzipped responses. This directive allows fine-tuning memory allocation for gunzip operations.",
    context = listOf(location),
    module = ngx_http_gunzip_module,
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Number of buffers allocated for gunzip operations. Determines how many buffers will be used during decompression.",
            valueType = ValueType.INTEGER,
            required = true
        ),
        DirectiveParameter(
            name = "size",
            description = "Size of each buffer used for decompression. Defines the memory allocation for each buffer during gunzip operations.",
            valueType = ValueType.SIZE,
            required = true
        )
    )
)
