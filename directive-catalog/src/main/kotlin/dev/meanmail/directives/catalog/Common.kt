package dev.meanmail.directives.catalog

import dev.meanmail.directives.catalog.nginx.core.ngx_core_module
import dev.meanmail.directives.catalog.nginx.google.ngx_google_perftools_module
import dev.meanmail.directives.catalog.nginx.http.*
import dev.meanmail.directives.catalog.nginx.http.auth.ngx_http_auth_basic_module
import dev.meanmail.directives.catalog.nginx.http.auth.ngx_http_auth_request_module
import dev.meanmail.directives.catalog.nginx.http.gzip.ngx_http_gzip_module
import dev.meanmail.directives.catalog.nginx.http.gzip.ngx_http_gzip_static_module
import dev.meanmail.directives.catalog.nginx.http.limit.ngx_http_limit_conn_module
import dev.meanmail.directives.catalog.nginx.http.limit.ngx_http_limit_req_module
import dev.meanmail.directives.catalog.nginx.http.upstream.ngx_http_upstream_module
import dev.meanmail.directives.catalog.nginx.mail.*
import dev.meanmail.directives.catalog.nginx.ngx_otel_module
import dev.meanmail.directives.catalog.nginx.stream.*
import dev.meanmail.directives.catalog.nginx.stream.ssl.ngx_stream_ssl_module
import dev.meanmail.directives.catalog.nginx.stream.ssl.ngx_stream_ssl_preread_module
import dev.meanmail.directives.catalog.nginx.stream.upstream.ngx_stream_upstream_module

open class Directive(
    val name: String,
    val description: String,
    val context: List<Directive>,
    val module: NginxModule
) {
    val children: MutableSet<Directive> = mutableSetOf()

    init {
        if (context.contains(any)) {
            all.forEach { it.children.add(this) }
        }
        if (context.contains(self)) {
            this.children.add(this)
        }
        context.forEach { it.children.add(this) }
        module.directives.add(this)
    }

    override fun toString(): String {
        return module.name + " ->  " + fullName
    }

    val fullName: String
        get() {
            return name + "(context: " + context.joinToString(", ") { it.name } + ")"
        }

    fun isAllowedPath(path: List<String>): Boolean {
        if (path.isEmpty()) {
            return false
        }
        if (path.last() != name) {
            return false
        }
        if (path.size == 1) {
            return true
        }
        val subPath = path.subList(0, path.size - 1)
        if (context.contains(any)) {
            return all.any { it.isAllowedPath(subPath) }
        }
        if (context.any {
                if (it == self) {
                    return this.isAllowedPath(subPath)
                }
                it.isAllowedPath(subPath)
            }) {
            return true
        }
        return false
    }

    companion object {
        private val standardDirectives by lazy {
            initDirectives()
        }

        private fun initDirectives(): List<Directive> = listOf(
            *main_module.directives.toTypedArray(),
            *ngx_core_module.directives.toTypedArray(),
            *ngx_google_perftools_module.directives.toTypedArray(),
            *ngx_http_access_module.directives.toTypedArray(),
            *ngx_http_addition_module.directives.toTypedArray(),
            *ngx_http_auth_basic_module.directives.toTypedArray(),
            *ngx_http_auth_request_module.directives.toTypedArray(),
            *ngx_http_autoindex_module.directives.toTypedArray(),
            *ngx_http_browser_module.directives.toTypedArray(),
            *ngx_http_charset_module.directives.toTypedArray(),
            *ngx_http_core_module.directives.toTypedArray(),
            *ngx_http_dav_module.directives.toTypedArray(),
            *ngx_http_empty_gif_module.directives.toTypedArray(),
            *ngx_http_fastcgi_module.directives.toTypedArray(),
            *ngx_http_flv_module.directives.toTypedArray(),
            *ngx_http_geo_module.directives.toTypedArray(),
            *ngx_http_geoip_module.directives.toTypedArray(),
            *ngx_http_grpc_module.directives.toTypedArray(),
            *ngx_http_gunzip_module.directives.toTypedArray(),
            *ngx_http_gzip_module.directives.toTypedArray(),
            *ngx_http_gzip_static_module.directives.toTypedArray(),
            *ngx_http_headers_module.directives.toTypedArray(),
            *ngx_http_image_filter_module.directives.toTypedArray(),
            *ngx_http_index_module.directives.toTypedArray(),
            *ngx_http_js_module.directives.toTypedArray(),
            *ngx_http_limit_conn_module.directives.toTypedArray(),
            *ngx_http_limit_req_module.directives.toTypedArray(),
            *ngx_http_log_module.directives.toTypedArray(),
            *ngx_http_map_module.directives.toTypedArray(),
            *ngx_http_memcached_module.directives.toTypedArray(),
            *ngx_http_mirror_module.directives.toTypedArray(),
            *ngx_http_mp4_module.directives.toTypedArray(),
            *ngx_http_perl_module.directives.toTypedArray(),
            *ngx_http_proxy_module.directives.toTypedArray(),
            *ngx_http_random_index_module.directives.toTypedArray(),
            *ngx_http_realip_module.directives.toTypedArray(),
            *ngx_http_referer_module.directives.toTypedArray(),
            *ngx_http_rewrite_module.directives.toTypedArray(),
            *ngx_http_scgi_module.directives.toTypedArray(),
            *ngx_http_secure_link_module.directives.toTypedArray(),
            *ngx_http_slice_module.directives.toTypedArray(),
            *ngx_http_spdy_module.directives.toTypedArray(),
            *ngx_http_split_clients_module.directives.toTypedArray(),
            *ngx_http_ssi_module.directives.toTypedArray(),
            *ngx_http_ssl_module.directives.toTypedArray(),
            *ngx_http_stub_status_module.directives.toTypedArray(),
            *ngx_http_sub_module.directives.toTypedArray(),
            *ngx_http_upstream_module.directives.toTypedArray(),
            *ngx_http_userid_module.directives.toTypedArray(),
            *ngx_http_uwsgi_module.directives.toTypedArray(),
            *ngx_http_v2_module.directives.toTypedArray(),
            *ngx_http_v3_module.directives.toTypedArray(),
            *ngx_http_xslt_module.directives.toTypedArray(),
            *ngx_http_acme_module.directives.toTypedArray(),
            // OpenTelemetry
            *ngx_otel_module.directives.toTypedArray(),

            // Stream modules
            *ngx_stream_access_module.directives.toTypedArray(),
            *ngx_stream_core_module.directives.toTypedArray(),
            *ngx_stream_geo_module.directives.toTypedArray(),
            *ngx_stream_geoip_module.directives.toTypedArray(),
            *ngx_stream_js_module.directives.toTypedArray(),
            *ngx_stream_limit_conn_module.directives.toTypedArray(),
            *ngx_stream_log_module.directives.toTypedArray(),
            *ngx_stream_map_module.directives.toTypedArray(),
            *ngx_stream_pass_module.directives.toTypedArray(),
            *ngx_stream_proxy_module.directives.toTypedArray(),
            *ngx_stream_realip_module.directives.toTypedArray(),
            *ngx_stream_return_module.directives.toTypedArray(),
            *ngx_stream_set_module.directives.toTypedArray(),
            *ngx_stream_split_clients_module.directives.toTypedArray(),
            *ngx_stream_ssl_module.directives.toTypedArray(),
            *ngx_stream_ssl_preread_module.directives.toTypedArray(),
            *ngx_stream_upstream_module.directives.toTypedArray(),

            // Mail modules
            *ngx_mail_auth_http_module.directives.toTypedArray(),
            *ngx_mail_core_module.directives.toTypedArray(),
            *ngx_mail_imap_module.directives.toTypedArray(),
            *ngx_mail_pop3_module.directives.toTypedArray(),
            *ngx_mail_proxy_module.directives.toTypedArray(),
            *ngx_mail_realip_module.directives.toTypedArray(),
            *ngx_mail_smtp_module.directives.toTypedArray(),
            *ngx_mail_ssl_module.directives.toTypedArray(),
        )

        val all: List<Directive>
            get() = standardDirectives
    }
}

open class NginxModule(
    val name: String,
    val description: String
) {
    val directives = mutableSetOf<Directive>()
}

val main_module = NginxModule(
    "main",
    description = "Main module"
)

val any = Directive(
    "any",
    "Directive for dynamic context determination",
    emptyList(),
    main_module
)

val self = Directive(
    "self",
    "Directive for self-referencing contexts",
    emptyList(),
    main_module
)

val main = Directive(
    "main",
    "Top-level directives that cannot be nested",
    emptyList(),
    main_module
)

fun findDirectives(name: String, path: List<String>? = null): List<Directive> {
    if (path == null) {
        return Directive.all.filter { it.name == name }
    }
    val directives = mutableListOf<Directive>()
    for (directive in Directive.all.filter { it.name == name }) {
        if (directive.isAllowedPath(path + listOf(name))) {
            directives.add(directive)
        }
    }
    return directives
}
