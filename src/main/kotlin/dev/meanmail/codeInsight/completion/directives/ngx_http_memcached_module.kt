package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_memcached_module.html

val memcachedBind = Directive("memcached_bind")
val memcachedBufferSize = Directive("memcached_buffer_size")
val memcachedConnectTimeout = Directive(
    "memcached_connect_timeout",
    defaultValue = "60s"
)
val memcachedForceRanges = ToggleDirective("memcached_force_ranges", false)
val memcachedGzipFlag = Directive("memcached_gzip_flag")
val memcachedNextUpstream = Directive(
    "memcached_next_upstream",
    defaultValue = "error timeout"
)
val memcachedNextUpstreamTimeout = Directive(
    "memcached_next_upstream_timeout",
    defaultValue = "0"
)
val memcachedNextUpstreamTries = Directive(
    "memcached_next_upstream_tries",
    defaultValue = "0"
)
val memcachedPass = Directive("memcached_pass")
val memcachedReadTimeout = Directive(
    "memcached_read_timeout",
    defaultValue = "60s"
)
val memcachedSendTimeout = Directive(
    "memcached_send_timeout",
    defaultValue = "60s"
)
val memcachedSocketKeepalive = ToggleDirective("memcached_socket_keepalive", false)

val ngx_http_memcached_module = Module(
    "ngx_http_memcached_module",
    enabled = true,
    directives = setOf(
        memcachedBind,
        memcachedBufferSize,
        memcachedConnectTimeout,
        memcachedForceRanges,
        memcachedGzipFlag,
        memcachedNextUpstream,
        memcachedNextUpstreamTimeout,
        memcachedNextUpstreamTries,
        memcachedPass,
        memcachedReadTimeout,
        memcachedSendTimeout,
        memcachedSocketKeepalive,
    )
)
