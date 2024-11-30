package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_pass_module.html

val ngx_stream_pass_module = NginxModule(
    name = "ngx_stream_pass_module",
    description = "Provides routing and proxying functionality for TCP/UDP stream connections to backend servers",
    enabled = true
)

val streamPass = Directive(
    "pass",
    description = "Redirects the incoming stream connection to a specified backend server or server group",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            valueType = ValueType.STRING,
            description = "Specifies the destination server address. Can be an IP address, hostname, or upstream group name",
            required = true
        ),
        DirectiveParameter(
            name = "port",
            valueType = ValueType.NUMBER,
            description = "Optional destination server port. If not specified, uses the same port as the incoming connection",
            required = false
        )
    ),
    context = listOf(stream, streamServer),
    module = ngx_stream_pass_module
)
