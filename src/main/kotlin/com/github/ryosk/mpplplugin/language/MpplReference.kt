package com.github.ryosk.mpplplugin.language

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.ResolveResult
import com.intellij.util.containers.toArray

class MpplReference(element: PsiElement, textRange: TextRange): PsiReferenceBase<PsiElement>(element, textRange), PsiPolyVariantReference {
    companion object {
        private val LOG = Logger.getInstance(this::class.java)
    }

    val name = element.text.substring(textRange.startOffset, textRange.endOffset)

    override fun resolve(): PsiElement? {
        return multiResolve(false).let {
            if (it.isNotEmpty()) it.first().element else null
        }
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val project = myElement.project
        val variableNameList = MpplUtil.findVariableNameList(project, name)
        val result = mutableListOf<ResolveResult>()
        result.addAll(
            variableNameList.map { PsiElementResolveResult(it) }
        )
        return result.toTypedArray()
    }

    override fun getVariants(): Array<Any> {
        val project = myElement.project
        val variableNameList = MpplUtil.findVariableNameList(project)
        return variableNameList.filter {
            it.name != null && it.name!!.isNotBlank()
        }.map {
            LookupElementBuilder.create(it).withTypeText(it.containingFile.name)
        }.toTypedArray()
    }
}