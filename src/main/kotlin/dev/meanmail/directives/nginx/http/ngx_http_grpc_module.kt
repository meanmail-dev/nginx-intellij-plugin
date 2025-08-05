package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.*

// https://nginx.org/en/docs/http/ngx_http_grpc_module.html

val ngx_http_grpc_module = NginxModule(
    "ngx_http_grpc_module",
    description = "Provides support for proxying gRPC requests to gRPC servers",
    enabled = true
)

val grpcBindOff = Directive(
    name = "grpc_bind",
    description = "Specifies the local IP address and port to bind gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "off",
            description = "The special value off cancels the effect of the grpc_bind directive inherited from the previous configuration level, which allows the system to auto-assign the local IP address and port",
            valueType = ValueType.BOOLEAN,
            required = true
        ),
    ),
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcBind = Directive(
    name = "grpc_bind",
    description = "Specifies the local IP address and port to bind gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            description = "Local IP address to bind gRPC connections, or 'off' to disable",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "transparent",
            description = "The transparent parameter allows outgoing connections to a gRPC server originate from a non-local IP address, for example, from a real IP address of a client",
            valueType = ValueType.BOOLEAN,
            required = false
        )
    ),
    context = listOf(http, server, location),
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
            defaultValue = "8k",
            required = true
        )
    ),
    context = listOf(http, server, location),
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
            defaultValue = "60s",
            required = true
        )
    ),
    context = listOf(http, server, location),
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
            required = true
        )
    ),
    context = listOf(http, server, location),
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
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcInterceptErrors = ToggleDirective(
    name = "grpc_intercept_errors",
    description = "Enables or disables error interception for gRPC connections",
    enabled = false,
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcNextUpstream = Directive(
    name = "grpc_next_upstream",
    description = "Specifies conditions for passing a request to the next server if the current server fails",
    parameters = listOf(
        DirectiveParameter( // TODO: Define all params
            name = "conditions",
            description = "Conditions for trying the next server (e.g., error, timeout, invalid_header, http_500, etc.)",
            valueType = ValueType.STRING,
            required = true,
            multiple = true
        )
    ),
    context = listOf(http, server, location),
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
            defaultValue = "0",
            required = true
        )
    ),
    context = listOf(http, server, location),
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
            defaultValue = "0",
            required = true
        )
    ),
    context = listOf(http, server, location),
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
    context = listOf(location, locationIf),
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
            required = true
        )
    ),
    context = listOf(http, server, location),
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
            defaultValue = "60s",
            required = true
        )
    ),
    context = listOf(http, server, location),
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
            defaultValue = "60s",
            required = true
        )
    ),
    context = listOf(http, server, location),
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
            defaultValue = "Content-Length",
            required = true
        ),
        DirectiveParameter(
            name = "value",
            description = "Header value",
            valueType = ValueType.STRING,
            defaultValue = "\$content_length",
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSocketKeepalive = ToggleDirective(
    name = "grpc_socket_keepalive",
    description = "Enables or disables socket keepalive for gRPC connections",
    enabled = false,
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslCertificate = Directive(
    name = "grpc_ssl_certificate",
    description = "Specifies the path to the client SSL certificate for gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the SSL certificate file",
            valueType = ValueType.PATH,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslCertificateCacheOff = Directive(
    name = "grpc_ssl_certificate_cache",
    description = "Enables or disables caching of SSL certificates for gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "off",
            description = "Disable SSL certificate caching",
            valueType = ValueType.BOOLEAN,
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslCertificateCache = Directive(
    name = "grpc_ssl_certificate_cache",
    description = "Enables or disables caching of SSL certificates for gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "max",
            description = "sets the maximum number of elements in the cache; on cache overflow the least recently used (LRU) elements are removed",
            valueType = ValueType.INTEGER,
            required = true,
        ),
        DirectiveParameter(
            name = "inactive",
            description = "defines a time after which an element is removed from the cache if it has not been accessed during this time; by default, it is 10 seconds",
            valueType = ValueType.TIME,
            required = false,
        ),
        DirectiveParameter(
            name = "valid",
            description = "defines a time during which an element in the cache is considered valid and can be reused; by default, it is 60 seconds. Certificates that exceed this time will be reloaded or revalidated",
            valueType = ValueType.TIME,
            required = false,
        ),
    ),
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslCertificateKey = Directive(
    name = "grpc_ssl_certificate_key",
    description = "Specifies the path to the client SSL certificate key for gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the SSL certificate key file",
            valueType = ValueType.PATH,
            required = true
        )
    ),
    context = listOf(http, server, location),
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
            multiple = true,
            defaultValue = "DEFAULT"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslConfCommand = Directive(
    name = "grpc_ssl_conf_command",
    description = "Specifies the OpenSSL configuration command for gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "name",
            description = "OpenSSL configuration command name",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "value",
            description = "OpenSSL configuration command value",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslCrl = Directive(
    name = "grpc_ssl_crl",
    description = "Specifies the path to the Certificate Revocation List (CRL) for gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the Certificate Revocation List (CRL) file",
            valueType = ValueType.PATH,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslKeyLog = Directive(
    name = "grpc_ssl_key_log",
    description = "Enables logging of gRPC SSL server connection SSL keys and specifies the path to the key log file. Keys are logged in the SSLKEYLOGFILE format compatible with Wireshark.",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the key log file",
            valueType = ValueType.PATH,
            required = true
        )
    ),
    context = listOf(http, server, location),
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
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslPasswordFile = Directive(
    name = "grpc_ssl_password_file",
    description = "Specifies the path to the password file for the SSL certificate key for gRPC connections",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the password file for SSL certificate key",
            valueType = ValueType.PATH,
            required = true
        )
    ),
    context = listOf(http, server, location),
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
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslServerName = ToggleDirective(
    name = "grpc_ssl_server_name",
    description = "Enables or disables the use of the server name for gRPC connections",
    enabled = false,
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslSessionReuse = ToggleDirective(
    name = "grpc_ssl_session_reuse",
    description = "Enables or disables SSL/TLS session reuse for gRPC connections",
    enabled = true,
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslTrustedCertificate = Directive(
    name = "grpc_ssl_trusted_certificate",
    description = "Specifies a file with trusted CA certificates in the PEM format used to verify the certificate of the gRPC SSL server.",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the file with trusted CA certificates in the PEM format",
            valueType = ValueType.PATH,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)

val grpcSslVerify = ToggleDirective(
    name = "grpc_ssl_verify",
    description = "Enables or disables SSL/TLS verification for gRPC connections",
    enabled = false,
    context = listOf(http, server, location),
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
            required = true,
            defaultValue = "1"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_grpc_module
)
