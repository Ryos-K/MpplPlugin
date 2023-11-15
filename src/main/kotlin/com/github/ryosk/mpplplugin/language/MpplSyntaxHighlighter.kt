package com.github.ryosk.mpplplugin.language

import com.github.ryosk.mpplplugin.language.psi.MpplTokenSets
import com.github.ryosk.mpplplugin.language.psi.MpplTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class MpplSyntaxHighlighter : SyntaxHighlighterBase() {

    companion object {
        val KEYWORD = createTextAttributesKey("Mppl Keyword", Default.KEYWORD)
        val STRING = createTextAttributesKey("Mppl String", Default.STRING)
        val NUMBER = createTextAttributesKey("Mppl Number", Default.NUMBER)
        val OPERATOR = createTextAttributesKey("Mppl Operator", Default.OPERATION_SIGN)
        val PAREN = createTextAttributesKey("Mppl Parentheses", Default.PARENTHESES)
        val BRACE = createTextAttributesKey("Mppl Brace", Default.BRACES)
        val IDENTIFIER = createTextAttributesKey("Mppl Identifier", Default.IDENTIFIER)
        val COMMA = createTextAttributesKey("Mppl Comma", Default.COMMA)
        val DOT = createTextAttributesKey("Mppl Dot", Default.DOT)
        val SEMICOLON = createTextAttributesKey("Mppl Semicolon", Default.SEMICOLON)
        val COMMENT = createTextAttributesKey("Mppl Comment", Default.BLOCK_COMMENT)
        val BAD_CHARACTER = createTextAttributesKey("Mppl Bad Character", HighlighterColors.BAD_CHARACTER)

        private val KEYWORD_KEYS = arrayOf(KEYWORD)
        private val STRING_KEYS = arrayOf(STRING)
        private val NUMBER_KEYS = arrayOf(NUMBER)
        private val OPERATOR_KEYS = arrayOf(OPERATOR)
        private val PAREN_KEYS = arrayOf(PAREN)
        private val BRACE_KEYS = arrayOf(BRACE)
        private val IDENTIFIER_KEYS = arrayOf(IDENTIFIER)
        private val COMMA_KEYS = arrayOf(COMMA)
        private val DOT_KEYS = arrayOf(DOT)
        private val SEMICOLON_KEYS = arrayOf(SEMICOLON)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val BAD_CHARACTER_KEYS = arrayOf(BAD_CHARACTER)
        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()

    }

    override fun getHighlightingLexer(): Lexer =
        MpplLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> =
        when (tokenType) {
            in MpplTokenSets.KEYWORD
            -> KEYWORD_KEYS

            MpplTypes.STRING,
            -> STRING_KEYS

            MpplTypes.NUMBER,
            -> NUMBER_KEYS

            in MpplTokenSets.OPERATOR
            -> OPERATOR_KEYS

            in MpplTokenSets.PAREN
            -> PAREN_KEYS

            in MpplTokenSets.BRACE
            -> BRACE_KEYS

            MpplTypes.NAME,
            -> IDENTIFIER_KEYS

            MpplTypes.COMMA,
            -> COMMA_KEYS

            MpplTypes.DOT,
            -> DOT_KEYS

            MpplTypes.SEMI,
            -> SEMICOLON_KEYS

            MpplTypes.COMMENT,
            -> COMMENT_KEYS

            TokenType.BAD_CHARACTER,
            -> BAD_CHARACTER_KEYS

            else -> EMPTY_KEYS
        }

}