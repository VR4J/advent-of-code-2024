package be.vreijsenj.aoc.days

import be.vreijsenj.aoc.utils.PuzzleUtils
import kotlin.time.measureTime

object Day02 {

    @JvmStatic
    fun main(args: Array<String>) {
        val elapsed = measureTime {
            val input = PuzzleUtils.getInput(2, 1)

            val resultPartOne = runPartOne(input);
            val resultPartTwo = runPartTwo(input);

            println("Total distance (pt.1): $resultPartOne")
            println("Similarity score (pt.2): $resultPartTwo")
        }

        println("Took $elapsed")
    }

    fun runPartOne(reports: List<String>): Int {
        return reports.map {
            val levels: List<Int> = it.split(" ")
                .map { levels -> levels.toInt() }

            isIncremental(levels) || isDecremental(levels)
        }.count { it }
    }

    fun runPartTwo(reports: List<String>): Int {
       return reports.map {
            val levels: List<Int> = it.split(" ")
                .map { levels -> levels.toInt() }

           val isOriginallySafe = isIncremental(levels) || isDecremental(levels)

           if(! isOriginallySafe) {
               val possible = IntRange(0, levels.size).map { index ->
                   levels.filterIndexed { i, level -> i != index}
               }

               possible.any { isIncremental(it) || isDecremental(it) }
           } else {
               true
           }
        }.count { it }
    }

    fun isIncremental(levels: List<Int>): Boolean {
        return levels.mapIndexed { index: Int, level: Int ->
            if(index == 0) {
                true
            } else {
                val previous = levels[index - 1]
                val diff =  Math.abs(level - previous)

                previous < level && diff <= 3 && diff > 0
            }
        }
        .all { it }
    }

    fun isDecremental(levels: List<Int>): Boolean {
        return levels.mapIndexed { index: Int, level: Int ->
            if(index == 0) {
                true
            } else {
                val previous = levels[index - 1]
                val diff =  Math.abs(level - previous)

                previous > level && diff <= 3 && diff > 0
            }
        }.all { it }
    }
}