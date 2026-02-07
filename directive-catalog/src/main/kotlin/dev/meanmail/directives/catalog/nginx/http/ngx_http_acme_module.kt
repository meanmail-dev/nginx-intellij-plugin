package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_acme_module.html

val ngx_http_acme_module = NginxModule(
    "ngx_http_acme_module",
    description = "Provides automatic SSL/TLS certificate management via the ACME protocol"
)

val acmeIssuer = Directive(
    name = "acme_issuer",
    description = "Defines an ACME issuer configuration block",
    context = listOf(http),
    module = ngx_http_acme_module
)

val acmeAcceptTermsOfService = Directive(
    name = "accept_terms_of_service",
    description = "Accepts the ACME server terms of service",
    context = listOf(acmeIssuer),
    module = ngx_http_acme_module
)

val acmeContact = Directive(
    name = "contact",
    description = "Specifies contact URLs for the ACME server account",
    context = listOf(acmeIssuer),
    module = ngx_http_acme_module
)

val acmePreferredChain = Directive(
    name = "preferred_chain",
    description = "Specifies preferred certificate chain",
    context = listOf(acmeIssuer),
    module = ngx_http_acme_module
)

val acmeAccountKey = Directive(
    name = "account_key",
    description = "Specifies account private key type (ecdsa or rsa)",
    context = listOf(acmeIssuer),
    module = ngx_http_acme_module
)

val acmeCertificate = Directive(
    name = "acme_certificate",
    description = "Defines a certificate with domain identifiers for automatic management",
    context = listOf(http),
    module = ngx_http_acme_module
)

val acmeSharedZone = Directive(
    name = "acme_shared_zone",
    description = "Configures a shared memory zone for ACME certificate data",
    context = listOf(http),
    module = ngx_http_acme_module
)

val acmeSslTrustedCertificate = Directive(
    name = "ssl_trusted_certificate",
    description = "Specifies a file with trusted CA certificates for ACME server verification",
    context = listOf(acmeIssuer),
    module = ngx_http_acme_module
)

val acmeSslVerify = Directive(
    name = "ssl_verify",
    description = "Enables or disables ACME server certificate verification",
    context = listOf(acmeIssuer),
    module = ngx_http_acme_module
)

val acmeStatePath = Directive(
    name = "state_path",
    description = "Sets the directory for ACME module state files",
    context = listOf(acmeIssuer),
    module = ngx_http_acme_module
)

val acmeUri = Directive(
    name = "uri",
    description = "Sets the ACME server directory URL",
    context = listOf(acmeIssuer),
    module = ngx_http_acme_module
)

val acmeChallenge = Directive(
    name = "challenge",
    description = "Sets the ACME challenge type (http-01 or tls-alpn-01)",
    context = listOf(acmeIssuer),
    module = ngx_http_acme_module
)

val acmeExternalAccountKey = Directive(
    name = "external_account_key",
    description = "Sets external account authorization parameters",
    context = listOf(acmeIssuer),
    module = ngx_http_acme_module
)

val acmeProfile = Directive(
    name = "profile",
    description = "Specifies a certificate profile for the ACME request",
    context = listOf(acmeIssuer),
    module = ngx_http_acme_module
)
