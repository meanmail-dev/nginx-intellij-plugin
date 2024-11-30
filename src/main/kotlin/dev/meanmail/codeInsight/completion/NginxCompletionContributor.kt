package dev.meanmail.codeInsight.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.util.findParentOfType
import com.intellij.util.ProcessingContext
import dev.meanmail.codeInsight.completion.directives.Directive
import dev.meanmail.codeInsight.completion.directives.all
import dev.meanmail.codeInsight.completion.directives.determineFileContext
import dev.meanmail.codeInsight.completion.directives.findDirectives
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

        val directives = directiveCache.getOrPut(contextStmt?.name) {
            val file = parameters.originalPosition?.containingFile
            if (file == null) {
                all
            } else {
                val fileContext: Set<Directive>? = determineFileContext(file)
                if (fileContext == null) {
                    all
                } else {
                    val path = contextStmt?.path
                    val completion = mutableSetOf<Directive>()

                    for (directive in fileContext) {
                        completion.addAll(findDirectives(directive.name, path))
                    }
                    completion.toList()
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
