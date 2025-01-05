package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/http/ngx_http_memcached_module.html

val ngx_http_memcached_module = NginxModule(
    name = "ngx_http_memcached_module",
    description = "Obtains responses from a Memcached server using the \$memcached_key variable",
    enabled = true
)

val memcachedBind = Directive(
    name = "memcached_bind",
    description = "Specifies the local IP address for outgoing connections to a Memcached server",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            description = "Local IP address to bind, can include 'transparent' or 'off'",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedBufferSize = Directive(
    name = "memcached_buffer_size",
    description = "Sets the buffer size for reading response from the Memcached server",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Buffer size for reading Memcached response",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "4k|8k"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedConnectTimeout = Directive(
    name = "memcached_connect_timeout",
    description = "Sets the timeout for establishing a connection to the Memcached server",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Connection timeout duration (usually not exceeding 75 seconds)",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "60s"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedForceRanges = Directive(
    name = "memcached_force_ranges",
    description = "Enables forced range requests for Memcached content",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            description = "Enable or disable forced range requests",
            valueType = ValueType.BOOLEAN,
            required = true,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedGzipFlag = Directive(
    name = "memcached_gzip_flag",
    description = "Sets a flag to test for compressed content in Memcached response",
    parameters = listOf(
        DirectiveParameter(
            name = "flag",
            description = "Flag value indicating compressed response",
            valueType = ValueType.NUMBER,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedNextUpstream = Directive(
    name = "memcached_next_upstream",
    description = "Defines conditions for failing over to another Memcached server",
    parameters = listOf(
        DirectiveParameter(
            name = "conditions",
            description = "Conditions that trigger failover (error, timeout, invalid_response, not_found, off)",
            valueType = ValueType.STRING_LIST,
            required = false,
            defaultValue = "error timeout",
            allowedValues = listOf("error", "timeout", "invalid_response", "not_found", "off")
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedNextUpstreamTimeout = Directive(
    name = "memcached_next_upstream_timeout",
    description = "Sets the maximum time for attempting to select a next upstream server",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Maximum time for upstream server selection",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "0"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedNextUpstreamTries = Directive(
    name = "memcached_next_upstream_tries",
    description = "Limits the number of attempts to select an upstream server",
    parameters = listOf(
        DirectiveParameter(
            name = "tries",
            description = "Maximum number of upstream server selection attempts",
            valueType = ValueType.NUMBER,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedPass = Directive(
    name = "memcached_pass",
    description = "Defines the Memcached server address for retrieving cached content",
    parameters = listOf(
        DirectiveParameter(
            name = "server_address",
            description = "Address of the Memcached server (hostname, IP, or socket)",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedReadTimeout = Directive(
    name = "memcached_read_timeout",
    description = "Sets the timeout for reading response from the Memcached server",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Read timeout duration",
            valueType = ValueType.TIME,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedSendTimeout = Directive(
    name = "memcached_send_timeout",
    description = "Sets the timeout for sending requests to the Memcached server",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Send timeout duration",
            valueType = ValueType.TIME,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)

val memcachedSocketKeepalive = Directive(
    name = "memcached_socket_keepalive",
    description = "Enables TCP keepalive for Memcached server connections",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            description = "Enable or disable TCP keepalive",
            valueType = ValueType.BOOLEAN,
            required = true,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_memcached_module
)
