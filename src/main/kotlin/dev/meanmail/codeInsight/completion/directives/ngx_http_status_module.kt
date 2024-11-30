package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_status_module.html

val ngx_http_status_module = NginxModule(
    name = "ngx_http_status_module",
    description = """
        Provides access to various status information. 
        Formerly part of commercial subscription until version 1.13.10, 
        partially replaced by ngx_http_api_module.
        
        Allows retrieving detailed information about NGINX server status, 
        connections, requests, SSL handshakes, and other metrics.
    """.trimIndent(),
    enabled = true
)

val status = Directive(
    name = "status",
    description = """
        Enables status information access in the current location. 
        
        Notes:
        - Access to this location should be strictly limited
        - Provides comprehensive server status information
        - Requires careful configuration to prevent unauthorized access
    """.trimIndent(),
    parameters = listOf(),
    context = listOf(location),
    module = ngx_http_status_module
)

val statusFormat = Directive(
    name = "status_format",
    description = """
        Configures the output format for status information.
        
        Notes:
        - Default format is JSON
        - JSONP support allows cross-domain status retrieval
        - Callback parameter can contain variables
    """.trimIndent(),
    parameters = listOf(
        DirectiveParameter(
            name = "format",
            description = "Output format for status information",
            valueType = ValueType.STRING,
            required = true,
            defaultValue = "json",
            allowedValues = listOf("json", "jsonp")
        ),
        DirectiveParameter(
            name = "callback",
            description = """
                Optional callback function name for JSONP. 
                If omitted or empty, defaults to 'ngx_status_jsonp_callback'.
                Can contain variables.
            """.trimIndent(),
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_status_module
)
