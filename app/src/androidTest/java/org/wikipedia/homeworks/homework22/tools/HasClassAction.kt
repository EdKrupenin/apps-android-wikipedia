package org.wikipedia.homeworks.homework22.tools

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class HasClassAction(private val targetClass: Class<out View>) : ViewAction {
    private var result = false

    fun isMatched(): Boolean = result

    override fun getConstraints(): Matcher<View> = ViewMatchers.isAssignableFrom(View::class.java)

    override fun getDescription(): String = "Checks if the view has the target Class."

    override fun perform(uiController: UiController?, view: View?) {
        val nonNullView = requireNotNull(view) { "View must not be null" }

        result = if (targetClass.isAssignableFrom(nonNullView::class.java)) {
            true
        } else {
            checkInnerView(nonNullView)
        }
    }

    private fun checkInnerView(checkable: View): Boolean {
        if (targetClass.isAssignableFrom(checkable::class.java)) return true
        if (checkable is ViewGroup) {
            checkable.children.forEach {
                if (checkInnerView(it)) return true
            }
        }
        return false
    }
}