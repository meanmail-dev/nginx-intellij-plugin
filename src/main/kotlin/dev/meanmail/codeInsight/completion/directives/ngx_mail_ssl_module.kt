package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/mail/ngx_mail_ssl_module.html

val ngx_mail_ssl_module = NginxModule(
    name = "ngx_mail_ssl_module",
    description = "The SSL module for NGINX server configuration",
    enabled = true,
)

val mailSsl = ToggleDirective(
    name = "ssl",
    description = "Enables SSL for mail connections",
    enabled = false,
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslCertificate = Directive(
    name = "ssl_certificate",
    description = "Specifies the path to the SSL certificate file for mail",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the SSL certificate file",
            valueType = ValueType.STRING
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslCertificateKey = Directive(
    name = "ssl_certificate_key",
    description = "Specifies the path to the SSL certificate key file for mail",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the SSL certificate key file",
            valueType = ValueType.STRING
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslCiphers = Directive(
    name = "ssl_ciphers",
    description = "Specifies the ciphers for SSL connections",
    parameters = listOf(
        DirectiveParameter(
            name = "ciphers",
            description = "List of SSL/TLS ciphers",
            valueType = ValueType.STRING
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslClientCertificate = Directive(
    name = "ssl_client_certificate",
    description = "Specifies the path to the client CA certificate file for $mail",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the client CA certificate file",
            valueType = ValueType.STRING
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslConfCommand = Directive(
    name = "ssl_conf_command",
    description = "Sets OpenSSL configuration commands",
    parameters = listOf(
        DirectiveParameter(
            name = "command",
            description = "OpenSSL configuration command",
            valueType = ValueType.STRING
        ),
        DirectiveParameter(
            name = "value",
            description = "Value for the configuration command",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslCrl = Directive(
    name = "ssl_crl",
    description = "Specifies the path to the certificate revocation list (CRL)",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the CRL file",
            valueType = ValueType.STRING
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslDhparam = Directive(
    name = "ssl_dhparam",
    description = "Specifies the path to the Diffie-Hellman parameters file",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the Diffie-Hellman parameters file",
            valueType = ValueType.STRING
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslEcdhCurve = Directive(
    name = "ssl_ecdh_curve",
    description = "Specifies the elliptic curve for ECDHE ciphers",
    parameters = listOf(
        DirectiveParameter(
            name = "curve",
            description = "Name of the elliptic curve",
            valueType = ValueType.STRING
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslPasswordFile = Directive(
    name = "ssl_password_file",
    description = "Specifies the path to the file with SSL private key passwords",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the password file",
            valueType = ValueType.STRING
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslPreferServerCiphers = ToggleDirective(
    name = "ssl_prefer_server_ciphers",
    description = "Enables server cipher preferences over client preferences",
    enabled = false,
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslProtocols = Directive(
    name = "ssl_protocols",
    description = "Specifies the SSL/TLS protocols to use",
    parameters = listOf(
        DirectiveParameter(
            name = "protocols",
            description = "List of SSL/TLS protocols",
            valueType = ValueType.STRING_LIST
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslSessionCache = Directive(
    name = "ssl_session_cache",
    description = "Configures the SSL session cache",
    parameters = listOf(
        DirectiveParameter(
            name = "cache_type",
            description = "Type of SSL session cache",
            valueType = ValueType.STRING
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslSessionTicketKey = Directive(
    name = "ssl_session_ticket_key",
    description = "Specifies the path to the SSL session ticket key file",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the session ticket key file",
            valueType = ValueType.STRING
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslSessionTickets = ToggleDirective(
    name = "ssl_session_tickets",
    description = "Enables or disables SSL session tickets",
    enabled = true,
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslSessionTimeout = Directive(
    name = "ssl_session_timeout",
    description = "Sets the timeout for SSL sessions",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            description = "SSL session timeout duration",
            valueType = ValueType.TIME
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslTrustedCertificate = Directive(
    name = "ssl_trusted_certificate",
    description = "Specifies the path to the trusted CA certificates file",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the trusted CA certificates file",
            valueType = ValueType.STRING
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslVerifyClient = Directive(
    name = "ssl_verify_client",
    description = "Configures client certificate verification",
    parameters = listOf(
        DirectiveParameter(
            name = "mode",
            description = "Client certificate verification mode",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslVerifyDepth = Directive(
    name = "ssl_verify_depth",
    description = "Sets the maximum depth of CA certificate chain verification",
    parameters = listOf(
        DirectiveParameter(
            name = "depth",
            description = "Maximum depth of CA certificate chain",
            valueType = ValueType.NUMBER
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val starttls = Directive(
    name = "starttls",
    description = "Configures STARTTLS support",
    parameters = listOf(
        DirectiveParameter(
            name = "mode",
            description = "STARTTLS mode (on, off, or only)",
            valueType = ValueType.STRING,
            allowedValues = listOf("on", "off", "only")
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)
