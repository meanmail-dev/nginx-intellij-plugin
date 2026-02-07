package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_memcached_module.html

val ngx_http_memcached_module = NginxModule(
    name = "ngx_http_memcached_module",
    description = "Obtains responses from a Memcached server using the \$memcached_key variable"
)

val memcachedBind = Directive(
    name = "memcached_bind",
    description = "Specifies the local IP address for outgoing connections to a Memcached server",
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedBufferSize = Directive(
    name = "memcached_buffer_size",
    description = "Sets the buffer size for reading response from the Memcached server",
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedConnectTimeout = Directive(
    name = "memcached_connect_timeout",
    description = "Sets the timeout for establishing a connection to the Memcached server",
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedForceRanges = Directive(
    name = "memcached_force_ranges",
    description = "Enables forced range requests for Memcached content",
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedGzipFlag = Directive(
    name = "memcached_gzip_flag",
    description = "Sets a flag to test for compressed content in Memcached response",
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedNextUpstream = Directive(
    name = "memcached_next_upstream",
    description = "Defines conditions for failing over to another Memcached server",
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedNextUpstreamTimeout = Directive(
    name = "memcached_next_upstream_timeout",
    description = "Sets the maximum time for attempting to select a next upstream server",
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedNextUpstreamTries = Directive(
    name = "memcached_next_upstream_tries",
    description = "Limits the number of attempts to select an upstream server",
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedPass = Directive(
    name = "memcached_pass",
    description = "Defines the Memcached server address for retrieving cached content",
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedReadTimeout = Directive(
    name = "memcached_read_timeout",
    description = "Sets the timeout for reading response from the Memcached server",
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedSendTimeout = Directive(
    name = "memcached_send_timeout",
    description = "Sets the timeout for sending requests to the Memcached server",
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedSocketKeepalive = Directive(
    name = "memcached_socket_keepalive",
    description = "Enables TCP keepalive for Memcached server connections",
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)
