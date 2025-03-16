package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.*

// https://nginx.org/en/docs/http/ngx_http_js_module.html

val ngx_http_js_module = NginxModule(
    "ngx_http_js_module",
    description = "Provides JavaScript integration for dynamic request processing and configuration",
    enabled = true
)

val jsImport = Directive(
    name = "js_import",
    description = "Imports JavaScript modules for use in Nginx configuration",
    parameters = listOf(
        DirectiveParameter(
            name = "module_path",
            description = "Path to the JavaScript module file",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http),
    module = ngx_http_js_module
)

val jsInclude = Directive(
    name = "js_include",
    description = "Includes JavaScript files for use in Nginx configuration",
    parameters = listOf(
        DirectiveParameter(
            name = "file_path",
            description = "Path to the JavaScript file to include",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http),
    module = ngx_http_js_module
)

val jsPath = Directive(
    name = "js_path",
    description = "Sets the search path for JavaScript modules used in Nginx configuration",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Directory path to search for JavaScript modules",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http),
    module = ngx_http_js_module
)

val jsPeriodic = Directive(
    name = "js_periodic",
    description = "Specifies a content handler to run at regular interval. The handler receives a session object as its first argument, it also has access to global objects such as ngx.",
    parameters = listOf(
        DirectiveParameter(
            name = "function",
            description = "JavaScript function to be executed periodically (function | module.function)",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "interval",
            description = "Interval in seconds for periodic JavaScript execution",
            valueType = ValueType.TIME,
            required = false
        ),
        DirectiveParameter(
            name = "jitter",
            description = "Jitter in seconds to randomize the execution time",
            valueType = ValueType.NUMBER,
            required = false
        ),
        DirectiveParameter(
            name = "worker_affinity",
            description = "Allows specifying particular worker processes where the location content handler should be executed. Each worker process set is represented by a bitmask of allowed worker processes. The all mask allows the handler to be executed in all worker processes.",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(location),
    module = ngx_http_js_module
)

val jsPreloadObject = Directive(
    name = "js_preload_object",
    description = "Preloads a JavaScript object for use in Nginx configuration",
    parameters = listOf(
        DirectiveParameter(
            name = "object_name",
            description = "Name of the JavaScript object to preload",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsBodyFilter = Directive(
    name = "js_body_filter",
    description = "Applies a JavaScript function to modify the response body before sending to the client",
    parameters = listOf(
        DirectiveParameter(
            name = "javascript_function",
            description = "JavaScript function to process and modify response body",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsContent = Directive(
    name = "js_content",
    description = "Specifies a JavaScript function to handle request content",
    parameters = listOf(
        DirectiveParameter(
            name = "javascript_function",
            description = "JavaScript function to process request content",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsContextReuse = Directive(
    name = "js_context_reuse",
    description = "Sets a maximum number of JS context to be reused for QuickJS engine. Each context is used for a single request. The finished context is put into a pool of reusable contexts. If the pool is full, the context is destroyed.",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Maximum number of JS contexts to be reused",
            valueType = ValueType.NUMBER,
            required = true,
            defaultValue = "128",
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsEngine = Directive(
    name = "js_engine",
    description = "Specifies the JavaScript engine to use for processing",
    parameters = listOf(
        DirectiveParameter(
            name = "engine_name",
            description = "Name of the JavaScript engine (e.g., 'quickjs')",
            valueType = ValueType.ENUM,
            allowedValues = listOf("njs", "qjs"),
            required = true,
            defaultValue = "njs"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchBufferSize = Directive(
    name = "js_fetch_buffer_size",
    description = "Sets the size of the buffer used for reading and writing with Fetch API.",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Buffer size in bytes",
            valueType = ValueType.SIZE,
            required = true,
            defaultValue = "16k"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchCiphers = Directive(
    name = "js_fetch_ciphers",
    description = "Configures SSL/TLS ciphers for JavaScript fetch operations",
    parameters = listOf(
        DirectiveParameter(
            name = "ciphers",
            description = "List of allowed SSL/TLS ciphers",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "HIGH:!aNULL:!MD5"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchMaxResponseBufferSize = Directive(
    name = "js_fetch_max_response_buffer_size",
    description = "Sets the maximum size of the response received with Fetch API.",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum response buffer size in bytes",
            valueType = ValueType.SIZE,
            required = true,
            defaultValue = "1m"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchProtocols = Directive(
    name = "js_fetch_protocols",
    description = "Specifies SSL/TLS protocols for JavaScript fetch operations",
    parameters = listOf(
        DirectiveParameter(
            name = "protocols",
            description = "List of allowed SSL/TLS protocols",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "TLSv1 TLSv1.1 TLSv1.2"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchTimeout = Directive(
    name = "js_fetch_timeout",
    description = "Defines a timeout for reading and writing for Fetch API. The timeout is set only between two successive read/write operations, not for the whole response. If no data is transmitted within this time, the connection is closed.",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Timeout duration in seconds",
            valueType = ValueType.TIME,
            required = true,
            defaultValue = "60s"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchTrustedCertificate = Directive(
    name = "js_fetch_trusted_certificate",
    description = "Specifies a trusted certificate file for SSL/TLS verification in JavaScript fetch operations",
    parameters = listOf(
        DirectiveParameter(
            name = "certificate_path",
            description = "Path to the trusted certificate file",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchVerify = ToggleDirective(
    name = "js_fetch_verify",
    description = "Enables or disables verification of the HTTPS server certificate with Fetch API.",
    enabled = true,
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsFetchVerifyDepth = Directive(
    name = "js_fetch_verify_depth",
    description = "Sets the maximum depth of SSL certificate verification chain",
    parameters = listOf(
        DirectiveParameter(
            name = "depth",
            description = "Maximum certificate verification chain depth",
            valueType = ValueType.NUMBER,
            required = false,
            defaultValue = "1"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsHeaderFilter = Directive(
    name = "js_header_filter",
    description = "Applies a JavaScript function to modify response headers before sending to the client",
    parameters = listOf(
        DirectiveParameter(
            name = "javascript_function",
            description = "JavaScript function to process and modify response headers",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

val jsSet = Directive(
    name = "js_set",
    description = "Sets an Nginx variable using a JavaScript function",
    parameters = listOf(
        DirectiveParameter(
            name = "javascript_function",
            description = "JavaScript function to generate variable value",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "variable",
            description = "Nginx variable to store the result",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_js_module
)

var jsSharedDictZone = Directive(
    name = "js_shared_dict_zone",
    description = "Defines a shared memory zone for JavaScript objects",
    parameters = listOf(
        DirectiveParameter(
            name = "zone_name",
            description = "Name of the shared memory zone (zone=name:size)",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "timeout",
            description = "Timeout for the shared memory zone in seconds",
            valueType = ValueType.TIME,
            required = false
        ),
        DirectiveParameter(
            name = "type",
            description = "Type of the shared memory zone (string|number)",
            valueType = ValueType.STRING,
            required = false
        ),
        DirectiveParameter(
            name = "evict",
            description = "Eviction policy for the shared memory zone (LRU|LFU)",
            valueType = ValueType.BOOLEAN,
            required = false
        )
    ),
    context = listOf(http),
    module = ngx_http_js_module
)

val jsVar = Directive(
    name = "js_var",
    description = "Sets an Nginx variable using a JavaScript expression",
    parameters = listOf(
        DirectiveParameter(
            name = "variable_name",
            description = "Name of the Nginx variable to set",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "javascript_expression",
            description = "JavaScript expression to set the variable value",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_js_module
)
