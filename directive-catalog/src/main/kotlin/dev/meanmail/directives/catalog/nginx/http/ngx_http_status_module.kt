package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_status_module.html

val ngx_http_status_module = NginxModule(
    name = "ngx_http_status_module",
    description = """
        Provides access to various status information. 
        Formerly part of commercial subscription until version 1.13.10, 
        partially replaced by ngx_http_api_module.
        
        Allows retrieving detailed information about NGINX server status, 
        connections, requests, SSL handshakes, and other metrics.
    """.trimIndent()
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
    context = listOf(http, server, location),
    module = ngx_http_status_module
)
