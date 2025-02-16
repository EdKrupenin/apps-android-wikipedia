package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.AnyOf

enum class Color { RED, BLUE, GREEN, YELLOW, BLACK, WHITE }

data class Shape(val length: Float, val sidesCount: Int, val color: Color) {
    fun calculateCorners(): Int = when {
        sidesCount < 3 -> 0
        else -> sidesCount
    }
}

class LengthInRangeMatcher(
    private val min: Float,
    private val max: Float
) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("length should be between $min and $max")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.length in min..max
    }
}

class CornersCheckMatcher(
    private val expectedCorners: Int
) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("expected $expectedCorners corners")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.calculateCorners() == expectedCorners
    }
}

class SideMatcher(private val even: Boolean) : TypeSafeMatcher<Shape>(){
    override fun describeTo(description: Description) {
        val type = if (even) "even" else "odd"
        description.appendText("sides count should be $type")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.sidesCount % 2 == 0 == even
    }
}

class ShapesColorMatcher(private val color: Color) :TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        description.appendText("color should be $color")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.color == color
    }
}

class LengthCheckMatcher(private val positive: Boolean) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        val text = if(positive) "positive" else "negative"
        description.appendText("length should be $text")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.length > 0 == positive
    }
}

class SidesCheckMatcher(
    private val positive: Boolean = true
) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description) {
        val text = if(positive) "positive" else "negative"
        description.appendText("sides count should be $text")
    }

    override fun matchesSafely(shape: Shape): Boolean {
        return shape.sidesCount > 0 == positive
    }
}

class MatcherBuilder {
    private val listOfMatchers = mutableListOf<Matcher<Shape>>()

    operator fun invoke(function: MatcherBuilder.() -> Unit){
        function()
    }

    fun buildAllMatchers(): Matcher<Shape> = allOf(listOfMatchers)
    fun buildAnyMatchers(): AnyOf<Shape> = anyOf(listOfMatchers)
    fun clearMatchers() = listOfMatchers.clear()

    fun lengthRangeCheck(from: Float, to: Float){
        listOfMatchers.add(LengthInRangeMatcher(from,to))
    }

    fun cornersCheck(expectedCorners: Int){
        listOfMatchers.add(CornersCheckMatcher(expectedCorners))
    }
    fun sideMatcher(even: Boolean = true) {
        listOfMatchers.add(SideMatcher(even))
    }
    fun shapesColor(color: Color) {
        listOfMatchers.add(ShapesColorMatcher(color))
    }
    fun isPositiveLength(positive: Boolean = true) {
        listOfMatchers.add(LengthCheckMatcher(positive))
    }
    fun isPositiveSide(positive: Boolean = true) {
        listOfMatchers.add(SidesCheckMatcher(positive))
    }
}

fun main() {
    val shapes = listOf(
        Shape(10f, 3, Color.RED), Shape(5f, 4, Color.BLUE), Shape(7f, 2, Color.GREEN),
        Shape(0.5f, 1, Color.YELLOW), Shape(-3f, 5, Color.BLACK), Shape(8f, -2, Color.WHITE),
        Shape(12f, 6, Color.RED), Shape(15f, 8, Color.BLUE), Shape(20f, 4, Color.GREEN),
        Shape(9f, 5, Color.YELLOW), Shape(2f, 3, Color.BLACK), Shape(11f, 7, Color.WHITE),
        Shape(6f, 10, Color.RED), Shape(3f, 2, Color.BLUE), Shape(4f, 1, Color.GREEN),
        Shape(25f, 12, Color.YELLOW), Shape(30f, 14, Color.BLACK), Shape(35f, 16, Color.WHITE),
        Shape(40f, 18, Color.RED), Shape(50f, 20, Color.BLUE)
    )

    val builder = MatcherBuilder()

    builder{
        lengthRangeCheck(0.1f,100f)
        cornersCheck(2)
        sideMatcher(true)
        shapesColor(Color.RED)
        isPositiveLength()
        isPositiveSide()
    }

    var result = shapes.filter { builder.buildAllMatchers().matches(it) }

    println(result)

    builder.clearMatchers()
    result = shapes.filter { builder.buildAnyMatchers().matches(it) }

    println(result)

}



