package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_referer_module.html

val refererHashBucketSize = Directive(
    "referer_hash_bucket_size",
    defaultValue = "64"
)
val refererHashMaxSize = Directive(
    "referer_hash_max_size",
    defaultValue = "2048"
)
val validReferers = Directive("valid_referers")

val ngx_http_referer_module = Module(
    "ngx_http_referer_module",
    enabled = true,
    directives = setOf(
        refererHashBucketSize,
        refererHashMaxSize,
        validReferers,
    )
)
