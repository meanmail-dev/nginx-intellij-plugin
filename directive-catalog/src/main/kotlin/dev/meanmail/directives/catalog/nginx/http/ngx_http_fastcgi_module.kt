package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/http/ngx_http_fastcgi_module.html

val ngx_http_fastcgi_module = NginxModule(
    "ngx_http_fastcgi_module",
    description = "The FastCGI module for NGINX"
)

val fastcgiBind = Directive(
    name = "fastcgi_bind",
    description = "Specifies the local IP address and port for connections to FastCGI servers",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiBufferSize = Directive(
    name = "fastcgi_buffer_size",
    description = "Sets the size of the buffer used for reading the first part of the FastCGI server response",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiBuffers = Directive(
    name = "fastcgi_buffers",
    description = "Configures the number and size of buffers used for reading FastCGI server responses",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiBusyBuffersSize = Directive(
    name = "fastcgi_busy_buffers_size",
    description = "Sets the maximum size of busy buffers when processing FastCGI server responses",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiBuffering = Directive(
    name = "fastcgi_buffering",
    description = "Controls whether buffering of FastCGI server responses is enabled",
        context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCache = Directive(
    name = "fastcgi_cache",
    description = "Defines a zone for caching FastCGI server responses",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheBackgroundUpdate = Directive(
    name = "fastcgi_cache_background_update",
    description = "Enables background updating of expired cache items",
        context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheBypass = Directive(
    name = "fastcgi_cache_bypass",
    description = "Defines conditions for bypassing the FastCGI cache",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheKey = Directive(
    name = "fastcgi_cache_key",
    description = "Defines the key used for storing and retrieving FastCGI cache entries",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheLock = Directive(
    name = "fastcgi_cache_lock",
    description = "Enables or disables locking mechanism to prevent multiple simultaneous requests for the same content",
        context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheLockAge = Directive(
    name = "fastcgi_cache_lock_age",
    description = "Sets the maximum time a request can wait to acquire a cache lock",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheLockTimeout = Directive(
    name = "fastcgi_cache_lock_timeout",
    description = "Sets the timeout for waiting to acquire a cache lock",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheMaxRangeOffset = Directive(
    name = "fastcgi_cache_max_range_offset",
    description = "Sets the maximum offset for partial content caching from the FastCGI server",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheMethods = Directive(
    name = "fastcgi_cache_methods",
    description = "Specifies HTTP methods for which FastCGI responses will be cached",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheMinUses = Directive(
    name = "fastcgi_cache_min_uses",
    description = "Sets the minimum number of requests before a response is cached",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCachePath = Directive(
    name = "fastcgi_cache_path",
    description = "Sets the path and parameters for the FastCGI cache",
    context = listOf(http),
    module = ngx_http_fastcgi_module
)

val fastcgiCachePurge = Directive(
    name = "fastcgi_cache_purge",
    description = "Defines conditions for purging cached content",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheRevalidate = Directive(
    name = "fastcgi_cache_revalidate",
    description = "Enables revalidation of expired cache items using conditional requests",
        context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheUseStale = Directive(
    name = "fastcgi_cache_use_stale",
    description = "Defines conditions for serving stale cached content when the FastCGI server is unavailable",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheValid = Directive(
    name = "fastcgi_cache_valid",
    description = "Sets the time for caching responses with specific status codes",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCatchStderr = Directive(
    name = "fastcgi_catch_stderr",
    description = "Enables or disables catching of stderr messages from the FastCGI server",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiConnectTimeout = Directive(
    name = "fastcgi_connect_timeout",
    description = "Sets the timeout for establishing a connection with a FastCGI server",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiConvertVariables = Directive(
    name = "fastcgi_convert_variables",
    description = "Controls the conversion of variables in FastCGI request parameters",
        context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiForceRanges = Directive(
    name = "fastcgi_force_ranges",
    description = "Enables or disables forcing of byte-range requests for FastCGI responses",
        context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiHideHeader = Directive(
    name = "fastcgi_hide_header",
    description = "Prevents specific headers from being passed from the FastCGI server response to the client",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiIgnoreHeaders = Directive(
    name = "fastcgi_ignore_headers",
    description = "Disables processing of specific headers received from the FastCGI server",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiIgnoreClientAbort = Directive(
    name = "fastcgi_ignore_client_abort",
    description = "Controls whether to continue processing requests if the client closes the connection",
        context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiIndex = Directive(
    name = "fastcgi_index",
    description = "Defines the default index file for FastCGI requests",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiInterceptErrors = Directive(
    name = "fastcgi_intercept_errors",
    description = "Controls whether NGINX will process 4xx and 5xx error responses from the FastCGI server",
        context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiKeepConn = Directive(
    name = "fastcgi_keep_conn",
    description = "Controls whether to keep the connection with the FastCGI server open after request processing",
        context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiLimitRate = Directive(
    name = "fastcgi_limit_rate",
    description = "Limits the rate of response transmission from the FastCGI server",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiMaxTempFileSize = Directive(
    name = "fastcgi_max_temp_file_size",
    description = "Sets the maximum size of temporary files used for buffering FastCGI server responses",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiNextUpstream = Directive(
    name = "fastcgi_next_upstream",
    description = "Specifies conditions for passing a request to the next FastCGI server if the current server fails",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiNextUpstreamTries = Directive(
    name = "fastcgi_next_upstream_tries",
    description = "Limits the number of possible tries for passing a request to the next FastCGI server",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiNextUpstreamTimeout = Directive(
    name = "fastcgi_next_upstream_timeout",
    description = "Sets the overall time limit for passing a request to the next FastCGI server",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiNoCache = Directive(
    name = "fastcgi_no_cache",
    description = "Defines the conditions under which the response will not be cached",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiParamLongValue = Directive(
    name = "fastcgi_param_long_value",
    description = "Controls the handling of long parameter values in FastCGI requests",
        context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiParams = Directive(
    name = "fastcgi_params",
    description = "Includes a standard set of FastCGI parameters for passing to the FastCGI server",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiParam = Directive(
    name = "fastcgi_param",
    description = "Defines or modifies FastCGI parameters passed to the FastCGI server",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiPass = Directive(
    name = "fastcgi_pass",
    description = "Defines the FastCGI server or upstream group to which requests will be proxied",
    context = listOf(location, locationIf),
    module = ngx_http_fastcgi_module
)

val fastcgiPassHeader = Directive(
    name = "fastcgi_pass_header",
    description = "Allows passing specified headers from the FastCGI server to the client",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiPassRequestBody = Directive(
    name = "fastcgi_pass_request_body",
    description = "Controls whether the client request body is passed to the FastCGI server",
        context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiPassRequestHeaders = Directive(
    name = "fastcgi_pass_request_headers",
    description = "Controls whether client request headers are passed to the FastCGI server",
        context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiReadTimeout = Directive(
    name = "fastcgi_read_timeout",
    description = "Sets the timeout for reading a response from the FastCGI server",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiRequestBuffering = Directive(
    name = "fastcgi_request_buffering",
    description = "Enables or disables buffering of the client request body for FastCGI requests",
        context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiSendTimeout = Directive(
    name = "fastcgi_send_timeout",
    description = "Sets the timeout for transmitting a request to the FastCGI server",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiSendLowat = Directive(
    name = "fastcgi_send_lowat",
    description = "Sets the minimum amount of data to be sent in a packet when communicating with the FastCGI server",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiSocketKeepalive = Directive(
    name = "fastcgi_socket_keepalive",
    description = "Controls the use of the SO_KEEPALIVE socket option for maintaining persistent connections with FastCGI servers",
        context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiSplitPathInfo = Directive(
    name = "fastcgi_split_path_info",
    description = "Defines a regular expression for splitting the request URI into path and script name for FastCGI processing",
    context = listOf(location),
    module = ngx_http_fastcgi_module
)

val fastcgiStore = Directive(
    name = "fastcgi_store",
    description = "Enables saving the response from the FastCGI server to a file on disk",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiStoreAccess = Directive(
    name = "fastcgi_store_access",
    description = "Sets the access permissions for files created by fastcgi_store",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiTempPath = Directive(
    name = "fastcgi_temp_path",
    description = "Defines the directory for storing temporary files when buffering FastCGI server responses",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiTempFileWriteSize = Directive(
    name = "fastcgi_temp_file_write_size",
    description = "Sets the size of temporary files when buffering responses from the FastCGI server",
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)
