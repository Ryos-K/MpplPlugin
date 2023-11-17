package com.github.ryosk.mpplplugin.language.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.InsertHandler
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.ProcessingContext

class MpplKeywordCompletionProvider(
    private vararg val keywordLookUpElements: LookupElementBuilder,
) : CompletionProvider<CompletionParameters>() {

    constructor(
        insertHandler: InsertHandler<LookupElement>?,
        vararg keywords: String,
    ) : this(
        *keywords.map {
            LookupElementBuilder.create(it).withInsertHandler(insertHandler)
        }.toTypedArray()
    )

    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        keywordLookUpElements.forEach {
            result.addElement(it)
        }
    }
}