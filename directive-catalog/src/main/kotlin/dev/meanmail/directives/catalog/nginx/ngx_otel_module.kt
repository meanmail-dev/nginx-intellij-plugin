package dev.meanmail.directives.catalog.nginx

import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.NginxModule
import dev.meanmail.directives.catalog.nginx.http.http
import dev.meanmail.directives.catalog.nginx.http.location
import dev.meanmail.directives.catalog.nginx.http.server

// https://nginx.org/en/docs/ngx_otel_module.html

val ngx_otel_module = NginxModule(
    name = "ngx_otel_module",
    description = "OpenTelemetry module for distributed tracing and context propagation"
)

val otelExporter = Directive(
    name = "otel_exporter",
    description = "Specifies OTel data export parameters as an OTel exporter configuration block",
    context = listOf(http),
    module = ngx_otel_module
)

val otelResourceAttr = Directive(
    name = "otel_resource_attr",
    description = "Sets custom OTel resource attributes",
    context = listOf(http),
    module = ngx_otel_module
)

val otelServiceName = Directive(
    name = "otel_service_name",
    description = "Sets the service.name attribute for the OTel resource",
    context = listOf(http),
    module = ngx_otel_module
)

val otelSpanAttr = Directive(
    name = "otel_span_attr",
    description = "Adds a custom OTel span attribute",
    context = listOf(http, server, location),
    module = ngx_otel_module
)

val otelSpanName = Directive(
    name = "otel_span_name",
    description = "Defines the span name for OpenTelemetry tracing",
    context = listOf(http, server, location),
    module = ngx_otel_module
)

val otelTrace = Directive(
    name = "otel_trace",
    description = "Enables or disables OpenTelemetry tracing",
    context = listOf(http, server, location),
    module = ngx_otel_module
)

val otelTraceContext = Directive(
    name = "otel_trace_context",
    description = "Specifies how to propagate traceparent/tracestate headers",
    context = listOf(http, server, location),
    module = ngx_otel_module
)
