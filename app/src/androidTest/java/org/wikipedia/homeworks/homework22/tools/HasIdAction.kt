package org.wikipedia.homeworks.homework22.tools

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class HasIdAction(private val targetID: Int) : ViewAction {
    private var result = false

    fun isMatched(): Boolean = result

    override fun getConstraints(): Matcher<View> = ViewMatchers.isAssignableFrom(View::class.java)

    override fun getDescription(): String = "Checks if the view has the target ID."

    override fun perform(uiController: UiController?, view: View?) {
        val nonNullView = requireNotNull(view) { "View must not be null" }
        result = when {
            nonNullView.id == targetID -> true
            nonNullView.findViewById<View>(targetID) != null -> true
            else -> false
        }
    }
}

