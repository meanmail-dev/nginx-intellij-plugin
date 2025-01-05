package dev.meanmail.directives.nginx.http.gzip

import dev.meanmail.directives.*
import dev.meanmail.directives.nginx.http.http
import dev.meanmail.directives.nginx.http.location
import dev.meanmail.directives.nginx.http.server

// https://nginx.org/en/docs/http/ngx_http_gzip_module.html

val ngx_http_gzip_module = NginxModule(
    "ngx_http_gzip_module",
    description = "Provides support for compressing HTTP responses using gzip to reduce transfer size",
    enabled = false
)

val gzip = ToggleDirective(
    name = "gzip",
    description = "Enables or disables gzipping of responses. When enabled, NGINX will compress HTTP responses to reduce bandwidth and improve transfer speed.",
    context = listOf(http, server, location),
    module = ngx_http_gzip_module,
    enabled = false
)

val gzipBuffers = Directive(
    name = "gzip_buffers",
    description = "Configures the number and size of buffers used for gzip compression. Controls memory allocation during compression process.",
    context = listOf(http, server, location),
    module = ngx_http_gzip_module,
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Number of buffers allocated for gzip compression. Determines memory allocation for compression.",
            valueType = ValueType.INTEGER,
            required = true
        ),
        DirectiveParameter(
            name = "size",
            description = "Size of each buffer used for compression. Defines memory chunk size during gzip processing.",
            valueType = ValueType.SIZE,
            required = true
        )
    )
)

val gzipCompLevel = Directive(
    name = "gzip_comp_level",
    description = "Sets the compression level for gzip, balancing between compression ratio and processing time.",
    context = listOf(http, server, location),
    module = ngx_http_gzip_module,
    parameters = listOf(
        DirectiveParameter(
            name = "level",
            description = "Compression level from 1 (least compression, fastest) to 9 (most compressed, slowest).",
            valueType = ValueType.NUMBER,
            required = true
        )
    )
)

val gzipDisable = Directive(
    name = "gzip_disable",
    description = "Disables gzip compression for clients matching specified regular expressions.",
    context = listOf(http, server, location),
    module = ngx_http_gzip_module,
    parameters = listOf(
        DirectiveParameter(
            name = "regex",
            description = "Regular expression to match against User-Agent header for excluding gzip compression.",
            valueType = ValueType.STRING,
            required = true
        )
    )
)

val gzipHttpVersion = Directive(
    name = "gzip_http_version",
    description = "Sets the minimum HTTP version required for gzip compression.",
    context = listOf(http, server, location),
    module = ngx_http_gzip_module,
    parameters = listOf(
        DirectiveParameter(
            name = "version",
            description = "Minimum HTTP version that supports gzip compression.",
            valueType = ValueType.STRING,
            required = true
        )
    )
)

val gzipMinLength = Directive(
    name = "gzip_min_length",
    description = "Sets the minimum length of a response to be eligible for gzip compression.",
    context = listOf(http, server, location),
    module = ngx_http_gzip_module,
    parameters = listOf(
        DirectiveParameter(
            name = "length",
            description = "Minimum response length (in bytes) required to apply gzip compression.",
            valueType = ValueType.SIZE,
            required = true
        )
    )
)

val gzipProxied = Directive(
    name = "gzip_proxied",
    description = "Enables gzip compression for proxied requests based on specific conditions.",
    context = listOf(http, server, location),
    module = ngx_http_gzip_module,
    parameters = listOf(
        DirectiveParameter(
            name = "mode",
            description = "Conditions for compressing proxied responses: off, expired, no-cache, no-store, private, no_last_modified, no_etag, auth.",
            valueType = ValueType.STRING,
            required = true
        )
    )
)

val gzipTypes = Directive(
    name = "gzip_types",
    description = "Specifies MIME types of responses that should be compressed.",
    context = listOf(http, server, location),
    module = ngx_http_gzip_module,
    parameters = listOf(
        DirectiveParameter(
            name = "mime_types",
            description = "List of MIME types to apply gzip compression.",
            valueType = ValueType.STRING,
            multiple = true,
            required = true
        )
    )
)

val gzipVary = ToggleDirective(
    name = "gzip_vary",
    description = "Enables or disables inserting the 'Vary: Accept-Encoding' response header field",
    context = listOf(http, server, location),
    module = ngx_http_gzip_module,
    enabled = false
)
