package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_dav_module.html

val createFullPutPath = ToggleDirective("create_full_put_path", false)
val davAccess = Directive(
    "dav_access",
    defaultValue = "user:rw"
)
val davMethods = Directive(
    "dav_methods",
    defaultValue = "off"
)
val minDeleteDepth = Directive(
    "min_delete_depth",
    defaultValue = "0"
)

val ngx_http_dav_module = Module(
    "ngx_http_dav_module",
    enabled = false,
    directives = setOf(
        createFullPutPath,
        davAccess,
        davMethods,
        minDeleteDepth,
    )
)
