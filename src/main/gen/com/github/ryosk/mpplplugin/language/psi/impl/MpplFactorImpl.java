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

public class MpplFactorImpl extends ASTWrapperPsiElement implements MpplFactor {

  public MpplFactorImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MpplVisitor visitor) {
    visitor.visitFactor(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MpplVisitor) accept((MpplVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MpplConstant getConstant() {
    return findChildByClass(MpplConstant.class);
  }

  @Override
  @Nullable
  public MpplExpression getExpression() {
    return findChildByClass(MpplExpression.class);
  }

  @Override
  @Nullable
  public MpplFactor getFactor() {
    return findChildByClass(MpplFactor.class);
  }

  @Override
  @Nullable
  public MpplStandardType getStandardType() {
    return findChildByClass(MpplStandardType.class);
  }

  @Override
  @Nullable
  public MpplVariable getVariable() {
    return findChildByClass(MpplVariable.class);
  }

}
