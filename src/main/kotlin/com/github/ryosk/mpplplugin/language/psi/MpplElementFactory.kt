package com.github.ryosk.mpplplugin.language.psi

import com.github.ryosk.mpplplugin.language.MpplFileType
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil


object MpplElementFactory {

    private val LOG = Logger.getInstance(this::class.java)

    fun createName(project: Project, name: String): PsiElement? {
        val file: MpplFile = createFile(project, name)
        return file.firstChild
    }

    fun createFile(project: Project, text: String): MpplFile {
        val name = "dummy.mpl"
        return PsiFileFactory.getInstance(project).createFileFromText(name, MpplFileType.INSTANCE, text) as MpplFile
    }
}