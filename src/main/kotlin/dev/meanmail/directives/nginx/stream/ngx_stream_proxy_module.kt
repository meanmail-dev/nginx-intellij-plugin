package dev.meanmail.directives.nginx.stream

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/stream/ngx_stream_proxy_module.html

val ngx_stream_proxy_module = NginxModule(
    name = "ngx_stream_proxy_module",
    description = "Advanced module for proxying TCP/UDP connections with comprehensive configuration and load balancing capabilities",
    enabled = true
)

val streamProxyBind = Directive(
    name = "proxy_bind",
    description = "Configures the local network interface for outgoing proxy connections, enabling precise source IP and port selection",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            valueType = ValueType.STRING,
            description = "Local IP address to bind outgoing connections. Supports IPv4 and IPv6 addresses",
            required = true
        ),
        DirectiveParameter(
            name = "port",
            valueType = ValueType.NUMBER,
            description = "Optional local port for outgoing connections. If not specified, an ephemeral port is used",
            required = false,
            minValue = 1,
            maxValue = 65535
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyBufferSize = Directive(
    name = "proxy_buffer_size",
    description = "Sets the buffer size for reading data from the proxied server, optimizing memory usage and performance",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            valueType = ValueType.SIZE,
            description = "Buffer size in bytes. Determines memory allocation for proxied server communication",
            required = true,
            defaultValue = "16k"
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyConnectTimeout = Directive(
    name = "proxy_connect_timeout",
    description = "Defines the maximum time allowed for establishing a connection with the proxied server",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            valueType = ValueType.TIME,
            description = "Timeout duration for connection establishment. Prevents long-hanging connections",
            required = true,
            defaultValue = "60s"
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyDownloadRate = Directive(
    name = "proxy_download_rate",
    description = "Limits the download speed from the proxied server, enabling bandwidth control",
    parameters = listOf(
        DirectiveParameter(
            name = "rate",
            valueType = ValueType.SIZE,
            description = "Maximum download speed in bytes per second. Zero means no limit",
            required = true,
            defaultValue = "0"
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyHalfClose = Directive(
    name = "proxy_half_close",
    description = "Enables support for half-closed connections, allowing more flexible connection handling",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            valueType = ValueType.BOOLEAN,
            description = "Enables or disables half-closed connection support. Allows one side to close connection while keeping the other side open",
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyNextUpstream = Directive(
    name = "proxy_next_upstream",
    description = "Configures failover mechanism for proxied connections when primary server fails",
    parameters = listOf(
        DirectiveParameter(
            name = "conditions",
            valueType = ValueType.STRING,
            description = "Specifies conditions for trying the next upstream server. Can include error, timeout, invalid_header, etc.",
            required = false,
            allowedValues = listOf("error", "timeout", "invalid_header", "http_500", "http_502", "http_503", "http_504")
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyNextUpstreamTimeout = Directive(
    name = "proxy_next_upstream_timeout",
    description = "Sets the maximum time allowed for trying multiple upstream servers during failover",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            valueType = ValueType.TIME,
            description = "Total timeout for attempting connections to multiple upstream servers",
            required = true,
            defaultValue = "0"
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyNextUpstreamTries = Directive(
    name = "proxy_next_upstream_tries",
    description = "Limits the number of attempts to pass a connection to the next upstream server",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            valueType = ValueType.NUMBER,
            description = "Maximum number of attempts to connect to alternative upstream servers",
            required = true,
            defaultValue = "1",
            minValue = 1,
            maxValue = 255
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyPass = Directive(
    name = "proxy_pass",
    description = "Defines the destination server or server group for proxying stream connections",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            valueType = ValueType.STRING,
            description = "Address of the proxied server. Can be an IP, hostname, or upstream group",
            required = true
        ),
        DirectiveParameter(
            name = "port",
            valueType = ValueType.NUMBER,
            description = "Optional port for the proxied server. Uses the original connection port if not specified",
            required = false,
            minValue = 1,
            maxValue = 65535
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyProtocol = Directive(
    name = "proxy_protocol",
    description = "Enables PROXY protocol for passing client connection information between proxy and backend servers",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            valueType = ValueType.BOOLEAN,
            description = "Enables or disables PROXY protocol. Allows passing client connection details like source IP",
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyRequests = Directive(
    name = "proxy_requests",
    description = "Limits the maximum number of client requests per single connection",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            valueType = ValueType.NUMBER,
            description = "Maximum number of requests allowed per connection before closing",
            required = true,
            defaultValue = "0",
            minValue = 0
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyResponses = Directive(
    name = "proxy_responses",
    description = "Controls the maximum number of server responses per client request",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            valueType = ValueType.NUMBER,
            description = "Maximum number of server responses allowed for a single client request",
            required = true,
            defaultValue = "0",
            minValue = 0
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySessionDrop = Directive(
    name = "proxy_session_drop",
    description = "Configures session handling when backend servers become unavailable",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            valueType = ValueType.BOOLEAN,
            description = "Enables dropping of active sessions when backend servers are unreachable",
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySocketKeepalive = Directive(
    name = "proxy_socket_keepalive",
    description = "Configures TCP keepalive settings for connections to proxied servers",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            valueType = ValueType.BOOLEAN,
            description = "Enables or disables TCP keepalive for proxy connections. Helps maintain long-lived connections",
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySsl = Directive(
    name = "proxy_ssl",
    description = "Enables SSL/TLS encryption for connections to backend servers",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            valueType = ValueType.BOOLEAN,
            description = "Enables SSL/TLS protocol for secure communication with proxied servers",
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslCertificate = Directive(
    name = "proxy_ssl_certificate",
    description = "Specifies the client SSL certificate for authentication with proxied servers",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            valueType = ValueType.STRING,
            description = "Path to the client SSL/TLS certificate file used for server authentication",
            required = true
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslCertificateKey = Directive(
    name = "proxy_ssl_certificate_key",
    description = "Specifies the private key for the client SSL certificate",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            valueType = ValueType.STRING,
            description = "Path to the private key file corresponding to the SSL certificate",
            required = true
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslPasswordFile = Directive(
    name = "proxy_ssl_password_file",
    description = "Specifies a file containing passwords for encrypted SSL certificates",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            valueType = ValueType.STRING,
            description = "Path to the file containing passwords for encrypted SSL private keys",
            required = true
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslProtocols = Directive(
    name = "proxy_ssl_protocols",
    description = "Configures the SSL/TLS protocols allowed for connections to proxied servers",
    parameters = listOf(
        DirectiveParameter(
            name = "protocols",
            valueType = ValueType.STRING,
            description = "Specifies enabled SSL/TLS protocol versions",
            required = false,
            allowedValues = listOf("TLSv1", "TLSv1.1", "TLSv1.2", "TLSv1.3"),
            defaultValue = "TLSv1.2 TLSv1.3"
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslServerName = Directive(
    name = "proxy_ssl_server_name",
    description = "Enables passing of the server name during SSL/TLS handshake",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            valueType = ValueType.BOOLEAN,
            description = "Enables sending of the original server name during SSL/TLS connection",
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslTrustedCertificate = Directive(
    name = "proxy_ssl_trusted_certificate",
    description = "Specifies the trusted CA certificate for verifying proxied server certificates",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            valueType = ValueType.STRING,
            description = "Path to the trusted Certificate Authority (CA) certificate file",
            required = true
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslVerify = Directive(
    name = "proxy_ssl_verify",
    description = "Enables verification of proxied server SSL certificates",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            valueType = ValueType.BOOLEAN,
            description = "Enables or disables verification of the proxied server's SSL certificate",
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslVerifyDepth = Directive(
    name = "proxy_ssl_verify_depth",
    description = "Sets the maximum depth of CA certificate chain verification",
    parameters = listOf(
        DirectiveParameter(
            name = "depth",
            valueType = ValueType.NUMBER,
            description = "Maximum number of intermediate certificates to verify",
            required = false,
            defaultValue = "1",
            minValue = 1,
            maxValue = 10
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslCiphers = Directive(
    name = "proxy_ssl_ciphers",
    description = "Specifies the ciphers for SSL connections to proxied servers",
    parameters = listOf(
        DirectiveParameter(
            name = "ciphers",
            valueType = ValueType.STRING,
            description = "List of SSL/TLS ciphers to be used in the connection. Follows OpenSSL cipher list format",
            required = false,
            defaultValue = "DEFAULT"
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslConfCommand = Directive(
    name = "proxy_ssl_conf_command",
    description = "Sets OpenSSL configuration commands for SSL connections",
    parameters = listOf(
        DirectiveParameter(
            name = "command",
            valueType = ValueType.STRING,
            description = "Name of the OpenSSL configuration command",
            required = true
        ),
        DirectiveParameter(
            name = "value",
            valueType = ValueType.STRING,
            description = "Value for the specified OpenSSL configuration command",
            required = true
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslCrl = Directive(
    name = "proxy_ssl_crl",
    description = "Sets the path to the certificate revocation list (CRL) for SSL verification",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            valueType = ValueType.STRING,
            description = "Path to the Certificate Revocation List (CRL) file",
            required = true
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslName = Directive(
    name = "proxy_ssl_name",
    description = "Sets the server name for SSL server name indication (SNI)",
    parameters = listOf(
        DirectiveParameter(
            name = "name",
            valueType = ValueType.STRING,
            description = "Server name to be used for SNI (Server Name Indication)",
            required = false
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslSessionReuse = Directive(
    name = "proxy_ssl_session_reuse",
    description = "Enables or disables reuse of SSL sessions",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            valueType = ValueType.BOOLEAN,
            description = "Enables or disables SSL session reuse to improve performance",
            required = false,
            defaultValue = "on"
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxySslKeyLog = Directive(
    name = "proxy_ssl_key_log",
    description = "Enables logging of SSL keys for debugging and analysis",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            valueType = ValueType.STRING,
            description = "Path to the file where SSL keys will be logged",
            required = true
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyTimeout = Directive(
    name = "proxy_timeout",
    description = "Sets the timeout for read and write operations with the proxied server in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            valueType = ValueType.TIME,
            description = "Timeout duration for read/write operations",
            required = true
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)

val streamProxyUploadRate = Directive(
    name = "proxy_upload_rate",
    description = "Limits the upload speed to the proxied server in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "rate",
            valueType = ValueType.SIZE,
            description = "Upload speed limit in bytes per second",
            required = true
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_proxy_module
)
