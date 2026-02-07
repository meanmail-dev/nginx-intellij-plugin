package dev.meanmail.directives.catalog.nginx.stream.ssl

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule
import dev.meanmail.directives.catalog.nginx.stream.stream
import dev.meanmail.directives.catalog.nginx.stream.streamServer

// https://nginx.org/en/docs/stream/ngx_stream_ssl_preread_module.html

val ngx_stream_ssl_preread_module = NginxModule(
    name = "ngx_stream_ssl_preread_module",
    description = "Stream SSL preread module for extracting information from SSL/TLS handshake without terminating the connection"
)

val streamSslPreread = Directive(
    name = "ssl_preread",
    description = "Enables extracting information from the ClientHello message at the preread phase without terminating SSL/TLS connection",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_preread_module
)
