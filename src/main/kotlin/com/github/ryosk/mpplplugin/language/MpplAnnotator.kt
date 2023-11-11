package com.github.ryosk.mpplplugin.language

import com.github.ryosk.mpplplugin.language.psi.MpplTypes
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.util.elementType

class MpplAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is LeafPsiElement) return
        val elementType = element.elementType
        if (elementType != MpplTypes.NAME) return
        val parent = element.parent
        val color = when (parent.elementType) {
            MpplTypes.VARIABLE_NAME -> DefaultLanguageHighlighterColors.INSTANCE_FIELD
            MpplTypes.PROCEDURE_NAME ->
                when (parent.parent.elementType) {
                    MpplTypes.CALL_STATEMENT -> DefaultLanguageHighlighterColors.FUNCTION_CALL
                    MpplTypes.SUBPROGRAM_DECLARATION -> DefaultLanguageHighlighterColors.FUNCTION_DECLARATION
                    else -> return
                }
            else -> return
        }
        holder
            .newSilentAnnotation(HighlightSeverity.INFORMATION)
            .textAttributes(color).create()
    }
}