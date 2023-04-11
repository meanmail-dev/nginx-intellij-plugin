package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/mail/ngx_mail_smtp_module.html

val smtpAuth = Directive(
    "imap_auth",
    defaultValue = "plain login"
)
val smtpCapabilities = Directive("smtp_capabilities")
val smtpClientBuffer = Directive("smtp_client_buffer")
val smtpGreetingDelay = Directive(
    "smtp_greeting_delay",
    defaultValue = "0"
)

val ngx_mail_smtp_module = Module(
    "ngx_mail_smtp_module",
    enabled = true,
    directives = setOf(
        smtpAuth,
        smtpCapabilities,
        smtpClientBuffer,
        smtpGreetingDelay,
    )
)
