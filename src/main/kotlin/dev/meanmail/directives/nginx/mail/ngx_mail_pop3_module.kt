package dev.meanmail.directives.nginx.mail

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/mail/ngx_mail_pop3_module.html

val ngx_mail_pop3_module = NginxModule(
    "ngx_mail_pop3_module",
    description = "Module for handling POP3 protocol in NGINX mail proxy",
    enabled = false
)

val pop3Auth = Directive(
    name = "pop3_auth",
    description = "Sets permitted methods of authentication for POP3 clients. Supported methods are: plain (USER/PASS, AUTH PLAIN, AUTH LOGIN), apop (APOP), cram-md5 (AUTH CRAM-MD5), and external (AUTH EXTERNAL)",
    parameters = listOf(
        DirectiveParameter(
            name = "method",
            description = "Authentication method for POP3 clients",
            valueType = ValueType.STRING,
            required = true,
            allowedValues = listOf("plain", "apop", "cram-md5", "external"),
            defaultValue = "plain"
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_pop3_module
)

val pop3Capabilities = Directive(
    name = "pop3_capabilities",
    description = "Sets the POP3 protocol extensions list passed to the client in response to the CAPA command. Authentication methods and STLS are automatically added based on configuration",
    parameters = listOf(
        DirectiveParameter(
            name = "extension",
            description = "POP3 protocol extension supported by the server",
            valueType = ValueType.STRING,
            required = true,
            defaultValue = "TOP USER UIDL"
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_pop3_module
)
