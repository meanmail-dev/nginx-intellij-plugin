package dev.meanmail.directives.nginx.stream

import dev.meanmail.directives.Directive
import dev.meanmail.directives.DirectiveParameter
import dev.meanmail.directives.NginxModule
import dev.meanmail.directives.ValueType

// https://nginx.org/en/docs/stream/ngx_stream_geoip_module.html

val ngx_stream_geoip_module = NginxModule(
    name = "ngx_stream_geoip_module",
    description = "The GeoIP module for NGINX",
    enabled = false
)

val streamGeoipCountry = Directive(
    name = "geoip_country",
    description = "Specifies the path to the GeoIP country database",
    parameters = listOf(
        DirectiveParameter(
            name = "database_file",
            description = "Path to the MaxMind GeoIP database file",
            valueType = ValueType.PATH,
            required = true
        )
    ),
    module = ngx_stream_geoip_module,
    context = listOf(stream)
)

val streamGeoipCity = Directive(
    name = "geoip_city",
    description = "Specifies the path to the GeoIP city database",
    parameters = listOf(
        DirectiveParameter(
            name = "database_file",
            description = "Path to the MaxMind GeoIP database file",
            valueType = ValueType.PATH,
            required = true
        )
    ),
    module = ngx_stream_geoip_module,
    context = listOf(stream)
)

val streamGeoipOrg = Directive(
    name = "geoip_org",
    description = "Specifies the path to the GeoIP organization database",
    parameters = listOf(
        DirectiveParameter(
            name = "database_file",
            description = "Path to the MaxMind GeoIP database file",
            valueType = ValueType.PATH,
            required = true
        )
    ),
    module = ngx_stream_geoip_module,
    context = listOf(stream)
)
