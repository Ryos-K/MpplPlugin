package com.github.ryosk.mpplplugin.language

import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType

class MpplLiveTemplateContextType: TemplateContextType("Mppl") {
    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        return templateActionContext.file.name.endsWith(MpplFileType.INSTANCE.defaultExtension)
    }
}