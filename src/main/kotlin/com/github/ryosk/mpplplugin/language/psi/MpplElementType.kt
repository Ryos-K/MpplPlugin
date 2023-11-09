package com.github.ryosk.mpplplugin.language.psi

import com.github.ryosk.mpplplugin.language.MpplLanguage
import com.intellij.psi.tree.IElementType

class MpplElementType(debugName : String) : IElementType(debugName, MpplLanguage.INSTANCE)