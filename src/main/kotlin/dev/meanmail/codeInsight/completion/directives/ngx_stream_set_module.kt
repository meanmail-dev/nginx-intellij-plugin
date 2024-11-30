package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_set_module.html

val ngx_stream_set_module = NginxModule(
    name = "ngx_stream_set_module",
    description = "Stream module for dynamically setting variables in Nginx stream processing",
    enabled = true
)

val streamSet = Directive(
    name = "set",
    description = "Sets a value of a variable in stream context",
    parameters = listOf(
        DirectiveParameter(
            name = "variable",
            valueType = ValueType.STRING,
            description = "Name of the variable to set",
        ),
        DirectiveParameter(
            name = "value",
            valueType = ValueType.STRING,
            description = "Value to assign to the variable",
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_set_module
)
