package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/mail/ngx_mail_realip_module.html

val ngx_mail_realip_module = NginxModule(
    "ngx_mail_realip_module",
    description = "Module for changing client address and port sent in the PROXY protocol header",
    enabled = false
)

val mailSetRealIpFrom = Directive(
    name = "set_real_ip_from",
    description = "Defines trusted addresses that are known to send correct replacement addresses",
    module = ngx_mail_realip_module,
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            description = "Trusted IP address, CIDR range, or 'unix:' for all UNIX-domain sockets",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(mail, mailServer)
)
