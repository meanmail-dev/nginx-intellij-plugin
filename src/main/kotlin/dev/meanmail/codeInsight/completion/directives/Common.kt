package dev.meanmail.codeInsight.completion.directives


open class Directive(
    val name: String,
    val values: Set<String>? = null,
    val defaultValue: String? = null,
    children: Set<Directive> = setOf()
) {
    val children: MutableSet<Directive> = mutableSetOf()

    init {
        this.children.addAll(children)
    }

    fun findChildByName(name: String?): Directive? {
        return children.find { it.name == name }
    }
}

class ToggleDirective(
    name: String,
    enabled: Boolean
) : Directive(
    name,
    setOf("on", "off"),
    defaultValue = if (enabled) "on" else "off"
)

class RecursiveDirective(
    name: String,
    values: Set<String>? = null,
    defaultValue: String? = null,
    children: Set<Directive> = setOf()
) : Directive(name, values, defaultValue, children) {
    init {
        this.children.add(this)
    }
}

open class Module(
    val name: String,
    val enabled: Boolean,
    val directives: Set<Directive>
)

val main_module = Module(
    "main",
    enabled = true,
    directives = setOf(
        daemon,
        debugPoints,
        env,
        errorLog,
        events,
        http,
        loadModule,
        lockFile,
        mail,
        masterProcess,
        pid,
        sslEngine,
        threadPool,
        timerResolution,
        user,
        workerCpuAffinity,
        workerPriority,
        workerProcesses,
        workerRlimitCore,
        workerRlimitNofile,
        workerShutdownTimeout,
        workingDirectory,
        stream,
        streamGooglePerftoolsProfiles,
    )
)


val any = Directive(
    "",
    children = setOf(
        include
    )
)

val all = Directive(
    "",
    children = ngx_core_module.directives +
            ngx_google_perftools_module.directives +
            ngx_http_access_module.directives +
            ngx_http_addition_module.directives +
            ngx_http_api_module.directives +
            ngx_http_auth_basic_module.directives +
            ngx_http_auth_jwt_module.directives +
            ngx_http_auth_request_module.directives +
            ngx_http_autoindex_module.directives +
            ngx_http_browser_module.directives +
            ngx_http_charset_module.directives +
            ngx_http_core_module.directives +
            ngx_http_dav_module.directives +
            ngx_http_empty_gif_module.directives +
            ngx_http_f4f_module.directives +
            ngx_http_fastcgi_module.directives +
            ngx_http_flv_module.directives +
            ngx_http_geo_module.directives +
            ngx_http_geoip_module.directives +
            ngx_http_grpc_module.directives +
            ngx_http_gunzip_module.directives +
            ngx_http_gzip_module.directives +
            ngx_http_gzip_static_module.directives +
            ngx_http_headers_module.directives +
            ngx_http_hls_module.directives +
            ngx_http_image_filter_module.directives +
            ngx_http_index_module.directives +
            ngx_http_js_module.directives +
            ngx_http_keyval_module.directives +
            ngx_http_limit_conn_module.directives +
            ngx_http_limit_req_module.directives +
            ngx_http_log_module.directives +
            ngx_http_map_module.directives +
            ngx_http_memcached_module.directives +
            ngx_http_mirror_module.directives +
            ngx_http_mp4_module.directives +
            ngx_http_perl_module.directives +
            ngx_http_proxy_module.directives +
            ngx_http_random_index_module.directives +
            ngx_http_realip_module.directives +
            ngx_http_referer_module.directives +
            ngx_http_rewrite_module.directives +
            ngx_http_scgi_module.directives +
            ngx_http_secure_link_module.directives +
            ngx_http_session_log_module.directives +
            ngx_http_slice_module.directives +
            ngx_http_spdy_module.directives +
            ngx_http_split_clients_module.directives +
            ngx_http_ssi_module.directives +
            ngx_http_ssl_module.directives +
            ngx_http_stub_status_module.directives +
            ngx_http_upstream_conf_module.directives +
            ngx_http_sub_module.directives +
            ngx_http_upstream_hc_module.directives +
            ngx_http_upstream_module.directives +
            ngx_http_userid_module.directives +
            ngx_http_uwsgi_module.directives +
            ngx_http_v2_module.directives +
            ngx_http_xslt_module.directives +
            ngx_mail_auth_http_module.directives +
            ngx_mail_core_module.directives +
            ngx_mail_imap_module.directives +
            ngx_mail_pop3_module.directives +
            ngx_mail_proxy_module.directives +
            ngx_mail_realip_module.directives +
            ngx_mail_smtp_module.directives +
            ngx_mail_ssl_module.directives +
            ngx_stream_access_module.directives +
            ngx_stream_core_module.directives +
            ngx_stream_geo_module.directives +
            ngx_stream_geoip_module.directives +
            ngx_stream_js_module.directives +
            ngx_stream_keyval_module.directives +
            ngx_stream_limit_conn_module.directives +
            ngx_stream_log_module.directives +
            ngx_stream_map_module.directives +
            ngx_stream_proxy_module.directives +
            ngx_stream_realip_module.directives +
            ngx_stream_return_module.directives +
            ngx_stream_set_module.directives +
            ngx_stream_split_clients_module.directives +
            ngx_stream_ssl_module.directives +
            ngx_stream_ssl_preread_module.directives +
            ngx_stream_upstream_hc_module.directives +
            ngx_stream_upstream_module.directives +
            ngx_stream_zone_sync_module.directives
)
