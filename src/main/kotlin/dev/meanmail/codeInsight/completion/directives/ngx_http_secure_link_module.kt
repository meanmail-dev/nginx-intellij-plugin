package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_secure_link_module.html

val secureLink = Directive("secure_link")
val secureLinkMd5 = Directive("secure_link_md5")
val secureLinkSecret = Directive("secure_link_secret")

val ngx_http_secure_link_module = Module(
    "ngx_http_secure_link_module",
    enabled = false,
    directives = setOf(
        secureLink,
        secureLinkMd5,
        secureLinkSecret,
    )
)
