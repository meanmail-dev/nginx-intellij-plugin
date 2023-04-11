package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/stream/ngx_stream_geoip_module.html

val streamGeoipCountry = Directive("geoip_country")
val streamGeoipCity = Directive("geoip_city")
val streamGeoipOrg = Directive("geoip_org")

val ngx_stream_geoip_module = Module(
    "ngx_stream_geoip_module",
    enabled = false,
    directives = setOf(
        streamGeoipCity,
        streamGeoipCountry,
        streamGeoipOrg,
    )
)
