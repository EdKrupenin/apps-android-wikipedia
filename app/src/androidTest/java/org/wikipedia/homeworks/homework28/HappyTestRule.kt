package org.wikipedia.homeworks.homework28

import com.kaspersky.kaspresso.logger.UiTestLogger
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class HappyTestRule(private val testLogger: UiTestLogger) : TestRule {
    private class HappyTestStatement(
        val testLogger: UiTestLogger,
        val description: Description?,
        val base: Statement?
    ) : Statement() {
        override fun evaluate() {
            testLogger.i(
                "HappyTestStatement started: " +
                        "${description?.className}" +
                        " ${description?.methodName}"
            )

            try {
                base?.evaluate()
            } catch (e: Throwable) {
                testLogger.e("HappyTestStatement evaluate failed", e.toString())
                throw e
            } finally {
                testLogger.i("HappyTestStatement ended")
            }
        }
    }

    override fun apply(base: Statement?, description: Description?): Statement {
        return HappyTestStatement(testLogger, description, base)
    }
}