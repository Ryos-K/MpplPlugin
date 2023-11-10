package com.github.ryosk.mpplplugin.language

import com.github.ryosk.mpplplugin.language.psi.MpplTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class MpplSyntaxHighlighter : SyntaxHighlighterBase() {

    companion object {
        private val KEYWORD = createTextAttributesKey("Mppl Keyword", DefaultLanguageHighlighterColors.KEYWORD)
        private val NUMBER = createTextAttributesKey("Mppl Number", DefaultLanguageHighlighterColors.NUMBER)
        private val OPERATOR = createTextAttributesKey("Mppl Operator", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        private val BRACE = createTextAttributesKey("Mppl Brace", DefaultLanguageHighlighterColors.BRACES)
        private val IDENTIFIER = createTextAttributesKey("Mppl Identifier", DefaultLanguageHighlighterColors.IDENTIFIER)
        private val COMMA = createTextAttributesKey("Mppl Comma", DefaultLanguageHighlighterColors.COMMA)
        private val DOT = createTextAttributesKey("Mppl Dot", DefaultLanguageHighlighterColors.DOT)
        private val SEMICOLON = createTextAttributesKey("Mppl Semicolon", DefaultLanguageHighlighterColors.SEMICOLON)
        private val COMMENT = createTextAttributesKey("Mppl Comment", DefaultLanguageHighlighterColors.BLOCK_COMMENT)
        private val BAD_CHARACTER = createTextAttributesKey("Mppl Bad Character", HighlighterColors.BAD_CHARACTER)

        private val KEYWORD_KEYS = arrayOf(KEYWORD)
        private val NUMBER_KEYS = arrayOf(NUMBER)
        private val OPERATOR_KEYS = arrayOf(OPERATOR)
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
            MpplTypes.ARRAY,
            MpplTypes.BEGIN,
            MpplTypes.BOOLEAN,
            MpplTypes.BREAK,
            MpplTypes.CALL,
            MpplTypes.CHAR,
            MpplTypes.DO,
            MpplTypes.ELSE,
            MpplTypes.END,
            MpplTypes.FALSE,
            MpplTypes.IF,
            MpplTypes.INTEGER,
            MpplTypes.NOT,
            MpplTypes.OF,
            MpplTypes.PROCEDURE,
            MpplTypes.PROGRAM,
            MpplTypes.READ,
            MpplTypes.READLN,
            MpplTypes.RETURN,
            MpplTypes.THEN,
            MpplTypes.TRUE,
            MpplTypes.VAR,
            MpplTypes.WHILE,
            MpplTypes.WRITE,
            MpplTypes.WRITELN,
            -> KEYWORD_KEYS

            MpplTypes.NUMBER,
            -> NUMBER_KEYS

            MpplTypes.AND,
            MpplTypes.DIV,
            MpplTypes.OR,
            MpplTypes.PLUS,
            MpplTypes.MINUS,
            MpplTypes.STAR,
            MpplTypes.EQUAL,
            MpplTypes.NOTEQ,
            MpplTypes.LE,
            MpplTypes.LEEQ,
            MpplTypes.GR,
            MpplTypes.GREQ,
            -> OPERATOR_KEYS

            MpplTypes.LPAREN,
            MpplTypes.RPAREN,
            MpplTypes.LSQPAREN,
            MpplTypes.RSQPAREN,
            -> BRACE_KEYS

            MpplTypes.NAME,
            -> IDENTIFIER_KEYS

            MpplTypes.COMMA,
            -> COMMA_KEYS

            MpplTypes.DOT,
            -> DOT_KEYS

            MpplTypes.COLON,
            MpplTypes.SEMI,
            -> SEMICOLON_KEYS

            MpplTypes.COMMENT,
            -> COMMENT_KEYS

            TokenType.BAD_CHARACTER,
            -> BAD_CHARACTER_KEYS

            else -> EMPTY_KEYS
        }

}