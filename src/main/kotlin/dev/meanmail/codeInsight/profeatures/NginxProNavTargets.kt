package dev.meanmail.codeInsight.profeatures

import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import dev.meanmail.psi.RegularDirectiveStmt
import dev.meanmail.psi.Types
import dev.meanmail.psi.ValueStmt

/**
 * Detects the symbols that the free plugin cannot navigate but Nginx Pro can:
 * variables (`$uri`) and upstream references (`proxy_pass http://backend`).
 *
 * Shared by the navigation, rename and find-usages upsell triggers so they all
 * agree on what counts as a high-intent "Pro wall" — and so the detection logic
 * is unit-testable in one place. The free plugin already resolves include file
 * paths, so those are intentionally NOT matched here.
 */
object NginxProNavTargets {

    private val PASS_DIRECTIVES = setOf(
        "proxy_pass",
        "fastcgi_pass",
        "uwsgi_pass",
        "scgi_pass",
        "grpc_pass",
        "memcached_pass"
    )

    fun isVariable(element: PsiElement?): Boolean {
        return element?.node?.elementType == Types.VARIABLE
    }

    fun isUpstreamReference(element: PsiElement?): Boolean {
        if (element == null) return false
        val directive = PsiTreeUtil.getParentOfType(element, RegularDirectiveStmt::class.java) ?: return false
        if (directive.nameStmt.text !in PASS_DIRECTIVES) return false
        val valueStmt = PsiTreeUtil.getParentOfType(element, ValueStmt::class.java, false) ?: return false
        if (valueStmt !in directive.valueStmtList) return false
        return extractUpstreamName(valueStmt.text) != null
    }

    fun isNavigableProSymbol(element: PsiElement?): Boolean {
        return isVariable(element) || isUpstreamReference(element)
    }

    /**
     * Returns the upstream name a pass-directive value points at, or null when the
     * value is a plain address that has no upstream to navigate to (IP, localhost,
     * a dotted domain, or a unix socket). Mirrors the Pro resolver's heuristic so
     * the upsell only fires on genuine upstream references.
     */
    fun extractUpstreamName(value: String): String? {
        val trimmed = value.trim()
        if (trimmed.startsWith("unix:")) return null

        val withoutScheme = when {
            trimmed.startsWith("http://") -> trimmed.removePrefix("http://")
            trimmed.startsWith("https://") -> trimmed.removePrefix("https://")
            trimmed.startsWith("grpc://") -> trimmed.removePrefix("grpc://")
            trimmed.startsWith("grpcs://") -> trimmed.removePrefix("grpcs://")
            else -> trimmed
        }

        val host = withoutScheme.takeWhile { it !in setOf(':', '/', '?', '#', '$') }

        if (host.isEmpty()) return null
        if (host == "localhost") return null
        if (host.startsWith("[") || host.contains("::")) return null
        if (host.matches(Regex("""^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$"""))) return null
        // Upstream names don't contain dots; dotted hosts are domains.
        if (host.contains('.')) return null

        return host
    }
}
