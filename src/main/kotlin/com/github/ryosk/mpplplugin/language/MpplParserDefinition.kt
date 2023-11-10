package com.github.ryosk.mpplplugin.language

import com.github.ryosk.mpplplugin.language.parser.MpplParser
import com.github.ryosk.mpplplugin.language.psi.MpplFile
import com.github.ryosk.mpplplugin.language.psi.MpplTokenSets
import com.github.ryosk.mpplplugin.language.psi.MpplTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class MpplParserDefinition : ParserDefinition {

    companion object {
        val FILE = IFileElementType(MpplLanguage.INSTANCE)
    }

    override fun createLexer(project: Project?): Lexer =
        MpplLexerAdapter()

    override fun createParser(project: Project?): PsiParser =
        MpplParser()

    override fun getFileNodeType(): IFileElementType =
        FILE
    
    override fun getCommentTokens(): TokenSet =
        MpplTokenSets.COMMENTS
    override fun getStringLiteralElements(): TokenSet =
        MpplTokenSets.STRING

    override fun createElement(node: ASTNode?): PsiElement =
        MpplTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile =
        MpplFile(viewProvider)
}