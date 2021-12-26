package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_fastcgi_module.html

val fastcgiBind = Directive("fastcgi_bind")
val fastcgiBufferSize = Directive("fastcgi_buffer_size")
val fastcgiBuffering = ToggleDirective("fastcgi_buffering", true)
val fastcgiBuffers = Directive("fastcgi_buffers")
val fastcgiBusyBuffersSize = Directive("fastcgi_busy_buffers_size")
val fastcgiCache = Directive(
    "fastcgi_cache",
    defaultValue = "off"
)
val fastcgiCacheBackgroundUpdate = ToggleDirective("fastcgi_cache_background_update", false)
val fastcgiCacheBypass = Directive("fastcgi_cache_bypass")
val fastcgiCacheKey = Directive("fastcgi_cache_key")
val fastcgiCacheLock = ToggleDirective("fastcgi_cache_lock", false)
val fastcgiCacheLockAge = Directive(
    "fastcgi_cache_lock_age",
    defaultValue = "5s"
)
val fastcgiCacheLockTimeout = Directive(
    "fastcgi_cache_lock_timeout",
    defaultValue = "5s"
)
val fastcgiCacheMaxRangeOffset = Directive("fastcgi_cache_max_range_offset")
val fastcgiCacheMethods = Directive(
    "fastcgi_cache_methods",
    defaultValue = "GET HEAD"
)
val fastcgiCacheMinUses = Directive(
    "fastcgi_cache_min_uses",
    defaultValue = "1"
)
val fastcgiCachePath = Directive("fastcgi_cache_path")
val fastcgiCachePurge = Directive("fastcgi_cache_purge")
val fastcgiCacheRevalidate = ToggleDirective("fastcgi_cache_revalidate", false)
val fastcgiCacheUseStale = Directive(
    "fastcgi_cache_use_stale",
    defaultValue = "off"
)
val fastcgiCacheValid = Directive("fastcgi_cache_valid")
val fastcgiCatchStderr = Directive("fastcgi_catch_stderr")
val fastcgiConnectTimeout = Directive(
    "fastcgi_connect_timeout",
    defaultValue = "60s"
)
val fastcgiForceRanges = ToggleDirective("fastcgi_force_ranges", false)
val fastcgiHideHeader = Directive("fastcgi_hide_header")
val fastcgiIgnoreClientAbort = ToggleDirective("fastcgi_ignore_client_abort", false)
val fastcgiIgnoreHeaders = Directive("fastcgi_ignore_headers")
val fastcgiIndex = Directive("fastcgi_index")
val fastcgiInterceptErrors = ToggleDirective("fastcgi_intercept_errors", false)
val fastcgiKeepConn = ToggleDirective("fastcgi_keep_conn", false)
val fastcgiLimitRate = Directive(
    "fastcgi_limit_rate",
    defaultValue = "0"
)
val fastcgiMaxTempFileSize = Directive(
    "fastcgi_max_temp_file_size",
    defaultValue = "1024m"
)
val fastcgiNextUpstream = Directive(
    "fastcgi_next_upstream",
    defaultValue = "error timeout"
)
val fastcgiNextUpstreamTimeout = Directive(
    "fastcgi_next_upstream_timeout",
    defaultValue = "0"
)
val fastcgiNextUpstreamTries = Directive(
    "fastcgi_next_upstream_tries",
    defaultValue = "0"
)
val fastcgiNoCache = Directive("fastcgi_no_cache")
val fastcgiParam = Directive("fastcgi_param")
val fastcgiPass = Directive("fastcgi_pass")
val fastcgiPassHeader = Directive("fastcgi_pass_header")
val fastcgiPassRequestBody = ToggleDirective("fastcgi_pass_request_body", true)
val fastcgiPassRequestHeaders = ToggleDirective("fastcgi_pass_request_headers", true)
val fastcgiReadTimeout = Directive(
    "fastcgi_read_timeout",
    defaultValue = "60s"
)
val fastcgiRequestBuffering = ToggleDirective("fastcgi_request_buffering", true)
val fastcgiSendLowat = Directive(
    "fastcgi_send_lowat",
    defaultValue = "0"
)
val fastcgiSendTimeout = Directive(
    "fastcgi_send_timeout",
    defaultValue = "60s"
)
val fastcgiSocketKeepalive = ToggleDirective("fastcgi_socket_keepalive", false)
val fastcgiSplitPathInfo = Directive("fastcgi_split_path_info")
val fastcgiStore = Directive(
    "fastcgi_store",
    defaultValue = "off"
)
val fastcgiStoreAccess = Directive(
    "fastcgi_store_access",
    defaultValue = "user:rw"
)
val fastcgiTempFileWriteSize = Directive("fastcgi_temp_file_write_size")
val fastcgiTempPath = Directive(
    "fastcgi_temp_path",
    defaultValue = "fastcgi_temp"
)

val ngx_http_fastcgi_module = Module(
    "ngx_http_fastcgi_module",
    enabled = true,
    directives = setOf(
        fastcgiBind,
        fastcgiBuffering,
        fastcgiBuffers,
        fastcgiBufferSize,
        fastcgiBusyBuffersSize,
        fastcgiCache,
        fastcgiCacheBackgroundUpdate,
        fastcgiCacheBypass,
        fastcgiCacheKey,
        fastcgiCacheLock,
        fastcgiCacheLockAge,
        fastcgiCacheLockTimeout,
        fastcgiCacheMaxRangeOffset,
        fastcgiCacheMethods,
        fastcgiCacheMinUses,
        fastcgiCachePath,
        fastcgiCachePurge,
        fastcgiCacheRevalidate,
        fastcgiCacheUseStale,
        fastcgiCacheValid,
        fastcgiCatchStderr,
        fastcgiConnectTimeout,
        fastcgiForceRanges,
        fastcgiHideHeader,
        fastcgiIgnoreClientAbort,
        fastcgiIgnoreHeaders,
        fastcgiIndex,
        fastcgiInterceptErrors,
        fastcgiKeepConn,
        fastcgiLimitRate,
        fastcgiMaxTempFileSize,
        fastcgiNextUpstream,
        fastcgiNextUpstreamTimeout,
        fastcgiNextUpstreamTries,
        fastcgiNoCache,
        fastcgiParam,
        fastcgiPass,
        fastcgiPassHeader,
        fastcgiPassRequestBody,
        fastcgiPassRequestHeaders,
        fastcgiReadTimeout,
        fastcgiRequestBuffering,
        fastcgiSendLowat,
        fastcgiSendTimeout,
        fastcgiSocketKeepalive,
        fastcgiSplitPathInfo,
        fastcgiStore,
        fastcgiStoreAccess,
        fastcgiTempFileWriteSize,
        fastcgiTempPath,
    )
)
