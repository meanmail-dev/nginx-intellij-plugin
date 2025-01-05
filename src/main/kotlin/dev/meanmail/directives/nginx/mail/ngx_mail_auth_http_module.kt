package dev.meanmail.directives.nginx.mail

import dev.meanmail.directives.*

// https://nginx.org/en/docs/mail/ngx_mail_auth_http_module.html

val ngx_mail_auth_http_module = NginxModule(
    "ngx_mail_auth_http_module",
    description = "HTTP authentication module for mail servers",
    enabled = true
)

val mailAuthHttp = Directive(
    name = "auth_http",
    description = "Sets the URL of the HTTP authentication server for mail authentication",
    parameters = listOf(
        DirectiveParameter(
            name = "url",
            description = "Full URL of the HTTP authentication server",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_auth_http_module
)

val mailAuthHttpHeader = Directive(
    name = "auth_http_header",
    description = "Appends a specified header to requests sent to the authentication server",
    parameters = listOf(
        DirectiveParameter(
            name = "header",
            description = "Custom header to be added to the authentication request",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "value",
            description = "Value of the custom header",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_auth_http_module
)

val mailAuthHttpPassClientCert = ToggleDirective(
    name = "auth_http_pass_client_cert",
    description = "Appends client SSL certificate to requests sent to the authentication server",
    context = listOf(mail, mailServer),
    enabled = false,
    module = ngx_mail_auth_http_module
)

val mailAuthHttpTimeout = Directive(
    name = "auth_http_timeout",
    description = "Sets the timeout for communication with the authentication server",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            description = "Timeout duration for HTTP authentication requests",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "60s"
        )
    ),
    context = listOf(mail, mailServer),
    module = ngx_mail_auth_http_module
)
