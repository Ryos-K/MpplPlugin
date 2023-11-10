package com.github.ryosk.mpplplugin.language

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class MpplColorSettingsPage: ColorSettingsPage {
    override fun getAttributeDescriptors(): Array<AttributesDescriptor> =
        arrayOf(
            AttributesDescriptor("Keyword", MpplSyntaxHighlighter.KEYWORD),
            AttributesDescriptor("Number" , MpplSyntaxHighlighter.NUMBER),
            AttributesDescriptor("Operator" , MpplSyntaxHighlighter.OPERATOR),
            AttributesDescriptor("Brace" , MpplSyntaxHighlighter.BRACE),
            AttributesDescriptor("Identifier" , MpplSyntaxHighlighter.IDENTIFIER),
            AttributesDescriptor("Comma" , MpplSyntaxHighlighter.COMMA),
            AttributesDescriptor("Dot" , MpplSyntaxHighlighter.DOT),
            AttributesDescriptor("Semicolon" , MpplSyntaxHighlighter.SEMICOLON),
            AttributesDescriptor("Comment" , MpplSyntaxHighlighter.COMMENT),
            AttributesDescriptor("Bad" , MpplSyntaxHighlighter.BAD_CHARACTER),
        )

    override fun getColorDescriptors(): Array<ColorDescriptor> =
        ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName(): String =
        "Mppl"

    override fun getIcon(): Icon =
        MpplIcons.FILE

    override fun getHighlighter(): SyntaxHighlighter =
        MpplSyntaxHighlighter()

    override fun getDemoText(): String = """
        program sample14;
        /* Calculator program	*/
        /*  c n : clear & set n	*/
        /*  + n : add n			*/
        /*  - n : subtract n	*/
        /*  * n : multiply n	*/
        /*  / n : divide n		*/
        /*  o : off				*/
        var	x, y : integer;
        procedure sum;
        begin
        x := x + y
        end;
        procedure sub;
        begin
        x := x - y
        end;
        procedure mult;
        begin
        x := x * y
        end;
        procedure divide;
        begin
        x := x div y
        end;
        var	com :char;
        endflag : boolean;
        begin
        writeln('   *** Calculator -- h for help ***');
        x := 0;
        endflag := false;
        while not endflag do begin
        writeln(' Please input command :');
        readln(com, y);
        if (com = 'c')  or (com = 'C') then x := y
        else if com = '+' then call sum
        else if com = '-' then call sub
        else if com = '*' then call mult
        else if com = '/' then call divide
        else if (com = 'o') or (com = 'O') then endflag := true
        else begin
        writeln;
        writeln('Calculator Usage:');
        writeln('  c number : clear & set it');
        writeln('  + number : add it');
        writeln('  - number : subtract it');
        writeln('  * number : multiply it');
        writeln('  / number : divide it');
        writeln('  o        : off(terminate execution)');
        writeln
        end;
        if endflag then writeln('Final Result =', x)
        else writeln('Temporary Result =', x)
        end
        end.
    """

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? = null
}