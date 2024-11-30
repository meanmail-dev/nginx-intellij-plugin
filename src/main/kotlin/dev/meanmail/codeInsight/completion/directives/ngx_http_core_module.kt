package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_core_module.html

val ngx_http_core_module = NginxModule(
    "ngx_http_core_module",
    description = "The core HTTP module",
    enabled = true
)

val http = Directive(
    "http",
    description = "Enables HTTP support",
    parameters = listOf(
        DirectiveParameter(
            name = "http_config",
            description = "HTTP configuration parameters",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(main),
    module = ngx_http_core_module
)

val server = Directive(
    "server",
    description = "Starts a new server block",
    parameters = listOf(
        DirectiveParameter(
            name = "server_name",
            description = "Server name or names",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(http),
    module = ngx_http_core_module
)

val location = RecursiveDirective(
    "location",
    description = "Location directives are used to control the behavior of a single location in a server block.",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Location path or modifier",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(server),
    module = ngx_http_core_module
)

val absoluteRedirect = ToggleDirective(
    "absolute_redirect",
    "Enables or disables absolute redirects",
    true,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val aio = ToggleDirective(
    "aio",
    "Enables or disables asynchronous file I/O",
    false,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val aioWrite = ToggleDirective(
    "aio_write",
    "Enables or disables asynchronous file writing when aio is enabled",
    false,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val alias = Directive(
    "alias",
    description = "Defines an alternative location for serving files",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Replacement path for the location",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(location),
    module = ngx_http_core_module
)

val chunkedTransferEncoding = ToggleDirective(
    "chunked_transfer_encoding",
    "Enables or disables chunked transfer encoding",
    true,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val clientBodyBufferSize = Directive(
    "client_body_buffer_size",
    description = "Sets the buffer size for reading client request body",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Buffer size for client request body",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "8k | 16k"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val clientBodyInFileOnly = Directive(
    "client_body_in_file_only",
    description = "Controls client request body storage",
    parameters = listOf(
        DirectiveParameter(
            name = "mode",
            description = "Determines how client request body is stored",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "off",
            allowedValues = listOf("on", "clean", "off")
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val clientBodyInSingleBuffer = ToggleDirective(
    "client_body_in_single_buffer",
    "Enables or disables storing client request body in a single buffer",
    false,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val clientBodyTempPath = Directive(
    "client_body_temp_path",
    description = "Sets the directory for storing client request bodies",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to temporary directory for client request bodies",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val clientBodyTimeout = Directive(
    "client_body_timeout",
    description = "Sets the timeout for reading client request body",
    parameters = listOf(
        DirectiveParameter(
            name = "duration",
            description = "Timeout for reading client request body",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "60s"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val clientHeaderBufferSize = Directive(
    "client_header_buffer_size",
    description = "Sets the buffer size for reading client request headers",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Buffer size for client request headers",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "1k"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val clientHeaderTimeout = Directive(
    "client_header_timeout",
    description = "Sets the timeout for reading client request headers",
    parameters = listOf(
        DirectiveParameter(
            name = "duration",
            description = "Timeout for reading client request headers",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "60s"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val clientMaxBodySize = Directive(
    "client_max_body_size",
    description = "Sets the maximum allowed size of client request body",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum size of client request body",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "1m"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val defaultType = Directive(
    "default_type",
    description = "Sets the default MIME type for responses",
    parameters = listOf(
        DirectiveParameter(
            name = "mime_type",
            description = "Default MIME type when not determined by file extension",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "text/plain"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val directio = Directive(
    "directio",
    description = "Enables or sets the threshold for direct I/O",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Threshold size for direct I/O",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val directioAlignment = Directive(
    "directio_alignment",
    description = "Sets the alignment for direct I/O",
    parameters = listOf(
        DirectiveParameter(
            name = "bytes",
            description = "Alignment size for direct I/O",
            valueType = ValueType.SIZE,
            required = false
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val disableSymlinks = Directive(
    "disable_symlinks",
    description = "Controls symbolic link checking for files",
    parameters = listOf(
        DirectiveParameter(
            name = "mode",
            description = "Determines how symbolic links are handled",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "off",
            allowedValues = listOf("on", "off", "if_not_owner")
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val errorPage = Directive(
    "error_page",
    description = "Defines custom error pages for specific HTTP status codes",
    parameters = listOf(
        DirectiveParameter(
            name = "codes",
            description = "HTTP error codes to handle",
            valueType = ValueType.STRING_LIST,
            required = true
        ),
        DirectiveParameter(
            name = "uri",
            description = "URI or path to the custom error page",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val etag = ToggleDirective(
    "etag",
    "Enables or disables ETag response header",
    true,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val ifModifiedSince = Directive(
    "if_modified_since",
    description = "Controls handling of the If-Modified-Since request header",
    parameters = listOf(
        DirectiveParameter(
            name = "mode",
            description = "Determines how If-Modified-Since is processed",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "exact",
            allowedValues = listOf("exact", "before")
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val ignoreInvalidHeaders = ToggleDirective(
    "ignore_invalid_headers",
    "Enables or disables ignoring of invalid headers",
    true,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val internal = Directive(
    "internal",
    description = "Restricts access to a location to internal requests only",
    parameters = listOf(
        DirectiveParameter(
            name = "flag",
            description = "Marks the location as internal",
            valueType = ValueType.BOOLEAN,
            required = false
        )
    ),
    context = listOf(location),
    module = ngx_http_core_module
)

val keepaliveDisable = Directive(
    "keepalive_disable",
    description = "Disables keep-alive connections for specific user agents",
    parameters = listOf(
        DirectiveParameter(
            name = "user_agents",
            description = "List of user agents for which keep-alive is disabled",
            valueType = ValueType.STRING_LIST,
            required = false,
            defaultValue = "msie6"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_core_module
)

val keepaliveRequests = Directive(
    "keepalive_requests",
    description = "Sets the maximum number of requests that can be served through a keep-alive connection",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Maximum number of requests per keep-alive connection",
            valueType = ValueType.NUMBER,
            required = false,
            defaultValue = "100"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val keepaliveTime = Directive(
    "keepalive_time",
    description = "Sets the maximum time a keep-alive connection can be open",
    parameters = listOf(
        DirectiveParameter(
            name = "duration",
            description = "Maximum time for a keep-alive connection",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "1h"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val keepaliveTimeout = Directive(
    "keepalive_timeout",
    description = "Sets the timeout for keep-alive connections",
    parameters = listOf(
        DirectiveParameter(
            name = "duration",
            description = "Timeout for keep-alive connections",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "75s"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val largeClientHeaderBuffers = Directive(
    "large_client_header_buffers",
    description = "Sets the maximum number and size of buffers for large client headers",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Maximum number of buffers",
            valueType = ValueType.NUMBER,
            required = true
        ),
        DirectiveParameter(
            name = "size",
            description = "Size of each buffer",
            valueType = ValueType.SIZE,
            required = true,
            defaultValue = "32k"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val limitExcept = Directive(
    "limit_except",
    description = "Limit access to specific HTTP methods within a location block",
    parameters = listOf(
        DirectiveParameter(
            name = "methods",
            description = "HTTP methods to limit (GET, POST, PUT, DELETE, etc.)",
            valueType = ValueType.STRING_LIST,
            required = true
        )
    ),
    context = listOf(location),
    module = ngx_http_core_module
)

val limitRate = Directive(
    "limit_rate",
    description = "Limits the rate of response transmission to a client",
    parameters = listOf(
        DirectiveParameter(
            name = "rate",
            description = "Maximum transmission rate",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "0"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val limitRateAfter = Directive(
    "limit_rate_after",
    description = "Sets the amount of data transferred before rate limiting begins",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Amount of data before rate limiting",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "0"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val lingeringClose = Directive(
    "lingering_close",
    description = "Controls how NGINX handles lingering close of client connections",
    parameters = listOf(
        DirectiveParameter(
            name = "mode",
            description = "Lingering close mode",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "on",
            allowedValues = listOf("off", "on", "always")
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val lingeringTime = Directive(
    "lingering_time",
    description = "Sets the maximum time for lingering connections",
    parameters = listOf(
        DirectiveParameter(
            name = "duration",
            description = "Maximum time for lingering connections",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "30s"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val lingeringTimeout = Directive(
    "lingering_timeout",
    description = "Sets the timeout for lingering connections",
    parameters = listOf(
        DirectiveParameter(
            name = "duration",
            description = "Timeout for lingering connections",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "5s"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val logNotFound = ToggleDirective(
    "log_not_found",
    "Enables or disables logging of not found errors",
    true,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val logSubrequest = ToggleDirective(
    "log_subrequest",
    "Enables or disables logging of subrequests",
    false,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val maxErrors = Directive(
    "max_errors",
    description = "Sets the maximum number of errors before closing the connection",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Maximum number of errors",
            valueType = ValueType.NUMBER,
            required = false,
            defaultValue = "5"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val maxRanges = Directive(
    "max_ranges",
    description = "Sets the maximum number of ranges allowed in a request",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Maximum number of ranges",
            valueType = ValueType.NUMBER,
            required = false
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val mergeSlashes = ToggleDirective(
    "merge_slashes",
    "Enables or disables merging of consecutive slashes",
    true,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val msiePadding = ToggleDirective(
    "msie_padding",
    "Enables or disables MSIE padding",
    true,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val msieRefresh = ToggleDirective(
    "msie_refresh",
    "Enables or disables MSIE refresh",
    false,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val openFileCache = Directive(
    "open_file_cache",
    description = "Configures caching of file descriptors, file sizes, and modification times",
    parameters = listOf(
        DirectiveParameter(
            name = "max",
            description = "Maximum number of cached files",
            valueType = ValueType.NUMBER,
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val openFileCacheErrors = ToggleDirective(
    "open_file_cache_errors",
    "Enables or disables caching of file open errors",
    false,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val openFileCacheMinUses = Directive(
    "open_file_cache_min_uses",
    description = "Sets the minimum number of file uses to keep in cache",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Minimum number of file uses",
            valueType = ValueType.NUMBER,
            required = false,
            defaultValue = "1"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val openFileCacheValid = Directive(
    "open_file_cache_valid",
    description = "Sets the time after which cached file information is validated",
    parameters = listOf(
        DirectiveParameter(
            name = "duration",
            description = "Time for cache validation",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "60s"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val outputBuffers = Directive(
    "output_buffers",
    description = "Sets the number and size of buffers used for writing response",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Number of buffers",
            valueType = ValueType.NUMBER,
            required = true
        ),
        DirectiveParameter(
            name = "size",
            description = "Size of each buffer",
            valueType = ValueType.SIZE,
            required = true,
            defaultValue = "32k"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val portInRedirect = ToggleDirective(
    "port_in_redirect",
    "Enables or disables including port in redirects",
    true,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val postponeOutput = Directive(
    "postpone_output",
    description = "Sets the minimum amount of bytes to postpone output",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Minimum bytes to postpone output",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "1460"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val readAhead = Directive(
    "read_ahead",
    description = "Sets the size of read-ahead for file operations",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Read-ahead size",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "0"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val recursiveErrorPages = ToggleDirective(
    "recursive_error_pages",
    "Enables or disables recursive error page processing",
    false,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val requestPoolSize = Directive(
    "request_pool_size",
    description = "Sets the size of the request pool",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Size of the request pool",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "4k"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val resetTimedoutConnection = ToggleDirective(
    "reset_timedout_connection",
    "Enables or disables resetting of timed-out connections",
    false,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val resolver = Directive(
    "resolver",
    description = "Sets the name servers for DNS resolution",
    parameters = listOf(
        DirectiveParameter(
            name = "servers",
            description = "List of DNS name servers",
            valueType = ValueType.STRING_LIST,
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val resolverTimeout = Directive(
    "resolver_timeout",
    description = "Sets the timeout for DNS resolution",
    parameters = listOf(
        DirectiveParameter(
            name = "duration",
            description = "Timeout for DNS resolution",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "30s"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val root = Directive(
    "root",
    description = "Sets the root directory for location block",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Root directory path",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "html"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val satisfy = Directive(
    "satisfy",
    description = "Defines the access control logic for a location",
    parameters = listOf(
        DirectiveParameter(
            name = "mode",
            description = "Access control mode",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "all",
            allowedValues = listOf("all", "any")
        )
    ),
    context = listOf(location),
    module = ngx_http_core_module
)

val sendLowat = Directive(
    "send_lowat",
    description = "Sets the minimum amount of data to send in a single packet",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Minimum amount of data to send",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "0"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val sendTimeout = Directive(
    "send_timeout",
    description = "Sets the timeout for sending data to a client",
    parameters = listOf(
        DirectiveParameter(
            name = "duration",
            description = "Timeout for sending data",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "60s"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val sendfile = ToggleDirective(
    "sendfile",
    "Enables or disables sendfile",
    false,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val sendfileMaxChunk = Directive(
    "sendfile_max_chunk",
    description = "Sets the maximum chunk size for sendfile",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum chunk size for sendfile",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "2m"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val serverNameInRedirect = ToggleDirective(
    "server_name_in_redirect",
    "Enables or disables server name in redirect",
    false,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val serverNamesHashBucketSize = Directive(
    "server_names_hash_bucket_size",
    description = "Sets the bucket size for server names hash table",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Size of the server names hash table bucket",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "64"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_core_module
)

val serverNamesHashMaxSize = Directive(
    "server_names_hash_max_size",
    description = "Sets the maximum size of the server names hash table",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum size of the server names hash table",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "512"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_core_module
)

val serverTokens = ToggleDirective(
    "server_tokens",
    "Enables or disables displaying NGINX version in error messages and server response headers",
    true,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val subrequestOutputBufferSize = Directive(
    "subrequest_output_buffer_size",
    description = "Sets the buffer size for subrequest output",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Buffer size for subrequest output",
            valueType = ValueType.SIZE,
            required = false
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val typesHashBucketSize = Directive(
    "types_hash_bucket_size",
    description = "Sets the bucket size for the types hash table",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Size of the types hash table bucket in bytes",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "64"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_core_module
)

val typesHashMaxSize = Directive(
    "types_hash_max_size",
    description = "Sets the maximum size of the types hash table",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum size of the types hash table in bytes",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "1024"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_core_module
)

val types = Directive(
    "types",
    description = "Defines MIME types for file extensions",
    parameters = listOf(
        DirectiveParameter(
            name = "mime_types",
            description = "MIME type mappings for file extensions",
            valueType = ValueType.LIST,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val tryFiles = Directive(
    "try_files",
    description = "Checks the existence of files in a specified order and uses the first found file or performs an internal redirect",
    parameters = listOf(
        DirectiveParameter(
            name = "files_or_uri",
            description = "List of files or URIs to check in order",
            valueType = ValueType.LIST,
            required = true
        ),
        DirectiveParameter(
            name = "fallback",
            description = "Final action if no files are found (e.g., @named_location or error code)",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(location),
    module = ngx_http_core_module
)

val tcpNodelay = ToggleDirective(
    "tcp_nodelay",
    "Enables or disables the TCP_NODELAY option for keepalive connections",
    true,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val tcpNopush = ToggleDirective(
    "tcp_nopush",
    "Enables or disables the TCP_NOPUSH (or TCP_CORK) socket option",
    false,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val underscoresInHeaders = ToggleDirective(
    "underscores_in_headers",
    "Enables or disables allowing underscores in client request header names",
    false,
    context = listOf(http, server, location),
    module = ngx_http_core_module
)

val variablesHashBucketSize = Directive(
    "variables_hash_bucket_size",
    description = "Sets the bucket size for the variables hash table",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Size of the variables hash table bucket",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "64"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_core_module
)

val variablesHashMaxSize = Directive(
    "variables_hash_max_size",
    description = "Sets the maximum size of the variables hash table",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum size of the variables hash table",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "1024"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_core_module
)


val listen = Directive(
    "listen",
    description = "Configures the IP address and port for server block",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            description = "IP address and port to listen on",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "*:80 | *:8000"
        )
    ),
    context = listOf(server),
    module = ngx_http_core_module
)

val serverName = Directive(
    "server_name",
    description = "Sets the server names for the current server block",
    parameters = listOf(
        DirectiveParameter(
            name = "names",
            description = "One or more server names, separated by spaces",
            valueType = ValueType.STRING_LIST,
            required = false,
            defaultValue = ""
        )
    ),
    context = listOf(server),
    module = ngx_http_core_module
)
