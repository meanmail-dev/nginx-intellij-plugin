package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/http/ngx_http_referer_module.html

val ngx_http_referer_module = NginxModule(
    name = "ngx_http_referer_module",
    description = "Controls and validates HTTP referer headers to prevent unauthorized access",
    enabled = true
)

val refererHashBucketSize = Directive(
    name = "referer_hash_bucket_size",
    description = "Sets the size of hash bucket for the referer hash table to optimize memory usage",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Size of hash bucket in bytes (default varies by system architecture)",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "64"
        )
    ),
    context = listOf(http),
    module = ngx_http_referer_module
)

val refererHashMaxSize = Directive(
    name = "referer_hash_max_size",
    description = "Sets the maximum size of the referer hash table to control memory allocation",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum size of the hash table in bytes",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "1024"
        )
    ),
    context = listOf(http),
    module = ngx_http_referer_module
)

val validReferers = Directive(
    name = "valid_referers",
    description = "Defines a list of valid referrer sources for request validation and blocking",
    parameters = listOf(
        DirectiveParameter(
            name = "referers",
            description = "List of allowed referrer domains or patterns (none, blocked, server_names, *.example.com)",
            valueType = ValueType.STRING_LIST,
            required = false
        )
    ),
    context = listOf(server, location),
    module = ngx_http_referer_module
)
