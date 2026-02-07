package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_referer_module.html

val ngx_http_referer_module = NginxModule(
    name = "ngx_http_referer_module",
    description = "Controls and validates HTTP referer headers to prevent unauthorized access"
)

val refererHashBucketSize = Directive(
    name = "referer_hash_bucket_size",
    description = "Sets the size of hash bucket for the referer hash table to optimize memory usage",
    context = listOf(http),
    module = ngx_http_referer_module
)

val refererHashMaxSize = Directive(
    name = "referer_hash_max_size",
    description = "Sets the maximum size of the referer hash table to control memory allocation",
    context = listOf(http),
    module = ngx_http_referer_module
)

val validReferers = Directive(
    name = "valid_referers",
    description = "Defines a list of valid referrer sources for request validation and blocking",
    context = listOf(server, location),
    module = ngx_http_referer_module
)
