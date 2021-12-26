package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/mail/ngx_mail_imap_module.html

val imapAuth = Directive(
    "imap_auth",
    defaultValue = "plain"
)
val imapCapabilities = Directive(
    "imap_capabilities",
    defaultValue = "IMAP4 IMAP4rev1 UIDPLUS"
)
val imapClientBuffer = Directive("imap_client_buffer")

val ngx_mail_imap_module = Module(
    "ngx_mail_imap_module",
    enabled = true,
    directives = setOf(
        imapAuth,
        imapCapabilities,
        imapClientBuffer,
    )
)
