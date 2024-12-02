package be.vreijsenj.aoc.days

import be.vreijsenj.aoc.utils.PuzzleUtils
import kotlin.time.measureTime
import kotlin.collections.getOrElse

object Day01 {

    @JvmStatic
    fun main(args: Array<String>) {
        val elapsed = measureTime {
            val input = PuzzleUtils.getInput(1, 1)

            val resultPartOne = runPartOne(input);
            val resultPartTwo = runPartTwo(input);

            println("Total distance (pt.1): $resultPartOne")
            println("Similarity score (pt.2): $resultPartTwo")
        }

        println("Took $elapsed")
    }

    fun runPartOne(input: List<String>): Int {
       val left = input.map { x -> toInt(x, 0) }.sorted()
       val right = input.map { x -> toInt(x, 1) }.sorted()

       return left.zip(right)
        .map { (l, r) -> Math.abs(l - r) }
        .sum()
    }

    fun runPartTwo(input: List<String>): Int {
        val left = input.map { x -> toInt(x, 0) }
        val right = input.map { x -> toInt(x, 1) }
                         .groupingBy { it }
                         .eachCount()
 
        return left
         .map { l -> l * right.getOrElse(l, { 0 }) }
         .sum()
     }

    fun toInt(input: String, index: Int): Int {
        return input.split("   ")[index].toInt()
    }
}