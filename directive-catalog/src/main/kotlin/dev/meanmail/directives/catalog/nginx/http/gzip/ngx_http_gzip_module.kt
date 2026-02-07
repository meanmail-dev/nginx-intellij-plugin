package dev.meanmail.directives.catalog.nginx.http.gzip

import dev.meanmail.directives.catalog.*
import dev.meanmail.directives.catalog.nginx.http.http
import dev.meanmail.directives.catalog.nginx.http.location
import dev.meanmail.directives.catalog.nginx.http.server

// https://nginx.org/en/docs/http/ngx_http_gzip_module.html

val ngx_http_gzip_module = NginxModule(
    "ngx_http_gzip_module",
    description = "Provides support for compressing HTTP responses using gzip to reduce transfer size"
)

val gzip = Directive(
    name = "gzip",
    description = "Enables or disables gzipping of responses. When enabled, NGINX will compress HTTP responses to reduce bandwidth and improve transfer speed.",
    context = listOf(http, server, location),
    module = ngx_http_gzip_module
)

val gzipBuffers = Directive(
    name = "gzip_buffers",
    description = "Configures the number and size of buffers used for gzip compression. Controls memory allocation during compression process.",
    context = listOf(http, server, location),
    module = ngx_http_gzip_module
)

val gzipCompLevel = Directive(
    name = "gzip_comp_level",
    description = "Sets the compression level for gzip, balancing between compression ratio and processing time.",
    context = listOf(http, server, location),
    module = ngx_http_gzip_module
)

val gzipDisable = Directive(
    name = "gzip_disable",
    description = "Disables gzip compression for clients matching specified regular expressions.",
    context = listOf(http, server, location),
    module = ngx_http_gzip_module
)

val gzipHttpVersion = Directive(
    name = "gzip_http_version",
    description = "Sets the minimum HTTP version required for gzip compression.",
    context = listOf(http, server, location),
    module = ngx_http_gzip_module
)

val gzipMinLength = Directive(
    name = "gzip_min_length",
    description = "Sets the minimum length of a response to be eligible for gzip compression.",
    context = listOf(http, server, location),
    module = ngx_http_gzip_module
)

val gzipProxied = Directive(
    name = "gzip_proxied",
    description = "Enables gzip compression for proxied requests based on specific conditions.",
    context = listOf(http, server, location),
    module = ngx_http_gzip_module
)

val gzipTypes = Directive(
    name = "gzip_types",
    description = "Specifies MIME types of responses that should be compressed.",
    context = listOf(http, server, location),
    module = ngx_http_gzip_module
)

val gzipVary = Directive(
    name = "gzip_vary",
    description = "Enables or disables inserting the 'Vary: Accept-Encoding' response header field",
    context = listOf(http, server, location),
    module = ngx_http_gzip_module
)
