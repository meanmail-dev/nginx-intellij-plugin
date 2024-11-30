package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_gzip_static_module.html

val ngx_http_gzip_static_module = NginxModule(
    "ngx_http_gzip_static_module",
    description = "Module for serving pre-compressed files with .gz extension",
    enabled = false
)

val gzipStatic = Directive(
    name = "gzip_static",
    description = "Enables serving of pre-compressed .gz files instead of compressing files on-the-fly. Allows efficient delivery of static pre-compressed content.",
    context = listOf(location),
    module = ngx_http_gzip_static_module,
    parameters = listOf(
        DirectiveParameter(
            name = "mode",
            description = "Compression mode for static gzip files: 'on' (serve .gz if exists), 'off' (disable), 'always' (always prefer .gz file).",
            valueType = ValueType.STRING,
            required = false,
            allowedValues = listOf("on", "off", "always"),
            defaultValue = "off"
        )
    )
)
