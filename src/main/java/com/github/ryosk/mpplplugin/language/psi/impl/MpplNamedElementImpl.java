package com.github.ryosk.mpplplugin.language.psi.impl;

import com.github.ryosk.mpplplugin.language.psi.MpplNamedElement;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class MpplNamedElementImpl extends ASTWrapperPsiElement implements MpplNamedElement {

    public MpplNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
