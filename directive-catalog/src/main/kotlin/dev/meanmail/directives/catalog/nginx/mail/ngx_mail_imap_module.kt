package dev.meanmail.directives.catalog.nginx.mail

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/mail/ngx_mail_imap_module.html

val ngx_mail_imap_module = NginxModule(
    "ngx_mail_imap_module",
    description = "Module for handling IMAP protocol in NGINX mail proxy"
)

val imapAuth = Directive(
    name = "imap_auth",
    description = "Sets permitted methods of authentication for IMAP clients. Supported methods are: plain (LOGIN, AUTH=PLAIN), login (AUTH=LOGIN), cram-md5 (AUTH=CRAM-MD5), and external (AUTH=EXTERNAL)",
    context = listOf(mail, mailServer),
    module = ngx_mail_imap_module
)

val imapCapabilities = Directive(
    name = "imap_capabilities",
    description = "Sets the IMAP protocol extensions list passed to the client in response to the CAPABILITY command. Authentication methods and STARTTLS are automatically added based on configuration",
    context = listOf(mail, mailServer),
    module = ngx_mail_imap_module
)

val imapClientBuffer = Directive(
    name = "imap_client_buffer",
    description = "Sets the size of the buffer used for reading IMAP commands. Default size is equal to one memory page (4K or 8K depending on platform)",
    context = listOf(mail, mailServer),
    module = ngx_mail_imap_module
)
