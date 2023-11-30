package com.github.ryosk.mpplplugin.language.commenter

import com.intellij.json.editor.JsonCommenter
import com.intellij.lang.Commenter

class MpplCommenter : Commenter {
    override fun getLineCommentPrefix(): String? {
        return null;
    }

    override fun getBlockCommentPrefix(): String? {
        return "{";
    }

    override fun getBlockCommentSuffix(): String? {
        return "}"
    }

    override fun getCommentedBlockCommentPrefix(): String? {
        return "{"
    }

    override fun getCommentedBlockCommentSuffix(): String? {
        return "}"
    }
}