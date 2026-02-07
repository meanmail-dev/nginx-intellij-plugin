package dev.meanmail.directives

import com.intellij.psi.PsiFile
import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.any
import dev.meanmail.directives.catalog.self
import dev.meanmail.psi.DirectiveStmt

/**
 * Determines the file-level nginx context by analyzing top-level directives.
 *
 * Resolves sentinel contexts (`any`, `self`) and progressively narrows
 * the context set via intersection. Incompatible directives are skipped
 * to achieve maximum narrowing without collapsing to an empty set.
 *
 * @return the narrowed context set, or `null` if no context could be inferred.
 */
fun determineFileContext(file: PsiFile): Set<Directive>? {
    val directives = file.children
        .filterIsInstance<DirectiveStmt>()

    var context: MutableSet<Directive>? = null
    for (directive in directives) {
        val matchingDirectives = Directive.all.filter { it.name == directive.name }
        if (matchingDirectives.isEmpty()) {
            continue
        }

        // Resolve sentinels: `any` is useless for narrowing, `self` means the directive itself
        val resolvedContext = matchingDirectives
            .flatMap { matched ->
                matched.context.flatMap { ctx ->
                    when (ctx) {
                        any -> emptyList()
                        self -> listOf(matched)
                        else -> listOf(ctx)
                    }
                }
            }
            .toSet()

        // Skip directives whose context resolved to nothing (e.g. `include`)
        if (resolvedContext.isEmpty()) {
            continue
        }

        if (context == null) {
            context = resolvedContext.toMutableSet()
            continue
        }

        // Narrow the context; skip this directive if it conflicts
        // to get the tightest possible context from compatible directives
        val narrowed = context.intersect(resolvedContext)
        if (narrowed.isNotEmpty()) {
            context = narrowed.toMutableSet()
        }
    }

    return context
}
