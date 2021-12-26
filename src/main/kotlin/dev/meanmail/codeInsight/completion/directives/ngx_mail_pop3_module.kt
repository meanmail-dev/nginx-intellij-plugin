package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/mail/ngx_mail_pop3_module.html

val pop3Auth = Directive(
    "pop3_auth",
    defaultValue = "plain"
)

val pop3Capabilities = Directive(
    "pop3_capabilities",
    defaultValue = "TOP USER UIDL"
)

val ngx_mail_pop3_module = Module(
    "ngx_mail_pop3_module",
    enabled = true,
    directives = setOf(
        pop3Auth,
        pop3Capabilities,
    )
)
