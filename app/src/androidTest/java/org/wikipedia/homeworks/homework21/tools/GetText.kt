package org.wikipedia.homeworks.homework21.tools

import android.view.View
import android.widget.TextView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class GetText : ViewAction {
    private var text: String = ""

    fun getViewsText() = text

    override fun getConstraints(): Matcher<View> {
        return ViewMatchers.isAssignableFrom(TextView::class.java)
    }

    override fun getDescription(): String {
        return "Get tex from Text"
    }

    override fun perform(uiController: UiController?, view: View?) {
        text = (view as TextView).text.toString()
    }
}