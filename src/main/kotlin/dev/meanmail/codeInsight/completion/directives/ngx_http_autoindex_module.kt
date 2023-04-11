package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_autoindex_module.html

val autoindex = ToggleDirective("autoindex", false)
val autoindexExactSize = ToggleDirective("autoindex_exact_size", true)
val autoindexFormat = Directive(
    "autoindex_format",
    setOf("html", "xml", "json", "jsonp"),
    defaultValue = "html"
)
val autoindexLocaltime = ToggleDirective("autoindex_localtime", false)

val ngx_http_autoindex_module = Module(
    "ngx_http_autoindex_module",
    enabled = true,
    directives = setOf(
        autoindex,
        autoindexExactSize,
        autoindexFormat,
        autoindexLocaltime,
    )
)
