package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_browser_module.html

val ngx_http_browser_module = NginxModule(
    "ngx_http_browser_module",
    description = "Enables browser detection and classification in Nginx",
    enabled = true
)

val ancientBrowser = Directive(
    name = "ancient_browser",
    description = "Defines browsers considered outdated or ancient",
    parameters = listOf(
        DirectiveParameter(
            name = "browser_name",
            description = "Name of the browser to be considered ancient",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_browser_module
)

val ancientBrowserValue = Directive(
    name = "ancient_browser_value",
    description = "Sets the value returned for ancient browsers",
    parameters = listOf(
        DirectiveParameter(
            name = "value",
            description = "Value returned when an ancient browser is detected",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "1"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_browser_module
)

val modernBrowser = Directive(
    name = "modern_browser",
    description = "Defines browsers considered modern or up-to-date",
    parameters = listOf(
        DirectiveParameter(
            name = "browser_name",
            description = "Name of the browser to be considered modern",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_browser_module
)

val modernBrowserValue = Directive(
    name = "modern_browser_value",
    description = "Sets the value returned for modern browsers",
    parameters = listOf(
        DirectiveParameter(
            name = "value",
            description = "Value returned when a modern browser is detected",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "0"
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_browser_module
)
