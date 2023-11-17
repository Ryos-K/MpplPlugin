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
                programLookUpElement(),
                varLookUpElement(),
                procedureLookUpElement(),
                beginEndLookUpElement(),
                ifThenLookUpElement(),
                ifThenElseLookUpElement(),
                whileLookUpElement(),
                arrayLookUpElement(),
                embeddedFunctionLookUpElement("read"),
                embeddedFunctionLookUpElement("readln"),
                embeddedFunctionLookUpElement("write"),
                embeddedFunctionLookUpElement("writeln"),
            )
        )

    }

    private fun programLookUpElement() = LookupElementBuilder
        .create("program")
        .withTailText(" ...")
        .withInsertHandler { context, item ->
            context.document.insertString(context.selectionEndOffset, " ;\nbegin\n end")
            EditorModificationUtil.moveCaretRelatively(context.editor, 1)
        }

    private fun varLookUpElement() = LookupElementBuilder
        .create("var")
        .withTailText(" ...")
        .withInsertHandler { context, item ->
            context.document.insertString(context.selectionEndOffset, " : ;")
            EditorModificationUtil.moveCaretRelatively(context.editor, 1)
        }


    private fun procedureLookUpElement() = LookupElementBuilder
        .create("procedure")
        .withTailText(" ...")
        .withInsertHandler { context, _ ->
            context.document.insertString(context.selectionEndOffset, " ;")
            EditorModificationUtil.moveCaretRelatively(context.editor, 1)
        }

    private fun beginEndLookUpElement() = LookupElementBuilder
        .create("begin")
        .withTailText(" ...")
        .withInsertHandler { context, _ ->
            context.document.insertString(context.selectionEndOffset, "  end")
            EditorModificationUtil.moveCaretRelatively(context.editor, 1)
        }

    private fun ifThenLookUpElement() = LookupElementBuilder
        .create("if")
        .withTailText(" ... then")
        .withInsertHandler { context, _ ->
            context.document.insertString(context.selectionEndOffset, "  then")
            EditorModificationUtil.moveCaretRelatively(context.editor, 1)
        }

    private fun ifThenElseLookUpElement() = LookupElementBuilder
        .create("if")
        .withTailText(" ... then ... else")
        .withInsertHandler { context, _ ->
            context.document.insertString(context.selectionEndOffset, "  then  else")
            EditorModificationUtil.moveCaretRelatively(context.editor, 1)
        }

    private fun whileLookUpElement() = LookupElementBuilder
        .create("while")
        .withTailText(" ... do")
        .withInsertHandler { context, _ ->
            context.document.insertString(context.selectionEndOffset, "  do")
            EditorModificationUtil.moveCaretRelatively(context.editor, 1)
        }

    private fun arrayLookUpElement() = LookupElementBuilder
        .create("array")
        .withTailText(" ...")
        .withInsertHandler { context, _ ->
            context.document.insertString(context.selectionEndOffset, " [] of ")
            EditorModificationUtil.moveCaretRelatively(context.editor, 1)
        }

    private fun embeddedFunctionLookUpElement(func: String) = LookupElementBuilder
        .create(func)
        .withTailText(" ...")
        .withInsertHandler { context, _ ->
            context.document.insertString(context.selectionEndOffset, "();")
            EditorModificationUtil.moveCaretRelatively(context.editor, 1)
        }

}

