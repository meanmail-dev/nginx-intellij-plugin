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

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey> {
        return mapOf(
            "brace" to NginxSyntaxHighlighter.BRACE,
            "comment" to NginxSyntaxHighlighter.COMMENT,
            "geo" to NginxSyntaxHighlighter.GEO,
            "geo_default" to NginxSyntaxHighlighter.GEO_DEFAULT,
            "geo_proxy" to NginxSyntaxHighlighter.GEO_PROXY,
            "geo_ranges" to NginxSyntaxHighlighter.GEO_RANGES,
            "identifier" to NginxSyntaxHighlighter.IDENTIFIER,
            "if" to NginxSyntaxHighlighter.IF,
            "return" to NginxSyntaxHighlighter.RETURN,
            "ip_address" to NginxSyntaxHighlighter.IP_ADDRESS,
            "ip_range" to NginxSyntaxHighlighter.IP_RANGE,
            "keyword" to NginxSyntaxHighlighter.KEYWORD,
            "lua_block" to NginxSyntaxHighlighter.LUA_BLOCK_DIRECTIVE,
            "map" to NginxSyntaxHighlighter.MAP,
            "map_default" to NginxSyntaxHighlighter.MAP_DEFAULT,
            "map_hostnames" to NginxSyntaxHighlighter.MAP_HOSTNAMES,
            "map_volatile" to NginxSyntaxHighlighter.MAP_VOLATILE,
            "number" to NginxSyntaxHighlighter.NUMBER,
            "number_size" to NginxSyntaxHighlighter.NUMBER_SIZE,
            "number_duration" to NginxSyntaxHighlighter.NUMBER_DURATION,
            "operator" to NginxSyntaxHighlighter.OPERATOR,
            "paren" to NginxSyntaxHighlighter.PAREN,
            "semicolon" to NginxSyntaxHighlighter.SEMICOLON,
            "string" to NginxSyntaxHighlighter.STRING,
            "value" to NginxSyntaxHighlighter.VALUE,
            "variable" to NginxSyntaxHighlighter.VARIABLE
        )
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
<comment># Map directive</comment>
<map>map</map> <variable>${'$'}http_user_agent</variable> <variable>${'$'}mobile</variable> <brace>{</brace>
    <map_default>default</map_default> <number>0</number><semicolon>;</semicolon>
    <value>~*android</value> <number>1</number><semicolon>;</semicolon>
    <value>~*iphone</value> <number>1</number><semicolon>;</semicolon>
<brace>}</brace>

<comment># Geo directive with IP addresses</comment>
<geo>geo</geo> <variable>${'$'}country</variable> <brace>{</brace>
    <geo_default>default</geo_default> <value>ZZ</value><semicolon>;</semicolon>
    <ip_address>127.0.0.1</ip_address> <value>US</value><semicolon>;</semicolon>
    <ip_address>10.0.0.0/8</ip_address> <value>INTERNAL</value><semicolon>;</semicolon>
    <ip_address>192.168.1.0/24</ip_address> <value>LAN</value><semicolon>;</semicolon>
    <ip_address>2001:db8::1</ip_address> <value>IPv6</value><semicolon>;</semicolon>
<brace>}</brace>

<comment># Geo directive with IP ranges</comment>
<geo>geo</geo> <variable>${'$'}region</variable><brace>{</brace>
    <geo_ranges>ranges</geo_ranges><semicolon>;</semicolon>
    <geo_default>default</geo_default> <value>unknown</value><semicolon>;</semicolon>
    <ip_range>10.0.0.0-10.255.255.255</ip_range> <value>internal</value><semicolon>;</semicolon>
    <ip_range>192.168.0.0-192.168.255.255</ip_range> <value>lan</value><semicolon>;</semicolon>
<brace>}</brace>

<comment># Upstream with IP addresses and ports</comment>
<identifier>upstream</identifier> <value>backend</value> <brace>{</brace>
    <identifier>server</identifier> <ip_address>192.168.1.10:8080</ip_address><semicolon>;</semicolon>
    <identifier>server</identifier> <ip_address>192.168.1.11:8080</ip_address><semicolon>;</semicolon>
    <identifier>server</identifier> <ip_address>[2001:db8::1]:9000</ip_address><semicolon>;</semicolon>
<brace>}</brace>

<comment># Main server configuration</comment>
<identifier>server</identifier> <brace>{</brace>
    <comment># Listen directives with port numbers</comment>
    <identifier>listen</identifier> <ip_address>192.168.1.100:443</ip_address> <value>ssl</value> <value>http2</value><semicolon>;</semicolon>
    <identifier>listen</identifier> <number>80</number><semicolon>;</semicolon>
    <identifier>server_name</identifier> <value>example.com</value> <value>www.example.com</value><semicolon>;</semicolon>

    <comment># Timeouts and sizes with units</comment>
    <identifier>client_body_timeout</identifier> <number_duration>60s</number_duration><semicolon>;</semicolon>
    <identifier>client_max_body_size</identifier> <number_size>10M</number_size><semicolon>;</semicolon>
    <identifier>keepalive_timeout</identifier> <number_duration>75s</number_duration><semicolon>;</semicolon>
    <identifier>proxy_connect_timeout</identifier> <number_duration>90s</number_duration><semicolon>;</semicolon>
    <identifier>proxy_read_timeout</identifier> <number_duration>3m</number_duration><semicolon>;</semicolon>
    <identifier>send_timeout</identifier> <number_duration>2m</number_duration><semicolon>;</semicolon>

    <comment># Buffer sizes</comment>
    <identifier>proxy_buffer_size</identifier> <number_size>4k</number_size><semicolon>;</semicolon>
    <identifier>proxy_buffers</identifier> <number>8</number> <number_size>8k</number_size><semicolon>;</semicolon>
    <identifier>client_body_buffer_size</identifier> <number_size>128k</number_size><semicolon>;</semicolon>

    <comment># SSL configuration</comment>
    <identifier>ssl_certificate</identifier> <string>'/etc/ssl/certs/cert.pem'</string><semicolon>;</semicolon>
    <identifier>ssl_session_timeout</identifier> <number_duration>1d</number_duration><semicolon>;</semicolon>
    <identifier>ssl_session_cache</identifier> <value>shared:SSL:10M</value><semicolon>;</semicolon>

    <comment># Numeric rate limiting</comment>
    <identifier>limit_rate</identifier> <number_size>500k</number_size><semicolon>;</semicolon>
    <identifier>limit_rate_after</identifier> <number_size>5M</number_size><semicolon>;</semicolon>

    <comment># Conditional redirect</comment>
    <if>if</if> <paren>(</paren><variable>${'$'}scheme</variable> <operator>!=</operator> <string>"https"</string><paren>)</paren> <brace>{</brace>
        <return>return</return> <number>301</number> <value>https://</value><variable>${'$'}server_name</variable><variable>${'$'}request_uri</variable><semicolon>;</semicolon>
    <brace>}</brace>

    <comment># Location block with Lua</comment>
    <identifier>location</identifier> <value>/api</value> <brace>{</brace>
        <comment># Lua block directive</comment>
        <lua_block>content_by_lua_block</lua_block> <brace>{</brace>
            ngx.say("Hello from Lua")
            ngx.log(ngx.INFO, "Request: " .. ngx.var.request_uri)
        <brace>}</brace>
    <brace>}</brace>

    <comment># Location with numbers and IP access control</comment>
    <identifier>location</identifier> <value>/api</value> <brace>{</brace>
        <identifier>allow</identifier> <ip_address>192.168.1.0/24</ip_address><semicolon>;</semicolon>
        <identifier>allow</identifier> <ip_address>10.0.0.0/8</ip_address><semicolon>;</semicolon>
        <identifier>deny</identifier> <value>all</value><semicolon>;</semicolon>

        <comment># Return codes</comment>
        <if>if</if> <paren>(</paren><operator>!-f</operator> <variable>${'$'}request_filename</variable><paren>)</paren> <brace>{</brace>
            <return>return</return> <number>404</number><semicolon>;</semicolon>
        <brace>}</brace>
    <brace>}</brace>
<brace>}</brace>
""".trimIndent()
    }
}
