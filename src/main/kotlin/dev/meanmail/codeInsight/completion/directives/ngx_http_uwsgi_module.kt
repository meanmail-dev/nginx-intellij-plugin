package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_uwsgi_module.html

val uwsgiBind = Directive("uwsgi_bind")
val uwsgiBufferSize = Directive("uwsgi_buffer_size")
val uwsgiBuffering = ToggleDirective("uwsgi_buffering", true)
val uwsgiBuffers = Directive("uwsgi_buffers")
val uwsgiBusyBuffersSize = Directive("uwsgi_busy_buffers_size")
val uwsgiCache = Directive(
    "uwsgi_cache",
    defaultValue = "off"
)
val uwsgiCacheBackgroundUpdate = ToggleDirective("uwsgi_cache_background_update", false)
val uwsgiCacheBypass = Directive("uwsgi_cache_bypass")
val uwsgiCacheKey = Directive("uwsgi_cache_key")
val uwsgiCacheLock = ToggleDirective("uwsgi_cache_lock", false)
val uwsgiCacheLockAge = Directive(
    "uwsgi_cache_lock_age",
    defaultValue = "5s"
)
val uwsgiCacheLockTimeout = Directive(
    "uwsgi_cache_lock_timeout",
    defaultValue = "5s"
)
val uwsgiCacheMaxRangeOffset = Directive("uwsgi_cache_max_range_offset")
val uwsgiCacheMethods = Directive(
    "uwsgi_cache_methods",
    defaultValue = "GET HEAD"
)
val uwsgiCacheMinUses = Directive(
    "uwsgi_cache_min_uses",
    defaultValue = "1"
)
val uwsgiCachePath = Directive("uwsgi_cache_path")
val uwsgiCachePurge = Directive("uwsgi_cache_purge")
val uwsgiCacheRevalidate = ToggleDirective("uwsgi_cache_revalidate", false)
val uwsgiCacheUseStale = Directive(
    "uwsgi_cache_use_stale",
    defaultValue = "off"
)
val uwsgiCacheValid = Directive("uwsgi_cache_valid")
val uwsgiConnectTimeout = Directive(
    "uwsgi_connect_timeout",
    defaultValue = "60s"
)
val uwsgiForceRanges = ToggleDirective("uwsgi_force_ranges", false)
val uwsgiHideHeader = Directive("uwsgi_hide_header")
val uwsgiIgnoreClientAbort = ToggleDirective("uwsgi_ignore_client_abort", false)
val uwsgiIgnoreHeaders = Directive("uwsgi_ignore_headers")
val uwsgiInterceptErrors = ToggleDirective("uwsgi_intercept_errors", false)
val uwsgiLimitRate = Directive(
    "uwsgi_limit_rate",
    defaultValue = "0"
)
val uwsgiMaxTempFileSize = Directive(
    "uwsgi_max_temp_file_size",
    defaultValue = "1024m"
)
val uwsgiModifier1 = Directive(
    "uwsgi_modifier1",
    defaultValue = "0"
)
val uwsgiModifier2 = Directive(
    "uwsgi_modifier2",
    defaultValue = "0"
)
val uwsgiNextUpstream = Directive(
    "uwsgi_next_upstream",
    defaultValue = "error timeout"
)
val uwsgiNextUpstreamTimeout = Directive(
    "uwsgi_next_upstream_timeout",
    defaultValue = "0"
)
val uwsgiNextUpstreamTries = Directive(
    "uwsgi_next_upstream_tries",
    defaultValue = "0"
)
val uwsgiNoCache = Directive("uwsgi_no_cache")
val uwsgiParam = Directive("uwsgi_param")
val uwsgiPass = Directive("uwsgi_pass")
val uwsgiPassHeader = Directive("uwsgi_pass_header")
val uwsgiPassRequestBody = ToggleDirective("uwsgi_pass_request_body", true)
val uwsgiPassRequestHeaders = ToggleDirective("uwsgi_pass_request_headers", true)
val uwsgiReadTimeout = Directive(
    "uwsgi_read_timeout",
    defaultValue = "60s"
)
val uwsgiRequestBuffering = ToggleDirective("uwsgi_request_buffering", true)
val uwsgiSendTimeout = Directive(
    "uwsgi_send_timeout",
    defaultValue = "60s"
)
val uwsgiSocketKeepalive = ToggleDirective("uwsgi_socket_keepalive", false)
val uwsgiSslCertificate = Directive("uwsgi_ssl_certificate")
val uwsgiSslCertificateKey = Directive("uwsgi_ssl_certificate_key")
val uwsgiSslCiphers = Directive(
    "uwsgi_ssl_ciphers",
    defaultValue = "DEFAULT"
)
val uwsgiSslConfCommand = Directive("uwsgi_ssl_conf_command")
val uwsgiSslCrl = Directive("uwsgi_ssl_crl")
val uwsgiSslName = Directive("uwsgi_ssl_name")
val uwsgiSslPasswordFile = Directive("uwsgi_ssl_password_file")
val uwsgiSslProtocols = Directive("uwsgi_ssl_protocols")
val uwsgiSslServerName = ToggleDirective("uwsgi_ssl_server_name", false)
val uwsgiSslSessionReuse = ToggleDirective("uwsgi_ssl_session_reuse", true)
val uwsgiSslTrustedCertificate = Directive("uwsgi_ssl_trusted_certificate")
val uwsgiSslVerify = ToggleDirective("uwsgi_ssl_verify", false)
val uwsgiSslVerifyDepth = Directive(
    "uwsgi_ssl_verify_depth",
    defaultValue = "1"
)
val uwsgiStore = Directive(
    "uwsgi_store",
    defaultValue = "off"
)
val uwsgiStoreAccess = Directive(
    "uwsgi_store_access",
    defaultValue = "user:rw"
)
val uwsgiTempFileWriteSize = Directive("uwsgi_temp_file_write_size")
val uwsgiTempPath = Directive(
    "uwsgi_temp_path",
    defaultValue = "uwsgi_temp"
)

val ngx_http_uwsgi_module = Module(
    "ngx_http_uwsgi_module",
    enabled = true,
    directives = setOf(
        uwsgiBind,
        uwsgiBuffering,
        uwsgiBuffers,
        uwsgiBufferSize,
        uwsgiBusyBuffersSize,
        uwsgiCache,
        uwsgiCacheBackgroundUpdate,
        uwsgiCacheBypass,
        uwsgiCacheKey,
        uwsgiCacheLock,
        uwsgiCacheLockAge,
        uwsgiCacheLockTimeout,
        uwsgiCacheMaxRangeOffset,
        uwsgiCacheMethods,
        uwsgiCacheMinUses,
        uwsgiCachePath,
        uwsgiCachePurge,
        uwsgiCacheRevalidate,
        uwsgiCacheUseStale,
        uwsgiCacheValid,
        uwsgiConnectTimeout,
        uwsgiForceRanges,
        uwsgiHideHeader,
        uwsgiIgnoreClientAbort,
        uwsgiIgnoreHeaders,
        uwsgiInterceptErrors,
        uwsgiLimitRate,
        uwsgiMaxTempFileSize,
        uwsgiModifier1,
        uwsgiModifier2,
        uwsgiNextUpstream,
        uwsgiNextUpstreamTimeout,
        uwsgiNextUpstreamTries,
        uwsgiNoCache,
        uwsgiParam,
        uwsgiPass,
        uwsgiPassHeader,
        uwsgiPassRequestBody,
        uwsgiPassRequestHeaders,
        uwsgiReadTimeout,
        uwsgiRequestBuffering,
        uwsgiSendTimeout,
        uwsgiSocketKeepalive,
        uwsgiSslCertificate,
        uwsgiSslCertificateKey,
        uwsgiSslCiphers,
        uwsgiSslConfCommand,
        uwsgiSslCrl,
        uwsgiSslName,
        uwsgiSslPasswordFile,
        uwsgiSslProtocols,
        uwsgiSslServerName,
        uwsgiSslSessionReuse,
        uwsgiSslTrustedCertificate,
        uwsgiSslVerify,
        uwsgiSslVerifyDepth,
        uwsgiStore,
        uwsgiStoreAccess,
        uwsgiTempFileWriteSize,
        uwsgiTempPath,
    )
)
