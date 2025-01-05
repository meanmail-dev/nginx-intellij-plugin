package dev.meanmail.directives.nginx.http

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/http/ngx_http_geoip_module.html

val ngx_http_geoip_module = NginxModule(
    "ngx_http_geoip_module",
    description = "Provides geolocation functionality using MaxMind GeoIP databases for IP-based information retrieval",
    enabled = true
)

val geoipCountry = Directive(
    name = "geoip_country",
    description = "Specifies the path to the MaxMind GeoIP country database for determining the country of the client's IP address",
    parameters = listOf(
        DirectiveParameter(
            name = "database_path",
            description = "Full path to the MaxMind GeoIP country database file",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_geoip_module
)

val geoipCity = Directive(
    name = "geoip_city",
    description = "Specifies the path to the MaxMind GeoIP city database for determining detailed location information",
    parameters = listOf(
        DirectiveParameter(
            name = "database_path",
            description = "Full path to the MaxMind GeoIP city database file",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_geoip_module
)

val geoipOrg = Directive(
    name = "geoip_org",
    description = "Specifies the path to the MaxMind GeoIP organization database for determining the organization associated with an IP address",
    parameters = listOf(
        DirectiveParameter(
            name = "database_path",
            description = "Full path to the MaxMind GeoIP organization database file",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http, server, location),
    module = ngx_http_geoip_module
)

val geoipProxy = Directive(
    name = "geoip_proxy",
    description = "Defines trusted proxy networks for correctly identifying the original client IP address when behind a proxy",
    parameters = listOf(
        DirectiveParameter(
            name = "network",
            description = "IP address or network range of trusted proxy servers",
            valueType = ValueType.STRING,
            required = true,
            multiple = true
        )
    ),
    context = listOf(http, server),
    module = ngx_http_geoip_module
)

val geoipProxyRecursive = Directive(
    name = "geoip_proxy_recursive",
    description = "Determines whether to recursively search for the original client IP address through multiple proxy layers",
    parameters = listOf(
        DirectiveParameter(
            name = "state",
            description = "Enable or disable recursive proxy IP search",
            valueType = ValueType.BOOLEAN,
            required = false,
            defaultValue = "off"
        )
    ),
    context = listOf(http, server),
    module = ngx_http_geoip_module
)
