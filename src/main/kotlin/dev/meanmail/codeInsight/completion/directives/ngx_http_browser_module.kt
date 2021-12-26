package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_browser_module.html

val ancientBrowser = Directive("ancient_browser")
val ancientBrowserValue = Directive(
    "ancient_browser_value",
    defaultValue = "1"
)
val modernBrowser = Directive("modern_browser")
val modernBrowserValue = Directive(
    "modern_browser_value",
    defaultValue = "1"
)

val ngx_http_browser_module = Module(
    "ngx_http_browser_module",
    enabled = true,
    directives = setOf(
        ancientBrowser,
        ancientBrowserValue,
        modernBrowser,
        modernBrowserValue,
    )
)
