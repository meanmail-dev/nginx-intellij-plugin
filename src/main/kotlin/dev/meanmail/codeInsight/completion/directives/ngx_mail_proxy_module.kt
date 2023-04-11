package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/mail/ngx_mail_proxy_module.html

val mailProxyBuffer = Directive("proxy_buffer")
val mailProxyPassErrorMessage = ToggleDirective("proxy_pass_error_message", false)
val mailProxyProtocol = ToggleDirective("proxy_protocol", false)
val mailProxySmtpAuth = ToggleDirective("proxy_smtp_auth", false)
val mailProxyTimeout = Directive(
    "proxy_timeout",
    defaultValue = "24h"
)
val mailXclient = ToggleDirective("xclient", true)

val ngx_mail_proxy_module = Module(
    "ngx_mail_proxy_module",
    enabled = true,
    directives = setOf(
        mailProxyBuffer,
        mailProxyPassErrorMessage,
        mailProxyProtocol,
        mailProxySmtpAuth,
        mailProxyTimeout,
        mailXclient,
    )
)
