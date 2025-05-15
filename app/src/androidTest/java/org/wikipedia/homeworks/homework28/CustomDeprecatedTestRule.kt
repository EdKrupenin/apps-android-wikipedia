package org.wikipedia.homeworks.homework28

import com.kaspersky.kaspresso.logger.UiTestLogger
import org.junit.AssumptionViolatedException
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class CustomDeprecatedTestRule(private val testLogger: UiTestLogger) : TestRule {
    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {
            override fun evaluate() {
                val deprecated = description?.getAnnotation(Deprecated::class.java)

                if (deprecated != null) {
                    testLogger.i("Test '${description.methodName}' is marked as @Deprecated, skipping...")
                    throw AssumptionViolatedException("Test '${description.methodName}' is deprecated")
                }

                testLogger.i("CustomDeprecatedTestRule started for '${description?.methodName}'")
                try {
                    base?.evaluate()
                } catch (e: Throwable) {
                    throw e
                } finally {
                    testLogger.i("CustomDepletedTestRule ended for '${description?.methodName}'")
                }
            }
        }
    }
}