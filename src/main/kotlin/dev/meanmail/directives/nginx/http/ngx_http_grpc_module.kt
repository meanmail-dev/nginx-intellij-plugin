package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.*

// https://nginx.org/en/docs/http/ngx_http_grpc_module.html

val ngx_http_grpc_module = NginxModule(
    "ngx_http_grpc_module",
    description = "Provides support for proxying gRPC requests to gRPC servers",
    enabled = true
)

val grpcBind = Directive(
    name = "grpc_bind",
    description = "Specifies the local IP address and port to bind gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            description = "Local IP address to bind gRPC connections, or 'off' to disable",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcBufferSize = Directive(
    name = "grpc_buffer_size",
    description = "Sets the buffer size for reading gRPC server responses",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Size of the buffer used for gRPC response processing",
            valueType = ValueType.SIZE,
            required = false
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcConnectTimeout = Directive(
    name = "grpc_connect_timeout",
    description = "Defines the timeout for establishing a connection with the gRPC server",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            description = "Connection timeout duration",
            valueType = ValueType.TIME,
            required = false
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcHideHeader = Directive(
    name = "grpc_hide_header",
    description = "Hides specified headers from the gRPC server response",
    parameters = listOf(
        DirectiveParameter(
            name = "header",
            description = "Name of the header to hide",
            valueType = ValueType.STRING,
            required = true,
            multiple = true
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcIgnoreHeaders = Directive(
    name = "grpc_ignore_headers",
    description = "Ignores specified headers from the gRPC server response",
    parameters = listOf(
        DirectiveParameter(
            name = "header",
            description = "Name of the header to ignore",
            valueType = ValueType.STRING,
            required = true,
            multiple = true
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcInterceptErrors = ToggleDirective(
    name = "grpc_intercept_errors",
    description = "Enables or disables error interception for gRPC connections",
    enabled = false,
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcNextUpstream = Directive(
    name = "grpc_next_upstream",
    description = "Specifies conditions for passing a request to the next server if the current server fails",
    parameters = listOf(
        DirectiveParameter(
            name = "conditions",
            description = "Conditions for trying the next server (e.g., error, timeout, invalid_header, http_500, etc.)",
            valueType = ValueType.STRING,
            required = true,
            multiple = true
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcNextUpstreamTimeout = Directive(
    name = "grpc_next_upstream_timeout",
    description = "Sets the maximum time for passing a request to the next server",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Maximum time for trying the next server",
            valueType = ValueType.TIME,
            required = false
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcNextUpstreamTries = Directive(
    name = "grpc_next_upstream_tries",
    description = "Sets the maximum number of attempts to pass a request to the next server",
    parameters = listOf(
        DirectiveParameter(
            name = "tries",
            description = "Maximum number of attempts to pass a request to the next server",
            valueType = ValueType.INTEGER,
            required = false
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcPass = Directive(
    name = "grpc_pass",
    description = "Specifies the gRPC server address to which requests should be passed",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            description = "gRPC server address",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcPassHeader = Directive(
    name = "grpc_pass_header",
    description = "Allows passing specified headers from the gRPC server to the client",
    parameters = listOf(
        DirectiveParameter(
            name = "header",
            description = "Name of the header to pass",
            valueType = ValueType.STRING,
            required = true,
            multiple = true
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcReadTimeout = Directive(
    name = "grpc_read_timeout",
    description = "Sets the timeout for reading a response from the gRPC server",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Timeout for reading gRPC server response",
            valueType = ValueType.TIME,
            required = false
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcSendTimeout = Directive(
    name = "grpc_send_timeout",
    description = "Sets the timeout for transmitting a request to the gRPC server",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Timeout for sending request to gRPC server",
            valueType = ValueType.TIME,
            required = false
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcSetHeader = Directive(
    name = "grpc_set_header",
    description = "Sets additional headers to be sent to the gRPC server",
    parameters = listOf(
        DirectiveParameter(
            name = "header",
            description = "Header name",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "value",
            description = "Header value",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcSocketKeepalive = ToggleDirective(
    name = "grpc_socket_keepalive",
    description = "Enables or disables socket keepalive for gRPC connections",
    enabled = false,
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcSslCertificate = Directive(
    name = "grpc_ssl_certificate",
    description = "Specifies the path to the client SSL certificate for gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the SSL certificate file",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcSslCertificateKey = Directive(
    name = "grpc_ssl_certificate_key",
    description = "Specifies the path to the client SSL certificate key for gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the SSL certificate key file",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcSslCiphers = Directive(
    name = "grpc_ssl_ciphers",
    description = "Specifies the list of supported SSL/TLS ciphers for gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "ciphers",
            description = "List of SSL/TLS ciphers to support",
            valueType = ValueType.STRING,
            required = false,
            multiple = true
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcSslConfCommand = Directive(
    name = "grpc_ssl_conf_command",
    description = "Specifies the OpenSSL configuration command for gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "command",
            description = "OpenSSL configuration command",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcSslCrl = Directive(
    name = "grpc_ssl_crl",
    description = "Specifies the path to the Certificate Revocation List (CRL) for gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the Certificate Revocation List (CRL) file",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcSslName = Directive(
    name = "grpc_ssl_name",
    description = "Specifies the server name for gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "name",
            description = "Server name for SSL/TLS verification",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcSslPasswordFile = Directive(
    name = "grpc_ssl_password_file",
    description = "Specifies the path to the password file for the SSL certificate key for gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the password file for SSL certificate key",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcSslProtocols = Directive(
    name = "grpc_ssl_protocols",
    description = "Enables the specified SSL/TLS protocols for gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "protocols",
            description = "List of SSL/TLS protocols to enable",
            valueType = ValueType.STRING,
            required = false,
            multiple = true
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcSslServerName = ToggleDirective(
    name = "grpc_ssl_server_name",
    description = "Enables or disables the use of the server name for gRPC connections",
    enabled = true,
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcSslSessionReuse = ToggleDirective(
    name = "grpc_ssl_session_reuse",
    description = "Enables or disables SSL/TLS session reuse for gRPC connections",
    enabled = true,
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcSslVerify = ToggleDirective(
    name = "grpc_ssl_verify",
    description = "Enables or disables SSL/TLS verification for gRPC connections",
    enabled = true,
    context = listOf(location),
    module = ngx_http_grpc_module
)

val grpcSslVerifyDepth = Directive(
    name = "grpc_ssl_verify_depth",
    description = "Specifies the maximum depth for SSL/TLS verification for gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "depth",
            description = "Maximum verification depth for SSL/TLS certificate chain",
            valueType = ValueType.INTEGER,
            required = false,
            defaultValue = "1"
        )
    ),
    context = listOf(location),
    module = ngx_http_grpc_module
)
