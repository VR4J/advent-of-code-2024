package be.vreijsenj.aoc.days

import be.vreijsenj.aoc.utils.PuzzleUtils
import java.util.*
import kotlin.time.measureTime

object Day05 {

    @JvmStatic
    fun main(args: Array<String>) {
        val elapsed = measureTime {
            val (rules, updates)= PuzzleUtils.getInputAsText(5, 1)
                .split("\n\n")
                .map { it.split("\n") }

            val resultPartOne = runPartOne(rules, updates);
            val resultPartTwo = runPartTwo(rules, updates);

            println("Sum of all middle pages of all correctly ordered updates (pt.1): $resultPartOne")
            println("Sum of all middle pages of all incorrectly ordered updates (pt.2): $resultPartTwo")
        }

        println("Took $elapsed")
    }

    fun runPartOne(rules: List<String>, updates: List<String>): Int {
        val predicates = getRulePredicates(rules)

        return updates
            .map { it.split(",") }
            .map { it.map { it.toInt() } }
            .filter { isCorrectlyOrdered(it, predicates) }
            .sumOf { it[it.size / 2] }
    }

    fun runPartTwo(rules: List<String>, updates: List<String>): Int {
        val predicates = getRulePredicates(rules)

        val incorrect = updates
            .map { it.split(",") }
            .map { it.map { it.toInt() } }
            .filter { ! isCorrectlyOrdered(it, predicates) }

        return incorrect.map { correct(it, rules) }
            .sumOf { it[it.size / 2] }
    }

    private fun isCorrectlyOrdered(update: List<Int>, predicates: List<(List<Int>, Int) -> Boolean>): Boolean {
        return update.all { predicates.all { predicate -> predicate.invoke(update, it) } }
    }

    private fun getRulePredicates(rules: List<String>): List<(List<Int>, Int) -> Boolean> {
        return rules.map { rule: String ->
            predicate@ {
                update: List<Int>, page: Int ->
                    val (left, right) = rule.split("|").map { it.toInt() }

                    val applies = update.contains(left) && update.contains(right) && page == left

                    if(! applies) return@predicate true

                    return@predicate update.indexOf(page) < update.indexOf(right)
            }
        }
    }

    private fun correct(update: List<Int>, rules: List<String>): List<Int> {
        return update.sortedWith { a, b ->
            when {
                "$a|$b" in rules -> -1
                else -> 1
            }
        }
    }
}