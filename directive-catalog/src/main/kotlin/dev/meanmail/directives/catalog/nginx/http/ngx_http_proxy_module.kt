package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/http/ngx_http_proxy_module.html

val ngx_http_proxy_module = NginxModule(
    name = "ngx_http_proxy_module",
    description = "Allows proxying requests to another server and configuring the connection"
)

val proxyBind = Directive(
    name = "proxy_bind",
    description = "Sets the local IP address and port for outgoing connections to a proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyBufferSize = Directive(
    name = "proxy_buffer_size",
    description = "Sets the size of the buffer used for reading the first part of the response from the proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyBuffering = Directive(
    name = "proxy_buffering",
    description = "Enables or disables buffering of responses from the proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyBuffers = Directive(
    name = "proxy_buffers",
    description = "Sets the number and size of buffers for reading a response from the proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyBusyBuffersSize = Directive(
    name = "proxy_busy_buffers_size",
    description = "Limits the total size of busy buffers that can be sent to the client",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCache = Directive(
    name = "proxy_cache",
    description = "Defines the cache zone to be used for storing responses from the proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheBackgroundUpdate = Directive(
    name = "proxy_cache_background_update",
    description = "Enables background updating of expired cache items",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheBypass = Directive(
    name = "proxy_cache_bypass",
    description = "Defines conditions under which the response will not be taken from the cache",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheConvertHead = Directive(
    name = "proxy_cache_convert_head",
    description = "Enables converting HEAD requests to GET requests for caching",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheKey = Directive(
    name = "proxy_cache_key",
    description = "Defines the key for caching a response from the proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheLock = Directive(
    name = "proxy_cache_lock",
    description = "Enables cache lock to prevent multiple simultaneous requests for the same content",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheLockAge = Directive(
    name = "proxy_cache_lock_age",
    description = "Sets the time during which subsequent requests will wait for the first request's response to be cached",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheLockTimeout = Directive(
    name = "proxy_cache_lock_timeout",
    description = "Sets the timeout for obtaining a cache lock",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheMaxRangeOffset = Directive(
    name = "proxy_cache_max_range_offset",
    description = "Sets the maximum allowed offset for range requests when caching",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheMethods = Directive(
    name = "proxy_cache_methods",
    description = "Defines HTTP methods that can be cached",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheMinUses = Directive(
    name = "proxy_cache_min_uses",
    description = "Sets the minimum number of requests before a response is cached",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCachePath = Directive(
    name = "proxy_cache_path",
    description = "Sets the path and configuration for the cache",
    context = listOf(http),
    module = ngx_http_proxy_module
)

val proxyCachePurge = Directive(
    name = "proxy_cache_purge",
    description = "Defines conditions for purging cache entries",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheRevalidate = Directive(
    name = "proxy_cache_revalidate",
    description = "Enables or disables revalidation of stale cache items",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheUseStale = Directive(
    name = "proxy_cache_use_stale",
    description = "Allows serving stale cached content under specific conditions",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCacheValid = Directive(
    name = "proxy_cache_valid",
    description = "Sets caching time for different response codes",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyConnectTimeout = Directive(
    name = "proxy_connect_timeout",
    description = "Defines a timeout for establishing a connection with a proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCookieDomain = Directive(
    name = "proxy_cookie_domain",
    description = "Sets the domain for the Set-Cookie header in responses from the proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCookieFlags = Directive(
    name = "proxy_cookie_flags",
    description = "Sets the flags for the Set-Cookie header in responses from the proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyCookiePath = Directive(
    name = "proxy_cookie_path",
    description = "Sets the path for the Set-Cookie header in responses from the proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyForceRanges = Directive(
    name = "proxy_force_ranges",
    description = "Enables byte-range support for proxied requests regardless of the Range request header field",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyHeadersHashBucketSize = Directive(
    name = "proxy_headers_hash_bucket_size",
    description = "Sets the bucket size for the hash tables used by proxy_hide_header and proxy_set_header directives",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyHeadersHashMaxSize = Directive(
    name = "proxy_headers_hash_max_size",
    description = "Sets the maximum size of the hash tables used by proxy_hide_header and proxy_set_header directives",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyHideHeader = Directive(
    name = "proxy_hide_header",
    description = "Prevents passing specified header fields from a proxied server to a client",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyHttpVersion = Directive(
    name = "proxy_http_version",
    description = "Sets the HTTP protocol version for proxying requests to the backend server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyIgnoreClientAbort = Directive(
    name = "proxy_ignore_client_abort",
    description = "Determines whether to ignore client aborts when sending requests to the proxied server",
        context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyIgnoreHeaders = Directive(
    name = "proxy_ignore_headers",
    description = "Disables processing of certain response headers from the proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyInterceptErrors = Directive(
    name = "proxy_intercept_errors",
    description = "Determines whether NGINX will process error responses from the proxied server or pass them directly to the client",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyLimitRate = Directive(
    name = "proxy_limit_rate",
    description = "Limits the transfer rate of a response from the proxied server to a client",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyMaxTempFileSize = Directive(
    name = "proxy_max_temp_file_size",
    description = "Limits the size of data written to a temporary file when the proxied server response cannot be stored in memory",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyMethod = Directive(
    name = "proxy_method",
    description = "Specifies a custom HTTP method to be used when forwarding requests to the proxied server, overriding the original client request method",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyNextUpstream = Directive(
    name = "proxy_next_upstream",
    description = "Specifies in which cases a request should be passed to the next server in the upstream group",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyNextUpstreamTimeout = Directive(
    name = "proxy_next_upstream_timeout",
    description = "Limits the time during which a request can be passed to the next server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyNextUpstreamTries = Directive(
    name = "proxy_next_upstream_tries",
    description = "Sets the maximum number of possible tries for passing a request to the next server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyNoCache = Directive(
    name = "proxy_no_cache",
    description = "Defines conditions under which the response will not be saved to a cache",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyPass = Directive(
    name = "proxy_pass",
    description = "Sets the protocol, address, and optional port of a proxied server. Can use domain names, IP addresses, and Unix sockets",
    context = listOf(location, locationIf, limitExcept),
    module = ngx_http_proxy_module
)

val proxyPassHeader = Directive(
    name = "proxy_pass_header",
    description = "Allows passing specified headers from the proxied server to the client, overriding the default header hiding behavior",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyPassRequestBody = Directive(
    name = "proxy_pass_request_body",
    description = "Determines whether the original request body is passed to the proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyPassRequestHeaders = Directive(
    name = "proxy_pass_request_headers",
    description = "Determines whether the original request headers are passed to the proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyPassTrailers = Directive(
    name = "proxy_pass_trailers",
    description = "Indicates whether trailer fields from the proxied server should be passed to the client",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyReadTimeout = Directive(
    name = "proxy_read_timeout",
    description = "Defines the timeout for reading a response from the proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyRedirect = Directive(
    name = "proxy_redirect",
    description = "Sets the text replacement for the Location and Refresh headers from the proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyRequestBuffering = Directive(
    name = "proxy_request_buffering",
    description = "Enables or disables buffering of a client request body",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySendLowat = Directive(
    name = "proxy_send_lowat",
    description = "Sets the low watermark for sending data to the proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySendTimeout = Directive(
    name = "proxy_send_timeout",
    description = "Sets a timeout for transmitting a request to the proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySetBody = Directive(
    name = "proxy_set_body",
    description = "Allows changing the request body before passing it to the proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySetHeader = Directive(
    name = "proxy_set_header",
    description = "Allows redefining or adding headers to be passed to the proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySocketKeepalive = Directive(
    name = "proxy_socket_keepalive",
    description = "Configures the TCP keepalive behavior for upstream connections",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslCertificate = Directive(
    name = "proxy_ssl_certificate",
    description = "Specifies the certificate file for authentication to a proxied HTTPS server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslCertificateCache = Directive(
    name = "proxy_ssl_certificate_cache",
    description = "Enables caching of SSL certificates used for authentication to a proxied HTTPS server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslCertificateKey = Directive(
    name = "proxy_ssl_certificate_key",
    description = "Specifies the secret key file for authentication to a proxied HTTPS server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslCiphers = Directive(
    name = "proxy_ssl_ciphers",
    description = "Specifies the enabled ciphers for requests to a proxied HTTPS server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslConfCommand = Directive(
    name = "proxy_ssl_conf_command",
    description = "Sets custom OpenSSL configuration commands for HTTPS connections to the proxied server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslCrl = Directive(
    name = "proxy_ssl_crl",
    description = "Specifies the certificate revocation list (CRL) file for verifying the certificate of the proxied HTTPS server",

    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslName = Directive(
    name = "proxy_ssl_name",
    description = "Sets the server name for TLS Server Name Indication (SNI) when connecting to a proxied HTTPS server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslPasswordFile = Directive(
    name = "proxy_ssl_password_file",
    description = "Specifies a file with passphrases for secret keys where each passphrase is specified on a separate line",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslProtocols = Directive(
    name = "proxy_ssl_protocols",
    description = "Specifies the SSL/TLS protocols to use when connecting to a proxied HTTPS server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslServerName = Directive(
    name = "proxy_ssl_server_name",
    description = "Enables or disables passing of the server name during SSL/TLS handshake to a proxied HTTPS server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslSessionReuse = Directive(
    name = "proxy_ssl_session_reuse",
    description = "Enables or disables reuse of SSL sessions when connecting to a proxied HTTPS server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslTrustedCertificate = Directive(
    name = "proxy_ssl_trusted_certificate",
    description = "Specifies the trusted CA certificates file for verifying the certificate of the proxied HTTPS server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslVerify = Directive(
    name = "proxy_ssl_verify",
    description = "Enables or disables verification of the proxied HTTPS server's certificate",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxySslVerifyDepth = Directive(
    name = "proxy_ssl_verify_depth",
    description = "Sets the maximum depth of certificate verification chain for a proxied HTTPS server",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyStore = Directive(
    name = "proxy_store",
    description = "Enables or sets the path for storing the response from the proxied server on the local file system",
    context = listOf(location),
    module = ngx_http_proxy_module
)

val proxyStoreAccess = Directive(
    name = "proxy_store_access",
    description = "Sets the access permissions for files stored by proxy_store directive",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyTempFileWriteSize = Directive(
    name = "proxy_temp_file_write_size",
    description = "Sets the size of data written to a temporary file at a time when proxying",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)

val proxyTempPath = Directive(
    name = "proxy_temp_path",
    description = "Sets the directory for storing temporary files when proxying",
    context = listOf(http, server, location),
    module = ngx_http_proxy_module
)
