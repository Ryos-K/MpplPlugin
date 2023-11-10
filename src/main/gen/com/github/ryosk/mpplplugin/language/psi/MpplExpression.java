// This is a generated file. Not intended for manual editing.
package com.github.ryosk.mpplplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MpplExpression extends PsiElement {

  @NotNull
  List<MpplRelationalOperator> getRelationalOperatorList();

  @NotNull
  List<MpplSimpleExpression> getSimpleExpressionList();

}
