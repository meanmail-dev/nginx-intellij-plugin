package dev.meanmail.directives

import com.intellij.psi.PsiFile
import dev.meanmail.directives.catalog.Directive
import dev.meanmail.psi.DirectiveStmt

fun determineFileContext(file: PsiFile): Set<Directive>? {
    val directives = file.children
        .filterIsInstance<DirectiveStmt>()

    var context = mutableSetOf<Directive>()
    for (directive in directives) {
        val matchingDirectives = Directive.all.filter { it.name == directive.name }
        if (matchingDirectives.isEmpty()) {
            continue
        }
        val matchingDirectivesContext = matchingDirectives.flatMap { it.context }.toSet()
        if (context.isEmpty()) {
            context = matchingDirectivesContext.toMutableSet()
            continue
        }
        val newContext = context.intersect(matchingDirectivesContext)
        if (newContext.isEmpty()) {
            return context
        } else {
            context = newContext.toMutableSet()
        }
    }

    return null
}
