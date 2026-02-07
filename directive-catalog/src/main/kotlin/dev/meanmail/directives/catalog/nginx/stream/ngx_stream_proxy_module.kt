package dev.meanmail.directives.catalog.nginx.stream

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/stream/ngx_stream_proxy_module.html

val ngx_stream_proxy_module = NginxModule(
    name = "ngx_stream_proxy_module",
    description = "Advanced module for proxying TCP/UDP connections with comprehensive configuration and load balancing capabilities"
)

val streamProxyBind = Directive(
    name = "proxy_bind",
    description = "Configures the local network interface for outgoing proxy connections, enabling precise source IP and port selection",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyBufferSize = Directive(
    name = "proxy_buffer_size",
    description = "Sets the buffer size for reading data from the proxied server, optimizing memory usage and performance",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyConnectTimeout = Directive(
    name = "proxy_connect_timeout",
    description = "Defines the maximum time allowed for establishing a connection with the proxied server",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyDownloadRate = Directive(
    name = "proxy_download_rate",
    description = "Limits the download speed from the proxied server, enabling bandwidth control",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyHalfClose = Directive(
    name = "proxy_half_close",
    description = "Enables support for half-closed connections, allowing more flexible connection handling",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyNextUpstream = Directive(
    name = "proxy_next_upstream",
    description = "When a connection to the proxied server cannot be established, determines whether a client connection will be passed to the next server.",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyNextUpstreamTimeout = Directive(
    name = "proxy_next_upstream_timeout",
    description = "Sets the maximum time allowed for trying multiple upstream servers during failover",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyNextUpstreamTries = Directive(
    name = "proxy_next_upstream_tries",
    description = "Limits the number of attempts to pass a connection to the next upstream server",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyPass = Directive(
    name = "proxy_pass",
    description = "Defines the destination server or server group for proxying stream connections",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyProtocol = Directive(
    name = "proxy_protocol",
    description = "Enables PROXY protocol for passing client connection information between proxy and backend servers",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyRequests = Directive(
    name = "proxy_requests",
    description = "Limits the maximum number of client requests per single connection",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyResponses = Directive(
    name = "proxy_responses",
    description = "Controls the maximum number of server responses per client request",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySocketKeepalive = Directive(
    name = "proxy_socket_keepalive",
    description = "Configures TCP keepalive settings for connections to proxied servers",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySsl = Directive(
    name = "proxy_ssl",
    description = "Enables SSL/TLS encryption for connections to backend servers",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslCertificate = Directive(
    name = "proxy_ssl_certificate",
    description = "Specifies the client SSL certificate for authentication with proxied servers",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslCertificateCache = Directive(
    name = "proxy_ssl_certificate_cache",
    description = "Enables caching of SSL certificates for proxied connections to improve performance",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslCertificateKey = Directive(
    name = "proxy_ssl_certificate_key",
    description = "Specifies the private key for the client SSL certificate",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslPasswordFile = Directive(
    name = "proxy_ssl_password_file",
    description = "Specifies a file containing passwords for encrypted SSL certificates",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslProtocols = Directive(
    name = "proxy_ssl_protocols",
    description = "Configures the SSL/TLS protocols allowed for connections to proxied servers",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslServerName = Directive(
    name = "proxy_ssl_server_name",
    description = "Enables passing of the server name during SSL/TLS handshake",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslTrustedCertificate = Directive(
    name = "proxy_ssl_trusted_certificate",
    description = "Specifies the trusted CA certificate for verifying proxied server certificates",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslVerify = Directive(
    name = "proxy_ssl_verify",
    description = "Enables verification of proxied server SSL certificates",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslVerifyDepth = Directive(
    name = "proxy_ssl_verify_depth",
    description = "Sets the maximum depth of CA certificate chain verification",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslCiphers = Directive(
    name = "proxy_ssl_ciphers",
    description = "Specifies the ciphers for SSL connections to proxied servers",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslConfCommand = Directive(
    name = "proxy_ssl_conf_command",
    description = "Sets OpenSSL configuration commands for SSL connections",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslCrl = Directive(
    name = "proxy_ssl_crl",
    description = "Sets the path to the certificate revocation list (CRL) for SSL verification",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslName = Directive(
    name = "proxy_ssl_name",
    description = "Sets the server name for SSL server name indication (SNI)",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslSessionReuse = Directive(
    name = "proxy_ssl_session_reuse",
    description = "Enables or disables reuse of SSL sessions",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyTimeout = Directive(
    name = "proxy_timeout",
    description = "Sets the timeout for read and write operations with the proxied server in stream context",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyUploadRate = Directive(
    name = "proxy_upload_rate",
    description = "Limits the upload speed to the proxied server in stream context",
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)
