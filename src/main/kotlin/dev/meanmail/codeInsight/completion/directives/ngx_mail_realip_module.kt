package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/mail/ngx_mail_realip_module.html

val mailSetRealIpFrom = Directive("set_real_ip_from")

val ngx_mail_realip_module = Module(
    "ngx_mail_realip_module",
    enabled = true,
    directives = setOf(
        mailSetRealIpFrom,
    )
)
