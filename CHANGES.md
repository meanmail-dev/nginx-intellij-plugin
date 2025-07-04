## 2025.14 (July, 4, 2025)

* added some new contexts to directives (Thanks @atwupack)
  - `js_import`
  - `js_path`
  - `js_preload_object`

## 2025.13 (June, 8, 2025)

* Add support for new directives:
  - `grpc_ssl_certificate_cache`
  - `keepalive_min_timeout`
  - `proxy_ssl_certificate_cache`
  - `ssl_certificate_cache`
  - `ssl_object_cache_inheritable`
  - `uwsgi_ssl_certificate_cache`

## 2025.11 (June, 6, 2025)

* Fix `pcre_jit` directive context
* Fix `google_perftools_profiles` directive context
* Support for external directives is only in Pro version

## 2025.10 (May, 31, 2025)

* Improved handling of the `if` directive in the rewrite module
* Simplified the `break` directive by removing unnecessary parameters

## 2025.9 (May, 28, 2025)

* Fix recursive include directive processing
* Update dependencies

## 2025.8 (April, 20, 2025)

* Add suport directives:
    - proxy_cookie_domain
    - proxy_cookie_flags
    - proxy_cookie_path
    - proxy_ignore_client_abort
    - proxy_ssl_certificate_cache
    - proxy_ssl_key_log

## 2025.7 (April, 6, 2025)

* Add error reporting

## 2025.6 (March, 22, 2025)

* A dark theme for file icons
* Allow set directive parameters in if block

## 2025.5.1 (March, 16, 2025)

* Support JetBrains IDE 2025.*

## 2025.5 (March, 16, 2025)

* Add support for directives:
    - `js_context_reuse`
    - `js_engine`
    - `js_fetch_buffer_size`
    - `js_fetch_max_response_buffer_size`
    - `js_fetch_timeout`
    - `js_fetch_verify`
    - `js_periodic`
    - `js_preload_object`
    - `js_shared_dict_zone`

## 2024.5 (December, 3, 2024)

* Enhanced directive support:
    - Full support for map directive configuration and validation
    - Improved autocompletion for map parameters
    - Added validation for map block values
    - Support for include files within map blocks
    - Added new inspection for validating Nginx directive values
* Added new features:
    - Full support for Lua blocks in configuration
    - Enhanced SSL configuration handling
    - Added support for geo blocks for geolocation
    - Expanded support for conditional expressions (if)
* Editor improvements:
    - Enhanced syntax highlighting for strings, braces, and values
    - Special highlighting for Lua code blocks
    - Smarter autocompletion for all directives
    - Enhanced configuration file navigation
    - More precise syntax validation
    - Better support for nested blocks
    - Improved handling of folding for blocks
* Bug fixes:
    - Fixed location blocks processing
    - Improved directive modifiers handling
    - Fixed parameter values processing
    - Fixed include directive paths resolution relative to nginx root directory
    - Fixed IDE error when trying to fold empty blocks
    - Prevented potential `IllegalArgumentException` in folding regions

## 2024.4 (November, 28, 2024)

* Full support for all Lua block directives in Nginx configuration parsing
* Added support for new Nginx 1.27.3 configuration syntax:
    - `resolve` parameter in `upstream` server directive
    - `resolver` and `resolver_timeout` directives in `upstream` block
    - New `proxy_pass_trailers` directive
* Security updates: Disabled TLSv1 and TLSv1.1 protocols by default across modules
    - Updated SSL/TLS protocols to TLSv1.2 and TLSv1.3 in:
        * HTTP JS module
        * Stream Proxy module
        * Stream Zone Sync module
        * SSL modules for HTTP, Stream, and Mail
* Fixed directive naming in SCGI module:
    - Corrected `scgiCacheLockAge` to `scgi_cache_lock_age`
* Enhanced IPv6 address handling in various directives
* Verified compatibility with Nginx 1.27.3
* Fixed lexer and syntax highlighting for Lua block directives with parameters
* Improved parsing of `set_by_lua_block` and similar Lua directives

## 2024.3 (May, 30, 2024)

* Add `ngx_stream_pass_module` to directives

## 2024.2 (May, 28, 2024)

* Update icon
* Support `ssl_certificate_by_lua_block` and `set_by_lua_block` (needs any Lua Language plugin)

## 2024.1 ( May, 26, 2024)

* Update dependencies

## 2022.1 (October, 9, 2022)

* Update dependencies

## 2021.3 (December, 5, 2021)

+ Support access_by_lua_block, content_by_lua_block, rewrite_by_lua_block (needs any Lua Language plugin)

## 2021.2 (May, 3, 2021)

+ Support include directive

## 2021.1 (April, 11, 2021)

+ Support a block folding

* Better strings handling (@Athorcis)

## 2020.2.1 (December, 8, 2020)

+ Support nginx file extension

* Update file icon

## 2020.2 (December, 6, 2020)

+ Comment with Line Comment action
+ Structure view

## 2020.1 (November, 27, 2020)

First release
