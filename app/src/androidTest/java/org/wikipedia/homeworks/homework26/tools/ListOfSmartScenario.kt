package org.wikipedia.homeworks.homework26.tools

class ListOfSmartScenario(private val list: List<BaseSmartScenario>) {
    fun execute() = list.any { it.init() }
}