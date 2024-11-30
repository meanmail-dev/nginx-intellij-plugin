package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_zone_sync_module.html

val ngx_stream_zone_sync_module = NginxModule(
    name = "ngx_stream_zone_sync_module",
    description = "Stream module for synchronizing shared memory zones between Nginx instances",
    enabled = true
)

val streamZoneSync = Directive(
    name = "zone_sync",
    description = "Enables synchronization of shared memory zones between Nginx instances in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "mode",
            valueType = ValueType.STRING,
            description = "Synchronization mode (master, slave)",
            allowedValues = listOf("master", "slave")
        )
    ),
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncBuffers = Directive(
    name = "zone_sync_buffers",
    description = "Configures buffers for zone synchronization in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            valueType = ValueType.NUMBER,
            description = "Number of buffers",
        ),
        DirectiveParameter(
            name = "size",
            valueType = ValueType.SIZE,
            description = "Size of each buffer",
        )
    ),
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncConnectRetryInterval = Directive(
    name = "zone_sync_connect_retry_interval",
    description = "Sets the interval for retrying connection during zone synchronization in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            valueType = ValueType.TIME,
            description = "Retry interval duration",
        )
    ),
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncConnectTimeout = Directive(
    name = "zone_sync_connect_timeout",
    description = "Sets the timeout for establishing a connection during zone synchronization in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            valueType = ValueType.TIME,
            description = "Connection timeout duration",
        )
    ),
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncInterval = Directive(
    name = "zone_sync_interval",
    description = "Sets the interval for periodic zone synchronization",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            valueType = ValueType.TIME,
            description = "Synchronization interval duration",
        )
    ),
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncRecvBufferSize = Directive(
    name = "zone_sync_recv_buffer_size",
    description = "Configures the receive buffer size for zone synchronization",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            valueType = ValueType.SIZE,
            description = "Size of the receive buffer",
        )
    ),
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncServer = Directive(
    name = "zone_sync_server",
    description = "Defines a server for zone synchronization",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            valueType = ValueType.STRING,
            description = "IP address or hostname of the sync server",
        ),
        DirectiveParameter(
            name = "port",
            valueType = ValueType.NUMBER,
            description = "Port of the sync server",
        )
    ),
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncSsl = ToggleDirective(
    name = "zone_sync_ssl",
    description = "Enables SSL/TLS for zone synchronization",
    enabled = true,
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncSslCertificate = Directive(
    name = "zone_sync_ssl_certificate",
    description = "Sets the path to the SSL/TLS certificate for zone synchronization",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            valueType = ValueType.STRING,
            description = "Path to the SSL/TLS certificate file",
        )
    ),
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncSslCertificateKey = Directive(
    name = "zone_sync_ssl_certificate_key",
    description = "Sets the path to the SSL/TLS certificate key for zone synchronization",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            valueType = ValueType.STRING,
            description = "Path to the SSL/TLS certificate key file",
        )
    ),
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncSslCiphers = Directive(
    name = "zone_sync_ssl_ciphers",
    description = "Specifies the ciphers for SSL/TLS connections during zone synchronization",
    parameters = listOf(
        DirectiveParameter(
            name = "ciphers",
            valueType = ValueType.STRING,
            description = "List of SSL/TLS cipher suites",
        )
    ),
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncSslConfCommand = Directive(
    name = "zone_sync_ssl_conf_command",
    description = "Sets OpenSSL configuration commands for SSL/TLS connections during zone synchronization",
    parameters = listOf(
        DirectiveParameter(
            name = "command",
            valueType = ValueType.STRING,
            description = "OpenSSL configuration command",
        ),
        DirectiveParameter(
            name = "value",
            valueType = ValueType.STRING,
            description = "Value for the configuration command",
        )
    ),
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncSslCrl = Directive(
    name = "zone_sync_ssl_crl",
    description = "Sets the path to the certificate revocation list (CRL) for SSL verification during zone synchronization",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            valueType = ValueType.STRING,
            description = "Path to the CRL file",
        )
    ),
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncSslName = Directive(
    name = "zone_sync_ssl_name",
    description = "Sets the server name for SSL server name indication (SNI) during zone synchronization",
    parameters = listOf(
        DirectiveParameter(
            name = "name",
            valueType = ValueType.STRING,
            description = "Server name for SNI",
        )
    ),
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncSslPasswordFile = Directive(
    name = "zone_sync_ssl_password_file",
    description = "Sets the path to a file containing SSL certificate passwords for zone synchronization",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            valueType = ValueType.STRING,
            description = "Path to the password file",
        )
    ),
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncSslProtocols = Directive(
    name = "zone_sync_ssl_protocols",
    description = "Specifies the SSL/TLS protocols to use during zone synchronization",
    parameters = listOf(
        DirectiveParameter(
            name = "protocols",
            valueType = ValueType.STRING,
            description = "List of SSL/TLS protocols to enable",
        )
    ),
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncSslServerName = ToggleDirective(
    name = "zone_sync_ssl_server_name",
    description = "Enables passing of the original server name during SSL handshake for zone synchronization",
    enabled = true,
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncSslTrustedCertificate = Directive(
    name = "zone_sync_ssl_trusted_certificate",
    description = "Sets the path to a trusted CA certificate for SSL verification during zone synchronization",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            valueType = ValueType.STRING,
            description = "Path to the trusted CA certificate file",
        )
    ),
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncSslVerify = ToggleDirective(
    name = "zone_sync_ssl_verify",
    description = "Enables verification of the server's SSL certificate during zone synchronization",
    enabled = true,
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncSslVerifyDepth = Directive(
    name = "zone_sync_ssl_verify_depth",
    description = "Sets the maximum depth of CA certificate chain verification during zone synchronization",
    parameters = listOf(
        DirectiveParameter(
            name = "depth",
            valueType = ValueType.NUMBER,
            description = "Maximum depth of certificate chain verification",
        )
    ),
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)

val streamZoneSyncTimeout = Directive(
    name = "zone_sync_timeout",
    description = "Sets the timeout for read and write operations during zone synchronization",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            valueType = ValueType.TIME,
            description = "Timeout duration for read/write operations",
        )
    ),
    context = listOf(stream),
    module = ngx_stream_zone_sync_module
)
