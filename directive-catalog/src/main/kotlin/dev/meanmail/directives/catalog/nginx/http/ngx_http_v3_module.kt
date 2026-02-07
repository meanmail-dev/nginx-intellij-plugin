package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_v3_module.html

val ngx_http_v3_module = NginxModule(
    "ngx_http_v3_module",
    description = "Provides support for HTTP/3 protocol over QUIC"
)

val http3 = Directive(
    name = "http3",
    description = "Enables HTTP/3 protocol negotiation",
    context = listOf(http, server),
    module = ngx_http_v3_module
)

val http3Hq = Directive(
    name = "http3_hq",
    description = "Enables HTTP/0.9 protocol negotiation used in QUIC interoperability tests",
    context = listOf(http, server),
    module = ngx_http_v3_module
)

val http3MaxConcurrentStreams = Directive(
    name = "http3_max_concurrent_streams",
    description = "Sets the maximum number of concurrent HTTP/3 streams in a connection",
    context = listOf(http, server),
    module = ngx_http_v3_module
)

val http3StreamBufferSize = Directive(
    name = "http3_stream_buffer_size",
    description = "Sets the size of the buffer used for reading and writing of the QUIC streams",
    context = listOf(http, server),
    module = ngx_http_v3_module
)

val quicActiveConnectionIdLimit = Directive(
    name = "quic_active_connection_id_limit",
    description = "Sets the QUIC active_connection_id_limit transport parameter value",
    context = listOf(http, server),
    module = ngx_http_v3_module
)

val quicBpf = Directive(
    name = "quic_bpf",
    description = "Enables routing of QUIC packets using eBPF (Linux 5.7+)",
    context = listOf(http),
    module = ngx_http_v3_module
)

val quicGso = Directive(
    name = "quic_gso",
    description = "Enables sending in optimized batch mode using segmentation offloading",
    context = listOf(http, server),
    module = ngx_http_v3_module
)

val quicHostKey = Directive(
    name = "quic_host_key",
    description = "Sets a file with the secret key used to encrypt stateless reset and address validation tokens",
    context = listOf(http, server),
    module = ngx_http_v3_module
)

val quicRetry = Directive(
    name = "quic_retry",
    description = "Enables the QUIC Address Validation feature",
    context = listOf(http, server),
    module = ngx_http_v3_module
)
