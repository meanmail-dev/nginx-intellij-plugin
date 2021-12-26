package dev.meanmail.codeInsight.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.util.findParentOfType
import com.intellij.util.ProcessingContext
import dev.meanmail.codeInsight.completion.directives.Directive
import dev.meanmail.codeInsight.completion.directives.any
import dev.meanmail.codeInsight.completion.directives.all
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
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        val parents = mutableListOf<String?>()
        var parent = parameters.originalPosition
            ?.parent?.findParentOfType<DirectiveStmt>()
        while (parent != null) {
            parents.add(parent.name)
            parent = parent.findParentOfType()
        }
        val directives: Set<Directive>
        if (parents.isEmpty()) {
            directives = all.children
        } else {
            var directive: Directive? = all
            for (parent_name in parents.reversed()) {
                directive = directive?.findChildByName(parent_name) ?: break
            }
            directives = (directive?.children ?: setOf()) + any.children
        }

        for (name in directives.map { it.name }) {
            result.addElement(LookupElementBuilder.create(name))
        }
    }
}
