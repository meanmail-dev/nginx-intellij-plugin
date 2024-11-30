package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_ssl_module.html

val ngx_http_ssl_module = NginxModule(
    name = "ngx_http_ssl_module",
    description = "Provides support for HTTPS protocol. Requires OpenSSL library. Not built by default, must be enabled with --with-http_ssl_module configuration parameter",
    enabled = true
)

val ssl = ToggleDirective(
    name = "ssl",
    description = "Enables HTTPS for the current server block (obsolete in version 1.15.0, use 'ssl' parameter of 'listen' directive instead)",
    context = listOf(http, server),
    module = ngx_http_ssl_module,
    enabled = false
)

val sslBufferSize = Directive(
    name = "ssl_buffer_size",
    description = "Sets the size of the buffer used for sending data. Default size is 16k, which corresponds to minimal overhead when sending big responses",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Buffer size for sending SSL data",
            valueType = ValueType.SIZE,
            required = true,
            defaultValue = "16k"
        )
    ),
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
    parameters = listOf(
        DirectiveParameter(
            name = "file",
            description = """
                Path to SSL certificate file in PEM format. 
                Can be:
                - File path
                - Variable (with OpenSSL 1.0.2+)
                - 'data:${'$'}variable' syntax (since 1.15.10)
            """.trimIndent(),
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslCertificateKey = Directive(
    name = "ssl_certificate_key",
    description = "Specifies the path to a file with the secret key in the PEM format for the given virtual server",
    parameters = listOf(
        DirectiveParameter(
            name = "file",
            description = "Path to SSL certificate key file in PEM format",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslCiphers = Directive(
    name = "ssl_ciphers",
    description = "Specifies the enabled ciphers for SSL connections. The ciphers are specified in the OpenSSL library format",
    parameters = listOf(
        DirectiveParameter(
            name = "ciphers",
            description = "List of enabled SSL ciphers",
            valueType = ValueType.STRING,
            required = true,
            defaultValue = "HIGH:!aNULL:!MD5",
            multiple = true
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslClientCertificate = Directive(
    name = "ssl_client_certificate",
    description = "Specifies the trusted CA certificates for client certificate authentication",
    parameters = listOf(
        DirectiveParameter(
            name = "file",
            description = "Path to the CA certificates file for client authentication",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslConfCommand = Directive(
    name = "ssl_conf_command",
    description = "Sets arbitrary OpenSSL configuration commands for the SSL context. Allows fine-tuning of SSL/TLS parameters not directly supported by NGINX",
    parameters = listOf(
        DirectiveParameter(
            name = "command",
            description = "OpenSSL configuration command name",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "value",
            description = "Value for the OpenSSL configuration command",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslCrl = Directive(
    name = "ssl_crl",
    description = "Specifies a file with revoked certificates (Certificate Revocation List) that will be used in the client certificate verification",
    parameters = listOf(
        DirectiveParameter(
            name = "file",
            description = "Path to the Certificate Revocation List (CRL) file in PEM format",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslDhparam = Directive(
    name = "ssl_dhparam",
    description = "Specifies the path to a file containing Diffie-Hellman parameters for DHE ciphers",
    parameters = listOf(
        DirectiveParameter(
            name = "file",
            description = "Path to the Diffie-Hellman parameters file in PEM format",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslEarlyData = ToggleDirective(
    name = "ssl_early_data",
    description = "Enables TLS 1.3 early data (0-RTT) support, which allows sending data in the first TLS handshake message",
    context = listOf(http, server),
    module = ngx_http_ssl_module,
    enabled = false
)

val sslEcdhCurve = Directive(
    name = "ssl_ecdh_curve",
    description = "Specifies a curve for ECDHE ciphers used in SSL connections",
    parameters = listOf(
        DirectiveParameter(
            name = "curve",
            description = "Elliptic curve for ECDHE key exchange",
            valueType = ValueType.STRING,
            required = true,
            defaultValue = "auto",
            allowedValues = listOf(
                "auto",
                "secp384r1",
                "secp256r1",
                "X25519",
                "sect571r1",
                "sect409k1"
            )
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslOcsp = Directive(
    name = "ssl_ocsp",
    description = "Enables or configures OCSP (Online Certificate Status Protocol) stapling",
    parameters = listOf(
        DirectiveParameter(
            name = "parameter",
            description = "OCSP stapling configuration option",
            valueType = ValueType.STRING,
            required = false,
            allowedValues = listOf(
                "on",
                "off",
                "leaf"
            )
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslOcspCache = Directive(
    name = "ssl_ocsp_cache",
    description = "Configures the storage of OCSP responses for SSL connections",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path and parameters for OCSP response cache",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http),
    module = ngx_http_ssl_module
)

val sslOcspResponder = Directive(
    name = "ssl_ocsp_responder",
    description = "Specifies the OCSP responder URL for certificate validation",
    parameters = listOf(
        DirectiveParameter(
            name = "url",
            description = "URL of the OCSP responder",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslPasswordFile = Directive(
    name = "ssl_password_file",
    description = "Specifies a file with passwords used to decrypt SSL private keys",
    parameters = listOf(
        DirectiveParameter(
            name = "file",
            description = "Path to the file containing SSL private key passwords",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslPreferServerCiphers = ToggleDirective(
    name = "ssl_prefer_server_ciphers",
    description = "Determines whether server or client ciphers are preferred during SSL negotiation",
    context = listOf(http, server),
    module = ngx_http_ssl_module,
    enabled = true
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
    parameters = listOf(
        DirectiveParameter(
            name = "protocols",
            description = "SSL/TLS protocols to enable",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "TLSv1 TLSv1.1 TLSv1.2 TLSv1.3",
            multiple = true,
            allowedValues = listOf(
                "SSLv2",
                "SSLv3",
                "TLSv1",
                "TLSv1.1",
                "TLSv1.2",
                "TLSv1.3"
            )
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslRejectHandshake = ToggleDirective(
    name = "ssl_reject_handshake",
    description = "Rejects SSL handshakes when no certificate is configured",
    context = listOf(http, server),
    module = ngx_http_ssl_module,
    enabled = false
)

val sslSessionCache = Directive(
    name = "ssl_session_cache",
    description = "Configures the SSL session cache for reusing SSL sessions",
    parameters = listOf(
        DirectiveParameter(
            name = "type",
            description = "Type and parameters of SSL session cache",
            valueType = ValueType.STRING,
            required = true,
            allowedValues = listOf(
                "off",
                "none",
                "shared:NAME:SIZE",
                "builtin"
            )
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslSessionTicketKey = Directive(
    name = "ssl_session_ticket_key",
    description = "Specifies a file with the secret key used to encrypt and decrypt TLS session tickets",
    parameters = listOf(
        DirectiveParameter(
            name = "file",
            description = "Path to the file containing the SSL session ticket key",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslSessionTickets = ToggleDirective(
    name = "ssl_session_tickets",
    description = "Enables or disables session tickets for SSL/TLS connections",
    context = listOf(http, server),
    module = ngx_http_ssl_module,
    enabled = true
)

val sslSessionTimeout = Directive(
    name = "ssl_session_timeout",
    description = "Sets the time for which an SSL session will be valid",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            description = "Duration of SSL session validity",
            valueType = ValueType.TIME,
            required = true,
            defaultValue = "1h"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslStapling = ToggleDirective(
    name = "ssl_stapling",
    description = "Enables OCSP stapling for SSL/TLS connections",
    context = listOf(http, server),
    module = ngx_http_ssl_module,
    enabled = false
)

val sslStaplingFile = Directive(
    name = "ssl_stapling_file",
    description = "Specifies a file with the OCSP response for SSL stapling",
    parameters = listOf(
        DirectiveParameter(
            name = "file",
            description = "Path to the file with OCSP response for stapling",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslStaplingResponder = Directive(
    name = "ssl_stapling_responder",
    description = "Specifies the OCSP responder URL for SSL stapling",
    parameters = listOf(
        DirectiveParameter(
            name = "url",
            description = "URL of the OCSP responder for stapling",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslStaplingVerify = ToggleDirective(
    name = "ssl_stapling_verify",
    description = "Enables verification of the OCSP response during SSL stapling",
    context = listOf(http, server),
    module = ngx_http_ssl_module,
    enabled = true
)

val sslTrustedCertificate = Directive(
    name = "ssl_trusted_certificate",
    description = "Specifies a file with trusted CA certificates for SSL/TLS connections",
    parameters = listOf(
        DirectiveParameter(
            name = "file",
            description = "Path to the file with trusted CA certificates in PEM format",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslVerifyClient = Directive(
    name = "ssl_verify_client",
    description = "Configures client certificate verification",
    parameters = listOf(
        DirectiveParameter(
            name = "mode",
            description = "Client certificate verification mode",
            valueType = ValueType.STRING,
            required = false,
            allowedValues = listOf(
                "on",
                "off",
                "optional",
                "optional_no_ca"
            )
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)

val sslVerifyDepth = Directive(
    name = "ssl_verify_depth",
    description = "Sets the maximum depth of client certificate verification chain",
    parameters = listOf(
        DirectiveParameter(
            name = "depth",
            description = "Maximum number of intermediate certificates to verify",
            valueType = ValueType.INTEGER,
            required = true,
            defaultValue = "1"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_ssl_module
)
