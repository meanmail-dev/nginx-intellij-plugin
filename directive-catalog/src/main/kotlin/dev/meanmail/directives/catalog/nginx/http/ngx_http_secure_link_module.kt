package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_secure_link_module.html

val ngx_http_secure_link_module = NginxModule(
    name = "ngx_http_secure_link_module",
    description = "Module for checking authenticity of requested links and protecting resources from unauthorized access"
)

val secureLink = Directive(
    name = "secure_link",
    description = "Defines a string with variables to extract the checksum value and lifetime of a link",
    context = listOf(http, server, location),
    module = ngx_http_secure_link_module
)

val secureLinkMd5 = Directive(
    name = "secure_link_md5",
    description = "Defines an expression for computing the MD5 hash value to compare with the request value",
    context = listOf(http, server, location),
    module = ngx_http_secure_link_module
)

val secureLinkSecret = Directive(
    name = "secure_link_secret",
    description = "Defines a secret word for checking the authenticity of requested links",
    context = listOf(location),
    module = ngx_http_secure_link_module
)
