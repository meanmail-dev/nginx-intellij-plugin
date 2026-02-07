package dev.meanmail.directives.catalog.nginx.mail

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/mail/ngx_mail_auth_http_module.html

val ngx_mail_auth_http_module = NginxModule(
    "ngx_mail_auth_http_module",
    description = "HTTP authentication module for mail servers"
)

val mailAuthHttp = Directive(
    name = "auth_http",
    description = "Sets the URL of the HTTP authentication server for mail authentication",
    context = listOf(mail, mailServer),
    module = ngx_mail_auth_http_module
)

val mailAuthHttpHeader = Directive(
    name = "auth_http_header",
    description = "Appends a specified header to requests sent to the authentication server",
    context = listOf(mail, mailServer),
    module = ngx_mail_auth_http_module
)

val mailAuthHttpPassClientCert = Directive(
    name = "auth_http_pass_client_cert",
    description = "Appends client SSL certificate to requests sent to the authentication server",
    context = listOf(mail, mailServer),
        module = ngx_mail_auth_http_module
)

val mailAuthHttpTimeout = Directive(
    name = "auth_http_timeout",
    description = "Sets the timeout for communication with the authentication server",
    context = listOf(mail, mailServer),
    module = ngx_mail_auth_http_module
)
