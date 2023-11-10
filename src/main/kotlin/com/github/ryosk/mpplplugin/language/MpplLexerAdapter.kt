package com.github.ryosk.mpplplugin.language

import com.intellij.lexer.FlexAdapter

class MpplLexerAdapter: FlexAdapter(MpplLexer(null))