package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_browser_module.html

val ngx_http_browser_module = NginxModule(
    "ngx_http_browser_module",
    description = "Enables browser detection and classification in Nginx"
)

val ancientBrowser = Directive(
    name = "ancient_browser",
    description = "Defines browsers considered outdated or ancient",
    context = listOf(http, server, location),
    module = ngx_http_browser_module
)

val ancientBrowserValue = Directive(
    name = "ancient_browser_value",
    description = "Sets the value returned for ancient browsers",
    context = listOf(http, server, location),
    module = ngx_http_browser_module
)

val modernBrowser = Directive(
    name = "modern_browser",
    description = "Defines browsers considered modern or up-to-date",
    context = listOf(http, server, location),
    module = ngx_http_browser_module
)

val modernBrowserValue = Directive(
    name = "modern_browser_value",
    description = "Sets the value returned for modern browsers",
    context = listOf(http, server, location),
    module = ngx_http_browser_module
)
