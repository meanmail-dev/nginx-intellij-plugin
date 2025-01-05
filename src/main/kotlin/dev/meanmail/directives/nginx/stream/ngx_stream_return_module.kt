package dev.meanmail.directives.nginx.stream

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/stream/ngx_stream_return_module.html

val ngx_stream_return_module = NginxModule(
    name = "ngx_stream_return_module",
    description = "A module to return the specified value in response to a stream request",
    enabled = true
)

val streamReturn = Directive(
    name = "return",
    description = "Sends a specified value to the client and closes the connection",
    parameters = listOf(
        DirectiveParameter(
            name = "value",
            valueType = ValueType.STRING,
            description = "Value to send to the client. Can contain text, variables, or their combination",
        )
    ),
    context = listOf(streamServer),
    module = ngx_stream_return_module
)
