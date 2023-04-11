package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_ssi_module.html

val ssi = ToggleDirective("ssi", false)
val ssiLastModified = ToggleDirective("ssi_last_modified", false)
val ssiMinFileChunk = Directive(
    "ssi_min_file_chunk",
    defaultValue = "1k"
)
val ssiSilentErrors = ToggleDirective("ssi_silent_errors", false)
val ssiTypes = Directive(
    "ssi_types",
    defaultValue = "text/html"
)
val ssiValueLength = Directive(
    "ssi_value_length",
    defaultValue = "256"
)

val ngx_http_ssi_module = Module(
    "ngx_http_ssi_module",
    enabled = true,
    directives = setOf(
        ssi,
        ssiLastModified,
        ssiMinFileChunk,
        ssiSilentErrors,
        ssiTypes,
        ssiValueLength,
    )
)
