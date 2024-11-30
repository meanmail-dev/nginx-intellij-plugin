package dev.meanmail.codeInsight.completion.directives

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

val jsFetchCiphers = Directive(
    name = "js_fetch_ciphers",
    description = "Configures SSL/TLS ciphers for JavaScript fetch operations",
    parameters = listOf(
        DirectiveParameter(
            name = "ciphers",
            description = "List of allowed SSL/TLS ciphers",
            valueType = ValueType.STRING,
            required = false
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
            required = false
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
