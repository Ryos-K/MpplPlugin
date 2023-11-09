package com.github.ryosk.mpplplugin.language

import com.intellij.lang.Language


class MpplLanguage : Language("Mppl") {
    companion object {
        val INSTANCE = MpplLanguage()
    }
}