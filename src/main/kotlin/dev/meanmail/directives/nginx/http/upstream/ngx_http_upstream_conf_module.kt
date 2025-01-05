package dev.meanmail.directives.nginx.http.upstream

import dev.meanmail.directives.Directive
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.nginx.http.location

// https://nginx.org/en/docs/http/ngx_http_upstream_conf_module.html

val ngx_http_upstream_conf_module = NginxModule(
    name = "ngx_http_upstream_conf_module",
    description = """
        Allows configuring upstream server groups on-the-fly via a simple HTTP interface 
        without the need of restarting nginx.
        
        Notes:
        - The upstream server group must reside in the shared memory
        - Was part of commercial subscription until 1.13.10
        - Superseded by ngx_http_api_module in 1.13.3
    """.trimIndent(),
    enabled = true
)

val upstreamConf = Directive(
    name = "upstream_conf",
    description = """
        Turns on the HTTP interface of upstream configuration in the surrounding location.
        Access to this location should be limited.
        
        Features:
        - View group configuration
        - View, modify, or remove a server
        - Add a new server
        
        Note: Since addresses in a group are not required to be unique, specific servers 
        in a group are referenced by their IDs.
    """.trimIndent(),
    parameters = emptyList(),
    context = listOf(location),
    module = ngx_http_upstream_conf_module
)
