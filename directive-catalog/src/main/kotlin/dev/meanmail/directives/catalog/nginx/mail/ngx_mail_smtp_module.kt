package dev.meanmail.directives.catalog.nginx.mail

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/mail/ngx_mail_smtp_module.html

val ngx_mail_smtp_module = NginxModule(
    name = "ngx_mail_smtp_module",
    description = "Module for configuring SMTP protocol support in NGINX mail proxy"
)

val smtpAuth = Directive(
    name = "smtp_auth",
    description = "Sets permitted methods of SASL authentication for SMTP clients",
    module = ngx_mail_smtp_module,
    context = listOf(mail, mailServer)
)

val smtpCapabilities = Directive(
    name = "smtp_capabilities",
    description = "Sets the SMTP protocol extensions list passed to the client in response to the EHLO command",
    module = ngx_mail_smtp_module,
    context = listOf(mail, mailServer)
)

val smtpClientBuffer = Directive(
    name = "smtp_client_buffer",
    description = "Sets the size of the buffer used for reading SMTP commands",
    module = ngx_mail_smtp_module,
    context = listOf(mail, mailServer)
)

val smtpGreetingDelay = Directive(
    name = "smtp_greeting_delay",
    description = "Sets a delay before sending an SMTP greeting to reject premature clients",
    module = ngx_mail_smtp_module,
    context = listOf(mail, mailServer)
)
