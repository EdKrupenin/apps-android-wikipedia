package org.wikipedia.homeworks.homework21.extentions

import io.github.kakaocup.kakao.text.TextViewActions
import org.wikipedia.homeworks.homework21.tools.GetText

fun TextViewActions.getText(): String {
    val getter = GetText()
    view.perform(getter)
    return getter.getViewsText()
}