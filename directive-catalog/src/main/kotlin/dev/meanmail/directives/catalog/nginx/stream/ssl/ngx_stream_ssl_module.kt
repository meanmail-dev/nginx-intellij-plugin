package dev.meanmail.directives.catalog.nginx.stream.ssl

import dev.meanmail.directives.catalog.*
import dev.meanmail.directives.catalog.nginx.stream.stream
import dev.meanmail.directives.catalog.nginx.stream.streamServer

// https://nginx.org/en/docs/stream/ngx_stream_ssl_module.html

val ngx_stream_ssl_module = NginxModule(
    name = "ngx_stream_ssl_module",
    description = "Comprehensive stream module for secure TCP/UDP connections, providing advanced SSL/TLS configuration, client authentication, and session management features"
)

val streamSslAlpn = Directive(
    name = "ssl_alpn",
    description = "Configures ALPN (Application-Layer Protocol Negotiation) for SSL/TLS stream connections",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslCertificate = Directive(
    name = "ssl_certificate",
    description = "Sets the path to the SSL/TLS certificate file for the server",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslCertificateCache = Directive(
    name = "ssl_certificate_cache",
    description = "Enables or disables the SSL certificate cache",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslCertificateKey = Directive(
    name = "ssl_certificate_key",
    description = "Sets the path to the SSL/TLS certificate private key file",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslCiphers = Directive(
    name = "ssl_ciphers",
    description = "Specifies the enabled ciphers for SSL/TLS connections",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslClientCertificate = Directive(
    name = "ssl_client_certificate",
    description = "Sets the path to the trusted CA certificate for client certificate verification",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslConfCommand = Directive(
    name = "ssl_conf_command",
    description = "Sets OpenSSL configuration commands for SSL/TLS connections",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslCrl = Directive(
    name = "ssl_crl",
    description = "Sets the path to the certificate revocation list (CRL) for client certificate verification",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslDhparam = Directive(
    name = "ssl_dhparam",
    description = "Sets the path to the Diffie-Hellman parameters file for key exchange",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslEcdhCurve = Directive(
    name = "ssl_ecdh_curve",
    description = "Specifies the elliptic curve for ECDHE key exchange",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslHandshakeTimeout = Directive(
    name = "ssl_handshake_timeout",
    description = "Sets the timeout for SSL/TLS handshake completion",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslPasswordFile = Directive(
    name = "ssl_password_file",
    description = "Sets the path to a file containing SSL certificate passwords",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslPreferServerCiphers = Directive(
    name = "ssl_prefer_server_ciphers",
    description = "Enables server cipher preference over client preference",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslProtocols = Directive(
    name = "ssl_protocols",
    description = "Specifies the SSL/TLS protocols to use",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslSessionCache = Directive(
    name = "ssl_session_cache",
    description = "Configures the SSL/TLS session cache type and size",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslSessionTicketKey = Directive(
    name = "ssl_session_ticket_key",
    description = "Sets the key for encrypting and decrypting TLS session tickets",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslSessionTickets = Directive(
    name = "ssl_session_tickets",
    description = "Enables or disables TLS session tickets",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslSessionTimeout = Directive(
    name = "ssl_session_timeout",
    description = "Sets the timeout for SSL/TLS session reuse",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslTrustedCertificate = Directive(
    name = "ssl_trusted_certificate",
    description = "Sets the path to the trusted CA certificate for SSL/TLS verification",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslVerifyClient = Directive(
    name = "ssl_verify_client",
    description = "Configures client certificate verification",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslVerifyDepth = Directive(
    name = "ssl_verify_depth",
    description = "Sets the maximum depth of CA certificate chain verification",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslCertificateCompression = Directive(
    name = "ssl_certificate_compression",
    description = "Enables TLSv1.3 certificate compression (RFC 8879). Disabled by default since 1.29.1",
        context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslEchFile = Directive(
    name = "ssl_ech_file",
    description = "Specifies a file with encrypted ClientHello configuration for TLS 1.3 ECH",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslOcsp = Directive(
    name = "ssl_ocsp",
    description = "Enables OCSP validation of the client certificate chain",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslOcspCache = Directive(
    name = "ssl_ocsp_cache",
    description = "Sets name and size of the cache that stores client certificates status for OCSP validation",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslOcspResponder = Directive(
    name = "ssl_ocsp_responder",
    description = "Overrides the URL of the OCSP responder for validation of client certificates",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslRejectHandshake = Directive(
    name = "ssl_reject_handshake",
    description = "If enabled, SSL handshakes in the server block will be rejected",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslStapling = Directive(
    name = "ssl_stapling",
    description = "Enables or disables stapling of OCSP responses by the server",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslStaplingFile = Directive(
    name = "ssl_stapling_file",
    description = "Sets the file for stapled OCSP response instead of querying the OCSP responder",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslStaplingResponder = Directive(
    name = "ssl_stapling_responder",
    description = "Overrides the URL of the OCSP responder for stapling",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)

val streamSslStaplingVerify = Directive(
    name = "ssl_stapling_verify",
    description = "Enables or disables verification of OCSP responses by the server",
    context = listOf(stream, streamServer),
    module = ngx_stream_ssl_module
)
