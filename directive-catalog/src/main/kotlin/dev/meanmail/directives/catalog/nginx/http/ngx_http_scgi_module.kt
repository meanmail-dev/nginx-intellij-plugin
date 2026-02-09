package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/http/ngx_http_scgi_module.html

val ngx_http_scgi_module = NginxModule(
    name = "ngx_http_scgi_module",
    description = """
        Allows passing requests to an SCGI server.
        
        Features:
        - Proxies requests to SCGI servers
        - Supports response buffering and caching
        - Provides connection management and failover
        - Allows customizing request parameters and headers
    """.trimIndent()
)

val scgiBind = Directive(
    name = "scgi_bind",
    description = "Specifies the local IP address and optional port for outgoing connections to the SCGI server",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiBufferSize = Directive(
    name = "scgi_buffer_size",
    description = "Sets the buffer size for reading the first part of the response from the SCGI server",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiBuffering = Directive(
    name = "scgi_buffering",
    description = """
        Enables or disables buffering of responses from the SCGI server.
        
        When buffering is enabled, nginx receives response as soon as possible, saving it 
        into buffers set by scgi_buffer_size and scgi_buffers directives.
        
        When disabled, response is passed to client synchronously, as it is received.
    """.trimIndent(),
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiBuffers = Directive(
    name = "scgi_buffers",
    description = "Configures the number and size of buffers for reading SCGI server responses",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiBusyBuffersSize = Directive(
    name = "scgi_busy_buffers_size",
    description = "Limits the total size of buffers that can be busy sending a response while the full response is not yet read",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiCache = Directive(
    name = "scgi_cache",
    description = """
        Defines a shared memory zone used for caching. 
        Same zone can be used in several places.
        The 'off' parameter disables caching inherited from previous level.
    """.trimIndent(),
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiCacheBackgroundUpdate = Directive(
    name = "scgi_cache_background_update",
    description = """
        Allows starting a background subrequest to update an expired cache item,
        while a stale cached response is returned to the client.
        
        Note that it is necessary to allow usage of a stale cached response
        when it is being updated.
    """.trimIndent(),
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiCacheBypass = Directive(
    name = "scgi_cache_bypass",
    description = "Defines conditions for bypassing the cache and directly requesting from the SCGI server",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiCacheKey = Directive(
    name = "scgi_cache_key",
    description = "Defines the key for caching SCGI server responses",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiCacheLock = Directive(
    name = "scgi_cache_lock",
    description = """
        When enabled, only one request at a time will be allowed to populate
        a new cache element identified according to the scgi_cache_key directive.
        
        Other requests of the same cache element will either wait for:
        - Response to appear in the cache
        - Cache lock to be released (up to the scgi_cache_lock_timeout)
    """.trimIndent(),
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiCacheLockAge = Directive(
    name = "scgi_cache_lock_age",
    description = "Sets the maximum age of a cache item to be considered for locking",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiCacheLockTimeout = Directive(
    name = "scgi_cache_lock_timeout",
    description = "Sets the timeout for locking cache items",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiCacheMaxRangeOffset = Directive(
    name = "scgi_cache_max_range_offset",
    description = "Sets the maximum range offset for caching SCGI server responses",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiCacheMethods = Directive(
    name = "scgi_cache_methods",
    description = "Defines the HTTP methods for which caching is enabled",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiCacheMinUses = Directive(
    name = "scgi_cache_min_uses",
    description = "Sets the minimum number of uses for caching SCGI server responses",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiCachePath = Directive(
    name = "scgi_cache_path",
    description = "Defines the path for caching SCGI server responses",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiCachePurge = Directive(
    name = "scgi_cache_purge",
    description = "Defines the conditions under which cached responses are purged",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiCacheRevalidate = Directive(
    name = "scgi_cache_revalidate",
    description = """
        Enables revalidation of expired cache items using conditional requests with 
        the "If-Modified-Since" and "If-None-Match" header fields.
    """.trimIndent(),
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiCacheUseStale = Directive(
    name = "scgi_cache_use_stale",
    description = "Defines the conditions under which stale cached responses are used",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiCacheValid = Directive(
    name = "scgi_cache_valid",
    description = "Defines the validity period for cached SCGI server responses",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiConnectTimeout = Directive(
    name = "scgi_connect_timeout",
    description = "Sets the timeout for connecting to the SCGI server",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiForceRanges = Directive(
    name = "scgi_force_ranges",
    description = """
        Enables byte-range support for both cached and uncached responses from the 
        SCGI server regardless of the "Accept-Ranges" field in these responses.
    """.trimIndent(),
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiHideHeader = Directive(
    name = "scgi_hide_header",
    description = "Hides the specified header from the SCGI server response",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiIgnoreClientAbort = Directive(
    name = "scgi_ignore_client_abort",
    description = """
        Determines whether the connection with an SCGI server should be closed 
        when a client closes the connection without waiting for a response.
    """.trimIndent(),
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiIgnoreHeaders = Directive(
    name = "scgi_ignore_headers",
    description = "Ignores the specified headers from the SCGI server response",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiInterceptErrors = Directive(
    name = "scgi_intercept_errors",
    description = """
        Determines whether SCGI server responses with codes greater than or equal 
        to 300 should be passed to a client or be intercepted and redirected to 
        nginx for processing with the error_page directive.
    """.trimIndent(),
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiLimitRate = Directive(
    name = "scgi_limit_rate",
    description = "Sets the rate limit for the SCGI server response",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiMaxTempFileSize = Directive(
    name = "scgi_max_temp_file_size",
    description = "Sets the maximum size of temporary files for the SCGI server response",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiNextUpstream = Directive(
    name = "scgi_next_upstream",
    description = "Defines the conditions under which the request is passed to the next upstream server",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiNextUpstreamTimeout = Directive(
    name = "scgi_next_upstream_timeout",
    description = "Sets the timeout for passing the request to the next upstream server",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiNextUpstreamTries = Directive(
    name = "scgi_next_upstream_tries",
    description = "Sets the number of tries for passing the request to the next upstream server",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiNoCache = Directive(
    name = "scgi_no_cache",
    description = "Disables caching of SCGI server responses",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiParam = Directive(
    name = "scgi_param",
    description = """
        Sets a parameter that should be passed to the SCGI server.
        The value can contain text, variables, and their combinations.
        
        These parameters are passed as SCGI protocol headers.
    """.trimIndent(),
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiPass = Directive(
    name = "scgi_pass",
    description = """
        Sets the address of an SCGI server. The address can be specified as a domain name 
        or IP address, and a port:
        
        - scgi_pass localhost:9000;
        - scgi_pass unix:/tmp/scgi.socket;
        
        Can also specify a server group defined in the upstream block.
    """.trimIndent(),
    context = listOf(location, locationIf),
    module = ngx_http_scgi_module
)

val scgiPassHeader = Directive(
    name = "scgi_pass_header",
    description = "Passes the specified header from the SCGI server response",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiPassRequestBody = Directive(
    name = "scgi_pass_request_body",
    description = "Enables passing of the request body to the SCGI server",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiPassRequestHeaders = Directive(
    name = "scgi_pass_request_headers",
    description = "Enables passing of request headers to the SCGI server",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiReadTimeout = Directive(
    name = "scgi_read_timeout",
    description = "Sets the timeout for reading the SCGI server response",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiRequestBuffering = Directive(
    name = "scgi_request_buffering",
    description = """
        Enables or disables buffering of a client request body.
        
        When enabled, the entire request body is read from the client before sending 
        the request to an SCGI server.
        
        When disabled, the request body is sent to the SCGI server immediately as 
        it is received.
    """.trimIndent(),
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiSendTimeout = Directive(
    name = "scgi_send_timeout",
    description = "Sets the timeout for sending the request to the SCGI server",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiSocketKeepalive = Directive(
    name = "scgi_socket_keepalive",
    description = """
        Configures the "TCP keepalive" behavior for outgoing connections to an 
        SCGI server. When enabled, the SO_KEEPALIVE socket option is turned on 
        for the socket.
    """.trimIndent(),
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiStore = Directive(
    name = "scgi_store",
    description = "Enables saving of the SCGI server response to a file",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiStoreAccess = Directive(
    name = "scgi_store_access",
    description = "Sets the access permissions for files created when saving SCGI server responses",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiTempFileWriteSize = Directive(
    name = "scgi_temp_file_write_size",
    description = "Sets the size of temporary files when buffering responses from the SCGI server",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)

val scgiTempPath = Directive(
    name = "scgi_temp_path",
    description = "Defines a directory for storing temporary files when buffering SCGI server responses",
    context = listOf(http, server, location),
    module = ngx_http_scgi_module
)
