# Nginx Configuration for JetBrains IDEs

<!--
Maintenance: verify feature claims against plugin.xml and shipped behavior. Do not add manually
maintained download, rating, star, or repository counts.
-->

[![JetBrains Marketplace rating](https://img.shields.io/jetbrains/plugin/r/stars/15461?label=Marketplace%20rating)](https://plugins.jetbrains.com/plugin/15461-nginx-configuration)
[![JetBrains Marketplace downloads](https://img.shields.io/jetbrains/plugin/d/15461)](https://plugins.jetbrains.com/plugin/15461-nginx-configuration)

Edit Nginx configuration files with IDE-native highlighting, completion, navigation, validation,
and structure view in IntelliJ IDEA, PyCharm, WebStorm, PhpStorm, GoLand, and other JetBrains IDEs.

[Install from JetBrains Marketplace](https://plugins.jetbrains.com/plugin/15461-nginx-configuration) ·
[Read the Nginx validation guide](https://meanmail.dev/posts/validate-nginx-configuration) ·
[Report an issue](https://github.com/meanmail-dev/Bug-Tracker/issues/new/choose)

## Features

- Syntax highlighting for directives, variables, strings, comments, and regular expressions
- Directive completion with basic context filtering
- Basic validation for unknown directives and common structural errors
- Navigation from `include` paths to referenced files
- Structure view for `server`, `location`, `upstream`, and other blocks
- Code folding for configuration blocks
- Recognition of `nginx.conf`, `mime.types`, `fastcgi_params`, `*.conf`, `*.nginx`, and related files
- Highlighting inside Lua block directives when a compatible Lua plugin is installed

Editor assistance catches mistakes while the configuration is still in context. It does not replace
testing the deployment-shaped configuration with `nginx -t` before a reload.

## Free and Pro editions

This repository contains the source for the free
[Nginx Configuration](https://plugins.jetbrains.com/plugin/15461-nginx-configuration) plugin.

[Nginx Configuration Pro](https://meanmail.dev/nginx-pro) adds deeper inspections and security
analysis, context-aware completion, cross-file navigation and refactoring, live templates, support
for custom and third-party directives, and IDE-managed `nginx -t` validation using a local Nginx
binary or a running Docker container.

## Support

- [Report a bug or request a feature](https://github.com/meanmail-dev/Bug-Tracker/issues/new/choose)
- [Ask a question in Discussions](https://github.com/meanmail-dev/Bug-Tracker/discussions)
- [Report a security vulnerability privately](https://github.com/meanmail-dev/Bug-Tracker/security/advisories/new)
- [Browse all meanmail.dev plugins](https://plugins.jetbrains.com/vendor/meanmail)
