package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/mail/ngx_mail_core_module.html

val mailListen = Directive("listen")
val mailMaxErrors = Directive(
    "max_errors",
    defaultValue = "5"
)
val mailProtocol = Directive("protocol")
val mailResolver = Directive(
    "resolver",
    defaultValue = "off"
)
val mailResolverTimeout = Directive(
    "resolver_timeout",
    defaultValue = "30s"
)
val mailServerName = Directive(
    "server_name",
    defaultValue = ""
)
val mailTimeout = Directive(
    "timeout",
    defaultValue = "60s"
)
val mailServer = Directive(
    "server",
    children = setOf(
        imapAuth,
        imapCapabilities,
        imapClientBuffer,
        mailAuthHttp,
        mailAuthHttpHeader,
        mailAuthHttpPassClientCert,
        mailAuthHttpTimeout,
        mailListen,
        mailMaxErrors,
        mailProtocol,
        mailProxyBuffer,
        mailProxyPassErrorMessage,
        mailProxyProtocol,
        mailProxySmtpAuth,
        mailProxyTimeout,
        mailResolver,
        mailResolverTimeout,
        mailServerName,
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
        mailXclient,
        pop3Auth,
        pop3Capabilities,
        smtpAuth,
        smtpCapabilities,
        smtpClientBuffer,
        smtpGreetingDelay,
        starttls,
    )
)
val mail = Directive(
    "mail",
    children = setOf(
        errorLog,
        imapAuth,
        imapCapabilities,
        imapClientBuffer,
        mailAuthHttp,
        mailAuthHttpHeader,
        mailAuthHttpPassClientCert,
        mailAuthHttpTimeout,
        mailMaxErrors,
        mailProxyBuffer,
        mailProxyPassErrorMessage,
        mailProxyProtocol,
        mailProxySmtpAuth,
        mailProxyTimeout,
        mailResolver,
        mailResolverTimeout,
        mailServer,
        mailServerName,
        mailSetRealIpFrom,
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
        mailTimeout,
        mailXclient,
        pop3Auth,
        pop3Capabilities,
        smtpAuth,
        smtpCapabilities,
        smtpClientBuffer,
        smtpGreetingDelay,
        starttls,
    )
)

val ngx_mail_core_module = Module(
    "ngx_mail_core_module",
    enabled = false,
    directives = setOf(
        mail,
        mailListen,
        mailMaxErrors,
        mailProtocol,
        mailResolver,
        mailResolverTimeout,
        mailServer,
        mailServerName,
        mailTimeout,
    )
)
