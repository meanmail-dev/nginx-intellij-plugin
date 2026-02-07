package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_stub_status_module.html

val ngx_http_stub_status_module = NginxModule(
    name = "ngx_http_stub_status_module",
    description = """
        Provides access to basic status information.
        
        Features:
        - Basic server status data including active connections, requests, etc.
        - Embedded variables support since version 1.3.14
        - Not built by default, requires --with-http_stub_status_module
        
        Note: Module must be explicitly enabled during NGINX compilation
    """.trimIndent()
)

val stubStatus = Directive(
    name = "stub_status",
    description = """
        Enables basic status information page in the surrounding location.
        
        Status information includes:
        - Active connections (current number including Waiting)
        - Total accepted/handled connections and requests
        - Current reading/writing/waiting connections
        
        Note: Prior to 1.7.5, required an argument (e.g., "stub_status on")
    """.trimIndent(),
    context = listOf(server, location),
    module = ngx_http_stub_status_module
)
