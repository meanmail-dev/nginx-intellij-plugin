package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_upstream_module.html

val upstreamServerResolve = Directive("resolve")
val upstreamServerResolverTimeout = Directive(
    "resolver_timeout", 
    defaultValue = "30s"
)

val upstreamServer = Directive(
    "server", 
    children = setOf(
        upstreamServerResolve,
        upstreamServerResolverTimeout
    )
)

val zone = Directive("zone")
val state = Directive("state")
val hash = Directive("hash")
val ipHash = Directive("ip_hash")
val keepalive = Directive("keepalive")
val upstreamKeepaliveRequests = Directive(
    "keepalive_requests",
    defaultValue = "1000"
)
val upstreamKeepaliveTime = Directive(
    "keepalive_time",
    defaultValue = "1h"
)
val upstreamKeepaliveTimeout = Directive(
    "keepalive_timeout",
    defaultValue = "60s"
)
val ntlm = Directive("ntlm")
val leastConn = Directive("least_conn")
val leastTime = Directive("least_time")
val queue = Directive("queue")
val random = Directive("random")
val upstreamResolver = Directive("resolver")
val upstreamResolverTimeout = Directive(
    "resolver_timeout",
    defaultValue = "30s"
)
val sticky = Directive("sticky")
val stickyCookieInsert = Directive("sticky_cookie_insert")

val upstream = Directive(
    "upstream",
    children = setOf(
        hash,
        ipHash,
        keepalive,
        leastConn,
        leastTime,
        ntlm,
        queue,
        random,
        state,
        sticky,
        stickyCookieInsert,
        upstreamKeepaliveRequests,
        upstreamKeepaliveTime,
        upstreamKeepaliveTimeout,
        upstreamResolver,
        upstreamResolverTimeout,
        upstreamServer,
        zone,
    )
)

val ngx_http_upstream_module = Module(
    "ngx_http_upstream_module",
    enabled = true,
    directives = setOf(
        hash,
        ipHash,
        keepalive,
        leastConn,
        leastTime,
        ntlm,
        queue,
        random,
        state,
        sticky,
        stickyCookieInsert,
        upstream,
        upstreamKeepaliveRequests,
        upstreamKeepaliveTime,
        upstreamKeepaliveTimeout,
        upstreamResolver,
        upstreamResolverTimeout,
        upstreamServer,
        zone,
    )
)
