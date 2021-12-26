package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_upstream_module.html

val streamUpstreamServer = Directive("server")
val streamUpstreamZone = Directive("zone")
val streamUpstreamState = Directive("state")
val streamUpstreamHash = Directive("hash")
val streamUpstreamLeastConn = Directive("least_conn")
val streamUpstreamLeastTime = Directive("least_time")
val streamUpstreamRandom = Directive("random")
val streamUpstreamResolver = Directive("resolver")
val streamUpstreamResolverTimeout = Directive(
    "resolver_timeout",
    defaultValue = "30s"
)

val streamUpstream = Directive(
    "upstream",
    children = setOf(
        streamUpstreamServer,
        streamUpstreamZone,
        streamUpstreamState,
        streamUpstreamHash,
        streamUpstreamLeastConn,
        streamUpstreamLeastTime,
        streamUpstreamRandom,
        streamUpstreamResolver,
        streamUpstreamResolverTimeout,
    )
)

val ngx_stream_upstream_module = Module(
    "ngx_stream_upstream_module",
    enabled = true,
    directives = setOf(
        streamUpstream,
        streamUpstreamHash,
        streamUpstreamLeastConn,
        streamUpstreamLeastTime,
        streamUpstreamRandom,
        streamUpstreamResolver,
        streamUpstreamResolverTimeout,
        streamUpstreamServer,
        streamUpstreamState,
        streamUpstreamZone,
    )
)
