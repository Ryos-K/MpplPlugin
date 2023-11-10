package com.github.ryosk.mpplplugin.language.psi

import com.github.ryosk.mpplplugin.language.MpplFileType
import com.github.ryosk.mpplplugin.language.MpplLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class MpplFile(viewProvider: FileViewProvider): PsiFileBase(viewProvider, MpplLanguage.INSTANCE) {

    override fun getFileType(): FileType = MpplFileType.INSTANCE

    override fun toString(): String = "Mppl File"
}