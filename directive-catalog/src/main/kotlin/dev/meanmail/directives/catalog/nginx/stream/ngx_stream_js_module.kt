package dev.meanmail.directives.catalog.nginx.stream

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule
import dev.meanmail.directives.catalog.main

// https://nginx.org/en/docs/stream/ngx_stream_js_module.html

val ngx_stream_js_module = NginxModule(
    name = "ngx_stream_js_module",
    description = "Advanced stream module for integrating JavaScript functionality, enabling dynamic scripting for access control, filtering, variable manipulation, and custom stream processing"
)

val streamJsAccess = Directive(
    name = "js_access",
    description = "Defines a JavaScript function to perform access control for stream connections, called once during the access phase",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsContextReuse = Directive(
    name = "js_context_reuse",
    description = "Sets maximum number of JavaScript contexts to be reused for QuickJS engine. Each context is used for a single stream session",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsEngine = Directive(
    name = "js_engine",
    description = "Specifies the JavaScript engine to be used for njs scripts",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchBufferSize = Directive(
    name = "js_fetch_buffer_size",
    description = "Sets the size of the buffer used for reading and writing with Fetch API",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchCiphers = Directive(
    name = "js_fetch_ciphers",
    description = "Specifies the enabled ciphers for HTTPS connections with Fetch API",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchProtocols = Directive(
    name = "js_fetch_protocols",
    description = "Specifies the SSL/TLS protocols to be used in Fetch API connections",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchTimeout = Directive(
    name = "js_fetch_timeout",
    description = "Sets the timeout for Fetch API connections",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchTrustedCertificate = Directive(
    name = "js_fetch_trusted_certificate",
    description = "Specifies the path to a file with trusted CA certificates for Fetch API",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchVerify = Directive(
    name = "js_fetch_verify",
    description = "Enables or disables verification of the remote certificate",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchVerifyDepth = Directive(
    name = "js_fetch_verify_depth",
    description = "Sets the maximum depth of CA certificate chain verification",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFilter = Directive(
    name = "js_filter",
    description = "Defines a JavaScript function to filter and modify stream data in real-time",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsImport = Directive(
    name = "js_import",
    description = "Imports a JavaScript module for use in stream processing",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsSet = Directive(
    name = "js_set",
    description = "Sets a variable using a JavaScript function, allowing dynamic variable generation",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsVar = Directive(
    name = "js_var",
    description = "Declares a JavaScript variable in the stream or server context",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchMaxResponseBufferSize = Directive(
    name = "js_fetch_max_response_buffer_size",
    description = "Sets the maximum size of the response buffer for Fetch API operations",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsInclude = Directive(
    name = "js_include",
    description = "Includes a JavaScript file for use in stream processing",
    context = listOf(stream),
    module = ngx_stream_js_module
)

val streamJsPath = Directive(
    name = "js_path",
    description = "Sets the directory path for searching JavaScript modules",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsPeriodic = Directive(
    name = "js_periodic",
    description = "Configures periodic JavaScript tasks in stream context",
    context = listOf(streamServer),
    module = ngx_stream_js_module
)

val streamJsPreloadObject = Directive(
    name = "js_preload_object",
    description = "Preloads JavaScript objects for use in stream processing",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsPreread = Directive(
    name = "js_preread",
    description = "Defines a JavaScript function to process data before stream connection routing",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsSharedDictZone = Directive(
    name = "js_shared_dict_zone",
    description = "Configures a shared dictionary zone for JavaScript in stream context",
    context = listOf(stream),
    module = ngx_stream_js_module
)

val streamJsFetchKeepalive = Directive(
    name = "js_fetch_keepalive",
    description = "Activates the cache for connections to destination servers with Fetch API",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchKeepaliveRequests = Directive(
    name = "js_fetch_keepalive_requests",
    description = "Sets the maximum number of requests through one keepalive connection with Fetch API",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchKeepaliveTime = Directive(
    name = "js_fetch_keepalive_time",
    description = "Limits the maximum time for requests through one keepalive connection with Fetch API",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchKeepaliveTimeout = Directive(
    name = "js_fetch_keepalive_timeout",
    description = "Sets a timeout for idle keepalive connections to destination servers with Fetch API",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchProxy = Directive(
    name = "js_fetch_proxy",
    description = "Configures a forward proxy URL with Fetch API",
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val jsLoadStreamNativeModule = Directive(
    name = "js_load_stream_native_module",
    description = "Loads a native module (shared library) for use in Stream JavaScript code (QuickJS only)",
    context = listOf(main),
    module = ngx_stream_js_module
)
