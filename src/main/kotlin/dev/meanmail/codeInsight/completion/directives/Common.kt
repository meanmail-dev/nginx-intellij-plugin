package dev.meanmail.codeInsight.completion.directives

import com.intellij.psi.PsiFile
import dev.meanmail.psi.DirectiveStmt

enum class ValueType {
    TIME,           // Time values (e.g., 10s, 1m, 500ms)
    NUMBER,         // Numeric values
    INTEGER,        // Integer values
    BOOLEAN,        // on/off, true/false
    STRING,         // String values
    PATH,           // File or directory path values
    LIST,           // List of values
    ENUM,           // Enumerated values
    SIZE,           // Size values (e.g., 10k, 1m, 500g)
    OFFSET,         // Offset values for ranges or positioning
    RATE,           // Rate limiting values (e.g., requests per second)
    STRING_LIST,    // List of string values
}

data class DirectiveParameter(
    val name: String? = null,
    val description: String? = null,
    val valueType: ValueType = ValueType.STRING,
    val allowedValues: List<String>? = null,
    val validator: ((String) -> Boolean)? = null,
    val regex: Regex? = null,
    val required: Boolean = true,
    val defaultValue: String? = null,
    val multiple: Boolean = false,
    val minValue: Int? = null,
    val maxValue: Int? = null
)

open class Directive(
    val name: String,
    val description: String,
    val parameters: List<DirectiveParameter>,
    val context: List<Directive>,
    val module: NginxModule
) {
    val children: MutableSet<Directive> = mutableSetOf()

    init {
        if (context.isNotEmpty() && context.contains(any)) {
            all.forEach { it.children.add(this) }
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
        if (context.any { it.isAllowedPath(path.subList(0, path.size - 1)) }) {
            return true
        }
        return false
    }

    companion object {
        private val _all by lazy {
            listOf(
                *main_module.directives.toTypedArray(),
                *ngx_core_module.directives.toTypedArray(),
                *ngx_google_perftools_module.directives.toTypedArray(),
                *ngx_http_access_module.directives.toTypedArray(),
                *ngx_http_addition_module.directives.toTypedArray(),
                *ngx_http_api_module.directives.toTypedArray(),
                *ngx_http_auth_basic_module.directives.toTypedArray(),
                *ngx_http_auth_jwt_module.directives.toTypedArray(),
                *ngx_http_auth_request_module.directives.toTypedArray(),
                *ngx_http_autoindex_module.directives.toTypedArray(),
                *ngx_http_browser_module.directives.toTypedArray(),
                *ngx_http_charset_module.directives.toTypedArray(),
                *ngx_http_core_module.directives.toTypedArray(),
                *ngx_http_dav_module.directives.toTypedArray(),
                *ngx_http_empty_gif_module.directives.toTypedArray(),
                *ngx_http_f4f_module.directives.toTypedArray(),
                *ngx_http_fastcgi_module.directives.toTypedArray(),
                *ngx_http_flv_module.directives.toTypedArray(),
                *ngx_http_geo_module.directives.toTypedArray(),
                *ngx_http_geoip_module.directives.toTypedArray(),
                *ngx_http_grpc_module.directives.toTypedArray(),
                *ngx_http_gunzip_module.directives.toTypedArray(),
                *ngx_http_gzip_module.directives.toTypedArray(),
                *ngx_http_gzip_static_module.directives.toTypedArray(),
                *ngx_http_headers_module.directives.toTypedArray(),
                *ngx_http_hls_module.directives.toTypedArray(),
                *ngx_http_image_filter_module.directives.toTypedArray(),
                *ngx_http_index_module.directives.toTypedArray(),
                *ngx_http_js_module.directives.toTypedArray(),
                *ngx_http_keyval_module.directives.toTypedArray(),
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
                *ngx_http_session_log_module.directives.toTypedArray(),
                *ngx_http_slice_module.directives.toTypedArray(),
                *ngx_http_spdy_module.directives.toTypedArray(),
                *ngx_http_split_clients_module.directives.toTypedArray(),
                *ngx_http_ssi_module.directives.toTypedArray(),
                *ngx_http_ssl_module.directives.toTypedArray(),
                *ngx_http_status_module.directives.toTypedArray(),
                *ngx_http_stub_status_module.directives.toTypedArray(),
                *ngx_http_sub_module.directives.toTypedArray(),
                *ngx_http_upstream_conf_module.directives.toTypedArray(),
                *ngx_http_upstream_hc_module.directives.toTypedArray(),
                *ngx_http_upstream_module.directives.toTypedArray(),
                *ngx_http_userid_module.directives.toTypedArray(),
                *ngx_http_uwsgi_module.directives.toTypedArray(),
                *ngx_http_v2_module.directives.toTypedArray(),
                *ngx_http_xslt_module.directives.toTypedArray(),

                // Stream modules
                *ngx_stream_access_module.directives.toTypedArray(),
                *ngx_stream_core_module.directives.toTypedArray(),
                *ngx_stream_geo_module.directives.toTypedArray(),
                *ngx_stream_geoip_module.directives.toTypedArray(),
                *ngx_stream_js_module.directives.toTypedArray(),
                *ngx_stream_keyval_module.directives.toTypedArray(),
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
                *ngx_stream_upstream_hc_module.directives.toTypedArray(),
                *ngx_stream_upstream_module.directives.toTypedArray(),
                *ngx_stream_zone_sync_module.directives.toTypedArray(),

                // Mail modules
                *ngx_mail_auth_http_module.directives.toTypedArray(),
                *ngx_mail_core_module.directives.toTypedArray(),
                *ngx_mail_imap_module.directives.toTypedArray(),
                *ngx_mail_pop3_module.directives.toTypedArray(),
                *ngx_mail_proxy_module.directives.toTypedArray(),
                *ngx_mail_realip_module.directives.toTypedArray(),
                *ngx_mail_smtp_module.directives.toTypedArray(),
                *ngx_mail_ssl_module.directives.toTypedArray(),

                // External modules
                *ngx_http_echo_module.directives.toTypedArray(),
                *ngx_http_lua_module.directives.toTypedArray(),
            )
        }

        val all: List<Directive>
            get() = _all
    }
}

class RecursiveDirective(
    name: String,
    description: String,
    parameters: List<DirectiveParameter>,
    context: List<Directive>,
    module: NginxModule
) : Directive(
    name,
    description,
    parameters,
    context,
    module
) {
    init {
        // Add itself as a potential child to support recursion
        this.children.add(this)
    }
}

class ToggleDirective(
    name: String,
    description: String,
    enabled: Boolean,
    context: List<Directive>,
    module: NginxModule
) : Directive(
    name,
    description,
    listOf(
        DirectiveParameter(
            name = "state",
            description = "Enables or disables the directive",
            valueType = ValueType.BOOLEAN,
            allowedValues = listOf("on", "off"),
            defaultValue = if (enabled) "on" else "off"
        )
    ),
    context,
    module
)

open class NginxModule(
    val name: String,
    val description: String,
    val enabled: Boolean
) {
    val directives = mutableSetOf<Directive>()
}

val main_module = NginxModule(
    "main",
    description = "Main module",
    enabled = true
)

val any = Directive(
    "any",
    "Directive for dynamic context determination",
    emptyList(),
    emptyList(),
    main_module
)

val main = Directive(
    "main",
    "Top-level directives that cannot be nested",
    emptyList(),
    emptyList(), // Mandatory empty context
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

fun determineFileContext(file: PsiFile): Set<Directive>? {
    // Find all directives in the file
    val directives = file.children
        .filterIsInstance<DirectiveStmt>()

    // Try to find a directive with a valid context
    var context = mutableSetOf<Directive>()
    for (directive in directives) {
        val matchingDirectives = Directive.all.filter { it.name == directive.name }
        if (matchingDirectives.isEmpty()) {
            continue
        }
        val matchingDirectivesContext = matchingDirectives.map { it.context }.flatten().toSet()
        if (context.isEmpty()) {
            context = matchingDirectivesContext.toMutableSet()
            continue
        }
        val newContext = context.intersect(matchingDirectivesContext)
        if (newContext.isEmpty()) {
            return context
        } else {
            context = newContext.toMutableSet()
        }
    }

    // If no directives with context found, return null
    // any context is allowed
    return null
}
