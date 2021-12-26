package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_grpc_module.html

val grpcBind = Directive(
    "grpc_bind",
    defaultValue = "off"
)
val grpcBufferSize = Directive("grpc_buffer_size")
val grpcConnectTimeout = Directive(
    "grpc_connect_timeout",
    defaultValue = "60s"
)
val grpcHideHeader = Directive("grpc_hide_header")
val grpcIgnoreHeaders = Directive("grpc_ignore_headers")
val grpcInterceptErrors = ToggleDirective("grpc_intercept_errors", false)
val grpcNextUpstream = Directive(
    "grpc_next_upstream",
    defaultValue = "timeout"
)
val grpcNextUpstreamTimeout = Directive(
    "grpc_next_upstream_timeout",
    defaultValue = "0"
)
val grpcNextUpstreamTries = Directive(
    "grpc_next_upstream_tries",
    defaultValue = "0"
)
val grpcPass = Directive("grpc_pass")
val grpcPassHeader = Directive("grpc_pass_header")
val grpcReadTimeout = Directive(
    "grpc_read_timeout",
    defaultValue = "60s"
)
val grpcSendTimeout = Directive(
    "grpc_send_timeout",
    defaultValue = "60s"
)
val grpcSetHeader = Directive(
    "grpc_set_header",
    defaultValue = "Content-Length \$content_length"
)
val grpcSocketKeepalive = ToggleDirective("grpc_socket_keepalive", false)
val grpcSslCertificate = Directive("grpc_ssl_certificate")
val grpcSslCertificateKey = Directive("grpc_ssl_certificate_key")
val grpcSslCiphers = Directive(
    "grpc_ssl_ciphers",
    defaultValue = "DEFAULT"
)
val grpcSslConfCommand = Directive("grpc_ssl_conf_command")
val grpcSslCrl = Directive("grpc_ssl_crl")
val grpcSslName = Directive("grpc_ssl_name")
val grpcSslPasswordFile = Directive("grpc_ssl_password_file")
val grpcSslProtocols = Directive(
    "grpc_ssl_protocols",
    defaultValue = "TLSv1 TLSv1.1 TLSv1.2"
)
val grpcSslServerName = ToggleDirective("grpc_ssl_server_name", false)
val grpcSslSessionReuse = ToggleDirective("grpc_ssl_session_reuse", true)
val grpcSslTrustedCertificate = Directive("grpc_ssl_trusted_certificate")
val grpcSslVerify = ToggleDirective("grpc_ssl_verify", false)
val grpcSslVerifyDepth = Directive(
    "grpc_ssl_verify_depth",
    defaultValue = "1"
)

val ngx_http_grpc_module = Module(
    "ngx_http_grpc_module",
    enabled = true,
    directives = setOf(
        grpcBind,
        grpcBufferSize,
        grpcConnectTimeout,
        grpcHideHeader,
        grpcIgnoreHeaders,
        grpcInterceptErrors,
        grpcNextUpstream,
        grpcNextUpstreamTimeout,
        grpcNextUpstreamTries,
        grpcPass,
        grpcPassHeader,
        grpcReadTimeout,
        grpcSendTimeout,
        grpcSetHeader,
        grpcSocketKeepalive,
        grpcSslCertificate,
        grpcSslCertificateKey,
        grpcSslCiphers,
        grpcSslConfCommand,
        grpcSslCrl,
        grpcSslName,
        grpcSslPasswordFile,
        grpcSslProtocols,
        grpcSslServerName,
        grpcSslSessionReuse,
        grpcSslTrustedCertificate,
        grpcSslVerify,
        grpcSslVerifyDepth,
    )
)
