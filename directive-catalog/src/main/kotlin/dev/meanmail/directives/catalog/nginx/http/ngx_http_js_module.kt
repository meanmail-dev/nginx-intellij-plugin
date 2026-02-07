package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/http/ngx_http_js_module.html

val ngx_http_js_module = NginxModule(
    "ngx_http_js_module",
    description = "Provides JavaScript integration for dynamic request processing and configuration"
)

val jsImport = Directive(
    name = "js_import",
    description = "Imports JavaScript modules for use in Nginx configuration",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsInclude = Directive(
    name = "js_include",
    description = "Includes JavaScript files for use in Nginx configuration",
    context = listOf(http),
    module = ngx_http_js_module
)

val jsPath = Directive(
    name = "js_path",
    description = "Sets the search path for JavaScript modules used in Nginx configuration",
    context = listOf(http),
    module = ngx_http_js_module
)

val jsPeriodic = Directive(
    name = "js_periodic",
    description = "Specifies a content handler to run at regular interval. The handler receives a session object as its first argument, it also has access to global objects such as ngx.",
    context = listOf(location),
    module = ngx_http_js_module
)

val jsPreloadObject = Directive(
    name = "js_preload_object",
    description = "Preloads a JavaScript object for use in Nginx configuration",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsBodyFilter = Directive(
    name = "js_body_filter",
    description = "Applies a JavaScript function to modify the response body before sending to the client",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsContent = Directive(
    name = "js_content",
    description = "Specifies a JavaScript function to handle request content",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsContextReuse = Directive(
    name = "js_context_reuse",
    description = "Sets a maximum number of JS context to be reused for QuickJS engine. Each context is used for a single request. The finished context is put into a pool of reusable contexts. If the pool is full, the context is destroyed.",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsEngine = Directive(
    name = "js_engine",
    description = "Specifies the JavaScript engine to use for processing",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchBufferSize = Directive(
    name = "js_fetch_buffer_size",
    description = "Sets the size of the buffer used for reading and writing with Fetch API.",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchCiphers = Directive(
    name = "js_fetch_ciphers",
    description = "Configures SSL/TLS ciphers for JavaScript fetch operations",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchMaxResponseBufferSize = Directive(
    name = "js_fetch_max_response_buffer_size",
    description = "Sets the maximum size of the response received with Fetch API.",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchProtocols = Directive(
    name = "js_fetch_protocols",
    description = "Specifies SSL/TLS protocols for JavaScript fetch operations",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchTimeout = Directive(
    name = "js_fetch_timeout",
    description = "Defines a timeout for reading and writing for Fetch API. The timeout is set only between two successive read/write operations, not for the whole response. If no data is transmitted within this time, the connection is closed.",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchTrustedCertificate = Directive(
    name = "js_fetch_trusted_certificate",
    description = "Specifies a trusted certificate file for SSL/TLS verification in JavaScript fetch operations",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchVerify = Directive(
    name = "js_fetch_verify",
    description = "Enables or disables verification of the HTTPS server certificate with Fetch API.",
        context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchVerifyDepth = Directive(
    name = "js_fetch_verify_depth",
    description = "Sets the maximum depth of SSL certificate verification chain",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsHeaderFilter = Directive(
    name = "js_header_filter",
    description = "Applies a JavaScript function to modify response headers before sending to the client",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsSet = Directive(
    name = "js_set",
    description = "Sets an Nginx variable using a JavaScript function",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

var jsSharedDictZone = Directive(
    name = "js_shared_dict_zone",
    description = "Defines a shared memory zone for JavaScript objects",
    context = listOf(http),
    module = ngx_http_js_module
)

val jsVar = Directive(
    name = "js_var",
    description = "Sets an Nginx variable using a JavaScript expression",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchKeepalive = Directive(
    name = "js_fetch_keepalive",
    description = "Activates the cache for connections to destination servers with Fetch API",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchKeepaliveRequests = Directive(
    name = "js_fetch_keepalive_requests",
    description = "Sets the maximum number of requests through one keepalive connection with Fetch API",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchKeepaliveTime = Directive(
    name = "js_fetch_keepalive_time",
    description = "Limits the maximum time for requests through one keepalive connection with Fetch API",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchKeepaliveTimeout = Directive(
    name = "js_fetch_keepalive_timeout",
    description = "Sets a timeout for idle keepalive connections to destination servers with Fetch API",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchProxy = Directive(
    name = "js_fetch_proxy",
    description = "Configures a forward proxy URL with Fetch API",
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsLoadHttpNativeModule = Directive(
    name = "js_load_http_native_module",
    description = "Loads a native module (shared library) for use in HTTP JavaScript code (QuickJS only)",
    context = listOf(main),
    module = ngx_http_js_module
)
