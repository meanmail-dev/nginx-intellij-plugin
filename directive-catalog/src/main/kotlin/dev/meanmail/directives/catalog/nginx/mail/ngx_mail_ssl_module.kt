package dev.meanmail.directives.catalog.nginx.mail

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/mail/ngx_mail_ssl_module.html

val ngx_mail_ssl_module = NginxModule(
    name = "ngx_mail_ssl_module",
    description = "The SSL module for NGINX server configuration"
)

val mailSsl = Directive(
    name = "ssl",
    description = "Enables SSL for mail connections",
        context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslCertificate = Directive(
    name = "ssl_certificate",
    description = "Specifies the path to the SSL certificate file for mail",
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslCertificateKey = Directive(
    name = "ssl_certificate_key",
    description = "Specifies the path to the SSL certificate key file for mail",
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslCiphers = Directive(
    name = "ssl_ciphers",
    description = "Specifies the ciphers for SSL connections",
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslClientCertificate = Directive(
    name = "ssl_client_certificate",
    description = "Specifies the path to the client CA certificate file for $mail",
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslConfCommand = Directive(
    name = "ssl_conf_command",
    description = "Sets OpenSSL configuration commands",
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslCrl = Directive(
    name = "ssl_crl",
    description = "Specifies the path to the certificate revocation list (CRL)",
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslDhparam = Directive(
    name = "ssl_dhparam",
    description = "Specifies the path to the Diffie-Hellman parameters file",
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslEcdhCurve = Directive(
    name = "ssl_ecdh_curve",
    description = "Specifies the elliptic curve for ECDHE ciphers",
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslPasswordFile = Directive(
    name = "ssl_password_file",
    description = "Specifies the path to the file with SSL private key passwords",
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslPreferServerCiphers = Directive(
    name = "ssl_prefer_server_ciphers",
    description = "Enables server cipher preferences over client preferences",
        context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslProtocols = Directive(
    name = "ssl_protocols",
    description = "Specifies the SSL/TLS protocols to use",
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslSessionCache = Directive(
    name = "ssl_session_cache",
    description = "Configures the SSL session cache",
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslSessionTicketKey = Directive(
    name = "ssl_session_ticket_key",
    description = "Specifies the path to the SSL session ticket key file",
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslSessionTickets = Directive(
    name = "ssl_session_tickets",
    description = "Enables or disables SSL session tickets",
        context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslSessionTimeout = Directive(
    name = "ssl_session_timeout",
    description = "Sets the timeout for SSL sessions",
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslTrustedCertificate = Directive(
    name = "ssl_trusted_certificate",
    description = "Specifies the path to the trusted CA certificates file",
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslVerifyClient = Directive(
    name = "ssl_verify_client",
    description = "Configures client certificate verification",
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslVerifyDepth = Directive(
    name = "ssl_verify_depth",
    description = "Sets the maximum depth of CA certificate chain verification",
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val starttls = Directive(
    name = "starttls",
    description = "Configures STARTTLS support",
    context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)

val mailSslCertificateCompression = Directive(
    name = "ssl_certificate_compression",
    description = "Enables TLSv1.3 certificate compression (RFC 8879). Disabled by default since 1.29.1",
        context = listOf(mail, mailServer),
    module = ngx_mail_ssl_module
)
