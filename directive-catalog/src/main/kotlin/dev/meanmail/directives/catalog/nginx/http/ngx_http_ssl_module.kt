package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/http/ngx_http_ssl_module.html

val ngx_http_ssl_module = NginxModule(
    name = "ngx_http_ssl_module",
    description = "Provides support for HTTPS protocol. Requires OpenSSL library. Not built by default, must be enabled with --with-http_ssl_module configuration parameter"
)

val ssl = Directive(
    name = "ssl",
    description = "Enables HTTPS for the current server block (obsolete in version 1.15.0, use 'ssl' parameter of 'listen' directive instead)",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslBufferSize = Directive(
    name = "ssl_buffer_size",
    description = "Sets the size of the buffer used for sending data. Default size is 16k, which corresponds to minimal overhead when sending big responses",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslCertificate = Directive(
    name = "ssl_certificate",
    description = """
        Specifies a file with the certificate in the PEM format for the given virtual server. 
        If intermediate certificates are needed, they should be specified in the same file in order: 
        primary certificate first, then intermediate certificates. 
        A secret key in PEM format may be placed in the same file.

        Can be specified multiple times to load certificates of different types (e.g., RSA and ECDSA).
        Requires OpenSSL 1.0.2+ for separate certificate chains.

        Supports variables in filename since version 1.15.9 (with potential performance implications).
        Can use 'data:${'$'}variable' syntax since 1.15.10 to load certificate from a variable.
    """.trimIndent(),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslCertificateCache = Directive(
    name = "ssl_certificate_cache",
    description = "Configures the cache for SSL certificates to improve performance by avoiding repeated file reads",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslCertificateKey = Directive(
    name = "ssl_certificate_key",
    description = "Specifies the path to a file with the secret key in the PEM format for the given virtual server",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslCiphers = Directive(
    name = "ssl_ciphers",
    description = "Specifies the enabled ciphers for SSL connections. The ciphers are specified in the OpenSSL library format",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslClientCertificate = Directive(
    name = "ssl_client_certificate",
    description = "Specifies the trusted CA certificates for client certificate authentication",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslConfCommand = Directive(
    name = "ssl_conf_command",
    description = "Sets arbitrary OpenSSL configuration commands for the SSL context. Allows fine-tuning of SSL/TLS parameters not directly supported by NGINX",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslCrl = Directive(
    name = "ssl_crl",
    description = "Specifies a file with revoked certificates (Certificate Revocation List) that will be used in the client certificate verification",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslDhparam = Directive(
    name = "ssl_dhparam",
    description = "Specifies the path to a file containing Diffie-Hellman parameters for DHE ciphers",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslEarlyData = Directive(
    name = "ssl_early_data",
    description = "Enables TLS 1.3 early data (0-RTT) support, which allows sending data in the first TLS handshake message",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslEcdhCurve = Directive(
    name = "ssl_ecdh_curve",
    description = "Specifies a curve for ECDHE ciphers used in SSL connections",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslOcsp = Directive(
    name = "ssl_ocsp",
    description = "Enables or configures OCSP (Online Certificate Status Protocol) stapling",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslOcspCache = Directive(
    name = "ssl_ocsp_cache",
    description = "Configures the storage of OCSP responses for SSL connections",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslOcspResponder = Directive(
    name = "ssl_ocsp_responder",
    description = "Specifies the OCSP responder URL for certificate validation",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslPasswordFile = Directive(
    name = "ssl_password_file",
    description = "Specifies a file with passwords used to decrypt SSL private keys",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslPreferServerCiphers = Directive(
    name = "ssl_prefer_server_ciphers",
    description = "Determines whether server or client ciphers are preferred during SSL negotiation",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslProtocols = Directive(
    name = "ssl_protocols",
    description = """
        Enables specified SSL/TLS protocols.

        Notes:
        - TLSv1.1 and TLSv1.2 require OpenSSL 1.0.1+
        - TLSv1.3 requires OpenSSL 1.1.1+
        - TLSv1.3 is used by default since version 1.23.4

        If specified at server level, can use default server's value.
    """.trimIndent(),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslRejectHandshake = Directive(
    name = "ssl_reject_handshake",
    description = "Rejects SSL handshakes when no certificate is configured",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslSessionCache = Directive(
    name = "ssl_session_cache",
    description = "Configures the SSL session cache for reusing SSL sessions",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslSessionTicketKey = Directive(
    name = "ssl_session_ticket_key",
    description = "Specifies a file with the secret key used to encrypt and decrypt TLS session tickets",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslSessionTickets = Directive(
    name = "ssl_session_tickets",
    description = "Enables or disables session tickets for SSL/TLS connections",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslSessionTimeout = Directive(
    name = "ssl_session_timeout",
    description = "Sets the time for which an SSL session will be valid",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslStapling = Directive(
    name = "ssl_stapling",
    description = "Enables OCSP stapling for SSL/TLS connections",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslStaplingFile = Directive(
    name = "ssl_stapling_file",
    description = "Specifies a file with the OCSP response for SSL stapling",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslStaplingResponder = Directive(
    name = "ssl_stapling_responder",
    description = "Specifies the OCSP responder URL for SSL stapling",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslStaplingVerify = Directive(
    name = "ssl_stapling_verify",
    description = "Enables verification of the OCSP response during SSL stapling",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslTrustedCertificate = Directive(
    name = "ssl_trusted_certificate",
    description = "Specifies a file with trusted CA certificates for SSL/TLS connections",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslVerifyClient = Directive(
    name = "ssl_verify_client",
    description = "Configures client certificate verification",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslVerifyDepth = Directive(
    name = "ssl_verify_depth",
    description = "Sets the maximum depth of client certificate verification chain",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslCertificateCompression = Directive(
    name = "ssl_certificate_compression",
    description = "Enables TLSv1.3 certificate compression (RFC 8879). Disabled by default since 1.29.1",
        context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslEchFile = Directive(
    name = "ssl_ech_file",
    description = "Specifies a file with encrypted ClientHello configuration for TLS 1.3 ECH",
    context = listOf(http, server),
    module = ngx_http_ssl_module
)
