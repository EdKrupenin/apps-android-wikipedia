package org.wikipedia.homeworks.homework21.tools

import android.view.View
import android.widget.CheckBox
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class CheckBoxChecked : ViewAction {
    override fun getConstraints(): Matcher<View> {
        return ViewMatchers.isAssignableFrom(CheckBox::class.java)
    }

    override fun getDescription(): String {
        return "change the flag state to the opposite"
    }

    override fun perform(uiController: UiController?, view: View?) {
        val checkBox = (view as CheckBox)
        checkBox.isChecked = !checkBox.isChecked
    }
}