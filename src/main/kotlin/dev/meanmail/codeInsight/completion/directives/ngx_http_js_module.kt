package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_js_module.html

val jsBodyFilter = Directive("js_body_filter")
val jsContent = Directive("js_content")
val jsFetchCiphers = Directive(
    "js_fetch_ciphers",
    defaultValue = "HIGH:!aNULL:!MD5"
)
val jsFetchProtocols = Directive(
    "js_fetch_protocols",
    defaultValue = "TLSv1 TLSv1.1 TLSv1.2"
)
val jsFetchTrustedCertificate = Directive("js_fetch_trusted_certificate")
val jsFetchVerifyDepth = Directive(
    "js_fetch_verify_depth",
    defaultValue = "100"
)
val jsHeaderFilter = Directive("js_header_filter")
val jsImport = Directive("js_import")
val jsInclude = Directive("js_include")
val jsPath = Directive("js_path")
val jsSet = Directive("js_set")
val jsVar = Directive("js_var")

val ngx_http_js_module = Module(
    "ngx_http_js_module",
    enabled = true,
    directives = setOf(
        jsBodyFilter,
        jsContent,
        jsFetchCiphers,
        jsFetchProtocols,
        jsFetchTrustedCertificate,
        jsFetchVerifyDepth,
        jsHeaderFilter,
        jsImport,
        jsInclude,
        jsPath,
        jsSet,
        jsVar,
    )
)
