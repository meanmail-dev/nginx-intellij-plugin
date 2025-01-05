package dev.meanmail.directives.nginx.mail

import dev.meanmail.directives.*

// https://nginx.org/en/docs/mail/ngx_mail_proxy_module.html

val ngx_mail_proxy_module = NginxModule(
    name = "ngx_mail_proxy_module",
    description = "Module for proxying mail protocols in NGINX mail server",
    enabled = false
)

val proxyBuffer = Directive(
    name = "proxy_buffer",
    description = "Sets the size of the buffer used for proxying. Default size is equal to one memory page (4K or 8K depending on platform)",
    module = ngx_mail_proxy_module,
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Buffer size for proxying",
            valueType = ValueType.SIZE,
            required = true,
            defaultValue = "4k|8k"
        )
    ),
    context = listOf(mail, mailServer)
)

val proxyPassErrorMessage = ToggleDirective(
    name = "proxy_pass_error_message",
    description = "Indicates whether to pass the error message obtained during backend authentication to the client. Default is off to prevent exposing internal error details",
    module = ngx_mail_proxy_module,
    context = listOf(mail, mailServer),
    enabled = false
)

val proxyProtocol = ToggleDirective(
    name = "proxy_protocol",
    description = "Enables the PROXY protocol for connections to a backend. Default is off",
    module = ngx_mail_proxy_module,
    context = listOf(mail, mailServer),
    enabled = false
)

val proxySmtpAuth = ToggleDirective(
    name = "proxy_smtp_auth",
    description = "Enables or disables user authentication on the SMTP backend using the AUTH command. Default is off",
    module = ngx_mail_proxy_module,
    context = listOf(mail, mailServer),
    enabled = false
)

val proxyTimeout = Directive(
    name = "proxy_timeout",
    description = "Sets the timeout between two successive read or write operations on client or proxied server connections. If no data is transmitted within this time, the connection is closed",
    module = ngx_mail_proxy_module,
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Connection timeout duration",
            valueType = ValueType.TIME,
            required = true,
            defaultValue = "24h"
        )
    ),
    context = listOf(mail, mailServer)
)

val xclient = ToggleDirective(
    name = "xclient",
    description = "Enables or disables the passing of the XCLIENT command with client parameters when connecting to the SMTP backend. Default is on",
    module = ngx_mail_proxy_module,
    context = listOf(mail, mailServer),
    enabled = true
)
