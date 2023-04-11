package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_proxy_module.html

val streamProxyBind = Directive("proxy_bind")
val streamProxyBufferSize = Directive(
    "proxy_buffer_size",
    defaultValue = "16k"
)
val streamProxyConnectTimeout = Directive(
    "proxy_connect_timeout",
    defaultValue = "60s"
)
val streamProxyDownloadRate = Directive(
    "proxy_download_rate",
    defaultValue = "0"
)
val streamProxyHalfClose = ToggleDirective("proxy_half_close", false)
val streamProxyNextUpstream = ToggleDirective("proxy_next_upstream", true)
val streamProxyNextUpstreamTimeout = Directive(
    "proxy_next_upstream_timeout",
    defaultValue = "0"
)
val streamProxyNextUpstreamTries = Directive(
    "proxy_next_upstream_tries",
    defaultValue = "0"
)
val streamProxyPass = Directive("proxy_pass")
val streamProxyProtocol = ToggleDirective("proxy_protocol", false)
val streamProxyRequests = Directive(
    "proxy_requests",
    defaultValue = "0"
)
val streamProxyResponses = Directive("proxy_responses")
val streamProxySessionDrop = ToggleDirective("proxy_session_drop", false)
val streamProxySocketKeepalive = ToggleDirective("proxy_socket_keepalive", false)
val streamProxySsl = ToggleDirective("proxy_ssl", false)
val streamProxySslCertificate = Directive("proxy_ssl_certificate")
val streamProxySslCertificateKey = Directive("proxy_ssl_certificate_key")
val streamProxySslCiphers = Directive(
    "proxy_ssl_ciphers",
    defaultValue = "DEFAULT"
)
val streamProxySslConfCommand = Directive("proxy_ssl_conf_command")
val streamProxySslCrl = Directive("proxy_ssl_crl")
val streamProxySslName = Directive("proxy_ssl_name")
val streamProxySslPasswordFile = Directive("proxy_ssl_password_file")
val streamProxySslProtocols = Directive(
    "proxy_ssl_protocols",
    defaultValue = "TLSv1 TLSv1.1 TLSv1.2"
)
val streamProxySslServerName = ToggleDirective("proxy_ssl_server_name", false)
val streamProxySslSessionReuse = ToggleDirective("proxy_ssl_session_reuse", true)
val streamProxySslTrustedCertificate = Directive("proxy_ssl_trusted_certificate")
val streamProxySslVerify = ToggleDirective("proxy_ssl_verify", false)
val streamProxySslVerifyDepth = Directive(
    "proxy_ssl_verify_depth",
    defaultValue = "1"
)
val streamProxyTimeout = Directive(
    "proxy_timeout",
    defaultValue = "10m"
)
val streamProxyUploadRate = Directive(
    "proxy_upload_rate",
    defaultValue = "0"
)

val ngx_stream_proxy_module = Module(
    "ngx_stream_proxy_module",
    enabled = true,
    directives = setOf(
        streamProxyBind,
        streamProxyBufferSize,
        streamProxyConnectTimeout,
        streamProxyDownloadRate,
        streamProxyHalfClose,
        streamProxyNextUpstream,
        streamProxyNextUpstreamTimeout,
        streamProxyNextUpstreamTries,
        streamProxyPass,
        streamProxyProtocol,
        streamProxyRequests,
        streamProxyResponses,
        streamProxySessionDrop,
        streamProxySocketKeepalive,
        streamProxySsl,
        streamProxySslCertificate,
        streamProxySslCertificateKey,
        streamProxySslCiphers,
        streamProxySslConfCommand,
        streamProxySslCrl,
        streamProxySslName,
        streamProxySslPasswordFile,
        streamProxySslProtocols,
        streamProxySslServerName,
        streamProxySslSessionReuse,
        streamProxySslTrustedCertificate,
        streamProxySslVerify,
        streamProxySslVerifyDepth,
        streamProxyTimeout,
        streamProxyUploadRate,
    )
)
