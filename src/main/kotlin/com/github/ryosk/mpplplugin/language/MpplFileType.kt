package com.github.ryosk.mpplplugin.language

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class MpplFileType : LanguageFileType(MpplLanguage.INSTANCE) {

    companion object {
        val INSTANCE = MpplFileType()
    }
    override fun getName(): String = "Mppl File"

    override fun getDescription(): String = "Mppl language file"

    override fun getDefaultExtension(): String = "mpl"

    override fun getIcon(): Icon = MpplIcons.FILE
}