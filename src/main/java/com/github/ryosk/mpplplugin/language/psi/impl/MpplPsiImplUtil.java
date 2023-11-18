package com.github.ryosk.mpplplugin.language.psi.impl;

import com.github.ryosk.mpplplugin.language.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;


public class MpplPsiImplUtil {
    public static String getName(MpplVariableName element) {
        ASTNode nameNode = element.getNode().findChildByType(MpplTypes.NAME);
        return nameNode != null ? nameNode.getText() : null;
    }

    public static PsiElement setName(MpplVariableName element, String newName) {
        return _setName(element, newName);
    }

    public static PsiElement getNameIdentifier(MpplVariableName element) {
        ASTNode nameNode = element.getNode().findChildByType(MpplTypes.NAME);
        return nameNode != null ? nameNode.getPsi() : null;
    }

    public static String getName(MpplProcedureName element) {
        ASTNode nameNode = element.getNode().findChildByType(MpplTypes.NAME);
        return nameNode != null ? nameNode.getText() : null;
    }

    public static PsiElement setName(MpplProcedureName element, String newName) {
        return _setName(element, newName);
    }

    public static PsiElement getNameIdentifier(MpplProcedureName element) {
        ASTNode nameNode = element.getNode().findChildByType(MpplTypes.NAME);
        return nameNode != null ? nameNode.getPsi() : null;
    }

    public static PsiElement _setName(PsiElement element, String newName) {
        ASTNode nameNode = element.getNode().findChildByType(MpplTypes.NAME);
        if (nameNode == null) return element;
        PsiElement name = MpplElementFactory.INSTANCE.createName(element.getProject(), newName);
        if (name == null) return element;
        ASTNode newNameNode = name.getNode();
        element.getNode().replaceChild(nameNode, newNameNode);
        return element;
    }

}

