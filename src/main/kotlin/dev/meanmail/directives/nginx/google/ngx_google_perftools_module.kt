package dev.meanmail.directives.nginx.google

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType
import dev.meanmail.directives.nginx.stream.stream

// https://nginx.org/en/docs/ngx_google_perftools_module.html

val ngx_google_perftools_module = NginxModule(
    name = "ngx_google_perftools_module",
    description = "Enables Google Perftools profiling for Nginx stream module",
    enabled = false
)

val streamGooglePerftoolsProfiles = Directive(
    "google_perftools_profiles",
    description = "Configures Google Perftools profiling for Nginx stream module",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the directory for storing profiling files",
            valueType = ValueType.PATH,
            required = true,
            defaultValue = "/tmp/nginx_profiles"
        )
    ),
    context = listOf(stream),
    module = ngx_google_perftools_module
)
