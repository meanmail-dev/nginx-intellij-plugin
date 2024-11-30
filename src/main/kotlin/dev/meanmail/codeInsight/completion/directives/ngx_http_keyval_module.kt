package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_keyval_module.html

val ngx_http_keyval_module = NginxModule(
    "ngx_http_keyval_module",
    description = "Creates variables with values from key-value pairs managed by API",
    enabled = true
)

val keyvalZone = Directive(
    name = "keyval_zone",
    description = "Sets name, size, and configuration of shared memory zone for key-value database",
    parameters = listOf(
        DirectiveParameter(
            name = "zone",
            description = "Name and size of shared memory zone",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "state",
            description = "File path to store key-value database state in JSON format",
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
            description = "Matching type for key lookup: string (default), ip, or prefix",
            valueType = ValueType.ENUM,
            allowedValues = listOf("string", "ip", "prefix"),
            required = false,
            defaultValue = "string"
        ),
        DirectiveParameter(
            name = "sync",
            description = "Enable synchronization of shared memory zone",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(http),
    module = ngx_http_keyval_module
)

val keyval = Directive(
    name = "keyval",
    description = "Creates a variable whose value is looked up by key in the key-value database",
    parameters = listOf(
        DirectiveParameter(
            name = "key",
            description = "Key for lookup in key-value database",
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
            description = "Name of shared memory zone containing the key-value database",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http),
    module = ngx_http_keyval_module
)
