package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_perl_module.html

val perl = Directive("perl")
val perlModules = Directive("perl_modules")
val perlRequire = Directive("perl_require")
val perlSet = Directive("perl_set")

val ngx_http_perl_module = Module(
    "ngx_http_perl_module",
    enabled = false,
    directives = setOf(
        perl,
        perlModules,
        perlRequire,
        perlSet,
    )
)
