package com.github.ryosk.mpplplugin.language

import com.github.ryosk.mpplplugin.language.psi.MpplVariableName
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil

object MpplUtil {
    private val LOG = Logger.getInstance(this::class.java)

    fun findVariableNameList(project: Project, name: String? = null): List<MpplVariableName> {
        val result = mutableListOf<MpplVariableName>()
        val virtualFiles = FileTypeIndex.getFiles(
            MpplFileType.INSTANCE, GlobalSearchScope.allScope(project)
        )
        virtualFiles.forEach { virtualFile ->
            val variableNameList = PsiManager.getInstance(project).findFile(virtualFile)?.let { mpplFile ->
                PsiTreeUtil.getChildrenOfType(
                    mpplFile, MpplVariableName::class.java
                )
            }
            if (name == null) {
                variableNameList?.let { result.addAll(it) }
            } else {
                variableNameList?.filter { it.name == name }?.let { result.addAll(it) }
            }
        }
        LOG.warn("$result")
        return result
    }
}