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

public class MpplOutputStatementImpl extends ASTWrapperPsiElement implements MpplOutputStatement {

  public MpplOutputStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MpplVisitor visitor) {
    visitor.visitOutputStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MpplVisitor) accept((MpplVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MpplOutputFormat> getOutputFormatList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MpplOutputFormat.class);
  }

}
