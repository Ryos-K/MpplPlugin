// This is a generated file. Not intended for manual editing.
package com.github.ryosk.mpplplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MpplStatement extends PsiElement {

  @Nullable
  MpplAssignmentStatement getAssignmentStatement();

  @Nullable
  MpplCallStatement getCallStatement();

  @Nullable
  MpplCompoundStatement getCompoundStatement();

  @Nullable
  MpplConditionStatement getConditionStatement();

  @Nullable
  MpplEmptyStatement getEmptyStatement();

  @Nullable
  MpplExitStatement getExitStatement();

  @Nullable
  MpplInputStatement getInputStatement();

  @Nullable
  MpplIterationStatement getIterationStatement();

  @Nullable
  MpplOutputStatement getOutputStatement();

  @Nullable
  MpplReturnStatement getReturnStatement();

}
