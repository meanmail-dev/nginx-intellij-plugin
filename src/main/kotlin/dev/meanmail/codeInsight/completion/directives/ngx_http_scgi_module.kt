package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_scgi_module.html

val scgiBind = Directive("scgi_bind")
val scgiBufferSize = Directive("scgi_buffer_size")
val scgiBuffering = ToggleDirective("scgi_buffering", true)
val scgiBuffers = Directive("scgi_buffers")
val scgiBusyBuffersSize = Directive("scgi_busy_buffers_size")
val scgiCache = Directive("scgi_cache")
val scgiCacheBackgroundUpdate = ToggleDirective("scgi_cache_background_update", false)
val scgiCacheBypass = Directive("scgi_cache_bypass")
val scgiCacheKey = Directive("scgi_cache_key")
val scgiCacheLock = ToggleDirective("scgi_cache_lock", false)
val scgiCacheLockAge = Directive(
    "scgi_cache_lock_age",
    defaultValue = "5s"
)
val scgiCacheLockTimeout = Directive(
    "scgi_cache_lock_timeout",
    defaultValue = "5s"
)
val scgiCacheMaxRangeOffset = Directive("scgi_cache_max_range_offset")
val scgiCacheMethods = Directive(
    "scgi_cache_methods",
    defaultValue = "GET HEAD"
)
val scgiCacheMinUses = Directive(
    "scgi_cache_min_uses",
    defaultValue = "1"
)
val scgiCachePath = Directive("scgi_cache_path")
val scgiCachePurge = Directive("scgi_cache_purge")
val scgiCacheRevalidate = ToggleDirective("scgi_cache_revalidate", false)
val scgiCacheUseStale = Directive(
    "scgi_cache_use_stale",
    defaultValue = "off"
)
val scgiCacheValid = Directive("scgi_cache_valid")
val scgiConnectTimeout = Directive(
    "scgi_connect_timeout",
    defaultValue = "60s"
)
val scgiForceRanges = ToggleDirective("scgi_force_ranges", false)
val scgiHideHeader = Directive("scgi_hide_header")
val scgiIgnoreClientAbort = ToggleDirective("scgi_ignore_client_abort", false)
val scgiIgnoreHeaders = Directive("scgi_ignore_headers")
val scgiInterceptErrors = ToggleDirective("scgi_intercept_errors", false)
val scgiLimitRate = Directive(
    "scgi_limit_rate",
    defaultValue = "0"
)
val scgiMaxTempFileSize = Directive(
    "scgi_max_temp_file_size",
    defaultValue = "1024m"
)
val scgiNextUpstream = Directive(
    "scgi_next_upstream",
    defaultValue = "timeout"
)
val scgiNextUpstreamTimeout = Directive(
    "scgi_next_upstream_timeout",
    defaultValue = "0"
)
val scgiNextUpstreamTries = Directive(
    "scgi_next_upstream_tries",
    defaultValue = "0"
)
val scgiNoCache = Directive("scgi_no_cache")
val scgiParam = Directive("scgi_param")
val scgiPass = Directive("scgi_pass")
val scgiPassHeader = Directive("scgi_pass_header")
val scgiPassRequestBody = ToggleDirective("scgi_pass_request_body", true)
val scgiPassRequestHeaders = ToggleDirective("scgi_pass_request_headers", true)
val scgiReadTimeout = Directive(
    "scgi_read_timeout",
    defaultValue = "60s"
)
val scgiRequestBuffering = ToggleDirective("scgi_request_buffering", true)
val scgiSendTimeout = Directive(
    "scgi_send_timeout",
    defaultValue = "60s"
)
val scgiSocketKeepalive = ToggleDirective("scgi_socket_keepalive", false)
val scgiStore = Directive(
    "scgi_store",
    defaultValue = "off"
)
val scgiStoreAccess = Directive(
    "scgi_store_access",
    defaultValue = "user:rw"
)
val scgiTempFileWriteSize = Directive("scgi_temp_file_write_size")
val scgiTempPath = Directive(
    "scgi_temp_path",
    defaultValue = "scgi_temp"
)

val ngx_http_scgi_module = Module(
    "ngx_http_scgi_module",
    enabled = true,
    directives = setOf(
        scgiBind,
        scgiBuffering,
        scgiBuffers,
        scgiBufferSize,
        scgiBusyBuffersSize,
        scgiCache,
        scgiCacheBackgroundUpdate,
        scgiCacheBypass,
        scgiCacheKey,
        scgiCacheLock,
        scgiCacheLockAge,
        scgiCacheLockTimeout,
        scgiCacheMaxRangeOffset,
        scgiCacheMethods,
        scgiCacheMinUses,
        scgiCachePath,
        scgiCachePurge,
        scgiCacheRevalidate,
        scgiCacheUseStale,
        scgiCacheValid,
        scgiConnectTimeout,
        scgiForceRanges,
        scgiHideHeader,
        scgiIgnoreClientAbort,
        scgiIgnoreHeaders,
        scgiInterceptErrors,
        scgiLimitRate,
        scgiMaxTempFileSize,
        scgiNextUpstream,
        scgiNextUpstreamTimeout,
        scgiNextUpstreamTries,
        scgiNoCache,
        scgiParam,
        scgiPass,
        scgiPassHeader,
        scgiPassRequestBody,
        scgiPassRequestHeaders,
        scgiReadTimeout,
        scgiRequestBuffering,
        scgiSendTimeout,
        scgiSocketKeepalive,
        scgiStore,
        scgiStoreAccess,
        scgiTempFileWriteSize,
        scgiTempPath,
    )
)
