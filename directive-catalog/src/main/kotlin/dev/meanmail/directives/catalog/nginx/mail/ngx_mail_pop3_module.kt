package dev.meanmail.directives.catalog.nginx.mail

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/mail/ngx_mail_pop3_module.html

val ngx_mail_pop3_module = NginxModule(
    "ngx_mail_pop3_module",
    description = "Module for handling POP3 protocol in NGINX mail proxy"
)

val pop3Auth = Directive(
    name = "pop3_auth",
    description = "Sets permitted methods of authentication for POP3 clients. Supported methods are: plain (USER/PASS, AUTH PLAIN, AUTH LOGIN), apop (APOP), cram-md5 (AUTH CRAM-MD5), and external (AUTH EXTERNAL)",
    context = listOf(mail, mailServer),
    module = ngx_mail_pop3_module
)

val pop3Capabilities = Directive(
    name = "pop3_capabilities",
    description = "Sets the POP3 protocol extensions list passed to the client in response to the CAPA command. Authentication methods and STLS are automatically added based on configuration",
    context = listOf(mail, mailServer),
    module = ngx_mail_pop3_module
)
