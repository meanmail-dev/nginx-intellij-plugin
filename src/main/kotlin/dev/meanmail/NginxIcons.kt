package dev.meanmail

import com.intellij.openapi.util.IconLoader
import com.intellij.ui.JBColor

object AllIcons {

    val FILE =
        IconLoader.getIcon(if (JBColor.isBright()) "/nginx.png" else "/nginx-dark.png", this::class.java) // 16x16

}
