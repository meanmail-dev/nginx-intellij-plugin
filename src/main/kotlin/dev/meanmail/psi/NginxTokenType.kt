package dev.meanmail.psi


import com.intellij.psi.tree.IElementType
import dev.meanmail.NginxLanguage
import org.jetbrains.annotations.NonNls

class NginxTokenType(@NonNls debugName: String) :
    IElementType(debugName, NginxLanguage) {

    override fun toString(): String {
        return "NginxTokenType.${super.toString()}"
    }
}
