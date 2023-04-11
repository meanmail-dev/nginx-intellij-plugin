package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_rewrite_module.html

val `break` = Directive("break")
val `return` = Directive("return")
val rewrite = Directive("rewrite")
val rewriteLog = ToggleDirective("rewrite_log", false)
val set = Directive("set")
val uninitializedVariableWarn = ToggleDirective("uninitialized_variable_warn", true)

val locationIf = Directive(
    "if",
    children = setOf(
        errorPage,
        limitRate,
        limitRateAfter,
        root,
        sendfile,
        statusZone,
        charset,
        overrideCharset,
        sourceCharset,
        fastcgiPass,
        grpcPass,
        gzip,
        expires,
        addTrailer,
        addHeader,
        accessLog,
        memcachedPass,
        proxyPass,
        scgiPass,
        ssi,
        `break`,
        `return`,
        rewrite,
        rewriteLog,
        set,
        uninitializedVariableWarn,
        uwsgiPass,
    )
)
val `if` = Directive(
    "if",
    children = setOf(
        `break`,
        `return`,
        rewrite,
        rewriteLog,
        set,
        uninitializedVariableWarn,
    )
)

val ngx_http_rewrite_module = Module(
    "ngx_http_rewrite_module",
    enabled = true,
    directives = setOf(
        `break`,
        `if`,
        `return`,
        locationIf,
        rewrite,
        rewriteLog,
        set,
        uninitializedVariableWarn,
    )
)
