package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/http/ngx_http_secure_link_module.html

val ngx_http_secure_link_module = NginxModule(
    name = "ngx_http_secure_link_module",
    description = "Module for checking authenticity of requested links and protecting resources from unauthorized access",
    enabled = false
)

val secureLink = Directive(
    name = "secure_link",
    description = "Defines a string with variables to extract the checksum value and lifetime of a link",
    parameters = listOf(
        DirectiveParameter(
            name = "expression",
            description = "Expression with variables to extract checksum and link lifetime",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_secure_link_module
)

val secureLinkMd5 = Directive(
    name = "secure_link_md5",
    description = "Defines an expression for computing the MD5 hash value to compare with the request value",
    parameters = listOf(
        DirectiveParameter(
            name = "expression",
            description = "Expression containing the secured link, secret ingredient, and optional expiration time",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_secure_link_module
)

val secureLinkSecret = Directive(
    name = "secure_link_secret",
    description = "Defines a secret word for checking the authenticity of requested links",
    parameters = listOf(
        DirectiveParameter(
            name = "word",
            description = "Secret word used to validate link authenticity",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(location),
    module = ngx_http_secure_link_module
)
