package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/http/ngx_http_log_module.html

val ngx_http_log_module = NginxModule(
    name = "ngx_http_log_module",
    description = "Writes request logs in the specified format",
    enabled = true
)

val accessLog = Directive(
    name = "access_log",
    description = "Sets the path, format, and configuration for a buffered log write",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the log file, can be 'off' to disable logging",
            valueType = ValueType.PATH,
            required = false,
            defaultValue = "logs/access.log"
        ),
        DirectiveParameter(
            name = "format",
            description = "Log format name or format string, defaults to 'combined'",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "combined"
        ),
        DirectiveParameter(
            name = "buffer",
            description = "Buffer size for log writing, must not exceed atomic write size",
            valueType = ValueType.SIZE,
            required = false
        ),
        DirectiveParameter(
            name = "gzip",
            description = "Enables gzip compression for log files (1-9)",
            valueType = ValueType.NUMBER,
            required = false,
            allowedValues = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
        )
    ),
    context = listOf(http, server, location, locationIf, limitExcept),
    module = ngx_http_log_module
)

val logFormat = Directive(
    name = "log_format",
    description = "Specifies log format with optional character escaping",
    parameters = listOf(
        DirectiveParameter(
            name = "format_name",
            description = "Name of the custom log format",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "escape",
            description = "Character escaping mode: default, json, or none",
            valueType = ValueType.ENUM,
            allowedValues = listOf("default", "json", "none"),
            required = false,
            defaultValue = "default"
        ),
        DirectiveParameter(
            name = "format_string",
            description = "Detailed format string defining log entry structure",
            valueType = ValueType.STRING,
            required = true,
            defaultValue = "\$remote_addr - \$remote_user [\$time_local] \"\$request\" \$status \$body_bytes_sent \"\$http_referer\" \"\$http_user_agent\""
        )
    ),
    context = listOf(http),
    module = ngx_http_log_module
)

val openLogFileCache = Directive(
    name = "open_log_file_cache",
    description = "Configures caching of log file descriptors to improve performance",
    parameters = listOf(
        DirectiveParameter(
            name = "max",
            description = "Maximum number of log files to keep open",
            valueType = ValueType.NUMBER,
            required = false,
            defaultValue = "1000"
        ),
        DirectiveParameter(
            name = "inactive",
            description = "Time after which an inactive log file descriptor is closed",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "10s"
        ),
        DirectiveParameter(
            name = "min_uses",
            description = "Minimum number of file uses before caching",
            valueType = ValueType.NUMBER,
            required = false,
            defaultValue = "1"
        ),
        DirectiveParameter(
            name = "valid",
            description = "Time to check file existence before reopening",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "60s"
        )
    ),
    context = listOf(http),
    module = ngx_http_log_module
)
