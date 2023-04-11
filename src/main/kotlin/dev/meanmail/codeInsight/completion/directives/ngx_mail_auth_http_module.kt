package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/mail/ngx_mail_auth_http_module.html


val mailAuthHttp = Directive("auth_http")
val mailAuthHttpHeader = Directive("auth_http_header")
val mailAuthHttpPassClientCert = ToggleDirective(
    "auth_http_pass_client_cert",
    false
)
val mailAuthHttpTimeout = Directive(
    "auth_http_timeout",
    defaultValue = "60s"
)

val ngx_mail_auth_http_module = Module(
    "ngx_mail_auth_http_module",
    enabled = true,
    directives = setOf(
        mailAuthHttp,
        mailAuthHttpHeader,
        mailAuthHttpPassClientCert,
        mailAuthHttpTimeout,
    )
)
