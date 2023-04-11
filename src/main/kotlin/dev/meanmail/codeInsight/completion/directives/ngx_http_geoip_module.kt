package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/http/ngx_http_geoip_module.html

val geoipCountry = Directive("geoip_country")
val geoipCity = Directive("geoip_city")
val geoipOrg = Directive("geoip_org")
val geoipProxy = Directive("geoip_proxy")
val geoipProxyRecursive = ToggleDirective("geoip_proxy_recursive", false)

val ngx_http_geoip_module = Module(
    "ngx_http_geoip_module",
    enabled = false,
    directives = setOf(
        geoipCity,
        geoipCountry,
        geoipOrg,
        geoipProxy,
        geoipProxyRecursive,
    )
)
