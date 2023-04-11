package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_upstream_conf_module.html

val upstreamConf = Directive("upstream_conf")

val ngx_http_upstream_conf_module = Module(
    "ngx_http_upstream_conf_module",
    enabled = true,
    directives = setOf(
        upstreamConf,
    )
)
