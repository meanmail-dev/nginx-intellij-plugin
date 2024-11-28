package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_ssl_module.html

val ssl = ToggleDirective("ssl", false)
val sslBufferSize = Directive(
    "ssl_buffer_size",
    defaultValue = "16k"
)
val sslCertificate = Directive("ssl_certificate")
val sslCertificateKey = Directive("ssl_certificate_key")
val sslCiphers = Directive(
    "ssl_ciphers",
    defaultValue = "HIGH:!aNULL:!MD5"
)
val sslClientCertificate = Directive("ssl_client_certificate")
val sslConfCommand = Directive("ssl_conf_command")
val sslCrl = Directive("ssl_crl")
val sslDhparam = Directive("ssl_dhparam")
val sslEarlyData = ToggleDirective("ssl_early_data", false)
val sslEcdhCurve = Directive(
    "ssl_ecdh_curve",
    defaultValue = "auto"
)
val sslOcsp = Directive(
    "ssl_ocsp",
    defaultValue = "off"
)
val sslOcspCache = Directive(
    "ssl_ocsp_cache",
    defaultValue = "off"
)
val sslOcspResponder = Directive("ssl_ocsp_responder")
val sslPasswordFile = Directive("ssl_password_file")
val sslPreferServerCiphers = ToggleDirective("ssl_prefer_server_ciphers", false)
val sslProtocols = Directive(
    "ssl_protocols",
    defaultValue = "TLSv1.2 TLSv1.3"
)
val sslRejectHandshake = ToggleDirective("ssl_reject_handshake", false)
val sslSessionCache = Directive(
    "ssl_session_cache",
    defaultValue = "none"
)
val sslSessionTicketKey = Directive("ssl_session_ticket_key")
val sslSessionTickets = ToggleDirective("ssl_session_tickets", true)
val sslSessionTimeout = Directive(
    "ssl_session_timeout",
    defaultValue = "5m"
)
val sslStapling = ToggleDirective("ssl_stapling", false)
val sslStaplingFile = Directive("ssl_stapling_file")
val sslStaplingResponder = Directive("ssl_stapling_responder")
val sslStaplingVerify = ToggleDirective("ssl_stapling_verify", false)
val sslTrustedCertificate = Directive("ssl_trusted_certificate")
val sslVerifyClient = Directive(
    "ssl_verify_client",
    defaultValue = "off"
)
val sslVerifyDepth = Directive(
    "ssl_verify_depth",
    defaultValue = "1"
)

val ngx_http_ssl_module = Module(
    "ngx_http_ssl_module",
    enabled = true,
    directives = setOf(
        ssl,
        sslBufferSize,
        sslCertificate,
        sslCertificateKey,
        sslCiphers,
        sslClientCertificate,
        sslConfCommand,
        sslCrl,
        sslDhparam,
        sslEarlyData,
        sslEcdhCurve,
        sslOcsp,
        sslOcspCache,
        sslOcspResponder,
        sslPasswordFile,
        sslPreferServerCiphers,
        sslProtocols,
        sslRejectHandshake,
        sslSessionCache,
        sslSessionTicketKey,
        sslSessionTickets,
        sslSessionTimeout,
        sslStapling,
        sslStaplingFile,
        sslStaplingResponder,
        sslStaplingVerify,
        sslTrustedCertificate,
        sslVerifyClient,
        sslVerifyDepth,
    )
)
