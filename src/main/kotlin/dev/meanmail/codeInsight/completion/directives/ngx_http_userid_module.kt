package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_userid_module.html

val userid = Directive(
    "userid",
    defaultValue = "off"
)
val useridDomain = Directive(
    "userid_domain",
    defaultValue = "none"
)
val useridFlags = Directive(
    "userid_flags",
    defaultValue = "off"
)
val useridMark = Directive(
    "userid_mark",
    defaultValue = "off"
)
val useridName = Directive(
    "userid_name",
    defaultValue = "off"
)
val useridP3P = Directive(
    "userid_p3p",
    defaultValue = "none"
)
val useridPath = Directive(
    "userid_path",
    defaultValue = "/"
)
val useridService = Directive("userid_service")

val ngx_http_userid_module = Module(
    "ngx_http_userid_module",
    enabled = true,
    directives = setOf(
        userid,
        useridDomain,
        useridFlags,
        useridMark,
        useridName,
        useridP3P,
        useridPath,
        useridService,
    )
)
