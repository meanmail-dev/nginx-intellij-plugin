package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/ngx_google_perftools_module.html

val streamGooglePerftoolsProfiles = Directive("google_perftools_profiles")

val ngx_google_perftools_module = Module(
    "ngx_google_perftools_module",
    enabled = false,
    directives = setOf(
        streamGooglePerftoolsProfiles,
    )
)
