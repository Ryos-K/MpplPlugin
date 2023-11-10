package com.github.ryosk.mpplplugin.language.psi

import com.intellij.psi.tree.TokenSet

object MpplTokenSets {

    val COMMENTS = TokenSet.create(MpplTypes.COMMENT)

    val STRING = TokenSet.create(MpplTypes.STRING)
}