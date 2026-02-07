package dev.meanmail.directives.catalog.nginx.mail

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/mail/ngx_mail_core_module.html

val ngx_mail_core_module = NginxModule(
    "ngx_mail_core_module",
    description = "Core module for NGINX mail server configuration"
)


val mail = Directive(
    name = "mail",
    description = "Provides configuration context for mail server directives",

    context = listOf(main),
    module = ngx_mail_core_module
)

val mailServer = Directive(
    name = "server",
    description = "Configures a mail server block",

    context = listOf(mail),
    module = ngx_mail_core_module
)

val mailListen = Directive(
    name = "listen",
    description = "Sets the address and port for the mail server socket",
    context = listOf(mailServer),
    module = ngx_mail_core_module
)

val mailMaxErrors = Directive(
    name = "max_errors",
    description = "Sets the number of protocol errors before closing the connection",
    context = listOf(mail, mailServer),
    module = ngx_mail_core_module
)

val mailProtocol = Directive(
    name = "protocol",
    description = "Specifies the mail protocol to use",
    context = listOf(mailServer),
    module = ngx_mail_core_module
)

val mailResolver = Directive(
    name = "resolver",
    description = "Defines DNS servers used to resolve hostnames",
    context = listOf(mail, mailServer),
    module = ngx_mail_core_module
)

val mailResolverTimeout = Directive(
    name = "resolver_timeout",
    description = "Sets the resolution timeout for DNS queries",
    context = listOf(mail, mailServer),
    module = ngx_mail_core_module
)

val mailServerName = Directive(
    name = "server_name",
    description = "Sets the server name for mail server",
    context = listOf(mail, mailServer),
    module = ngx_mail_core_module
)

val mailTimeout = Directive(
    name = "timeout",
    description = "Sets the timeout for mail server connections",
    context = listOf(mail, mailServer),
    module = ngx_mail_core_module
)
