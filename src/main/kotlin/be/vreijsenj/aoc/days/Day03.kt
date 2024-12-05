package be.vreijsenj.aoc.days

import be.vreijsenj.aoc.utils.PuzzleUtils
import kotlin.time.measureTime

object Day03 {

    val MUL_FUNCTION_PATTERN = """mul\((\d{1,3}),(\d{1,3})\)"""
    val DISABLE_PATTERN = """don't\(\)"""
    val ENABLE_PATTERN = """do\(\)"""

    @JvmStatic
    fun main(args: Array<String>) {
        val elapsed = measureTime {
            val input = PuzzleUtils.getInputAsText(3, 1)

            val resultPartOne = runPartOne(input);
            val resultPartTwo = runPartTwo(input);

            println("Sum of all uncorrupted mul function results (pt.1): $resultPartOne")
            println("Sum of all enabled mul function results (pt.2): $resultPartTwo")
        }

        println("Took $elapsed")
    }

    fun runPartOne(memory: String): Int {
        return MUL_FUNCTION_PATTERN.toRegex().findAll(memory)
            .map { it.groups[1]!!.value.toInt() * it.groups[2]!!.value.toInt() }
            .sum()
    }

    fun runPartTwo(memory: String): Int {
        val toRemovePattern = """$DISABLE_PATTERN.*?($MUL_FUNCTION_PATTERN)+.*?$ENABLE_PATTERN"""
            .toRegex(option = RegexOption.DOT_MATCHES_ALL)

        val cleansed = memory.replace(toRemovePattern, "")

        return runPartOne(cleansed)
    }
}