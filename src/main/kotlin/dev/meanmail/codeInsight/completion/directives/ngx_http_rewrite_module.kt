package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_rewrite_module.html

val ngx_http_rewrite_module = NginxModule(
    name = "ngx_http_rewrite_module",
    description = "Provides URI transformation, conditional configuration selection, and request processing control using PCRE regular expressions",
    enabled = true
)

val locationIf = RecursiveDirective(
    name = "if",
    description = "Creates a conditional block within a location context, executing directives when the specified condition is true",
    parameters = listOf(
        DirectiveParameter(
            name = "condition",
            description = "Condition to evaluate, supporting variable checks, comparisons, regex matching, and file existence tests",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(location),
    module = ngx_http_rewrite_module
)

val `break` = Directive(
    name = "break",
    description = "Stops processing the current set of rewrite module directives and continues request processing in the current location",
    parameters = listOf(
        DirectiveParameter(
            name = "none",
            description = "No parameters required. Immediately stops further processing of rewrite directives",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(server, location, locationIf),
    module = ngx_http_rewrite_module
)

val `return` = Directive(
    name = "return",
    description = "Stops request processing and returns a specified HTTP status code or redirects to another URL",
    parameters = listOf(
        DirectiveParameter(
            name = "code",
            description = "HTTP status code (e.g., 200, 301, 404) or URL for redirection",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(server, location, locationIf),
    module = ngx_http_rewrite_module
)

val rewrite = Directive(
    name = "rewrite",
    description = "Modifies the request URI using PCRE regular expressions, potentially changing the request processing path",
    parameters = listOf(
        DirectiveParameter(
            name = "regex",
            description = "PCRE regular expression to match and transform the request URI",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "replacement",
            description = "Replacement URI pattern, can include captured regex groups",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "flag",
            description = "Optional processing flag (last, break, redirect, permanent)",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(server, location, locationIf),
    module = ngx_http_rewrite_module
)

val rewriteLog = ToggleDirective(
    name = "rewrite_log",
    description = "Enables or disables logging of rewrite module directive processing for debugging",
    context = listOf(http, server, location),
    module = ngx_http_rewrite_module,
    enabled = false
)

val set = Directive(
    name = "set",
    description = "Assigns a value to a specified NGINX variable for dynamic request processing",
    parameters = listOf(
        DirectiveParameter(
            name = "variable",
            description = "Name of the NGINX variable to set",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "value",
            description = "Value to assign to the variable, can include dynamic expressions",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(server, location, locationIf),
    module = ngx_http_rewrite_module
)

val uninitializedVariableWarn = ToggleDirective(
    name = "uninitialized_variable_warn",
    description = "Controls logging of warnings when uninitialized variables are encountered during request processing",
    context = listOf(http, server, location),
    module = ngx_http_rewrite_module,
    enabled = true
)

val `if` = RecursiveDirective(
    name = "if",
    description = "Creates a conditional configuration block that executes directives when the specified condition is true",
    parameters = listOf(
        DirectiveParameter(
            name = "condition",
            description = "Condition to evaluate, supporting variable checks, comparisons, regex matching, and file existence tests",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(server, location),
    module = ngx_http_rewrite_module
)
