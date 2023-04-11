package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_ssl_module.html

val streamSslAlpn = Directive("ssl_alpn")
val streamSslCertificate = Directive("ssl_certificate")
val streamSslCertificateKey = Directive("ssl_certificate_key")
val streamSslCiphers = Directive(
    "ssl_ciphers",
    defaultValue = "HIGH:!aNULL:!MD5"
)
val streamSslClientCertificate = Directive("ssl_client_certificate")
val streamSslConfCommand = Directive("ssl_conf_command")
val streamSslCrl = Directive("ssl_crl")
val streamSslDhparam = Directive("ssl_dhparam")
val streamSslEcdhCurve = Directive(
    "ssl_ecdh_curve",
    defaultValue = "auto"
)
val streamSslHandshakeTimeout = Directive(
    "ssl_handshake_timeout",
    defaultValue = "60s"
)
val streamSslPasswordFile = Directive("ssl_password_file")
val streamSslPreferServerCiphers = ToggleDirective("ssl_prefer_server_ciphers", false)
val streamSslProtocols = Directive(
    "ssl_protocols",
    defaultValue = "TLSv1 TLSv1.1 TLSv1.2"
)
val streamSslSessionCache = Directive(
    "ssl_session_cache",
    defaultValue = "none"
)
val streamSslSessionTicketKey = Directive("ssl_session_ticket_key")
val streamSslSessionTickets = ToggleDirective("ssl_session_tickets", true)
val streamSslSessionTimeout = Directive(
    "ssl_session_timeout",
    defaultValue = "5m"
)
val streamSslTrustedCertificate = Directive("ssl_trusted_certificate")
val streamSslVerifyClient = Directive(
    "ssl_verify_client",
    defaultValue = "off"
)
val streamSslVerifyDepth = Directive(
    "ssl_verify_depth",
    defaultValue = "1"
)

val ngx_stream_ssl_module = Module(
    "ngx_stream_ssl_module",
    enabled = false,
    directives = setOf(
        streamSslAlpn,
        streamSslCertificate,
        streamSslCertificateKey,
        streamSslCiphers,
        streamSslClientCertificate,
        streamSslConfCommand,
        streamSslCrl,
        streamSslDhparam,
        streamSslEcdhCurve,
        streamSslHandshakeTimeout,
        streamSslPasswordFile,
        streamSslPreferServerCiphers,
        streamSslProtocols,
        streamSslSessionCache,
        streamSslSessionTicketKey,
        streamSslSessionTickets,
        streamSslSessionTimeout,
        streamSslTrustedCertificate,
        streamSslVerifyClient,
        streamSslVerifyDepth,
    )
)
