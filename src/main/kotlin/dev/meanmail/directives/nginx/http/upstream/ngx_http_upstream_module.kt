package dev.meanmail.directives.nginx.http.upstream

import dev.meanmail.directives.*
import dev.meanmail.directives.nginx.http.http

// https://nginx.org/en/docs/http/ngx_http_upstream_module.html

val ngx_http_upstream_module = NginxModule(
    name = "ngx_http_upstream_module",
    description = """
        The ngx_http_upstream_module module is used to define groups of servers that can be referenced by:
        - proxy_pass
        - fastcgi_pass
        - uwsgi_pass
        - scgi_pass
        - memcached_pass
        - grpc_pass
        
        Key features:
        - Load balancing (round-robin, least connections, IP hash)
        - Server weights and connection limits
        - Health checks and failover
        - Keepalive connections
        - Dynamic reconfiguration (commercial subscription)
        - DNS resolution and service discovery
    """.trimIndent(),
    enabled = true
)

val upstream = Directive(
    name = "upstream",
    description = """
        Defines a group of servers that can be referenced by their defined name.
        Servers can listen on different ports and mix TCP and UNIX-domain sockets.
        
        By default, requests are distributed between servers using weighted round-robin balancing.
        
        Example:
        upstream backend {
            server backend1.example.com weight=5;
            server 127.0.0.1:8080 max_fails=3 fail_timeout=30s;
            server unix:/tmp/backend3;
            server backup1.example.com backup;
        }
    """.trimIndent(),
    parameters = listOf(
        DirectiveParameter(
            name = "name",
            description = "Name of the upstream group",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(http),
    module = ngx_http_upstream_module
)

val upstreamServer = Directive(
    name = "server",
    description = """
        Defines address and parameters of a server in an upstream group.
        The address can be:
        - Domain name or IP address with optional port (default: 80)
        - UNIX-domain socket path with "unix:" prefix
        
        A domain name resolving to multiple IPs defines multiple servers at once.
        
        Commercial subscription features:
        - resolve: monitors changes of IP addresses for domain names
        - service: enables DNS SRV records resolution
        - slow_start: gradually recovers server weight
        - drain: puts server in "draining" mode
    """.trimIndent(),
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            description = "Server address (domain:port, IP:port, unix:path)",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "weight",
            description = "Server weight for load balancing (default: 1)",
            valueType = ValueType.INTEGER,
            required = false,
            defaultValue = "1"
        ),
        DirectiveParameter(
            name = "max_conns",
            description = "Limit of maximum number of simultaneous active connections (default: 0 - no limit)",
            valueType = ValueType.INTEGER,
            required = false,
            defaultValue = "0"
        ),
        DirectiveParameter(
            name = "max_fails",
            description = "Number of unsuccessful attempts before marking server as unavailable (default: 1, 0 disables)",
            valueType = ValueType.INTEGER,
            required = false,
            defaultValue = "1"
        ),
        DirectiveParameter(
            name = "fail_timeout",
            description = "Time to mark server unavailable and duration server stays unavailable",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "10s"
        ),
        DirectiveParameter(
            name = "backup",
            description = "Marks the server as a backup server. Used when primary servers are unavailable.",
            valueType = ValueType.BOOLEAN,
            required = false
        ),
        DirectiveParameter(
            name = "down",
            description = "Marks the server as permanently unavailable",
            valueType = ValueType.BOOLEAN,
            required = false
        ),
        DirectiveParameter(
            name = "resolve",
            description = "Monitors changes of the IP addresses that correspond to a domain name (commercial subscription)",
            valueType = ValueType.BOOLEAN,
            required = false
        ),
        DirectiveParameter(
            name = "service",
            description = "Enables DNS SRV records resolution and sets the service name (commercial subscription)",
            valueType = ValueType.STRING,
            required = false
        ),
        DirectiveParameter(
            name = "slow_start",
            description = "Time during which the server will recover its weight from zero (commercial subscription)",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "0"
        ),
        DirectiveParameter(
            name = "drain",
            description = "Puts the server into the 'draining' mode (commercial subscription)",
            valueType = ValueType.BOOLEAN,
            required = false
        )
    ),
    context = listOf(upstream),
    module = ngx_http_upstream_module
)

val zone = Directive(
    name = "zone",
    description = """
        Defines shared memory zone for storing upstream group configuration and run-time state.
        Multiple groups may share the same zone.
        
        Required for:
        - Dynamic reconfiguration without restart
        - Health checks
        - DNS resolution updates
        
        Commercial subscription feature.
    """.trimIndent(),
    parameters = listOf(
        DirectiveParameter(
            name = "name",
            description = "Name of the shared memory zone",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "size",
            description = "Size of the shared memory zone",
            valueType = ValueType.SIZE,
            required = false
        )
    ),
    context = listOf(upstream),
    module = ngx_http_upstream_module
)

val hash = Directive(
    name = "hash",
    description = """
        Specifies load balancing method based on hashed key value.
        The key can contain text, variables, and their combinations.
        
        With 'consistent' parameter uses ketama consistent hashing method, 
        which ensures only few keys are remapped when servers are added or removed.
    """.trimIndent(),
    parameters = listOf(
        DirectiveParameter(
            name = "key",
            description = "Key for hashing (can include variables)",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "consistent",
            description = "Use consistent hashing (ketama) method",
            valueType = ValueType.BOOLEAN,
            required = false
        )
    ),
    context = listOf(upstream),
    module = ngx_http_upstream_module
)

val ip_hash = ToggleDirective(
    name = "ip_hash",
    description = """
        Specifies that a group should use IP-based load balancing.
        The first three octets of the client IPv4 address, or the entire IPv6 address,
        are used as a hashing key.
        
        Ensures requests from the same client will always be passed to the same server
        except when this server is unavailable.
        
        To temporarily remove a server while preserving the client IP mapping,
        mark it with the 'down' parameter.
    """.trimIndent(),
    context = listOf(upstream),
    module = ngx_http_upstream_module,
    enabled = true
)

val keepalive = Directive(
    name = "keepalive",
    description = """
        Activates the cache for connections to upstream servers.
        The connections parameter sets the maximum number of idle keepalive 
        connections to upstream servers preserved in the cache of each worker process.
        
        Note: This does not limit the total number of connections to upstream servers.
        The number should be small enough to let upstream servers process new incoming connections.
    """.trimIndent(),
    parameters = listOf(
        DirectiveParameter(
            name = "connections",
            description = "Maximum number of idle keepalive connections per worker",
            valueType = ValueType.INTEGER,
            required = true
        )
    ),
    context = listOf(upstream),
    module = ngx_http_upstream_module
)

val least_conn = ToggleDirective(
    name = "least_conn",
    description = """
        Specifies that a group should use least-connections load balancing algorithm.
        Passes request to the server with the least number of active connections,
        considering weights of servers.
    """.trimIndent(),
    context = listOf(upstream),
    module = ngx_http_upstream_module,
    enabled = true
)

val least_time = Directive(
    name = "least_time",
    description = """
        Specifies that a group should use least-time load balancing algorithm.
        Passes request to the server with the least average response time and least number
        of active connections, considering weights of servers.
        
        Commercial subscription feature.
    """.trimIndent(),
    parameters = listOf(
        DirectiveParameter(
            name = "header",
            description = "Use time to receive response header",
            valueType = ValueType.BOOLEAN,
            required = false
        ),
        DirectiveParameter(
            name = "last_byte",
            description = "Use time to receive full response",
            valueType = ValueType.BOOLEAN,
            required = false
        )
    ),
    context = listOf(upstream),
    module = ngx_http_upstream_module
)

val ntlm = Directive(
    name = "ntlm",
    description = "Enables NTLM authentication for upstream servers",
    parameters = emptyList(),
    context = listOf(upstream),
    module = ngx_http_upstream_module
)

val queue = Directive(
    name = "queue",
    description = "Defines a queue for upstream servers",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Size of the queue",
            valueType = ValueType.NUMBER,
            required = true
        ),
        DirectiveParameter(
            name = "timeout",
            description = "Timeout for the queue",
            valueType = ValueType.TIME,
            required = true
        )
    ),
    context = listOf(upstream),
    module = ngx_http_upstream_module
)

val random = Directive(
    name = "random",
    description = "Enables random load balancing",
    parameters = listOf(
        DirectiveParameter(
            name = "index",
            description = "Index of the random server",
            valueType = ValueType.NUMBER,
            required = true
        )
    ),
    context = listOf(upstream),
    module = ngx_http_upstream_module
)

val state = Directive(
    name = "state",
    description = "Defines the state of an upstream server",
    parameters = listOf(
        DirectiveParameter(
            name = "file",
            description = "Path to the state file",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(upstream),
    module = ngx_http_upstream_module
)

val sticky = Directive(
    name = "sticky",
    description = "Enables sticky sessions for upstream servers",
    parameters = listOf(
        DirectiveParameter(
            name = "cookie",
            description = "Name of the sticky cookie",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(upstream),
    module = ngx_http_upstream_module
)

val stickyCookieInsert = Directive(
    name = "sticky_cookie_insert",
    description = "Inserts a sticky cookie for upstream servers",
    parameters = listOf(
        DirectiveParameter(
            name = "cookie",
            description = "Name of the sticky cookie",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(upstream),
    module = ngx_http_upstream_module
)

val upstreamKeepaliveRequests = Directive(
    name = "keepalive_requests",
    description = "Sets the number of requests to send over a keepalive connection",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Number of requests",
            valueType = ValueType.NUMBER,
            required = true
        )
    ),
    context = listOf(upstream),
    module = ngx_http_upstream_module
)

val upstreamKeepaliveTime = Directive(
    name = "keepalive_time",
    description = "Sets the keepalive timeout",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            description = "Timeout value",
            valueType = ValueType.TIME,
            required = true
        )
    ),
    context = listOf(upstream),
    module = ngx_http_upstream_module
)

val upstreamKeepaliveTimeout = Directive(
    name = "keepalive_timeout",
    description = "Sets the keepalive timeout",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            description = "Timeout value",
            valueType = ValueType.TIME,
            required = true
        )
    ),
    context = listOf(upstream),
    module = ngx_http_upstream_module
)

val upstreamResolver = Directive(
    name = "resolver",
    description = "Defines a resolver for upstream servers",
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            description = "IP address or hostname of the resolver",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(upstream),
    module = ngx_http_upstream_module
)

val upstreamResolverTimeout = Directive(
    name = "resolver_timeout",
    description = "Sets the timeout for the resolver",
    parameters = listOf(
        DirectiveParameter(
            name = "time",
            description = "Timeout value",
            valueType = ValueType.TIME,
            required = true
        )
    ),
    context = listOf(upstream),
    module = ngx_http_upstream_module
)

val upstreamServerResolve = Directive(
    name = "resolver",
    description = """
        Configures name servers used to resolve names of upstream servers into addresses.
        For example:
        
        resolver 127.0.0.1 [::1]:5353;
        resolver 127.0.0.1 valid=30s;
        
        The following parameters can be specified:
        - valid: duration of caching a positive response (30s by default)
        - ipv6: use IPv6 addresses if available (on by default)
        - ipv4: use IPv4 addresses if available (on by default)
        - status_zone: enables collection of DNS server statistics
    """.trimIndent(),
    parameters = listOf(
        DirectiveParameter(
            name = "address",
            description = "Name server address with optional port (default: 53)",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "valid",
            description = "Duration of caching a positive response",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "30s"
        )
    ),
    context = listOf(upstream),
    module = ngx_http_upstream_module
)

val upstreamServerResolverTimeout = Directive(
    name = "resolver_timeout",
    description = """
        Sets a timeout for name resolution.
        
        Example:
        resolver_timeout 5s;
    """.trimIndent(),
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Timeout for name resolution",
            valueType = ValueType.TIME,
            required = true
        )
    ),
    context = listOf(upstream),
    module = ngx_http_upstream_module
)
