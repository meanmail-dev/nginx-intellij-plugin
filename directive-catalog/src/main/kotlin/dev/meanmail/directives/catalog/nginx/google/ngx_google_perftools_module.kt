package dev.meanmail.directives.catalog.nginx.google

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/ngx_google_perftools_module.html

val ngx_google_perftools_module = NginxModule(
    name = "ngx_google_perftools_module",
    description = "Enables Google Perftools profiling for Nginx stream module"
)

val streamGooglePerftoolsProfiles = Directive(
    "google_perftools_profiles",
    description = "Configures Google Perftools profiling for Nginx stream module",
    context = listOf(main),
    module = ngx_google_perftools_module
)
