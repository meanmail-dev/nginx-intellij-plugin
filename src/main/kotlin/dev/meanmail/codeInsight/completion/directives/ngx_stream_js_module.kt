package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_js_module.html

val streamJsAccess = Directive("js_access")
val streamJsFetchCiphers = Directive(
    "js_fetch_ciphers",
    defaultValue = "HIGH:!aNULL:!MD5"
)
val streamJsFetchProtocols = Directive(
    "js_fetch_protocols",
    defaultValue = "TLSv1 TLSv1.1 TLSv1.2"
)
val streamJsFetchTrustedCertificate = Directive("js_fetch_trusted_certificate")
val streamJsFetchVerifyDepth = Directive(
    "js_fetch_verify_depth",
    defaultValue = "100"
)
val streamJsFilter = Directive("js_filter")
val streamJsImport = Directive("js_import")
val streamJsInclude = Directive("js_include")
val streamJsPath = Directive("js_path")
val streamJsPreread = Directive("js_preread")
val streamJsSet = Directive("js_set")
val streamJsVar = Directive("js_var")

val ngx_stream_js_module = Module(
    "ngx_stream_js_module",
    enabled = true,
    directives = setOf(
        streamJsAccess,
        streamJsFetchCiphers,
        streamJsFetchProtocols,
        streamJsFetchTrustedCertificate,
        streamJsFetchVerifyDepth,
        streamJsFilter,
        streamJsImport,
        streamJsInclude,
        streamJsPath,
        streamJsPreread,
        streamJsSet,
        streamJsVar,
    )
)
