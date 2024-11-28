package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_proxy_module.html

val proxyBind = Directive("proxy_bind")
val proxyBufferSize = Directive("proxy_buffer_size")
val proxyBuffering = ToggleDirective("proxy_buffering", true)
val proxyBuffers = Directive("proxy_buffers")
val proxyBusyBuffersSize = Directive("proxy_busy_buffers_size")
val proxyCache = Directive(
    "proxy_cache",
    defaultValue = "off"
)
val proxyCacheBackgroundUpdate = ToggleDirective("proxy_cache_background_update", false)
val proxyCacheBypass = Directive("proxy_cache_bypass")
val proxyCacheConvertHead = ToggleDirective("proxy_cache_convert_head", true)
val proxyCacheKey = Directive(
    "proxy_cache_key",
    defaultValue = "\$scheme\$proxy_host\$request_uri"
)
val proxyCacheLock = ToggleDirective("proxy_cache_lock", false)
val proxyCacheLockAge = Directive(
    "proxy_cache_lock_age",
    defaultValue = "5s"
)
val proxyCacheLockTimeout = Directive(
    "proxy_cache_lock_timeout",
    defaultValue = "5s"
)
val proxyCacheMaxRangeOffset = Directive("proxy_cache_max_range_offset")
val proxyCacheMethods = Directive(
    "proxy_cache_methods",
    defaultValue = "GET HEAD"
)
val proxyCacheMinUses = Directive(
    "proxy_cache_min_uses",
    defaultValue = "1"
)
val proxyCachePath = Directive("")
val proxyCachePurge = Directive("proxy_cache_purge")
val proxyCacheRevalidate = ToggleDirective("proxy_cache_revalidate", false)
val proxyCacheUseStale = Directive(
    "proxy_cache_use_stale",
    defaultValue = "off"
)
val proxyCacheValid = Directive("proxy_cache_valid")
val proxyConnectTimeout = Directive(
    "proxy_connect_timeout",
    defaultValue = "60s"
)
val proxyCookieDomain = Directive(
    "proxy_cookie_domain",
    defaultValue = "off"
)
val proxyCookieFlags = Directive(
    "proxy_cookie_flags",
    defaultValue = "off"
)
val proxyCookiePath = Directive(
    "proxy_cookie_path",
    defaultValue = "off"
)
val proxyForceRanges = ToggleDirective("proxy_force_ranges", false)
val proxyHeadersHashBucketSize = Directive(
    "proxy_headers_hash_bucket_size",
    defaultValue = "64"
)
val proxyHeadersHashMaxSize = Directive(
    "proxy_headers_hash_max_size",
    defaultValue = "512"
)
val proxyHideHeader = Directive("proxy_hide_header")
val proxyHttpVersion = Directive(
    "proxy_http_version",
    setOf("1.0", "1.1"),
    defaultValue = "1.0"
)
val proxyIgnoreClientAbort = ToggleDirective("proxy_ignore_client_abort", false)
val proxyIgnoreHeaders = Directive("proxy_ignore_headers")
val proxyInterceptErrors = ToggleDirective("proxy_intercept_errors", false)
val proxyLimitRate = Directive(
    "proxy_limit_rate",
    defaultValue = "0"
)
val proxyMaxTempFileSize = Directive(
    "proxy_max_temp_file_size",
    defaultValue = "1024m"
)
val proxyMethod = Directive("proxy_method")
val proxyNextUpstream = Directive(
    "proxy_next_upstream",
    defaultValue = "error timeout"
)
val proxyNextUpstreamTimeout = Directive(
    "proxy_next_upstream_timeout",
    defaultValue = "0"
)
val proxyNextUpstreamTries = Directive(
    "proxy_next_upstream_tries",
    defaultValue = "0"
)
val proxyNoCache = Directive("proxy_no_cache")
val proxyPass = Directive("proxy_pass")

val proxyPassHeader = Directive("proxy_pass_header")
val proxyPassRequestBody = ToggleDirective("proxy_pass_request_body", true)
val proxyPassRequestHeaders = ToggleDirective("proxy_pass_request_headers", true)
val proxyPassTrailers = ToggleDirective("proxy_pass_trailers", false)
val proxyReadTimeout = Directive(
    "proxy_read_timeout",
    defaultValue = "60s"
)
val proxyRedirect = Directive(
    "proxy_redirect",
    defaultValue = "default"
)
val proxyRequestBuffering = ToggleDirective("proxy_request_buffering", true)
val proxySendLowat = Directive(
    "proxy_send_lowat",
    defaultValue = "0"
)
val proxySendTimeout = Directive(
    "proxy_send_timeout",
    defaultValue = "60s"
)
val proxySetBody = Directive("proxy_set_body")
val proxySetHeader = Directive("proxy_set_header")
val proxySocketKeepalive = ToggleDirective("proxy_socket_keepalive", false)
val proxySslCertificate = Directive("proxy_ssl_certificate")
val proxySslCertificateKey = Directive("proxy_ssl_certificate_key")
val proxySslCiphers = Directive(
    "proxy_ssl_ciphers",
    defaultValue = "DEFAULT"
)
val proxySslConfCommand = Directive("proxy_ssl_conf_command")
val proxySslCrl = Directive("proxy_ssl_crl")
val proxySslName = Directive(
    "proxy_ssl_name",
    defaultValue = "\$proxy_host"
)
val proxySslPasswordFile = Directive("proxy_ssl_password_file")
val proxySslProtocols = Directive(
    "proxy_ssl_protocols",
    defaultValue = "TLSv1 TLSv1.1 TLSv1.2"
)
val proxySslServerName = ToggleDirective("proxy_ssl_server_name", false)
val proxySslSessionReuse = ToggleDirective("proxy_ssl_session_reuse", true)
val proxySslTrustedCertificate = Directive("proxy_ssl_trusted_certificate")
val proxySslVerify = ToggleDirective("proxy_ssl_verify", false)
val proxySslVerifyDepth = Directive(
    "proxy_ssl_verify_depth",
    defaultValue = "1"
)
val proxyStore = Directive(
    "proxy_store",
    defaultValue = "off"
)
val proxyStoreAccess = Directive(
    "proxy_store_access",
    defaultValue = "user:rw"
)
val proxyTempFileWriteSize = Directive("proxy_temp_file_write_size")
val proxyTempPath = Directive("proxy_temp_path")

val ngx_http_proxy_module = Module(
    "ngx_http_proxy_module",
    enabled = true,
    directives = setOf(
        proxyBind,
        proxyBuffering,
        proxyBuffers,
        proxyBufferSize,
        proxyBusyBuffersSize,
        proxyCache,
        proxyCacheBackgroundUpdate,
        proxyCacheBypass,
        proxyCacheConvertHead,
        proxyCacheKey,
        proxyCacheLock,
        proxyCacheLockAge,
        proxyCacheLockTimeout,
        proxyCacheMaxRangeOffset,
        proxyCacheMethods,
        proxyCacheMinUses,
        proxyCachePath,
        proxyCachePurge,
        proxyCacheRevalidate,
        proxyCacheUseStale,
        proxyCacheValid,
        proxyConnectTimeout,
        proxyCookieDomain,
        proxyCookieFlags,
        proxyCookiePath,
        proxyForceRanges,
        proxyHeadersHashBucketSize,
        proxyHeadersHashMaxSize,
        proxyHideHeader,
        proxyHttpVersion,
        proxyIgnoreClientAbort,
        proxyIgnoreHeaders,
        proxyInterceptErrors,
        proxyLimitRate,
        proxyMaxTempFileSize,
        proxyMethod,
        proxyNextUpstream,
        proxyNextUpstreamTimeout,
        proxyNextUpstreamTries,
        proxyNoCache,
        proxyPass,
        proxyPassHeader,
        proxyPassRequestBody,
        proxyPassRequestHeaders,
        proxyPassTrailers,
        proxyReadTimeout,
        proxyRedirect,
        proxyRequestBuffering,
        proxySendLowat,
        proxySendTimeout,
        proxySetBody,
        proxySetHeader,
        proxySocketKeepalive,
        proxySslCertificate,
        proxySslCertificateKey,
        proxySslCiphers,
        proxySslConfCommand,
        proxySslCrl,
        proxySslName,
        proxySslPasswordFile,
        proxySslProtocols,
        proxySslServerName,
        proxySslSessionReuse,
        proxySslTrustedCertificate,
        proxySslVerify,
        proxySslVerifyDepth,
        proxyStore,
        proxyStoreAccess,
        proxyTempFileWriteSize,
        proxyTempPath,
    )
)
