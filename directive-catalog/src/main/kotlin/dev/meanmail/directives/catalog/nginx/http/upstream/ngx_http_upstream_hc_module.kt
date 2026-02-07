package dev.meanmail.directives.catalog.nginx.http.upstream

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule
import dev.meanmail.directives.catalog.nginx.http.http
import dev.meanmail.directives.catalog.nginx.http.location

// https://nginx.org/en/docs/http/ngx_http_upstream_hc_module.html

val ngx_http_upstream_hc_module = NginxModule(
    name = "ngx_http_upstream_hc_module",
    description = """
        Allows enabling periodic health checks of the servers in an upstream group.
        
        Features:
        - Periodic health checks of upstream servers
        - Configurable test criteria for responses
        - Support for response status, headers, and body content checks
        
        Notes:
        - Server group must reside in shared memory
        - Most variables will have empty values when used with health checks
        - Available as part of commercial subscription
    """.trimIndent()
)

val health_check = Directive(
    name = "health_check",
    description = """
        Enables periodic health checks of the servers in an upstream group referenced 
        in the surrounding location.
        
        If a health check fails, the server will be considered unhealthy. Client requests 
        are not passed to unhealthy servers and servers in the "checking" state.
        
        Multiple health checks for the same group: a single failure of any check will 
        make the corresponding server be considered unhealthy.
    """.trimIndent(),
    context = listOf(location),
    module = ngx_http_upstream_hc_module
)

val match = Directive(
    name = "match",
    description = """
        Defines the named test set used to verify responses to health check requests.
        
        Can test:
        - Response status codes (e.g., status 200 or status 200-399)
        - Header presence and values (e.g., header Content-Type = text/html)
        - Response body content (using regular expressions)
    """.trimIndent(),
    context = listOf(http),
    module = ngx_http_upstream_hc_module
)
