
package com.github.ryosk.mpplplugin.language;

import com.github.ryosk.mpplplugin.language.psi.MpplTokenType;
import com.github.ryosk.mpplplugin.language.psi.MpplTypes;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;

%%

%class MpplLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

// Separator
CRLF       = \r\n | \r | \n
WHITESPACE = [ \t]
// Unsigned Integer
NUMBER = [0-9]+
// String
STRING = "'" ("''" | [^'])* "'"
// Identifier
NAME = [a-zA-Z][a-zA-Z0-9]*
// Comment
COMMENT1 = "{" [^}]* "}"
COMMENT2 = "/*" ( ([^"*"]|[\r\n])* ("*"+ [^"*""/"] )? )* ("*" | "*"+"/")?


%%


<YYINITIAL> {
    ({COMMENT1}|{COMMENT2}) { return MpplTypes.COMMENT; }

    ({CRLF}|{WHITESPACE})+ { return TokenType.WHITE_SPACE; }

    {NUMBER} { return MpplTypes.NUMBER; }
    {STRING} { return MpplTypes.STRING; }

    // Keyword
    "and"       {return MpplTypes.AND; }
    "array"     {return MpplTypes.ARRAY; }
    "begin"     {return MpplTypes.BEGIN; }
    "boolean"   {return MpplTypes.BOOLEAN; }
    "break"     {return MpplTypes.BREAK; }
    "call"      {return MpplTypes.CALL; }
    "char"      {return MpplTypes.CHAR; }
    "div"       {return MpplTypes.DIV; }
    "do"        {return MpplTypes.DO; }
    "else"      {return MpplTypes.ELSE; }
    "end"       {return MpplTypes.END; }
    "false"     {return MpplTypes.FALSE; }
    "if"        {return MpplTypes.IF; }
    "integer"   {return MpplTypes.INTEGER; }
    "not"       {return MpplTypes.NOT; }
    "of"        {return MpplTypes.OF; }
    "or"        {return MpplTypes.OR; }
    "procedure" {return MpplTypes.PROCEDURE; }
    "program"   {return MpplTypes.PROGRAM; }
    "read"      {return MpplTypes.READ; }
    "readln"    {return MpplTypes.READLN; }
    "return"    {return MpplTypes.RETURN; }
    "then"      {return MpplTypes.THEN; }
    "true"      {return MpplTypes.TRUE; }
    "var"       {return MpplTypes.VAR; }
    "while"     {return MpplTypes.WHILE; }
    "write"     {return MpplTypes.WRITE; }
    "writeln"   {return MpplTypes.WRITELN; }

    // Symbol
    "+"         { return MpplTypes.PLUS; }
    "-"         { return MpplTypes.MINUS; }
    "*"         { return MpplTypes.STAR; }
    "="         { return MpplTypes.EQUAL; }
    "<>"        { return MpplTypes.NOTEQ; }
    "<"         { return MpplTypes.LE; }
    "<="        { return MpplTypes.LEEQ; }
    ">"         { return MpplTypes.GR; }
    ">="        { return MpplTypes.GREQ; }
    "("         { return MpplTypes.LPAREN; }
    ")"         { return MpplTypes.RPAREN; }
    "["         { return MpplTypes.LSQPAREN; }
    "]"         { return MpplTypes.RSQPAREN; }
    ":="        { return MpplTypes.ASSIGN; }
    "."         { return MpplTypes.DOT; }
    ","         { return MpplTypes.COMMA; }
    ":"         { return MpplTypes.COLON; }
    ";"         { return MpplTypes.SEMI; }

    // Identifier must be below every token
    {NAME} { return MpplTypes.NAME; }

    [^]  { return TokenType.BAD_CHARACTER; }
}