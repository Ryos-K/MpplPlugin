package com.github.ryosk.mpplplugin.language.psi

import com.intellij.psi.tree.TokenSet

object MpplTokenSets {

    val COMMENTS = TokenSet.create(MpplTypes.COMMENT)

    val STRING = TokenSet.create(MpplTypes.STRING)

    val KEYWORD = TokenSet.create(
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
    )

    val OPERATOR = TokenSet.create(
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
    )

    val PAREN = TokenSet.create(
        MpplTypes.LPAREN,
        MpplTypes.RPAREN,
    )

    val BRACE = TokenSet.create(
        MpplTypes.LSQPAREN,
        MpplTypes.RSQPAREN,
    )
}