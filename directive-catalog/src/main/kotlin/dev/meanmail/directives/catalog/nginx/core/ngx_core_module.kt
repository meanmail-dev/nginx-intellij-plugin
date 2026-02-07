package dev.meanmail.directives.catalog.nginx.core

import dev.meanmail.directives.catalog.*
import dev.meanmail.directives.catalog.nginx.http.http
import dev.meanmail.directives.catalog.nginx.http.location
import dev.meanmail.directives.catalog.nginx.http.server
import dev.meanmail.directives.catalog.nginx.mail.mail
import dev.meanmail.directives.catalog.nginx.stream.stream

// https://nginx.org/en/docs/ngx_core_module.html

val ngx_core_module = NginxModule(
    "ngx_core_module",
    description = "Core module for Nginx"
)

val events = Directive(
    name = "events",
    description = "Configures event processing parameters",
    context = listOf(main),
    module = ngx_core_module
)

val acceptMutex = Directive(
    "accept_mutex",
    "Enables or disables the mutex for serializing the accept() calls",
    context = listOf(events),
    module = ngx_core_module
)

val acceptMutexDelay = Directive(
    "accept_mutex_delay",
    description = "Defines the maximum time for waiting for a mutex",
    context = listOf(events),
    module = ngx_core_module
)

val daemon = Directive(
    "daemon",
    "Determines whether nginx will run in daemon mode",
    context = listOf(main),
    module = ngx_core_module
)

val debugConnection = Directive(
    name = "debug_connection",
    description = "Enables debug logging for specific client addresses",
    context = listOf(events),
    module = ngx_core_module
)

val debugPoints = Directive(
    "debug_points",
    description = "Determines the debug points for error tracking",
    context = listOf(main),
    module = ngx_core_module
)

val env = Directive(
    name = "env",
    description = "Sets or modifies environment variables",
    context = listOf(main),
    module = ngx_core_module
)

val errorLog = Directive(
    name = "error_log",
    description = "Configures error logging",
    context = listOf(main, http, mail, stream, server, location),
    module = ngx_core_module
)

val include = Directive(
    name = "include",
    description = "Includes additional configuration files",
    context = listOf(any),
    module = ngx_core_module
)

val loadModule = Directive(
    "load_module",
    description = "Loads a dynamic module",
    context = listOf(main),
    module = ngx_core_module
)

val lockFile = Directive(
    "lock_file",
    description = "Sets the path to the lock file",
    context = listOf(main),
    module = ngx_core_module
)

val masterProcess = Directive(
    "master_process",
    "Enables or disables master process mode",
    context = listOf(main),
    module = ngx_core_module
)

val multiAccept = Directive(
    name = "multi_accept",
    description = "Enables or disables multiple connection handling",
    context = listOf(events),
    module = ngx_core_module
)

val pcreJit = Directive(
    name = "pcre_jit",
    description = "Enables or disables PCRE JIT compilation",
    context = listOf(main),
    module = ngx_core_module
)

val pid = Directive(
    "pid",
    description = "Specifies the path to the PID file",
    context = listOf(main),
    module = ngx_core_module
)

val sslEngine = Directive(
    "ssl_engine",
    description = "Specifies SSL hardware device name",
    context = listOf(main),
    module = ngx_core_module
)

val sslObjectCacheInheritable = Directive(
    "ssl_object_cache_inheritable",
    "Enables or disables inheritable SSL object cache",
    context = listOf(main),
    module = ngx_core_module
)

val threadPool = Directive(
    "thread_pool",
    description = "Configures thread pool parameters",
    context = listOf(main),
    module = ngx_core_module
)

val timerResolution = Directive(
    "timer_resolution",
    description = "Configures timer resolution",
    context = listOf(main),
    module = ngx_core_module
)

val use = Directive(
    name = "use",
    description = "Specifies the event processing method",
    context = listOf(events),
    module = ngx_core_module
)

val user = Directive(
    "user",
    description = "Defines user and group credentials for worker processes",
    context = listOf(main),
    module = ngx_core_module
)

val workerAioRequests = Directive(
    name = "worker_aio_requests",
    description = "Sets the maximum number of asynchronous I/O operations",
    context = listOf(events),
    module = ngx_core_module
)

val workerConnections = Directive(
    name = "worker_connections",
    description = "Sets the maximum number of connections per worker process",
    context = listOf(events),
    module = ngx_core_module
)

val workerCPUAffinity = Directive(
    "worker_cpu_affinity",
    description = "Binds worker processes to specific CPUs",
    context = listOf(main),
    module = ngx_core_module
)

val workerPriority = Directive(
    "worker_priority",
    description = "Sets worker process priority",
    context = listOf(main),
    module = ngx_core_module
)

val workerProcesses = Directive(
    "worker_processes",
    description = "Defines the number of worker processes",
    context = listOf(main),
    module = ngx_core_module
)

val workerRlimitCore = Directive(
    name = "worker_rlimit_core",
    description = "Sets the maximum size of core files for worker processes",
    context = listOf(main),
    module = ngx_core_module
)

val workerRlimitNofile = Directive(
    "worker_rlimit_nofile",
    description = "Sets the maximum number of open files for worker processes",
    context = listOf(main),
    module = ngx_core_module
)

val workerRlimitSignPending = Directive(
    "worker_rlimit_sigpending",
    description = "Sets the maximum number of signals that can be queued for worker processes",
    context = listOf(main),
    module = ngx_core_module
)

val workerShutdownTimeout = Directive(
    "worker_shutdown_timeout",
    description = "Sets the timeout for worker process shutdown",
    context = listOf(main),
    module = ngx_core_module
)

val workingDirectory = Directive(
    name = "working_directory",
    description = "Configures the working directory for worker processes",
    context = listOf(main),
    module = ngx_core_module
)
