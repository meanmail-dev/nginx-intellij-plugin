package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_userid_module.html

val ngx_http_userid_module = NginxModule(
    name = "ngx_http_userid_module",
    description = """
        The Userid module sets cookies suitable for client identification.
        Received and set cookies can be logged using embedded variables \$\uid_got and \$\uid_set.
        Compatible with mod_uid module for Apache.
    """.trimIndent()
)

val userid = Directive(
    name = "userid",
    description = "Enables or disables setting cookies and logging received cookies",
    context = listOf(http, server, location),
    module = ngx_http_userid_module
)

val useridDomain = Directive(
    name = "userid_domain",
    description = "Defines a domain for which the cookie is set",
    context = listOf(http, server, location),
    module = ngx_http_userid_module
)

val useridExpires = Directive(
    name = "userid_expires",
    description = "Sets the time during which a browser should keep the cookie",
    context = listOf(http, server, location),
    module = ngx_http_userid_module
)

val useridFlags = Directive(
    name = "userid_flags",
    description = "Defines additional flags for the cookie",
    context = listOf(http, server, location),
    module = ngx_http_userid_module
)

val useridMark = Directive(
    name = "userid_mark",
    description = "Sets a mark for the user identification cookie",
    context = listOf(http, server, location),
    module = ngx_http_userid_module
)

val useridName = Directive(
    name = "userid_name",
    description = "Sets the name of the user identification cookie",
    context = listOf(http, server, location),
    module = ngx_http_userid_module
)

val useridP3P = Directive(
    name = "userid_p3p",
    description = "Sets the P3P privacy policy for the user identification cookie",
    context = listOf(http, server, location),
    module = ngx_http_userid_module
)

val useridPath = Directive(
    name = "userid_path",
    description = "Sets the path for the user identification cookie",
    context = listOf(http, server, location),
    module = ngx_http_userid_module
)

val useridService = Directive(
    name = "userid_service",
    description = "Sets the service identifier for the user identification cookie",
    context = listOf(http, server, location),
    module = ngx_http_userid_module
)
