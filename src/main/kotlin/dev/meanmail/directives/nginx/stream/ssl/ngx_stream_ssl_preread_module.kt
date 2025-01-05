package dev.meanmail.directives.nginx.stream.ssl

import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ToggleDirective
import dev.meanmail.directives.nginx.stream.stream
import dev.meanmail.directives.nginx.stream.streamServer

// https://nginx.org/en/docs/stream/ngx_stream_ssl_preread_module.html

val ngx_stream_ssl_preread_module = NginxModule(
    name = "ngx_stream_ssl_preread_module",
    description = "Stream SSL preread module for extracting information from SSL/TLS handshake without terminating the connection",
    enabled = false
)

val streamSslPreread = ToggleDirective(
    name = "ssl_preread",
    description = "Enables extracting information from the ClientHello message at the preread phase without terminating SSL/TLS connection",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_preread_module,
    enabled = false
)
