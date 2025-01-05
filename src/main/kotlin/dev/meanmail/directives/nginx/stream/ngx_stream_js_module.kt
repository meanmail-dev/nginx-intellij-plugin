package dev.meanmail.directives.nginx.stream

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/stream/ngx_stream_js_module.html

val ngx_stream_js_module = NginxModule(
    name = "ngx_stream_js_module",
    description = "Advanced stream module for integrating JavaScript functionality, enabling dynamic scripting for access control, filtering, variable manipulation, and custom stream processing",
    enabled = true
)

val streamJsAccess = Directive(
    name = "js_access",
    description = "Defines a JavaScript function to perform access control for stream connections, called once during the access phase",
    parameters = listOf(
        DirectiveParameter(
            name = "function",
            description = "JavaScript function or module.function for access control",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsContextReuse = Directive(
    name = "js_context_reuse",
    description = "Sets maximum number of JavaScript contexts to be reused for QuickJS engine. Each context is used for a single stream session",
    parameters = listOf(
        DirectiveParameter(
            name = "max_contexts",
            description = "Maximum number of reusable JS contexts",
            valueType = ValueType.NUMBER,
            defaultValue = "128",
            required = false
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsEngine = Directive(
    name = "js_engine",
    description = "Specifies the JavaScript engine to be used for njs scripts",
    parameters = listOf(
        DirectiveParameter(
            name = "engine",
            description = "JavaScript engine type (njs or qjs)",
            valueType = ValueType.STRING,
            defaultValue = "njs",
            allowedValues = listOf("njs", "qjs"),
            required = true
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchBufferSize = Directive(
    name = "js_fetch_buffer_size",
    description = "Sets the size of the buffer used for reading and writing with Fetch API",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Buffer size for Fetch API operations",
            valueType = ValueType.SIZE,
            defaultValue = "16k",
            required = false
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchCiphers = Directive(
    name = "js_fetch_ciphers",
    description = "Specifies the enabled ciphers for HTTPS connections with Fetch API",
    parameters = listOf(
        DirectiveParameter(
            name = "ciphers",
            description = "OpenSSL-compatible cipher suite configuration",
            valueType = ValueType.STRING,
            defaultValue = "HIGH:!aNULL:!MD5",
            required = false
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchProtocols = Directive(
    name = "js_fetch_protocols",
    description = "Specifies the SSL/TLS protocols to be used in Fetch API connections",
    parameters = listOf(
        DirectiveParameter(
            name = "protocols",
            description = "List of allowed SSL/TLS protocols",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchTimeout = Directive(
    name = "js_fetch_timeout",
    description = "Sets the timeout for Fetch API connections",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Connection timeout duration",
            valueType = ValueType.TIME,
            required = false
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchTrustedCertificate = Directive(
    name = "js_fetch_trusted_certificate",
    description = "Specifies the path to a file with trusted CA certificates for Fetch API",
    parameters = listOf(
        DirectiveParameter(
            name = "certificate_file",
            description = "Path to trusted CA certificate file",
            valueType = ValueType.PATH,
            required = false
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchVerify = Directive(
    name = "js_fetch_verify",
    description = "Enables or disables verification of the remote certificate",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            description = "Enable (on) or disable (off) certificate verification",
            valueType = ValueType.BOOLEAN,
            defaultValue = "on",
            required = false
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchVerifyDepth = Directive(
    name = "js_fetch_verify_depth",
    description = "Sets the maximum depth of CA certificate chain verification",
    parameters = listOf(
        DirectiveParameter(
            name = "depth",
            description = "Maximum depth of certificate chain verification",
            valueType = ValueType.NUMBER,
            defaultValue = "1",
            required = false
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFilter = Directive(
    name = "js_filter",
    description = "Defines a JavaScript function to filter and modify stream data in real-time",
    parameters = listOf(
        DirectiveParameter(
            name = "function",
            description = "JavaScript function or module.function for stream data filtering",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsImport = Directive(
    name = "js_import",
    description = "Imports a JavaScript module for use in stream processing",
    parameters = listOf(
        DirectiveParameter(
            name = "module",
            description = "Path to the JavaScript module or module name",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(stream),
    module = ngx_stream_js_module
)

val streamJsSet = Directive(
    name = "js_set",
    description = "Sets a variable using a JavaScript function, allowing dynamic variable generation",
    parameters = listOf(
        DirectiveParameter(
            name = "variable",
            description = "Variable name to be set",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "function",
            description = "JavaScript function to generate variable value",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsVar = Directive(
    name = "js_var",
    description = "Declares a JavaScript variable in the stream or server context",
    parameters = listOf(
        DirectiveParameter(
            name = "variable",
            description = "Variable name",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "value",
            description = "Optional initial value for the variable",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsFetchMaxResponseBufferSize = Directive(
    name = "js_fetch_max_response_buffer_size",
    description = "Sets the maximum size of the response buffer for Fetch API operations",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum response buffer size",
            valueType = ValueType.SIZE,
            defaultValue = "1m",
            required = false
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsInclude = Directive(
    name = "js_include",
    description = "Includes a JavaScript file for use in stream processing",
    parameters = listOf(
        DirectiveParameter(
            name = "file",
            description = "Path to the JavaScript file to include",
            valueType = ValueType.PATH,
            required = true
        )
    ),
    context = listOf(stream),
    module = ngx_stream_js_module
)

val streamJsPath = Directive(
    name = "js_path",
    description = "Sets the directory path for searching JavaScript modules",
    parameters = listOf(
        DirectiveParameter(
            name = "directory",
            description = "Path to the directory containing JavaScript modules",
            valueType = ValueType.PATH,
            required = true
        )
    ),
    context = listOf(stream),
    module = ngx_stream_js_module
)

val streamJsPeriodic = Directive(
    name = "js_periodic",
    description = "Configures periodic JavaScript tasks in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "function",
            description = "JavaScript function to be executed periodically",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "interval",
            description = "Interval between periodic executions",
            valueType = ValueType.TIME,
            required = true
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsPreloadObject = Directive(
    name = "js_preload_object",
    description = "Preloads JavaScript objects for use in stream processing",
    parameters = listOf(
        DirectiveParameter(
            name = "object_name",
            description = "Name of the object to preload",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "path",
            description = "Path to the file containing the object",
            valueType = ValueType.PATH,
            required = true
        )
    ),
    context = listOf(stream),
    module = ngx_stream_js_module
)

val streamJsPreread = Directive(
    name = "js_preread",
    description = "Defines a JavaScript function to process data before stream connection routing",
    parameters = listOf(
        DirectiveParameter(
            name = "function",
            description = "JavaScript function for preread processing",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_js_module
)

val streamJsSharedDictZone = Directive(
    name = "js_shared_dict_zone",
    description = "Configures a shared dictionary zone for JavaScript in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "name",
            description = "Name of the shared dictionary zone",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "size",
            description = "Size of the shared dictionary zone",
            valueType = ValueType.SIZE,
            required = true
        )
    ),
    context = listOf(stream),
    module = ngx_stream_js_module
)
