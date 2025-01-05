package dev.meanmail

import com.intellij.lexer.FlexAdapter

import java.io.Reader

class NginxLexerAdapter : FlexAdapter(NginxLexer(null as Reader?))
