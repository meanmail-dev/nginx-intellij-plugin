package dev.meanmail

import com.intellij.lexer.FlexAdapter
import dev.meanmail.NginxLexer

import java.io.Reader

class NginxLexerAdapter : FlexAdapter(NginxLexer(null as Reader?))
