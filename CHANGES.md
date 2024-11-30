## 2024.5 (December, 2, 2024)

* Add directive inspection
* Enhanced syntax highlighting:
    - Added proper highlighting for strings in quotes
    - Added highlighting for braces, values, and include targets
    - Added special highlighting for Lua code blocks
* Improved file navigation:
    - Fixed include directive paths resolution relative to nginx root directory
* Added new inspection for validating Nginx directive values
* Improved handling of folding for blocks with unbalanced or empty braces in `NginxFoldingBuilder`
* Bug fixes:
    - Fixed IDE error when trying to fold empty blocks
* Prevented potential `IllegalArgumentException` when creating folding regions for empty or malformed blocks

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
