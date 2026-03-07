package dev.meanmail.psi

import com.intellij.psi.tree.ILazyParseableElementType
import dev.meanmail.NginxLanguage

class NginxLazyBlockElementType(debugName: String) :
    ILazyParseableElementType(debugName, NginxLanguage)
