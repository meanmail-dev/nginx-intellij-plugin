package dev.meanmail.directives.nginx.stream

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/stream/ngx_stream_keyval_module.html

val ngx_stream_keyval_module = NginxModule(
    name = "ngx_stream_keyval_module",
    description = "Advanced stream module for dynamic key-value storage and lookup, enabling flexible runtime configuration, data sharing, and conditional processing",
    enabled = true,
)

val streamKeyval = Directive(
    name = "keyval",
    description = "Creates a variable whose value is looked up by the key in the key-value database",
    parameters = listOf(
        DirectiveParameter(
            name = "key",
            description = "Key for lookup in the key-value database",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "variable",
            description = "Variable to store the looked-up value",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "zone",
            description = "Shared memory zone name containing the key-value database",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(stream),
    module = ngx_stream_keyval_module
)

val streamKeyvalZone = Directive(
    name = "keyval_zone",
    description = "Sets the name, size, and configuration of the shared memory zone for key-value database",
    parameters = listOf(
        DirectiveParameter(
            name = "zone",
            description = "Name and size of the shared memory zone",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "state",
            description = "File path to persist key-value database state",
            valueType = ValueType.PATH,
            required = false
        ),
        DirectiveParameter(
            name = "timeout",
            description = "Time after which key-value pairs are removed from the zone",
            valueType = ValueType.TIME,
            required = false
        ),
        DirectiveParameter(
            name = "type",
            description = "Type of key matching (string, ip, prefix)",
            valueType = ValueType.STRING,
            allowedValues = listOf("string", "ip", "prefix"),
            defaultValue = "string",
            required = false
        ),
        DirectiveParameter(
            name = "sync",
            description = "Enable synchronization of the shared memory zone",
            valueType = ValueType.BOOLEAN,
            required = false
        )
    ),
    context = listOf(stream),
    module = ngx_stream_keyval_module
)
