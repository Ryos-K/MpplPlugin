package com.github.ryosk.mpplplugin.language.psi

import com.github.ryosk.mpplplugin.language.MpplLanguage
import com.intellij.psi.tree.IElementType

class MpplTokenType(debugName: String): IElementType(debugName, MpplLanguage.INSTANCE) {

    override fun toString(): String = "MpplTokenType.${super.toString()}"
}