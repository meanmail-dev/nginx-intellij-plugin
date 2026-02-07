package dev.meanmail.directives.catalog.nginx.stream

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule

// https://nginx.org/en/docs/stream/ngx_stream_geo_module.html


val ngx_stream_geo_module = NginxModule(
    name = "ngx_stream_geo_module",
        description = "Advanced stream module for creating dynamic geolocation variables based on client IP addresses, supporting complex routing and content delivery strategies",
)

val streamGeo = Directive(
    name = "geo",
    description = "Defines a geolocation variable based on the client IP address in stream context, enabling dynamic content and routing decisions",
    module = ngx_stream_geo_module,
    context = listOf(stream)
)
