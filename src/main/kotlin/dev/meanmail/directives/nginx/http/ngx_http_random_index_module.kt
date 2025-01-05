package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ToggleDirective

// https://nginx.org/en/docs/http/ngx_http_random_index_module.html

val ngx_http_random_index_module = NginxModule(
    "ngx_http_random_index_module",
    description = "Processes requests ending with '/' and picks a random file in a directory to serve as an index file",
    enabled = false
)

val randomIndex = ToggleDirective(
    name = "random_index",
    description = "Enables or disables processing of random index file selection in a location",
    context = listOf(location),
    module = ngx_http_random_index_module,
    enabled = false
)
