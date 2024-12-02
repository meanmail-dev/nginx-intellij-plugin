package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/ngx_core_module.html

val ngx_core_module = NginxModule(
    "ngx_core_module",
    description = "Core module for Nginx",
    enabled = true
)

val events = Directive(
    name = "events",
    description = "Configures event processing parameters",
    parameters = listOf(
        DirectiveParameter(
            name = "worker_connections",
            description = "Sets the maximum number of connections per worker process",
            valueType = ValueType.INTEGER,
            required = false,
            defaultValue = "512"
        )
    ),
    context = listOf(main),
    module = ngx_core_module
)

val acceptMutex = ToggleDirective(
    "accept_mutex",
    "Enables or disables the mutex for serializing the accept() calls",
    false,
    context = listOf(events),
    module = ngx_core_module
)

val acceptMutexDelay = Directive(
    "accept_mutex_delay",
    description = "Defines the maximum time for waiting for a mutex",
    parameters = listOf(
        DirectiveParameter(
            name = "delay",
            description = "Maximum waiting time for mutex",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "500ms"
        )
    ),
    context = listOf(events),
    module = ngx_core_module
)

val daemon = ToggleDirective(
    "daemon",
    "Determines whether nginx will run in daemon mode",
    true,
    context = listOf(main),
    module = ngx_core_module
)

val debugConnection = Directive(
    name = "debug_connection",
    description = "Enables debug logging for specific client addresses",
    parameters = listOf(
        DirectiveParameter(
            valueType = ValueType.STRING,
            name = "address",
            description = "IP address or CIDR range"
        )
    ),
    context = listOf(events),
    module = ngx_core_module
)

val debugPoints = Directive(
    "debug_points",
    description = "Determines the debug points for error tracking",
    parameters = listOf(
        DirectiveParameter(
            name = "mode",
            description = "Debug point mode (abort, stop)",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "stop"
        )
    ),
    context = listOf(main),
    module = ngx_core_module
)

val env = Directive(
    name = "env",
    description = "Sets or modifies environment variables",
    parameters = listOf(
        DirectiveParameter(
            name = "variable",
            description = "Environment variable name or value",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(main),
    module = ngx_core_module
)

val errorLog = Directive(
    name = "error_log",
    description = "Configures error logging",
    parameters = listOf(
        DirectiveParameter(
            name = "file",
            valueType = ValueType.PATH,
            description = "Path to error log file"
        ),
        DirectiveParameter(
            name = "level",
            valueType = ValueType.ENUM,
            description = "Logging level",
            allowedValues = listOf("debug", "info", "notice", "warn", "error", "crit", "alert", "emerg"),
            required = false
        )
    ),
    context = listOf(main, http, mail, stream, server, location),
    module = ngx_core_module
)

val include = Directive(
    name = "include",
    description = "Includes additional configuration files",
    parameters = listOf(
        DirectiveParameter(
            name = "file",
            description = "Path to configuration file",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(any),
    module = ngx_core_module
)

val loadModule = Directive(
    "load_module",
    description = "Loads a dynamic module",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to dynamic module",
            valueType = ValueType.STRING,
            required = true
        )
    ),
    context = listOf(main),
    module = ngx_core_module
)

val lockFile = Directive(
    "lock_file",
    description = "Sets the path to the lock file",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to lock file",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "logs/nginx.lock"
        )
    ),
    context = listOf(main),
    module = ngx_core_module
)

val masterProcess = ToggleDirective(
    "master_process",
    "Enables or disables master process mode",
    true,
    context = listOf(main),
    module = ngx_core_module
)

val multiAccept = Directive(
    name = "multi_accept",
    description = "Enables or disables multiple connection handling",
    parameters = listOf(
        DirectiveParameter(
            valueType = ValueType.BOOLEAN,
            name = "state",
            description = "Multiple connection handling state",
            allowedValues = listOf("on", "off")
        )
    ),
    context = listOf(events),
    module = ngx_core_module
)

val pcreJit = Directive(
    name = "pcre_jit",
    description = "Enables or disables PCRE JIT compilation",
    parameters = listOf(
        DirectiveParameter(
            valueType = ValueType.BOOLEAN,
            name = "state",
            description = "PCRE JIT compilation state",
            allowedValues = listOf("on", "off")
        )
    ),
    context = listOf(events),
    module = ngx_core_module
)

val pid = Directive(
    "pid",
    description = "Specifies the path to the PID file",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to PID file",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "logs/nginx.pid"
        )
    ),
    context = listOf(main),
    module = ngx_core_module
)

val sslEngine = Directive(
    "ssl_engine",
    description = "Specifies SSL hardware device name",
    parameters = listOf(
        DirectiveParameter(
            valueType = ValueType.STRING,
            name = "device",
            description = "SSL hardware device name",
            required = true
        )
    ),
    context = listOf(main),
    module = ngx_core_module
)

val threadPool = Directive(
    "thread_pool",
    description = "Configures thread pool parameters",
    parameters = listOf(
        DirectiveParameter(
            name = "name",
            description = "Thread pool name",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "threads",
            description = "Number of threads",
            valueType = ValueType.INTEGER,
            required = false,
            defaultValue = "32"
        ),
        DirectiveParameter(
            name = "max_queue",
            description = "Maximum queue size",
            valueType = ValueType.INTEGER,
            required = false,
            defaultValue = "65536"
        )
    ),
    context = listOf(main),
    module = ngx_core_module
)

val timerResolution = Directive(
    "timer_resolution",
    description = "Configures timer resolution",
    parameters = listOf(
        DirectiveParameter(
            name = "resolution",
            description = "Timer resolution value",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "100ms"
        )
    ),
    context = listOf(main),
    module = ngx_core_module
)

val use = Directive(
    name = "use",
    description = "Specifies the event processing method",
    parameters = listOf(
        DirectiveParameter(
            valueType = ValueType.STRING,
            description = "Event processing method (epoll, kqueue, etc.)"
        )
    ),
    context = listOf(events),
    module = ngx_core_module
)

val user = Directive(
    "user",
    description = "Defines user and group credentials for worker processes",
    parameters = listOf(
        DirectiveParameter(
            name = "username",
            description = "Username for worker processes",
            valueType = ValueType.STRING,
            required = true
        ),
        DirectiveParameter(
            name = "group",
            description = "Group name for worker processes",
            valueType = ValueType.STRING,
            required = false
        )
    ),
    context = listOf(main),
    module = ngx_core_module
)

val workerAioRequests = Directive(
    name = "worker_aio_requests",
    description = "Sets the maximum number of asynchronous I/O operations",
    parameters = listOf(
        DirectiveParameter(
            valueType = ValueType.NUMBER
        )
    ),
    context = listOf(events),
    module = ngx_core_module
)

val workerConnections = Directive(
    name = "worker_connections",
    description = "Sets the maximum number of connections per worker process",
    parameters = listOf(
        DirectiveParameter(
            valueType = ValueType.NUMBER
        )
    ),
    context = listOf(events),
    module = ngx_core_module
)

val workerCPUAffinity = Directive(
    "worker_cpu_affinity",
    description = "Binds worker processes to specific CPUs",
    parameters = listOf(
        DirectiveParameter(
            name = "mask",
            description = "CPU mask for worker processes",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "auto"
        )
    ),
    context = listOf(main),
    module = ngx_core_module
)

val workerPriority = Directive(
    "worker_priority",
    description = "Sets worker process priority",
    parameters = listOf(
        DirectiveParameter(
            name = "priority",
            description = "Nice value for worker processes (-20 to 19)",
            valueType = ValueType.INTEGER,
            required = false,
            defaultValue = "0",
            minValue = -20,
            maxValue = 19
        )
    ),
    context = listOf(main),
    module = ngx_core_module
)

val workerProcesses = Directive(
    "worker_processes",
    description = "Defines the number of worker processes",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Number of worker processes (auto or positive integer)",
            valueType = ValueType.STRING,
            required = false,
            defaultValue = "auto",
            allowedValues = listOf("auto") + (1..32).map { it.toString() }
        )
    ),
    context = listOf(main),
    module = ngx_core_module
)

val workerRlimitCore = Directive(
    name = "worker_rlimit_core",
    description = "Sets the maximum size of core files for worker processes",
    parameters = listOf(
        DirectiveParameter(
            name = "size",
            description = "Maximum core file size (0 means unlimited)",
            valueType = ValueType.SIZE,
            required = false,
            defaultValue = "0",
            minValue = 0
        )
    ),
    context = listOf(main),
    module = ngx_core_module
)

val workerRlimitNofile = Directive(
    "worker_rlimit_nofile",
    description = "Sets the maximum number of open files for worker processes",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Maximum number of open files (1024-1048576)",
            valueType = ValueType.INTEGER,
            required = false,
            defaultValue = "1024",
            minValue = 1024,
            maxValue = 1048576
        )
    ),
    context = listOf(main),
    module = ngx_core_module
)

val workerRlimitSignPending = Directive(
    "worker_rlimit_sigpending",
    description = "Sets the maximum number of signals that can be queued for worker processes",
    parameters = listOf(
        DirectiveParameter(
            name = "number",
            description = "Maximum number of queued signals (1-1024)",
            valueType = ValueType.INTEGER,
            required = false,
            defaultValue = "32",
            minValue = 1,
            maxValue = 1024
        )
    ),
    context = listOf(main),
    module = ngx_core_module
)

val workerShutdownTimeout = Directive(
    "worker_shutdown_timeout",
    description = "Sets the timeout for worker process shutdown",
    parameters = listOf(
        DirectiveParameter(
            name = "timeout",
            description = "Shutdown timeout duration",
            valueType = ValueType.TIME,
            required = false,
            defaultValue = "10s"
        )
    ),
    context = listOf(main),
    module = ngx_core_module
)

val workingDirectory = Directive(
    name = "working_directory",
    description = "Configures the working directory for worker processes",
    parameters = listOf(
        DirectiveParameter(
            name = "path",
            description = "Path to the working directory (absolute path)",
            valueType = ValueType.PATH,
            required = false,
            defaultValue = "/var/tmp"
        )
    ),
    context = listOf(main),
    module = ngx_core_module
)
