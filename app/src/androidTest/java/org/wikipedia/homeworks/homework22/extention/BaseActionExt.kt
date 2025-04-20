package org.wikipedia.homeworks.homework22.extention

import android.view.View
import io.github.kakaocup.kakao.common.actions.BaseActions
import org.wikipedia.homeworks.homework22.tools.HasClassAction
import org.wikipedia.homeworks.homework22.tools.HasIdAction

fun BaseActions.hasIdAction(targetID: Int): Boolean {
    val checker = HasIdAction(targetID)
    view.perform(checker)
    return checker.isMatched()
}

fun BaseActions.hasClassAction(targetClass: Class<out View>): Boolean {
    val checker = HasClassAction(targetClass)
    view.perform(checker)
    return checker.isMatched()
}