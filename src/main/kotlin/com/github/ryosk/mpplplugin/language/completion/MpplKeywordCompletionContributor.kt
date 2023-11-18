package com.github.ryosk.mpplplugin.language.completion

import com.github.ryosk.mpplplugin.language.MpplLanguage
import com.github.ryosk.mpplplugin.language.psi.MpplTypes
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.editor.EditorModificationUtil
import com.intellij.patterns.PlatformPatterns.*

class MpplKeywordCompletionContributor : CompletionContributor() {
    private val insideMpplPattern = psiElement(MpplTypes.NAME).withLanguage(MpplLanguage.INSTANCE)

    init {
        extend(
            CompletionType.BASIC,
            insideMpplPattern,
            MpplKeywordCompletionProvider(
                AddSpaceInsertHandler.INSTANCE,
                "and",
                "div",
                "do",
                "else",
                "not",
                "of",
                "or",
                "then",
            )
        )
        extend(
            CompletionType.BASIC, insideMpplPattern, MpplKeywordCompletionProvider(
                null,
                "boolean",
                "char",
                "end",
                "false",
                "integer",
                "true",
            )

        )
        extend(
            CompletionType.BASIC, insideMpplPattern, MpplKeywordCompletionProvider(
                embeddedFunctionLookupElement("read"),
                embeddedFunctionLookupElement("readln"),
                embeddedFunctionLookupElement("write"),
                embeddedFunctionLookupElement("writeln"),
                callStatementLookupElement(),
                breakStatementLookupElement(),
                returnStatementLookupElement()
            )
        )

    }

    private fun embeddedFunctionLookupElement(func: String) = LookupElementBuilder
        .create(func)
        .withTailText(" ...")
        .withInsertHandler { ctx, _ ->
            ctx.document.insertString(ctx.selectionEndOffset, "();")
            EditorModificationUtil.moveCaretRelatively(ctx.editor, 1)
        }

    private fun callStatementLookupElement() = LookupElementBuilder
        .create("call")
        .withTailText(" ...;")
        .withInsertHandler { ctx, _ ->
            ctx.document.insertString(ctx.selectionEndOffset, " ;")
            EditorModificationUtil.moveCaretRelatively(ctx.editor, 1)
        }

    private fun breakStatementLookupElement() = LookupElementBuilder
        .create("break")
        .withTailText(";")
        .withInsertHandler { ctx, _ ->
            ctx.document.insertString(ctx.selectionEndOffset, ";")
            EditorModificationUtil.moveCaretRelatively(ctx.editor, 1)
        }

    private fun returnStatementLookupElement() = LookupElementBuilder
        .create("return")
        .withTailText(";")
        .withInsertHandler { ctx, _ ->
            ctx.document.insertString(ctx.selectionEndOffset, ";")
            EditorModificationUtil.moveCaretRelatively(ctx.editor, 1)
        }

}

