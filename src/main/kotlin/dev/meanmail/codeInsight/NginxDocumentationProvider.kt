package dev.meanmail.codeInsight

import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.openapi.application.ApplicationManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.util.PsiTreeUtil
import dev.meanmail.directives.catalog.findDirectives
import dev.meanmail.psi.DirectiveStmt

class NginxDocumentationProvider : AbstractDocumentationProvider() {
    companion object {
        private const val INSTALL_PRO_LINK_ID = "install_nginx_pro"
    }

    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        val directiveStmt = resolveDirectiveStmt(element, originalElement) ?: return null
        val name = directiveStmt.name ?: return null

        val directives = findDirectives(name)

        if (directives.isEmpty()) {
            return buildUnknownDirectiveDoc(name)
        }

        return buildKnownDirectiveDoc(name, directives)
    }

    private fun resolveDirectiveStmt(element: PsiElement?, originalElement: PsiElement?): DirectiveStmt? {
        if (element is DirectiveStmt) return element

        val fromOriginal = originalElement?.let {
            PsiTreeUtil.getParentOfType(it, DirectiveStmt::class.java)
        }
        if (fromOriginal != null) return fromOriginal

        return element?.let {
            PsiTreeUtil.getParentOfType(it, DirectiveStmt::class.java)
        }
    }

    override fun getDocumentationElementForLink(
        psiManager: PsiManager,
        link: String,
        context: PsiElement?
    ): PsiElement? {
        if (link == INSTALL_PRO_LINK_ID) {
            ApplicationManager.getApplication().invokeLater {
                NginxProPluginInstaller.openInstallDialog(context?.project)
            }
            return context
        }
        return super.getDocumentationElementForLink(psiManager, link, context)
    }

    private fun buildKnownDirectiveDoc(
        name: String,
        directives: List<dev.meanmail.directives.catalog.Directive>
    ): String {
        val sb = StringBuilder()
        sb.append("<div>")
        sb.append("<h2>$name</h2>")

        for (directive in directives) {
            sb.append("<p>${directive.description}</p>")
            sb.append("<p><b>Module:</b> ${directive.module.name}</p>")
            if (directive.context.isNotEmpty()) {
                sb.append("<p><b>Context:</b> ${directive.context.joinToString(", ") { it.name }}</p>")
            }
        }

        sb.append("<hr/>")
        sb.append("<p>Full documentation with examples is available in ")
        sb.append("<a href=\"psi_element://$INSTALL_PRO_LINK_ID\">")
        sb.append("Nginx Pro</a></p>")
        sb.append("</div>")

        return sb.toString()
    }

    private fun buildUnknownDirectiveDoc(name: String): String {
        val sb = StringBuilder()
        sb.append("<div>")
        sb.append("<h2>$name</h2>")
        sb.append("<p>This directive may be supported in ")
        sb.append("<a href=\"psi_element://$INSTALL_PRO_LINK_ID\">")
        sb.append("Nginx Pro</a></p>")
        sb.append("</div>")

        return sb.toString()
    }
}
