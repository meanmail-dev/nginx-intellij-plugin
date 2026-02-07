package dev.meanmail.codeInsight.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.util.findParentOfType
import com.intellij.util.ProcessingContext
import dev.meanmail.directives.catalog.Directive
import dev.meanmail.directives.catalog.findDirectives
import dev.meanmail.psi.DirectiveStmt
import dev.meanmail.psi.NameStmt

class NginxCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement().withParent(NameStmt::class.java),
            DirectiveNameCompletionProvider()
        )

    }
}

class DirectiveNameCompletionProvider : CompletionProvider<CompletionParameters>() {
    private val directiveCache = mutableMapOf<String?, List<Directive>>()

    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        val contextStmt = parameters.originalPosition
            ?.parent?.findParentOfType<DirectiveStmt>()
        var parent = contextStmt?.findParentOfType<DirectiveStmt>()
        if (contextStmt != null) {
            val name = contextStmt.name
            val path = parent?.path
            if (name != null) {
                val directives = findDirectives(name, path)
                if (directives.isNotEmpty()) {
                    if (result.prefixMatcher.prefix == "") {
                        parent = contextStmt
                    }
                }
            }
        }
        val name = parent?.name

        val directives = directiveCache.getOrPut(name) {
            if (name == null || parent == null) {
                Directive.all
            } else {
                val directives = findDirectives(name, parent.path.subList(0, parent.path.size - 1))
                if (directives.isEmpty()) {
                    emptyList()
                } else {
                    directives.flatMap { it.children }
                }
            }
        }

        for (directive in directives) {
            val lookupElement = LookupElementBuilder
                .create(directive.name)
                .withTypeText(directive.description)
                .withPresentableText(directive.name)

            result.addElement(lookupElement)
        }
    }
}
