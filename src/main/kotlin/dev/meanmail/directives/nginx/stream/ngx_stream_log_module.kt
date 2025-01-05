package dev.meanmail.directives.nginx.stream

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/stream/ngx_stream_log_module.html

val ngx_stream_log_module = NginxModule(
    name = "ngx_stream_log_module",
    description = "Provides logging functionality for TCP/UDP stream connections, enabling detailed logging of client connection events",
    enabled = true
)

val streamAccessLog = Directive(
    "access_log",
    description = "Configures logging of client connections in the stream context, allowing detailed tracking of connection events",
    parameters = listOf(
        DirectiveParameter(
            "path",
            "Path to the log file, or 'off' to disable logging. Can be an absolute or relative path",
            valueType = ValueType.STRING,
            required = false,
            allowedValues = listOf("off")
        ),
        DirectiveParameter(
            "format",
            "Name of the log format previously defined by log_format directive. If not specified, uses the predefined 'combined' format",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "combined"
        ),
        DirectiveParameter(
            "buffer",
            "Sets the buffer size for writing log entries. Helps improve logging performance by buffering log writes",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "64k"
        ),
        DirectiveParameter(
            "gzip",
            "Sets compression level for log files (1-9). Higher levels provide more compression but are more CPU-intensive",
            valueType = ValueType.NUMBER,
            required = false,
            minValue = 1,
            maxValue = 9
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_log_module
)

val streamLogFormat = Directive(
    "log_format",
    description = "Defines a custom log format for stream connections, allowing flexible and detailed logging of connection metadata",
    parameters = listOf(
        DirectiveParameter(
            "name",
            "Name of the log format. Used as a reference in access_log directive. 'combined' is the default predefined format",
            valueType = ValueType.STRING,
            required = true,
            defaultValue = "combined"
        ),
        DirectiveParameter(
            "format",
            "Format string defining log entries using stream-specific variables. Supports escape sequences and variable interpolation",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(stream),
    module = ngx_stream_log_module
)

val streamOpenLogFileCache = Directive(
    "open_log_file_cache",
    description = "Configures caching of log file descriptors to improve logging performance and reduce system overhead",
    parameters = listOf(
        DirectiveParameter(
            "max",
            "Maximum number of cached log files. Controls memory usage for log file caching",
            valueType = ValueType.NUMBER,
            required = false,
            defaultValue = "10"
        ),
        DirectiveParameter(
            "inactive",
            "Time after which an unused file descriptor is closed. Helps manage resource allocation",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "10m"
        ),
        DirectiveParameter(
            "min_uses",
            "Minimum number of file uses to keep it open. Prevents caching of rarely used log files",
            valueType = ValueType.NUMBER,
            required = false,
            defaultValue = "1"
        ),
        DirectiveParameter(
            "valid",
            "Time interval to check file existence and metadata. Helps detect file changes",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "1m"
        ),
        DirectiveParameter(
            "state",
            "Enables or disables the log file descriptor cache",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_log_module
)
