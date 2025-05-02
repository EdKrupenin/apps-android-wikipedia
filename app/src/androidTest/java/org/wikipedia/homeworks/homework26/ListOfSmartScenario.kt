package org.wikipedia.homeworks.homework26

class ListOfSmartScenario(private val list: List<BaseSmartScenario>) {
    fun execute() = list.any { it.init() }
}