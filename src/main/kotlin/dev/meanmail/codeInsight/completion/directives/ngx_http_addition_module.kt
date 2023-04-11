package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_addition_module.html

val addAfterBody = Directive("add_after_body")
val addBeforeBody = Directive("add_before_body")
val additionTypes = Directive(
    "addition_types",
    defaultValue = "text/html"
)

val ngx_http_addition_module = Module(
    "ngx_http_addition_module",
    enabled = false,
    directives = setOf(
        addAfterBody,
        addBeforeBody,
        additionTypes,
    )
)
