package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/http/ngx_http_core_module.html

val ngx_http_core_module = NginxModule(
    "ngx_http_core_module",
    description = "The core HTTP module"
)

val http = Directive(
    "http",
    description = "Enables HTTP support",
    context = listOf(main),
    module = ngx_http_core_module
)

val server = Directive(
    "server",
    description = "Starts a new server block",
    context = listOf(http),
    module = ngx_http_core_module
)

val location = Directive(
    "location",
    description = "Location directives are used to control the behavior of a single location in a server block.",
    context = listOf(server, self),
    module = ngx_http_core_module
)

val absoluteRedirect = Directive(
    "absolute_redirect",
    "Enables or disables absolute redirects",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val aio = Directive(
    "aio",
    "Enables or disables asynchronous file I/O",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val aioWrite = Directive(
    "aio_write",
    "Enables or disables asynchronous file writing when aio is enabled",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val alias = Directive(
    "alias",
    description = "Defines an alternative location for serving files",
    context = listOf(location),
    module = ngx_http_core_module
)

val chunkedTransferEncoding = Directive(
    "chunked_transfer_encoding",
    "Enables or disables chunked transfer encoding",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val clientBodyBufferSize = Directive(
    "client_body_buffer_size",
    description = "Sets the buffer size for reading client request body",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val clientBodyInFileOnly = Directive(
    "client_body_in_file_only",
    description = "Controls client request body storage",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val clientBodyInSingleBuffer = Directive(
    "client_body_in_single_buffer",
    "Enables or disables storing client request body in a single buffer",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val clientBodyTempPath = Directive(
    "client_body_temp_path",
    description = "Sets the directory for storing client request bodies",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val clientBodyTimeout = Directive(
    "client_body_timeout",
    description = "Sets the timeout for reading client request body",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val clientHeaderBufferSize = Directive(
    "client_header_buffer_size",
    description = "Sets the buffer size for reading client request headers",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val clientHeaderTimeout = Directive(
    "client_header_timeout",
    description = "Sets the timeout for reading client request headers",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val clientMaxBodySize = Directive(
    "client_max_body_size",
    description = "Sets the maximum allowed size of client request body",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val defaultType = Directive(
    "default_type",
    description = "Sets the default MIME type for responses",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val directio = Directive(
    "directio",
    description = "Enables or sets the threshold for direct I/O",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val directioAlignment = Directive(
    "directio_alignment",
    description = "Sets the alignment for direct I/O",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val disableSymlinks = Directive(
    "disable_symlinks",
    description = "Controls symbolic link checking for files",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val errorPage = Directive(
    "error_page",
    description = "Defines custom error pages for specific HTTP status codes",
    context = listOf(http, server, location, locationIf),
    module = ngx_http_core_module
)

val etag = Directive(
    "etag",
    "Enables or disables ETag response header",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val ifModifiedSince = Directive(
    "if_modified_since",
    description = "Controls handling of the If-Modified-Since request header",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val ignoreInvalidHeaders = Directive(
    "ignore_invalid_headers",
    "Enables or disables ignoring of invalid headers",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val internal = Directive(
    "internal",
    description = "Restricts access to a location to internal requests only",
    context = listOf(location),
    module = ngx_http_core_module
)

val keepaliveDisable = Directive(
    "keepalive_disable",
    description = "Disables keep-alive connections for specific user agents",
    context = listOf(http, server),
    module = ngx_http_core_module
)

val keepaliveMinTimeout = Directive(
    "keepalive_min_timeout",
    description = "Sets the minimum timeout for keep-alive connections",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val keepaliveRequests = Directive(
    "keepalive_requests",
    description = "Sets the maximum number of requests that can be served through a keep-alive connection",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val keepaliveTime = Directive(
    "keepalive_time",
    description = "Sets the maximum time a keep-alive connection can be open",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val keepaliveTimeout = Directive(
    "keepalive_timeout",
    description = "Sets the timeout for keep-alive connections",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val largeClientHeaderBuffers = Directive(
    "large_client_header_buffers",
    description = "Sets the maximum number and size of buffers for large client headers",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val limitExcept = Directive(
    "limit_except",
    description = "Limit access to specific HTTP methods within a location block",
    context = listOf(location),
    module = ngx_http_core_module
)

val limitRate = Directive(
    "limit_rate",
    description = "Limits the rate of response transmission to a client",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val limitRateAfter = Directive(
    "limit_rate_after",
    description = "Sets the amount of data transferred before rate limiting begins",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val lingeringClose = Directive(
    "lingering_close",
    description = "Controls how NGINX handles lingering close of client connections",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val lingeringTime = Directive(
    "lingering_time",
    description = "Sets the maximum time for lingering connections",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val lingeringTimeout = Directive(
    "lingering_timeout",
    description = "Sets the timeout for lingering connections",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val logNotFound = Directive(
    "log_not_found",
    "Enables or disables logging of not found errors",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val logSubrequest = Directive(
    "log_subrequest",
    "Enables or disables logging of subrequests",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val maxErrors = Directive(
    "max_errors",
    description = "Sets the maximum number of errors before closing the connection",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val maxRanges = Directive(
    "max_ranges",
    description = "Sets the maximum number of ranges allowed in a request",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val mergeSlashes = Directive(
    "merge_slashes",
    "Enables or disables merging of consecutive slashes",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val msiePadding = Directive(
    "msie_padding",
    "Enables or disables MSIE padding",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val msieRefresh = Directive(
    "msie_refresh",
    "Enables or disables MSIE refresh",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val openFileCache = Directive(
    "open_file_cache",
    description = "Configures caching of file descriptors, file sizes, and modification times",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val openFileCacheErrors = Directive(
    "open_file_cache_errors",
    "Enables or disables caching of file open errors",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val openFileCacheMinUses = Directive(
    "open_file_cache_min_uses",
    description = "Sets the minimum number of file uses to keep in cache",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val openFileCacheValid = Directive(
    "open_file_cache_valid",
    description = "Sets the time after which cached file information is validated",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val outputBuffers = Directive(
    "output_buffers",
    description = "Sets the number and size of buffers used for writing response",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val portInRedirect = Directive(
    "port_in_redirect",
    "Enables or disables including port in redirects",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val postponeOutput = Directive(
    "postpone_output",
    description = "Sets the minimum amount of bytes to postpone output",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val readAhead = Directive(
    "read_ahead",
    description = "Sets the size of read-ahead for file operations",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val recursiveErrorPages = Directive(
    "recursive_error_pages",
    "Enables or disables recursive error page processing",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val requestPoolSize = Directive(
    "request_pool_size",
    description = "Sets the size of the request pool",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val resetTimedoutConnection = Directive(
    "reset_timedout_connection",
    "Enables or disables resetting of timed-out connections",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val resolver = Directive(
    "resolver",
    description = "Sets the name servers for DNS resolution",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val resolverTimeout = Directive(
    "resolver_timeout",
    description = "Sets the timeout for DNS resolution",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val root = Directive(
    "root",
    description = "Sets the root directory for location block",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val satisfy = Directive(
    "satisfy",
    description = "Defines the access control logic for a location",
    context = listOf(location),
    module = ngx_http_core_module
)

val sendLowat = Directive(
    "send_lowat",
    description = "Sets the minimum amount of data to send in a single packet",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val sendTimeout = Directive(
    "send_timeout",
    description = "Sets the timeout for sending data to a client",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val sendfile = Directive(
    "sendfile",
    "Enables or disables sendfile",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val sendfileMaxChunk = Directive(
    "sendfile_max_chunk",
    description = "Sets the maximum chunk size for sendfile",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val serverNameInRedirect = Directive(
    "server_name_in_redirect",
    "Enables or disables server name in redirect",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val serverNamesHashBucketSize = Directive(
    "server_names_hash_bucket_size",
    description = "Sets the bucket size for server names hash table",
    context = listOf(http, server),
    module = ngx_http_core_module
)

val serverNamesHashMaxSize = Directive(
    "server_names_hash_max_size",
    description = "Sets the maximum size of the server names hash table",
    context = listOf(http, server),
    module = ngx_http_core_module
)

val serverTokens = Directive(
    "server_tokens",
    "Enables or disables displaying NGINX version in error messages and server response headers",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val earlyHints = Directive(
    name = "early_hints",
    description = "Enables processing and forwarding of 103 Early Hints from upstream (proxy/gRPC)",
        context = listOf(http, server, location),
    module = ngx_http_core_module
)

val subrequestOutputBufferSize = Directive(
    "subrequest_output_buffer_size",
    description = "Sets the buffer size for subrequest output",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val typesHashBucketSize = Directive(
    "types_hash_bucket_size",
    description = "Sets the bucket size for the types hash table",
    context = listOf(http, server),
    module = ngx_http_core_module
)

val typesHashMaxSize = Directive(
    "types_hash_max_size",
    description = "Sets the maximum size of the types hash table",
    context = listOf(http, server),
    module = ngx_http_core_module
)

val types = Directive(
    "types",
    description = "Defines MIME types for file extensions",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val tryFiles = Directive(
    "try_files",
    description = "Checks the existence of files in a specified order and uses the first found file or performs an internal redirect",
    context = listOf(location),
    module = ngx_http_core_module
)

val tcpNodelay = Directive(
    "tcp_nodelay",
    "Enables or disables the TCP_NODELAY option for keepalive connections",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val tcpNopush = Directive(
    "tcp_nopush",
    "Enables or disables the TCP_NOPUSH (or TCP_CORK) socket option",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val underscoresInHeaders = Directive(
    "underscores_in_headers",
    "Enables or disables allowing underscores in client request header names",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val variablesHashBucketSize = Directive(
    "variables_hash_bucket_size",
    description = "Sets the bucket size for the variables hash table",
    context = listOf(http, server),
    module = ngx_http_core_module
)

val variablesHashMaxSize = Directive(
    "variables_hash_max_size",
    description = "Sets the maximum size of the variables hash table",
    context = listOf(http, server),
    module = ngx_http_core_module
)


val listen = Directive(
    "listen",
    description = "Configures the IP address and port for server block",
    context = listOf(server),
    module = ngx_http_core_module
)

val serverName = Directive(
    "server_name",
    description = "Sets the server names for the current server block",
    context = listOf(server),
    module = ngx_http_core_module
)

val authDelay = Directive(
    "auth_delay",
    "Delays processing of unauthorized requests with 401 response code to prevent timing attacks",
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val connectionPoolSize = Directive(
    "connection_pool_size",
    "Allows accurate tuning of per-connection memory allocations",
    context = listOf(http, server),
    module = ngx_http_core_module
)
