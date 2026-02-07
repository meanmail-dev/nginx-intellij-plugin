package dev.meanmail.directives.catalog.nginx.http

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/http/ngx_http_geoip_module.html

val ngx_http_geoip_module = NginxModule(
    "ngx_http_geoip_module",
    description = "Provides geolocation functionality using MaxMind GeoIP databases for IP-based information retrieval"
)

val geoipCountry = Directive(
    name = "geoip_country",
    description = "Specifies the path to the MaxMind GeoIP country database for determining the country of the client's IP address",
    context = listOf(http, server, location),
    module = ngx_http_geoip_module
)

val geoipCity = Directive(
    name = "geoip_city",
    description = "Specifies the path to the MaxMind GeoIP city database for determining detailed location information",
    context = listOf(http, server, location),
    module = ngx_http_geoip_module
)

val geoipOrg = Directive(
    name = "geoip_org",
    description = "Specifies the path to the MaxMind GeoIP organization database for determining the organization associated with an IP address",
    context = listOf(http, server, location),
    module = ngx_http_geoip_module
)

val geoipProxy = Directive(
    name = "geoip_proxy",
    description = "Defines trusted proxy networks for correctly identifying the original client IP address when behind a proxy",
    context = listOf(http, server),
    module = ngx_http_geoip_module
)

val geoipProxyRecursive = Directive(
    name = "geoip_proxy_recursive",
    description = "Determines whether to recursively search for the original client IP address through multiple proxy layers",
    context = listOf(http, server),
    module = ngx_http_geoip_module
)
