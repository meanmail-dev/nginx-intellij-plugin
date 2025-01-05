package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.*

// https://nginx.org/en/docs/http/ngx_http_fastcgi_module.html

val ngx_http_fastcgi_module = NginxModule(
    "ngx_http_fastcgi_module",
    description = "The FastCGI module for NGINX",
    enabled = true
)

val fastcgiBind = Directive(
    name = "fastcgi_bind",
    description = "Specifies the local IP address and port for connections to FastCGI servers",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            description = "Local IP address or interface for FastCGI server connections",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiBufferSize = Directive(
    name = "fastcgi_buffer_size",
    description = "Sets the size of the buffer used for reading the first part of the FastCGI server response",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Size of the buffer for the first part of the FastCGI response",
            valueType = ValueType.SIZE,
            required = true,
            defaultValue = "4k"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiBuffers = Directive(
    name = "fastcgi_buffers",
    description = "Configures the number and size of buffers used for reading FastCGI server responses",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Number of buffers for reading FastCGI server responses",
            valueType = ValueType.INTEGER,
            required = true,
            defaultValue = "8"
        ),
        DirectiveParameter(
            name = "size",
            description = "Size of each buffer for reading FastCGI server responses",
            valueType = ValueType.SIZE,
            required = true,
            defaultValue = "4k"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiBusyBuffersSize = Directive(
    name = "fastcgi_busy_buffers_size",
    description = "Sets the maximum size of busy buffers when processing FastCGI server responses",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum size of busy buffers during FastCGI response processing",
            valueType = ValueType.SIZE,
            required = true,
            defaultValue = "8k"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiBuffering = ToggleDirective(
    name = "fastcgi_buffering",
    description = "Controls whether buffering of FastCGI server responses is enabled",
    enabled = true,
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCache = Directive(
    name = "fastcgi_cache",
    description = "Defines a zone for caching FastCGI server responses",
    parameters = listOf(
        DirectiveParameter(
            name = "zone",
            description = "Name of the shared memory zone used for caching FastCGI responses",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "mode",
            description = "Optional caching mode (e.g., max_size, inactive, etc.)",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheBackgroundUpdate = ToggleDirective(
    name = "fastcgi_cache_background_update",
    description = "Enables background updating of expired cache items",
    enabled = false,
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheBypass = Directive(
    name = "fastcgi_cache_bypass",
    description = "Defines conditions for bypassing the FastCGI cache",
    parameters = listOf(
        DirectiveParameter(
            name = "condition",
            description = "Condition or variable that determines when to bypass the cache",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheKey = Directive(
    name = "fastcgi_cache_key",
    description = "Defines the key used for storing and retrieving FastCGI cache entries",
    parameters = listOf(
        DirectiveParameter(
            name = "key",
            description = "Unique identifier for caching FastCGI responses",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheLock = ToggleDirective(
    name = "fastcgi_cache_lock",
    description = "Enables or disables locking mechanism to prevent multiple simultaneous requests for the same content",
    enabled = false,
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheLockAge = Directive(
    name = "fastcgi_cache_lock_age",
    description = "Sets the maximum time a request can wait to acquire a cache lock",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Maximum time to wait for acquiring a cache lock",
            valueType = ValueType.TIME,
            required = true,
            defaultValue = "5s"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheLockTimeout = Directive(
    name = "fastcgi_cache_lock_timeout",
    description = "Sets the timeout for waiting to acquire a cache lock",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Maximum time to wait for a cache lock before giving up",
            valueType = ValueType.TIME,
            required = true,
            defaultValue = "5s"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheMaxRangeOffset = Directive(
    name = "fastcgi_cache_max_range_offset",
    description = "Sets the maximum offset for partial content caching from the FastCGI server",
    parameters = listOf(
        DirectiveParameter(
            name = "offset",
            description = "Maximum offset for partial content caching",
            valueType = ValueType.SIZE,
            required = true,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheMethods = Directive(
    name = "fastcgi_cache_methods",
    description = "Specifies HTTP methods for which FastCGI responses will be cached",
    parameters = listOf(
        DirectiveParameter(
            name = "methods",
            description = "HTTP methods to be cached (GET, HEAD, etc.)",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "GET HEAD"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheMinUses = Directive(
    name = "fastcgi_cache_min_uses",
    description = "Sets the minimum number of requests before a response is cached",
    parameters = listOf(
        DirectiveParameter(
            name = "uses",
            description = "Minimum number of requests required to cache a response",
            valueType = ValueType.INTEGER,
            required = true,
            defaultValue = "1"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCachePath = Directive(
    name = "fastcgi_cache_path",
    description = "Sets the path and parameters for the FastCGI cache",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the directory for storing cached files",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "parameters",
            description = "Optional cache configuration parameters (levels, keys_zone, max_size, inactive, etc.)",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(http),
    module = ngx_http_fastcgi_module
)

val fastcgiCachePurge = Directive(
    name = "fastcgi_cache_purge",
    description = "Defines conditions for purging cached content",
    parameters = listOf(
        DirectiveParameter(
            name = "condition",
            description = "Condition or method to purge specific cache entries (can use variables)",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(http, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheRevalidate = ToggleDirective(
    name = "fastcgi_cache_revalidate",
    description = "Enables revalidation of expired cache items using conditional requests",
    enabled = false,
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheUseStale = Directive(
    name = "fastcgi_cache_use_stale",
    description = "Defines conditions for serving stale cached content when the FastCGI server is unavailable",
    parameters = listOf(
        DirectiveParameter(
            name = "conditions",
            description = "Conditions for serving stale content (error, timeout, invalid_header, updating, etc.)",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "error timeout"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCacheValid = Directive(
    name = "fastcgi_cache_valid",
    description = "Sets the time for caching responses with specific status codes",
    parameters = listOf(
        DirectiveParameter(
            name = "status_codes",
            description = "HTTP status codes for which caching time is defined (e.g., 200, 404)",
            valueType = ValueType.STRING,
            required = false
        ),
        DirectiveParameter(
            name = "time",
            description = "Time period for which the response will be considered valid in cache",
            valueType = ValueType.TIME,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiCatchStderr = Directive(
    name = "fastcgi_catch_stderr",
    description = "Enables or disables catching of stderr messages from the FastCGI server",
    parameters = listOf(
        DirectiveParameter(
            name = "flag",
            description = "Flag indicating whether to catch stderr messages",
            valueType = ValueType.BOOLEAN,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiConnectTimeout = Directive(
    name = "fastcgi_connect_timeout",
    description = "Sets the timeout for establishing a connection with a FastCGI server",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Connection timeout duration",
            valueType = ValueType.TIME,
            required = true,
            defaultValue = "60s"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiConvertVariables = ToggleDirective(
    name = "fastcgi_convert_variables",
    description = "Controls the conversion of variables in FastCGI request parameters",
    enabled = true,
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiForceRanges = ToggleDirective(
    name = "fastcgi_force_ranges",
    description = "Enables or disables forcing of byte-range requests for FastCGI responses",
    enabled = false,
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiHideHeader = Directive(
    name = "fastcgi_hide_header",
    description = "Prevents specific headers from being passed from the FastCGI server response to the client",
    parameters = listOf(
        DirectiveParameter(
            name = "header",
            description = "Name of the header to be hidden from the client",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiIgnoreHeaders = Directive(
    name = "fastcgi_ignore_headers",
    description = "Disables processing of specific headers received from the FastCGI server",
    parameters = listOf(
        DirectiveParameter(
            name = "headers",
            description = "List of headers to ignore from the FastCGI server response",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiIgnoreClientAbort = ToggleDirective(
    name = "fastcgi_ignore_client_abort",
    description = "Controls whether to continue processing requests if the client closes the connection",
    enabled = false,
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiIndex = Directive(
    name = "fastcgi_index",
    description = "Defines the default index file for FastCGI requests",
    parameters = listOf(
        DirectiveParameter(
            name = "file",
            description = "Name of the default index file (e.g., index.php)",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiInterceptErrors = ToggleDirective(
    name = "fastcgi_intercept_errors",
    description = "Controls whether NGINX will process 4xx and 5xx error responses from the FastCGI server",
    enabled = false,
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiKeepConn = ToggleDirective(
    name = "fastcgi_keep_conn",
    description = "Controls whether to keep the connection with the FastCGI server open after request processing",
    enabled = false,
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiLimitRate = Directive(
    name = "fastcgi_limit_rate",
    description = "Limits the rate of response transmission from the FastCGI server",
    parameters = listOf(
        DirectiveParameter(
            name = "rate",
            description = "Maximum transmission rate for FastCGI server responses",
            valueType = ValueType.SIZE,
            required = true,
            defaultValue = "0"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiMaxTempFileSize = Directive(
    name = "fastcgi_max_temp_file_size",
    description = "Sets the maximum size of temporary files used for buffering FastCGI server responses",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum size of temporary file for response buffering",
            valueType = ValueType.SIZE,
            required = true,
            defaultValue = "1024m"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiNextUpstream = Directive(
    name = "fastcgi_next_upstream",
    description = "Specifies conditions for passing a request to the next FastCGI server if the current server fails",
    parameters = listOf(
        DirectiveParameter(
            name = "conditions",
            description = "Conditions for trying the next server (error, timeout, invalid_header, http_500, etc.)",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "error timeout"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiNextUpstreamTries = Directive(
    name = "fastcgi_next_upstream_tries",
    description = "Limits the number of possible tries for passing a request to the next FastCGI server",
    parameters = listOf(
        DirectiveParameter(
            name = "attempts",
            description = "Maximum number of attempts to pass the request to another server",
            valueType = ValueType.INTEGER,
            required = true,
            defaultValue = "0"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiNextUpstreamTimeout = Directive(
    name = "fastcgi_next_upstream_timeout",
    description = "Sets the overall time limit for passing a request to the next FastCGI server",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Maximum time allowed for trying the next server",
            valueType = ValueType.TIME,
            required = true,
            defaultValue = "0"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiNoCache = Directive(
    name = "fastcgi_no_cache",
    description = "Defines the conditions under which the response will not be cached",
    parameters = listOf(
        DirectiveParameter(
            name = "condition",
            description = "Condition under which the response will not be cached",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiParamLongValue = ToggleDirective(
    name = "fastcgi_param_long_value",
    description = "Controls the handling of long parameter values in FastCGI requests",
    enabled = false,
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiParams = Directive(
    name = "fastcgi_params",
    description = "Includes a standard set of FastCGI parameters for passing to the FastCGI server",
    parameters = listOf(
        DirectiveParameter(
            name = "file",
            description = "Path to the file containing predefined FastCGI parameters",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiParam = Directive(
    name = "fastcgi_param",
    description = "Defines or modifies FastCGI parameters passed to the FastCGI server",
    parameters = listOf(
        DirectiveParameter(
            name = "parameter",
            description = "Name of the FastCGI parameter to set or modify",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "value",
            description = "Value of the FastCGI parameter",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "if_not_empty",
            description = "Optional flag to only set the parameter if its value is not empty",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "false"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiPass = Directive(
    name = "fastcgi_pass",
    description = "Defines the FastCGI server or upstream group to which requests will be proxied",
    parameters = listOf(
        DirectiveParameter(
            name = "server",
            description = "Address of the FastCGI server (IP, hostname, or upstream group name)",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(location, locationIf),
    module = ngx_http_fastcgi_module
)

val fastcgiPassHeader = Directive(
    name = "fastcgi_pass_header",
    description = "Allows passing specified headers from the FastCGI server to the client",
    parameters = listOf(
        DirectiveParameter(
            name = "header",
            description = "Name of the header to be passed from the FastCGI server response",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiPassRequestBody = ToggleDirective(
    name = "fastcgi_pass_request_body",
    description = "Controls whether the client request body is passed to the FastCGI server",
    enabled = true,
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiPassRequestHeaders = ToggleDirective(
    name = "fastcgi_pass_request_headers",
    description = "Controls whether client request headers are passed to the FastCGI server",
    enabled = true,
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiReadTimeout = Directive(
    name = "fastcgi_read_timeout",
    description = "Sets the timeout for reading a response from the FastCGI server",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Response read timeout duration",
            valueType = ValueType.TIME,
            required = true,
            defaultValue = "60s"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiRequestBuffering = ToggleDirective(
    name = "fastcgi_request_buffering",
    description = "Enables or disables buffering of the client request body for FastCGI requests",
    enabled = true,
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiSendTimeout = Directive(
    name = "fastcgi_send_timeout",
    description = "Sets the timeout for transmitting a request to the FastCGI server",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Request send timeout duration",
            valueType = ValueType.TIME,
            required = true,
            defaultValue = "60s"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiSendLowat = Directive(
    name = "fastcgi_send_lowat",
    description = "Sets the minimum amount of data to be sent in a packet when communicating with the FastCGI server",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Minimum number of bytes to be sent in a single network packet",
            valueType = ValueType.SIZE,
            required = true,
            defaultValue = "0"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiSocketKeepalive = ToggleDirective(
    name = "fastcgi_socket_keepalive",
    description = "Controls the use of the SO_KEEPALIVE socket option for maintaining persistent connections with FastCGI servers",
    enabled = false,
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiSplitPathInfo = Directive(
    name = "fastcgi_split_path_info",
    description = "Defines a regular expression for splitting the request URI into path and script name for FastCGI processing",
    parameters = listOf(
        DirectiveParameter(
            name = "regex",
            description = "Regular expression to split the request URI (typically used with PHP-FPM)",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(location),
    module = ngx_http_fastcgi_module
)

val fastcgiStore = Directive(
    name = "fastcgi_store",
    description = "Enables saving the response from the FastCGI server to a file on disk",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "File path where the FastCGI server response will be stored",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiStoreAccess = Directive(
    name = "fastcgi_store_access",
    description = "Sets the access permissions for files created by fastcgi_store",
    parameters = listOf(
        DirectiveParameter(
            name = "permissions",
            description = "Access permissions for stored files (e.g., user:rw, group:r, all:r)",
            valueType = ValueType.STRING,
            required = true,
            defaultValue = "user:rw group:r all:r"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)

val fastcgiTempPath = Directive(
    name = "fastcgi_temp_path",
    description = "Defines the directory for storing temporary files when buffering FastCGI server responses",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the directory for temporary files",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "levels",
            description = "Number of directory levels for temporary file storage",
            valueType = ValueType.INTEGER,
            required = false,
            defaultValue = "2"
        ),
        DirectiveParameter(
            name = "size1",
            description = "Size of the first-level directory",
            valueType = ValueType.SIZE,
            required = false
        ),
        DirectiveParameter(
            name = "size2",
            description = "Size of the second-level directory",
            valueType = ValueType.SIZE,
            required = false
        )
    ),
    context = listOf(http),
    module = ngx_http_fastcgi_module
)

val fastcgiTempFileWriteSize = Directive(
    name = "fastcgi_temp_file_write_size",
    description = "Sets the size of temporary files when buffering responses from the FastCGI server",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum size of temporary files during FastCGI response buffering",
            valueType = ValueType.SIZE,
            required = true,
            defaultValue = "8k"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_fastcgi_module
)
