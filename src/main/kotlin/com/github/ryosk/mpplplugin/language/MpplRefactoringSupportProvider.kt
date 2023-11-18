package com.github.ryosk.mpplplugin.language

import com.github.ryosk.mpplplugin.language.psi.MpplNamedElement
import com.github.ryosk.mpplplugin.language.psi.MpplProcedureName
import com.github.ryosk.mpplplugin.language.psi.MpplVariableName
import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement
import com.intellij.refactoring.Refactoring

class MpplRefactoringSupportProvider: RefactoringSupportProvider() {
    override fun isMemberInplaceRenameAvailable(element: PsiElement, context: PsiElement?): Boolean {
        return element.firstChild is MpplNamedElement
    }
}