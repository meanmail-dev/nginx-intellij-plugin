package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.*

// https://nginx.org/en/docs/http/ngx_http_proxy_module.html

val ngx_http_proxy_module = NginxModule(
    name = "ngx_http_proxy_module",
    description = "Allows proxying requests to another server and configuring the connection",
    enabled = true
)

val proxyBind = Directive(
    name = "proxy_bind",
    description = "Sets the local IP address and port for outgoing connections to a proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            description = "Local IP address or interface to bind outgoing connections",
            valueType = ValueType.STRING,
            required = false
        ),
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyBufferSize = Directive(
    name = "proxy_buffer_size",
    description = "Sets the size of the buffer used for reading the first part of the response from the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Size of the buffer for reading the first part of the response",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "4k"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyBuffering = Directive(
    name = "proxy_buffering",
    description = "Enables or disables buffering of responses from the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "enabled",
            description = "Whether to enable buffering of responses from the proxied server",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "on"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyBuffers = Directive(
    name = "proxy_buffers",
    description = "Sets the number and size of buffers for reading a response from the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Number of buffers for reading the response",
            valueType = ValueType.NUMBER,
            required = false,
            defaultValue = "8"
        ),
        DirectiveParameter(
            name = "size",
            description = "Size of each buffer for reading the response",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "4k"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyBusyBuffersSize = Directive(
    name = "proxy_busy_buffers_size",
    description = "Limits the total size of busy buffers that can be sent to the client",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum total size of busy buffers",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "8k"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCache = Directive(
    name = "proxy_cache",
    description = "Defines the cache zone to be used for storing responses from the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "zone",
            description = "Name of the cache zone for storing proxied server responses",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheBackgroundUpdate = Directive(
    name = "proxy_cache_background_update",
    description = "Enables background updating of expired cache items",
    parameters = listOf(
        DirectiveParameter(
            name = "enabled",
            description = "Whether to enable background updating of expired cache items",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheBypass = Directive(
    name = "proxy_cache_bypass",
    description = "Defines conditions under which the response will not be taken from the cache",
    parameters = listOf(
        DirectiveParameter(
            name = "condition",
            description = "Condition that determines whether to bypass the cache",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheConvertHead = Directive(
    name = "proxy_cache_convert_head",
    description = "Enables converting HEAD requests to GET requests for caching",
    parameters = listOf(
        DirectiveParameter(
            name = "enabled",
            description = "Whether to convert HEAD requests to GET requests for caching",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "on"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheKey = Directive(
    name = "proxy_cache_key",
    description = "Defines the key for caching a response from the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "key",
            description = "Unique identifier used to generate the cache key",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheLock = Directive(
    name = "proxy_cache_lock",
    description = "Enables cache lock to prevent multiple simultaneous requests for the same content",
    parameters = listOf(
        DirectiveParameter(
            name = "enabled",
            description = "Whether to enable cache lock",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "false"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheLockAge = Directive(
    name = "proxy_cache_lock_age",
    description = "Sets the time during which subsequent requests will wait for the first request's response to be cached",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            description = "Maximum time to wait for cache lock",
            valueType = ValueType.TIME,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheLockTimeout = Directive(
    name = "proxy_cache_lock_timeout",
    description = "Sets the timeout for obtaining a cache lock",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Maximum time to wait for cache lock",
            valueType = ValueType.TIME,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheMaxRangeOffset = Directive(
    name = "proxy_cache_max_range_offset",
    description = "Sets the maximum allowed offset for range requests when caching",
    parameters = listOf(
        DirectiveParameter(
            name = "offset",
            description = "Maximum range offset",
            valueType = ValueType.SIZE,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheMethods = Directive(
    name = "proxy_cache_methods",
    description = "Defines HTTP methods that can be cached",
    parameters = listOf(
        DirectiveParameter(
            name = "cacheable_methods",
            description = "List of HTTP methods allowed for caching",
            valueType = ValueType.STRING_LIST,
            required = false
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheMinUses = Directive(
    name = "proxy_cache_min_uses",
    description = "Sets the minimum number of requests before a response is cached",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Minimum number of requests",
            valueType = ValueType.INTEGER,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCachePath = Directive(
    name = "proxy_cache_path",
    description = "Sets the path and configuration for the cache",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Directory path for cache storage",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "parameters",
            description = "Additional cache configuration parameters",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCachePurge = Directive(
    name = "proxy_cache_purge",
    description = "Defines conditions for purging cache entries",
    parameters = listOf(
        DirectiveParameter(
            name = "condition",
            description = "Condition for cache purge",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheRevalidate = Directive(
    name = "proxy_cache_revalidate",
    description = "Enables or disables revalidation of stale cache items",
    parameters = listOf(
        DirectiveParameter(
            name = "enabled",
            description = "Whether to enable revalidation",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "false"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheUseStale = Directive(
    name = "proxy_cache_use_stale",
    description = "Allows serving stale cached content under specific conditions",
    parameters = listOf(
        DirectiveParameter(
            name = "stale_conditions",
            description = "Conditions for serving stale content",
            valueType = ValueType.STRING_LIST,
            required = false
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheValid = Directive(
    name = "proxy_cache_valid",
    description = "Sets caching time for different response codes",
    parameters = listOf(
        DirectiveParameter(
            name = "code",
            description = "HTTP status code",
            valueType = ValueType.NUMBER,
            required = false
        ),
        DirectiveParameter(
            name = "time",
            description = "Time to cache the response",
            valueType = ValueType.TIME,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyConnectTimeout = Directive(
    name = "proxy_connect_timeout",
    description = "Defines a timeout for establishing a connection with a proxied server",
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
    module = ngx_http_proxy_module
)

val proxyCookieDomain = Directive(
    name = "proxy_cookie_domain",
    description = "Sets the domain for the Set-Cookie header in responses from the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "domain",
            description = "Domain for the Set-Cookie header",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCookieFlags = Directive(
    name = "proxy_cookie_flags",
    description = "Sets the flags for the Set-Cookie header in responses from the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "flags",
            description = "Flags for the Set-Cookie header",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCookiePath = Directive(
    name = "proxy_cookie_path",
    description = "Sets the path for the Set-Cookie header in responses from the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path for the Set-Cookie header",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyForceRanges = Directive(
    name = "proxy_force_ranges",
    description = "Enables byte-range support for proxied requests regardless of the Range request header field",
    parameters = listOf(
        DirectiveParameter(
            name = "enabled",
            description = "Whether to enable byte-range support",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "false"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyHeadersHashBucketSize = Directive(
    name = "proxy_headers_hash_bucket_size",
    description = "Sets the bucket size for the hash tables used by proxy_hide_header and proxy_set_header directives",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Bucket size in bytes",
            valueType = ValueType.SIZE,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyHeadersHashMaxSize = Directive(
    name = "proxy_headers_hash_max_size",
    description = "Sets the maximum size of the hash tables used by proxy_hide_header and proxy_set_header directives",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum size in bytes",
            valueType = ValueType.SIZE,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyHideHeader = Directive(
    name = "proxy_hide_header",
    description = "Prevents passing specified header fields from a proxied server to a client",
    parameters = listOf(
        DirectiveParameter(
            name = "field",
            description = "Header field name to hide",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyHttpVersion = Directive(
    name = "proxy_http_version",
    description = "Sets the HTTP protocol version for proxying requests to the backend server",
    parameters = listOf(
        DirectiveParameter(
            name = "version",
            description = "HTTP protocol version to use when proxying requests",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "1.0",
            allowedValues = listOf("1.0", "1.1")
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyIgnoreClientAbort = ToggleDirective(
    name = "proxy_ignore_client_abort",
    description = "Determines whether to ignore client aborts when sending requests to the proxied server",
    enabled = false,
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyIgnoreHeaders = Directive(
    name = "proxy_ignore_headers",
    description = "Disables processing of certain response headers from the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "headers",
            description = "Space-separated list of headers to ignore when processing the proxied server's response",
            valueType = ValueType.STRING,
            required = true,
            allowedValues = listOf(
                "X-Accel-Redirect",
                "X-Accel-Expires",
                "X-Accel-Limit-Rate",
                "X-Accel-Buffering",
                "X-Accel-Charset",
                "Expires",
                "Cache-Control",
                "Set-Cookie"
            )
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyInterceptErrors = Directive(
    name = "proxy_intercept_errors",
    description = "Determines whether NGINX will process error responses from the proxied server or pass them directly to the client",
    parameters = listOf(
        DirectiveParameter(
            name = "enabled",
            description = "When enabled, NGINX will process error responses (status codes 4xx, 5xx) from the proxied server using error_page directive",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "false"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyLimitRate = Directive(
    name = "proxy_limit_rate",
    description = "Limits the transfer rate of a response from the proxied server to a client",
    parameters = listOf(
        DirectiveParameter(
            name = "rate",
            description = "Maximum transfer rate in bytes per second. Zero means no limit",
            valueType = ValueType.NUMBER,
            required = false,
            defaultValue = "0"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyMaxTempFileSize = Directive(
    name = "proxy_max_temp_file_size",
    description = "Limits the size of data written to a temporary file when the proxied server response cannot be stored in memory",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum size of temporary file (0 disables buffering to temporary files)",
            valueType = ValueType.SIZE,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyMethod = Directive(
    name = "proxy_method",
    description = "Specifies a custom HTTP method to be used when forwarding requests to the proxied server, overriding the original client request method",
    parameters = listOf(
        DirectiveParameter(
            name = "method",
            description = "HTTP method to use instead of the client request method (e.g., GET, POST, PUT, DELETE)",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyNextUpstream = Directive(
    name = "proxy_next_upstream",
    description = "Specifies in which cases a request should be passed to the next server in the upstream group",
    parameters = listOf(
        DirectiveParameter(
            name = "conditions",
            description = "Space-separated list of conditions that trigger passing the request to the next server",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "error timeout",
            allowedValues = listOf(
                "error",
                "timeout",
                "invalid_header",
                "http_500",
                "http_502",
                "http_503",
                "http_504",
                "http_403",
                "http_404",
                "http_429",
                "non_idempotent"
            )
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyNextUpstreamTimeout = Directive(
    name = "proxy_next_upstream_timeout",
    description = "Limits the time during which a request can be passed to the next server",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            description = "Time limit (0 disables the limit)",
            valueType = ValueType.TIME,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyNextUpstreamTries = Directive(
    name = "proxy_next_upstream_tries",
    description = "Sets the maximum number of possible tries for passing a request to the next server",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Maximum number of attempts to pass the request to the next server. Zero means no limit",
            valueType = ValueType.NUMBER,
            required = false,
            defaultValue = "0"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyNoCache = Directive(
    name = "proxy_no_cache",
    description = "Defines conditions under which the response will not be saved to a cache",
    parameters = listOf(
        DirectiveParameter(
            name = "string",
            description = "String values to check",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyPass = Directive(
    name = "proxy_pass",
    description = "Sets the protocol, address, and optional port of a proxied server. Can use domain names, IP addresses, and Unix sockets",
    parameters = listOf(
        DirectiveParameter(
            name = "url",
            description = "URL of the proxied server, including protocol (http/https), optional port, and path. Can include variables and Unix socket paths",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(location, locationIf, limitExcept),
    module = ngx_http_proxy_module
)

val proxyPassHeader = Directive(
    name = "proxy_pass_header",
    description = "Allows passing specified headers from the proxied server to the client, overriding the default header hiding behavior",
    parameters = listOf(
        DirectiveParameter(
            name = "header",
            description = "Name of the header to pass from the proxied server to the client",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyPassRequestBody = Directive(
    name = "proxy_pass_request_body",
    description = "Determines whether the original request body is passed to the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "enabled",
            description = "When enabled, the original client request body is passed to the proxied server",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "on"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyPassRequestHeaders = Directive(
    name = "proxy_pass_request_headers",
    description = "Determines whether the original request headers are passed to the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "enabled",
            description = "When enabled, the original client request headers are passed to the proxied server",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "on"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyPassTrailers = Directive(
    name = "proxy_pass_trailers",
    description = "Indicates whether trailer fields from the proxied server should be passed to the client",
    parameters = listOf(
        DirectiveParameter(
            name = "enabled",
            description = "Whether to pass trailers",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "false"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyReadTimeout = Directive(
    name = "proxy_read_timeout",
    description = "Defines the timeout for reading a response from the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Time in seconds to wait for a response from the proxied server. Zero means no timeout",
            valueType = ValueType.NUMBER,
            required = false,
            defaultValue = "60"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyRedirect = Directive(
    name = "proxy_redirect",
    description = "Sets the text replacement for the Location and Refresh headers from the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "replacement",
            description = "Replacement for the original URL in Location and Refresh headers",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "default"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyRequestBuffering = Directive(
    name = "proxy_request_buffering",
    description = "Enables or disables buffering of a client request body",
    parameters = listOf(
        DirectiveParameter(
            name = "enabled",
            description = "Whether to enable request buffering",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "true"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySendLowat = Directive(
    name = "proxy_send_lowat",
    description = "Sets the low watermark for sending data to the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Low watermark size",
            valueType = ValueType.SIZE,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySendTimeout = Directive(
    name = "proxy_send_timeout",
    description = "Sets a timeout for transmitting a request to the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            description = "Timeout duration",
            valueType = ValueType.TIME,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySetBody = Directive(
    name = "proxy_set_body",
    description = "Allows changing the request body before passing it to the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "body",
            description = "New body content to be sent to the proxied server",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySetHeader = Directive(
    name = "proxy_set_header",
    description = "Allows redefining or adding headers to be passed to the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "header",
            description = "Name of the header to be set or modified",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "value",
            description = "Value of the header to be set",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySocketKeepalive = Directive(
    name = "proxy_socket_keepalive",
    description = "Configures the TCP keepalive behavior for upstream connections",
    parameters = listOf(
        DirectiveParameter(
            name = "enabled",
            description = "Whether to enable socket keepalive",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "false"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslCertificate = Directive(
    name = "proxy_ssl_certificate",
    description = "Specifies the certificate file for authentication to a proxied HTTPS server",
    parameters = listOf(
        DirectiveParameter(
            name = "certificate",
            description = "Path to the certificate file in PEM format",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslCertificateCache = Directive(
    name = "proxy_ssl_certificate_cache",
    description = "Specifies the cache for SSL certificates used for authentication to a proxied HTTPS server",
    parameters = emptyList(),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslCertificateKey = Directive(
    name = "proxy_ssl_certificate_key",
    description = "Specifies the secret key file for authentication to a proxied HTTPS server",
    parameters = listOf(
        DirectiveParameter(
            name = "key",
            description = "Path to the secret key file in PEM format",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslCiphers = Directive(
    name = "proxy_ssl_ciphers",
    description = "Specifies the enabled ciphers for requests to a proxied HTTPS server",
    parameters = listOf(
        DirectiveParameter(
            name = "ciphers",
            description = "OpenSSL cipher list",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslConfCommand = Directive(
    name = "proxy_ssl_conf_command",
    description = "Sets custom OpenSSL configuration commands for HTTPS connections to the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "command",
            description = "OpenSSL configuration command name",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "value",
            description = "Value for the OpenSSL configuration command",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslCrl = Directive(
    name = "proxy_ssl_crl",
    description = "Specifies the certificate revocation list (CRL) file for verifying the certificate of the proxied HTTPS server",
    parameters = emptyList(),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslKeyLog = Directive(
    name = "proxy_ssl_key_log",
    description = "Specifies the file for logging SSL session keys for debugging purposes",
    parameters = emptyList(),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslName = Directive(
    name = "proxy_ssl_name",
    description = "Sets the server name for TLS Server Name Indication (SNI) when connecting to a proxied HTTPS server",
    parameters = listOf(
        DirectiveParameter(
            name = "name",
            description = "Server name to use for SNI during SSL/TLS handshake",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslPasswordFile = Directive(
    name = "proxy_ssl_password_file",
    description = "Specifies a file with passphrases for secret keys where each passphrase is specified on a separate line",
    parameters = listOf(
        DirectiveParameter(
            name = "file",
            description = "Path to password file",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslProtocols = Directive(
    name = "proxy_ssl_protocols",
    description = "Specifies the SSL/TLS protocols to use when connecting to a proxied HTTPS server",
    parameters = listOf(
        DirectiveParameter(
            name = "protocols",
            description = "Allowed SSL/TLS protocol versions",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "TLSv1 TLSv1.1 TLSv1.2"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslServerName = Directive(
    name = "proxy_ssl_server_name",
    description = "Enables or disables passing of the server name during SSL/TLS handshake to a proxied HTTPS server",
    parameters = listOf(
        DirectiveParameter(
            name = "enabled",
            description = "Whether to pass the server name during SSL/TLS handshake",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "on"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslSessionReuse = Directive(
    name = "proxy_ssl_session_reuse",
    description = "Enables or disables reuse of SSL sessions when connecting to a proxied HTTPS server",
    parameters = listOf(
        DirectiveParameter(
            name = "enabled",
            description = "Whether to enable SSL session reuse",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "on"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslTrustedCertificate = Directive(
    name = "proxy_ssl_trusted_certificate",
    description = "Specifies the trusted CA certificates file for verifying the certificate of the proxied HTTPS server",
    parameters = listOf(
        DirectiveParameter(
            name = "file",
            description = "Path to the trusted CA certificates file in PEM format",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslVerify = Directive(
    name = "proxy_ssl_verify",
    description = "Enables or disables verification of the proxied HTTPS server's certificate",
    parameters = listOf(
        DirectiveParameter(
            name = "enabled",
            description = "Whether to verify the certificate of the proxied HTTPS server",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslVerifyDepth = Directive(
    name = "proxy_ssl_verify_depth",
    description = "Sets the maximum depth of certificate verification chain for a proxied HTTPS server",
    parameters = listOf(
        DirectiveParameter(
            name = "depth",
            description = "Maximum number of intermediate certificates to verify",
            valueType = ValueType.NUMBER,
            required = false,
            defaultValue = "1"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyStore = Directive(
    name = "proxy_store",
    description = "Enables or sets the path for storing the response from the proxied server on the local file system",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to store the response file or 'on/off' to enable/disable storing",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(location),
    module = ngx_http_proxy_module
)

val proxyStoreAccess = Directive(
    name = "proxy_store_access",
    description = "Sets the access permissions for files stored by proxy_store directive",
    parameters = listOf(
        DirectiveParameter(
            name = "permissions",
            description = "Access permissions for stored files",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "user:rw group:r all:r"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyTempFileWriteSize = Directive(
    name = "proxy_temp_file_write_size",
    description = "Sets the size of data written to a temporary file at a time when proxying",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Size of data written to temporary file in a single write operation",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "8k"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyTempPath = Directive(
    name = "proxy_temp_path",
    description = "Sets the directory for storing temporary files when proxying",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the directory for storing temporary files",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)
