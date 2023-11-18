package com.github.ryosk.mpplplugin.language

import com.github.ryosk.mpplplugin.language.psi.MpplTypes
import com.github.ryosk.mpplplugin.language.psi.MpplVariableName
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PlatformPatterns.*
import com.intellij.psi.*
import com.intellij.util.ProcessingContext

class MpplReferenceContributor : PsiReferenceContributor() {

    companion object {
        private val LOG = Logger.getInstance(this::class.java)
    }

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            psiElement(),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    if ((element as MpplVariableName).name == null)
                        return PsiReference.EMPTY_ARRAY
                    val textRange = TextRange(0, element.name!!.length)
                    return arrayOf(MpplReference(element, textRange)    )
                }
            })
    }
}