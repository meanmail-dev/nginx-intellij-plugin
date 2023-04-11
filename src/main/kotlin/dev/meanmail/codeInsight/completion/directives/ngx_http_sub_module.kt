package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_sub_module.html

val subFilter = Directive("sub_filter")
val subFilterLastModified = ToggleDirective("sub_filter_last_modified", false)
val subFilterOnce = ToggleDirective("sub_filter_once", true)
val subFilterTypes = Directive(
    "sub_filter_types",
    defaultValue = "text/html"
)

val ngx_http_sub_module = Module(
    "ngx_http_sub_module",
    enabled = false,
    directives = setOf(
        subFilter,
        subFilterLastModified,
        subFilterOnce,
        subFilterTypes,
    )
)
