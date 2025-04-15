package org.wikipedia.homeworks.homework21.extentions

import io.github.kakaocup.kakao.check.CheckableActions
import org.wikipedia.homeworks.homework21.tools.CheckBoxChecked

fun CheckableActions.switchCheck() {
    view.perform(CheckBoxChecked())
}