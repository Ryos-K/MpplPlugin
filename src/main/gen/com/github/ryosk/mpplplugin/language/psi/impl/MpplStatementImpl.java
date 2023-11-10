// This is a generated file. Not intended for manual editing.
package com.github.ryosk.mpplplugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.ryosk.mpplplugin.language.psi.MpplTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.ryosk.mpplplugin.language.psi.*;

public class MpplStatementImpl extends ASTWrapperPsiElement implements MpplStatement {

  public MpplStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MpplVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MpplVisitor) accept((MpplVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MpplAssignmentStatement getAssignmentStatement() {
    return findChildByClass(MpplAssignmentStatement.class);
  }

  @Override
  @Nullable
  public MpplCallStatement getCallStatement() {
    return findChildByClass(MpplCallStatement.class);
  }

  @Override
  @Nullable
  public MpplCompoundStatement getCompoundStatement() {
    return findChildByClass(MpplCompoundStatement.class);
  }

  @Override
  @Nullable
  public MpplConditionStatement getConditionStatement() {
    return findChildByClass(MpplConditionStatement.class);
  }

  @Override
  @Nullable
  public MpplEmptyStatement getEmptyStatement() {
    return findChildByClass(MpplEmptyStatement.class);
  }

  @Override
  @Nullable
  public MpplExitStatement getExitStatement() {
    return findChildByClass(MpplExitStatement.class);
  }

  @Override
  @Nullable
  public MpplInputStatement getInputStatement() {
    return findChildByClass(MpplInputStatement.class);
  }

  @Override
  @Nullable
  public MpplIterationStatement getIterationStatement() {
    return findChildByClass(MpplIterationStatement.class);
  }

  @Override
  @Nullable
  public MpplOutputStatement getOutputStatement() {
    return findChildByClass(MpplOutputStatement.class);
  }

  @Override
  @Nullable
  public MpplReturnStatement getReturnStatement() {
    return findChildByClass(MpplReturnStatement.class);
  }

}
