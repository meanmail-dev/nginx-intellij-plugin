package dev.meanmail

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class NginxColorSettingsPage : ColorSettingsPage {

    private val descriptors = arrayOf(
        AttributesDescriptor("Braces", NginxSyntaxHighlighter.BRACE),
        AttributesDescriptor("Comment", NginxSyntaxHighlighter.COMMENT),
        AttributesDescriptor("Directive identifier", NginxSyntaxHighlighter.IDENTIFIER),
        AttributesDescriptor("Directive identifier//Lua block", NginxSyntaxHighlighter.LUA_BLOCK_DIRECTIVE),
        AttributesDescriptor("IP address", NginxSyntaxHighlighter.IP_ADDRESS),
        AttributesDescriptor("IP range", NginxSyntaxHighlighter.IP_RANGE),
        AttributesDescriptor("Keyword directives", NginxSyntaxHighlighter.KEYWORD),
        AttributesDescriptor("Keyword directives//geo", NginxSyntaxHighlighter.GEO),
        AttributesDescriptor("Keyword directives//geo//default parameter", NginxSyntaxHighlighter.GEO_DEFAULT),
        AttributesDescriptor("Keyword directives//geo//proxy parameter", NginxSyntaxHighlighter.GEO_PROXY),
        AttributesDescriptor("Keyword directives//geo//ranges parameter", NginxSyntaxHighlighter.GEO_RANGES),
        AttributesDescriptor("Keyword directives//if", NginxSyntaxHighlighter.IF),
        AttributesDescriptor("Keyword directives//return", NginxSyntaxHighlighter.RETURN),
        AttributesDescriptor("Keyword directives//map", NginxSyntaxHighlighter.MAP),
        AttributesDescriptor("Keyword directives//map//default parameter", NginxSyntaxHighlighter.MAP_DEFAULT),
        AttributesDescriptor("Keyword directives//map//hostnames parameter", NginxSyntaxHighlighter.MAP_HOSTNAMES),
        AttributesDescriptor("Keyword directives//map//volatile parameter", NginxSyntaxHighlighter.MAP_VOLATILE),
        AttributesDescriptor("Number", NginxSyntaxHighlighter.NUMBER),
        AttributesDescriptor("Number//Size", NginxSyntaxHighlighter.NUMBER_SIZE),
        AttributesDescriptor("Number//Duration", NginxSyntaxHighlighter.NUMBER_DURATION),
        AttributesDescriptor("Operator", NginxSyntaxHighlighter.OPERATOR),
        AttributesDescriptor("Parentheses", NginxSyntaxHighlighter.PAREN),
        AttributesDescriptor("Semicolon", NginxSyntaxHighlighter.SEMICOLON),
        AttributesDescriptor("String", NginxSyntaxHighlighter.STRING),
        AttributesDescriptor("Value", NginxSyntaxHighlighter.VALUE),
        AttributesDescriptor("Variable", NginxSyntaxHighlighter.VARIABLE)
    )


    override fun getIcon(): Icon {
        return NginxFileType.INSTANCE.icon
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return NginxSyntaxHighlighter()
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? {
        return null
    }

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return descriptors
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "NGINX"
    }


    override fun getDemoText(): String {
        return """
# Map directive
map ${'$'}http_user_agent ${'$'}mobile {
    default 0;
    ~*android 1;
    ~*iphone 1;
}

# Geo directive with IP addresses
geo ${'$'}country {
    default ZZ;
    127.0.0.1 US;
    10.0.0.0/8 INTERNAL;
    192.168.1.0/24 LAN;
    2001:db8::1 IPv6;
}

# Geo directive with IP ranges
geo ${'$'}region {
    ranges;
    default unknown;
    10.0.0.0-10.255.255.255 internal;
    192.168.0.0-192.168.255.255 lan;
}

# Upstream with IP addresses and ports
upstream backend {
    server 192.168.1.10:8080;
    server 192.168.1.11:8080;
    server [2001:db8::1]:9000;
}

# Main server configuration
server {
    # Listen directives with port numbers
    listen 192.168.1.100:443 ssl http2;
    listen 80;
    server_name example.com www.example.com;

    # Timeouts and sizes with units
    client_body_timeout 60s;
    client_max_body_size 10M;
    keepalive_timeout 75s;
    proxy_connect_timeout 90s;
    proxy_read_timeout 3m;
    send_timeout 2m;

    # Buffer sizes
    proxy_buffer_size 4k;
    proxy_buffers 8 8k;
    client_body_buffer_size 128k;

    # SSL configuration
    ssl_certificate '/etc/ssl/certs/cert.pem';
    ssl_session_timeout 1d;
    ssl_session_cache shared:SSL:10M;

    # Numeric rate limiting
    limit_rate 500k;
    limit_rate_after 5M;

    # Conditional redirect
    if (${'$'}scheme != "https") {
        return 301 https://${'$'}server_name${'$'}request_uri;
    }

    # Location block with Lua
    location /api {
        # Lua block directive
        content_by_lua_block {
            ngx.say("Hello from Lua")
            ngx.log(ngx.INFO, "Request: " .. ngx.var.request_uri)
        }
    }

    # Location with numbers and IP access control
    location /api {
        allow 192.168.1.0/24;
        allow 10.0.0.0/8;
        deny all;

        # Return codes
        if (!-f ${'$'}request_filename) {
            return 404;
        }
    }
}
""".trimIndent()
    }
}
