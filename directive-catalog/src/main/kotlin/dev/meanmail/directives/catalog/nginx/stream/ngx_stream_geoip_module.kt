package dev.meanmail.directives.catalog.nginx.stream

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/stream/ngx_stream_geoip_module.html

val ngx_stream_geoip_module = NginxModule(
    name = "ngx_stream_geoip_module",
    description = "The GeoIP module for NGINX"
)

val streamGeoipCountry = Directive(
    name = "geoip_country",
    description = "Specifies the path to the GeoIP country database",
    module = ngx_stream_geoip_module,
    context = listOf(stream)
)

val streamGeoipCity = Directive(
    name = "geoip_city",
    description = "Specifies the path to the GeoIP city database",
    module = ngx_stream_geoip_module,
    context = listOf(stream)
)

val streamGeoipOrg = Directive(
    name = "geoip_org",
    description = "Specifies the path to the GeoIP organization database",
    module = ngx_stream_geoip_module,
    context = listOf(stream)
)
