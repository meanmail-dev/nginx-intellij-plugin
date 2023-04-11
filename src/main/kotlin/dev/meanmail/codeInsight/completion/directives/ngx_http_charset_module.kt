package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_charset_module.html

val charset = Directive(
    "charset",
    defaultValue = "off"
)
val charsetMap = Directive("charset_map")
val charsetTypes = Directive(
    "charset_types",
    defaultValue = "text/html text/xml text/plain text/vnd.wap.wml\n" +
            "application/javascript application/rss+xml"
)
val overrideCharset = ToggleDirective("override_charset", false)
val sourceCharset = Directive("source_charset")

val ngx_http_charset_module = Module(
    "ngx_http_charset_module",
    enabled = true,
    directives = setOf(
        charset,
        charsetMap,
        charsetTypes,
        overrideCharset,
        sourceCharset,
    )
)
