package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_zone_sync_module.html

val streamZoneSync = Directive("zone_sync")
val streamZoneSyncBuffers = Directive("zone_sync_buffers")
val streamZoneSyncConnectRetryInterval = Directive(
    "zone_sync_connect_retry_interval",
    defaultValue = "1s"
)
val streamZoneSyncConnectTimeout = Directive(
    "zone_sync_connect_timeout",
    defaultValue = "5s"
)
val streamZoneSyncInterval = Directive(
    "zone_sync_interval",
    defaultValue = "1s"
)
val streamZoneSyncRecvBufferSize = Directive("zone_sync_recv_buffer_size")
val streamZoneSyncServer = Directive("zone_sync_server")
val streamZoneSyncSsl = ToggleDirective("zone_sync_ssl", false)
val streamZoneSyncSslCertificate = Directive("zone_sync_ssl_certificate")
val streamZoneSyncSslCertificateKey = Directive("zone_sync_ssl_certificate_key")
val streamZoneSyncSslCiphers = Directive("zone_sync_ssl_ciphers")
val streamZoneSyncSslConfCommand = Directive("zone_sync_ssl_conf_command")
val streamZoneSyncSslCrl = Directive("zone_sync_ssl_crl")
val streamZoneSyncSslName = Directive("zone_sync_ssl_name")
val streamZoneSyncSslPasswordFile = Directive("zone_sync_ssl_password_file")
val streamZoneSyncSslProtocols = Directive(
    "zone_sync_ssl_protocols",
    defaultValue = "TLSv1.2 TLSv1.3"
)
val streamZoneSyncSslServerName = ToggleDirective("zone_sync_ssl_server_name", false)
val streamZoneSyncSslTrustedCertificate = Directive("zone_sync_ssl_trusted_certificate")
val streamZoneSyncSslVerify = ToggleDirective("zone_sync_ssl_verify", false)
val streamZoneSyncSslVerifyDepth = Directive(
    "zone_sync_ssl_verify_depth",
    defaultValue = "1"
)
val streamZoneSyncTimeout = Directive(
    "zone_sync_timeout",
    defaultValue = "5s"
)

val ngx_stream_zone_sync_module = Module(
    "ngx_stream_zone_sync_module",
    enabled = true,
    directives = setOf(
        streamZoneSync,
        streamZoneSyncBuffers,
        streamZoneSyncConnectRetryInterval,
        streamZoneSyncConnectTimeout,
        streamZoneSyncInterval,
        streamZoneSyncRecvBufferSize,
        streamZoneSyncServer,
        streamZoneSyncSsl,
        streamZoneSyncSslCertificate,
        streamZoneSyncSslCertificateKey,
        streamZoneSyncSslCiphers,
        streamZoneSyncSslConfCommand,
        streamZoneSyncSslCrl,
        streamZoneSyncSslName,
        streamZoneSyncSslPasswordFile,
        streamZoneSyncSslProtocols,
        streamZoneSyncSslServerName,
        streamZoneSyncSslTrustedCertificate,
        streamZoneSyncSslVerify,
        streamZoneSyncSslVerifyDepth,
        streamZoneSyncTimeout,
    )
)
