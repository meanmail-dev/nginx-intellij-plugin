package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_perl_module.html

val ngx_http_perl_module = NginxModule(
    name = "ngx_http_perl_module",
    description = "Implements location and variable handlers in Perl and allows Perl calls in SSI"
)

val perl = Directive(
    name = "perl",
    description = "Sets a Perl handler for the given location",
    context = listOf(location, limitExcept),
    module = ngx_http_perl_module
)

val perlModules = Directive(
    name = "perl_modules",
    description = "Sets an additional path for Perl modules",
    context = listOf(http),
    module = ngx_http_perl_module
)

val perlRequire = Directive(
    name = "perl_require",
    description = "Defines a module to be loaded during each reconfiguration",
    context = listOf(http),
    module = ngx_http_perl_module
)

val perlSet = Directive(
    name = "perl_set",
    description = "Installs a Perl handler for the specified variable",
    context = listOf(http),
    module = ngx_http_perl_module
)
