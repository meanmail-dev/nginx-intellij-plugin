package dev.meanmail.psi

import com.intellij.psi.tree.IElementType
import dev.meanmail.NginxLanguage
import org.jetbrains.annotations.NonNls


class NginxElementType(@NonNls debugName: String) :
        IElementType(debugName, NginxLanguage)
