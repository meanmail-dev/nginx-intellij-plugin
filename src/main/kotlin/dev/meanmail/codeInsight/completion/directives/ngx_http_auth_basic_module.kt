package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_auth_basic_module.html

val ngx_http_auth_basic_module = NginxModule(
    "ngx_http_auth_basic_module",
    description = "HTTP basic authentication module",
    enabled = true
)

val authBasic = Directive(
    name = "auth_basic",
    description = "Enables HTTP basic authentication and specifies the authentication realm",
    parameters = listOf(
        DirectiveParameter(
            name = "realm",
            description = "Authentication realm displayed in the browser's login prompt",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "Restricted"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_auth_basic_module
)

val authBasicUserFile = Directive(
    name = "auth_basic_user_file",
    description = "Specifies the path to the file containing user credentials for basic authentication",
    parameters = listOf(
        DirectiveParameter(
            name = "file_path",
            description = "Path to the htpasswd file containing username and encrypted password",
            valueType = ValueType.PATH,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_auth_basic_module
)
