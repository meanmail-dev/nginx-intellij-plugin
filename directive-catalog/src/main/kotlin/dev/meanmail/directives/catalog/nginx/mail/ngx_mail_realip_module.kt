package dev.meanmail.directives.catalog.nginx.mail

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/mail/ngx_mail_realip_module.html

val ngx_mail_realip_module = NginxModule(
    "ngx_mail_realip_module",
    description = "Module for changing client address and port sent in the PROXY protocol header"
)

val mailSetRealIpFrom = Directive(
    name = "set_real_ip_from",
    description = "Defines trusted addresses that are known to send correct replacement addresses",
    module = ngx_mail_realip_module,
    context = listOf(mail, mailServer)
)
