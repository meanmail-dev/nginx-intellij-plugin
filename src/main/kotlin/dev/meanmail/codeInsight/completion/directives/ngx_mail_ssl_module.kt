package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/mail/ngx_mail_ssl_module.html

val mailSsl = ToggleDirective("ssl", false)
val mailSslCertificate = Directive("ssl_certificate")
val mailSslCertificateKey = Directive("ssl_certificate_key")
val mailSslCiphers = Directive(
    "ssl_ciphers",
    defaultValue = "HIGH:!aNULL:!MD5"
)
val mailSslClientCertificate = Directive("ssl_client_certificate")
val mailSslConfCommand = Directive("ssl_conf_command")
val mailSslCrl = Directive("ssl_crl")
val mailSslDhparam = Directive("ssl_dhparam")
val mailSslEcdhCurve = Directive(
    "ssl_ecdh_curve",
    defaultValue = "auto"
)
val mailSslPasswordFile = Directive("ssl_password_file")
val mailSslPreferServerCiphers = ToggleDirective("ssl_prefer_server_ciphers", false)
val mailSslProtocols = Directive(
    "ssl_protocols",
    defaultValue = "TLSv1.2 TLSv1.3"
)
val mailSslSessionCache = Directive(
    "ssl_session_cache",
    defaultValue = "none"
)
val mailSslSessionTicketKey = Directive("ssl_session_ticket_key")
val mailSslSessionTickets = ToggleDirective("ssl_session_tickets", true)
val mailSslSessionTimeout = Directive(
    "ssl_session_timeout",
    defaultValue = "5m"
)
val mailSslTrustedCertificate = Directive("ssl_trusted_certificate")
val mailSslVerifyClient = Directive(
    "ssl_verify_client",
    defaultValue = "off"
)
val mailSslVerifyDepth = Directive(
    "ssl_verify_depth",
    defaultValue = "1"
)
val starttls = Directive(
    "starttls",
    defaultValue = "off"
)

val ngx_mail_ssl_module = Module(
    "ngx_mail_ssl_module",
    enabled = true,
    directives = setOf(
        mailSsl,
        mailSslCertificate,
        mailSslCertificateKey,
        mailSslCiphers,
        mailSslClientCertificate,
        mailSslConfCommand,
        mailSslCrl,
        mailSslDhparam,
        mailSslEcdhCurve,
        mailSslPasswordFile,
        mailSslPreferServerCiphers,
        mailSslProtocols,
        mailSslSessionCache,
        mailSslSessionTicketKey,
        mailSslSessionTickets,
        mailSslSessionTimeout,
        mailSslTrustedCertificate,
        mailSslVerifyClient,
        mailSslVerifyDepth,
        starttls,
    )
)
