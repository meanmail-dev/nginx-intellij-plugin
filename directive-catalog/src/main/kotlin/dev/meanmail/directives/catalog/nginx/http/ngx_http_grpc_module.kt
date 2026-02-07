package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.*

// https://nginx.org/en/docs/http/ngx_http_grpc_module.html

val ngx_http_grpc_module = NginxModule(
    "ngx_http_grpc_module",
    description = "Provides support for proxying gRPC requests to gRPC servers"
)

val grpcBindOff = Directive(
    name = "grpc_bind",
    description = "Specifies the local IP address and port to bind gRPC connections",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcBind = Directive(
    name = "grpc_bind",
    description = "Specifies the local IP address and port to bind gRPC connections",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcBufferSize = Directive(
    name = "grpc_buffer_size",
    description = "Sets the buffer size for reading gRPC server responses",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcConnectTimeout = Directive(
    name = "grpc_connect_timeout",
    description = "Defines the timeout for establishing a connection with the gRPC server",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcHideHeader = Directive(
    name = "grpc_hide_header",
    description = "Hides specified headers from the gRPC server response",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcIgnoreHeaders = Directive(
    name = "grpc_ignore_headers",
    description = "Ignores specified headers from the gRPC server response",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcInterceptErrors = Directive(
    name = "grpc_intercept_errors",
    description = "Enables or disables error interception for gRPC connections",
        context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcNextUpstream = Directive(
    name = "grpc_next_upstream",
    description = "Specifies conditions for passing a request to the next server if the current server fails",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcNextUpstreamTimeout = Directive(
    name = "grpc_next_upstream_timeout",
    description = "Sets the maximum time for passing a request to the next server",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcNextUpstreamTries = Directive(
    name = "grpc_next_upstream_tries",
    description = "Sets the maximum number of attempts to pass a request to the next server",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcPass = Directive(
    name = "grpc_pass",
    description = "Specifies the gRPC server address to which requests should be passed",
    context = listOf(location, locationIf),
    module = ngx_http_grpc_module
)

val grpcPassHeader = Directive(
    name = "grpc_pass_header",
    description = "Allows passing specified headers from the gRPC server to the client",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcReadTimeout = Directive(
    name = "grpc_read_timeout",
    description = "Sets the timeout for reading a response from the gRPC server",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSendTimeout = Directive(
    name = "grpc_send_timeout",
    description = "Sets the timeout for transmitting a request to the gRPC server",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSetHeader = Directive(
    name = "grpc_set_header",
    description = "Sets additional headers to be sent to the gRPC server",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSocketKeepalive = Directive(
    name = "grpc_socket_keepalive",
    description = "Enables or disables socket keepalive for gRPC connections",
        context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslCertificate = Directive(
    name = "grpc_ssl_certificate",
    description = "Specifies the path to the client SSL certificate for gRPC connections",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslCertificateCacheOff = Directive(
    name = "grpc_ssl_certificate_cache",
    description = "Enables or disables caching of SSL certificates for gRPC connections",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslCertificateCache = Directive(
    name = "grpc_ssl_certificate_cache",
    description = "Enables or disables caching of SSL certificates for gRPC connections",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslCertificateKey = Directive(
    name = "grpc_ssl_certificate_key",
    description = "Specifies the path to the client SSL certificate key for gRPC connections",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslCiphers = Directive(
    name = "grpc_ssl_ciphers",
    description = "Specifies the list of supported SSL/TLS ciphers for gRPC connections",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslConfCommand = Directive(
    name = "grpc_ssl_conf_command",
    description = "Specifies the OpenSSL configuration command for gRPC connections",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslCrl = Directive(
    name = "grpc_ssl_crl",
    description = "Specifies the path to the Certificate Revocation List (CRL) for gRPC connections",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslName = Directive(
    name = "grpc_ssl_name",
    description = "Specifies the server name for gRPC connections",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslPasswordFile = Directive(
    name = "grpc_ssl_password_file",
    description = "Specifies the path to the password file for the SSL certificate key for gRPC connections",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslProtocols = Directive(
    name = "grpc_ssl_protocols",
    description = "Enables the specified SSL/TLS protocols for gRPC connections",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslServerName = Directive(
    name = "grpc_ssl_server_name",
    description = "Enables or disables the use of the server name for gRPC connections",
        context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslSessionReuse = Directive(
    name = "grpc_ssl_session_reuse",
    description = "Enables or disables SSL/TLS session reuse for gRPC connections",
        context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslTrustedCertificate = Directive(
    name = "grpc_ssl_trusted_certificate",
    description = "Specifies a file with trusted CA certificates in the PEM format used to verify the certificate of the gRPC SSL server.",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslVerify = Directive(
    name = "grpc_ssl_verify",
    description = "Enables or disables SSL/TLS verification for gRPC connections",
        context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslVerifyDepth = Directive(
    name = "grpc_ssl_verify_depth",
    description = "Specifies the maximum depth for SSL/TLS verification for gRPC connections",
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)
