package org.wikipedia.homeworks.homeworks08.matcher

import android.view.View
import com.google.android.material.tabs.TabLayout
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

class TabLayoutSelectedMatcher(private val expectedPosition: Int) :
    TypeSafeMatcher<View>() {
    override fun describeTo(description: Description?) {
        description?.appendText("TabLayout with selected position: $expectedPosition")
    }

    override fun describeMismatchSafely(item: View, mismatchDescription: Description?) {
        if (item is TabLayout) {
            mismatchDescription?.appendText("Actual selected position: ${item.selectedTabPosition}")
        } else {
            mismatchDescription?.appendText("Not a TabLayout")
        }
    }

    override fun matchesSafely(item: View?): Boolean {
        return if (item is TabLayout) {
            item.selectedTabPosition == expectedPosition
        } else {
            false
        }
    }
}

fun hasSelectedTabAt(position: Int): Matcher<View> {
    return TabLayoutSelectedMatcher(position)
}