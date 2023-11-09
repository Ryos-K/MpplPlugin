// This is a generated file. Not intended for manual editing.
package com.github.ryosk.mpplplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.ryosk.mpplplugin.language.psi.impl.*;

public interface MpplTypes {

  IElementType PROPERTY = new MpplElementType("PROPERTY");

  IElementType COMMENT = new MpplTokenType("COMMENT");
  IElementType CRLF = new MpplTokenType("CRLF");
  IElementType KEY = new MpplTokenType("KEY");
  IElementType SEPARATOR = new MpplTokenType("SEPARATOR");
  IElementType VALUE = new MpplTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new MpplPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
