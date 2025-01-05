package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/http/ngx_http_perl_module.html

val ngx_http_perl_module = NginxModule(
    name = "ngx_http_perl_module",
    description = "Implements location and variable handlers in Perl and allows Perl calls in SSI",
    enabled = true
)

val perl = Directive(
    name = "perl",
    description = "Sets a Perl handler for the given location",
    parameters = listOf(
        DirectiveParameter(
            name = "handler",
            description = "Perl module::function or anonymous subroutine",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(location, limitExcept),
    module = ngx_http_perl_module
)

val perlModules = Directive(
    name = "perl_modules",
    description = "Sets an additional path for Perl modules",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Directory path for additional Perl modules",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http),
    module = ngx_http_perl_module
)

val perlRequire = Directive(
    name = "perl_require",
    description = "Defines a module to be loaded during each reconfiguration",
    parameters = listOf(
        DirectiveParameter(
            name = "module",
            description = "Name of the Perl module to require",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http),
    module = ngx_http_perl_module
)

val perlSet = Directive(
    name = "perl_set",
    description = "Installs a Perl handler for the specified variable",
    parameters = listOf(
        DirectiveParameter(
            name = "variable",
            description = "NGINX variable to set using Perl",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "handler",
            description = "Perl module::function or anonymous subroutine",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http),
    module = ngx_http_perl_module
)
