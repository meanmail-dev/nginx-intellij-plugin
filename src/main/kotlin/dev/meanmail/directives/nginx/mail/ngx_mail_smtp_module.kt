package dev.meanmail.directives.nginx.mail

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/mail/ngx_mail_smtp_module.html

val ngx_mail_smtp_module = NginxModule(
    name = "ngx_mail_smtp_module",
    description = "Module for configuring SMTP protocol support in NGINX mail proxy",
    enabled = false
)

val smtpAuth = Directive(
    name = "smtp_auth",
    description = "Sets permitted methods of SASL authentication for SMTP clients",
    module = ngx_mail_smtp_module,
    parameters = listOf(
        DirectiveParameter(
            name = "method",
            description = "Authentication methods: plain, login, cram-md5, external, none",
            valueType = ValueType.STRING,
            required = true,
            multiple = true,
            allowedValues = listOf("plain", "login", "cram-md5", "external", "none"),
            defaultValue = "plain login"
        )
    ),
    context = listOf(mail, mailServer)
)

val smtpCapabilities = Directive(
    name = "smtp_capabilities",
    description = "Sets the SMTP protocol extensions list passed to the client in response to the EHLO command",
    module = ngx_mail_smtp_module,
    parameters = listOf(
        DirectiveParameter(
            name = "extension",
            description = "SMTP protocol extensions supported by the backend MTA",
            valueType = ValueType.STRING,
            required = true,
            multiple = true
        )
    ),
    context = listOf(mail, mailServer)
)

val smtpClientBuffer = Directive(
    name = "smtp_client_buffer",
    description = "Sets the size of the buffer used for reading SMTP commands",
    module = ngx_mail_smtp_module,
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Buffer size for SMTP commands",
            valueType = ValueType.SIZE,
            defaultValue = "4k|8k"
        )
    ),
    context = listOf(mail, mailServer)
)

val smtpGreetingDelay = Directive(
    name = "smtp_greeting_delay",
    description = "Sets a delay before sending an SMTP greeting to reject premature clients",
    module = ngx_mail_smtp_module,
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            description = "Delay time before SMTP greeting",
            valueType = ValueType.TIME,
            defaultValue = "0"
        )
    ),
    context = listOf(mail, mailServer)
)
