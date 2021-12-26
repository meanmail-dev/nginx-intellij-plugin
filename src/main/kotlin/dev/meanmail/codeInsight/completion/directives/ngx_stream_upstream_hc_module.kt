package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_upstream_hc_module.html

val streamUpstreamHealthCheck = Directive("health_check")
val streamUpstreamHealthCheckTimeout = Directive(
    "health_check_timeout",
    defaultValue = "5s"
)
val streamUpstreamMatch = Directive("match")

val ngx_stream_upstream_hc_module = Module(
    "ngx_stream_upstream_hc_module",
    enabled = true,
    directives = setOf(
        streamUpstreamHealthCheck,
        streamUpstreamHealthCheckTimeout,
        streamUpstreamMatch,
    )
)
