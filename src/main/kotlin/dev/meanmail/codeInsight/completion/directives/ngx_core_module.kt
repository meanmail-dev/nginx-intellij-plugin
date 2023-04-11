package dev.meanmail.codeInsight.completion.directives

// https://nginx.org/en/docs/ngx_core_module.html

val acceptMutex = ToggleDirective("accept_mutex", false)
val acceptMutexDelay = Directive(
    "accept_mutex_delay",
    defaultValue = "500ms"
)
val daemon = ToggleDirective("daemon", true)
val debugConnection = Directive("debug_connection")
val debugPoints = Directive(
    "debug_points",
    setOf("abort", "stop")
)
val env = Directive(
    "env",
    defaultValue = "TZ"
)
val errorLog = Directive(
    "error_log",
    defaultValue = "logs/error.log error"
)
val include = Directive("include")
val loadModule = Directive("load_module")
val lockFile = Directive(
    "lock_file",
    defaultValue = "logs/nginx.lock"
)
val masterProcess = ToggleDirective("master_process", true)
val multiAccept = ToggleDirective("multi_accept", false)
val pcreJit = ToggleDirective("pcre_jit", false)
val pid = Directive(
    "pid",
    defaultValue = "logs/nginx.pid"
)
val sslEngine = Directive("ssl_engine")
val threadPool = Directive(
    "thread_pool",
    defaultValue = "default threads=32 max_queue=65536"
)
val timerResolution = Directive("timer_resolution")
val use = Directive("use")
val user = Directive(
    "user",
    defaultValue = "nobody nobody"
)
val workerAioRequests = Directive(
    "worker_aio_requests",
    defaultValue = "32"
)
val workerConnections = Directive(
    "worker_connections",
    defaultValue = "512"
)
val workerCpuAffinity = Directive("worker_cpu_affinity")
val workerPriority = Directive(
    "worker_priority",
    defaultValue = "0"
)
val workerProcesses = Directive(
    "worker_processes",
    defaultValue = "1"
)
val workerRlimitCore = Directive("worker_rlimit_core")
val workerRlimitNofile = Directive("worker_rlimit_nofile")
val workerShutdownTimeout = Directive("worker_shutdown_timeout")
val workingDirectory = Directive("working_directory")
val events = Directive(
    "events",
    children = setOf(
        acceptMutex,
        acceptMutexDelay,
        debugConnection,
        multiAccept,
        use,
        workerAioRequests,
        workerConnections,
    )
)

val ngx_core_module = Module(
    "ngx_core_module.kt",
    enabled = true,
    directives = setOf(
        acceptMutex,
        acceptMutexDelay,
        daemon,
        debugConnection,
        debugPoints,
        env,
        errorLog,
        events,
        include,
        loadModule,
        lockFile,
        masterProcess,
        multiAccept,
        pcreJit,
        pid,
        sslEngine,
        threadPool,
        timerResolution,
        use,
        user,
        workerAioRequests,
        workerConnections,
        workerCpuAffinity,
        workerPriority,
        workerProcesses,
        workerRlimitCore,
        workerRlimitNofile,
        workerShutdownTimeout,
        workingDirectory,
    )
)
