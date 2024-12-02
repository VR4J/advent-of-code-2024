package be.vreijsenj.aoc.days

import be.vreijsenj.aoc.utils.PuzzleUtils
import kotlin.time.measureTime

object Day01 {

    @JvmStatic
    fun main(args: Array<String>) {
        val elapsed = measureTime {
            val input = PuzzleUtils.getInput(1, 1)

            val resultPartOne = runPartOne(input);

            println("Sum of all calibration values (pt.1): $resultPartOne")
        }

        println("Took $elapsed")
    }

    fun runPartOne(input: List<String>): Int {
       val left = input.map { x -> toInt(x, 0) }.sorted()
       val right = input.map { x -> toInt(x, 1) }.sorted()

       println(input)

       return left.zip(right)
        .map { (l, r) -> Math.abs(l - r) }
        .sum()
    }

    fun toInt(input: String, index: Int): Int {
        return input.split("   ")[index].toInt()
    }
}