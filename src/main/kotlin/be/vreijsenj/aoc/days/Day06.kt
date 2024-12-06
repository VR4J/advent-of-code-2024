package be.vreijsenj.aoc.days

import be.vreijsenj.aoc.days.utils.Direction
import be.vreijsenj.aoc.days.utils.Grid
import be.vreijsenj.aoc.days.utils.Point
import be.vreijsenj.aoc.utils.PuzzleUtils
import kotlin.time.measureTime

object Day06 {

    @JvmStatic
    fun main(args: Array<String>) {
        val elapsed = measureTime {
            val input = PuzzleUtils.getInput(6, 1)

            val resultPartOne = runPartOne(input);
            val resultPartTwo = runPartTwo(input);

            println("Total positions visited (pt.1): $resultPartOne")
            println(" (pt.2): $resultPartTwo")
        }

        println("Took $elapsed")
    }

    fun runPartOne(input: List<String>): Int {
        val grid = Grid.rasterize(input);
        val history = mutableListOf<Point>()

        var position: Point = getStartingPoint(input)
        var direction: Direction = Direction.UP

        while(true) {
            history.add(position);

            val next = position.next(direction)

            if(next !in grid) break;

            val value =  input[next.y][next.x]

            direction = if(value == '#') { turn(direction) } else { direction }

            position = position.next(direction)
        }

        return history.distinct().count()
    }

    fun runPartTwo(input: List<String>): Int {
        return 0
    }

    private fun turn(direction: Direction): Direction {
        return when (direction) {
            Direction.UP -> Direction.RIGHT
            Direction.RIGHT -> Direction.DOWN
            Direction.DOWN -> Direction.LEFT
            Direction.LEFT -> Direction.UP
        }
    }

    private fun getStartingPoint(input: List<String>, value: Char = '^'): Point {
        return input
            .filter { it.contains(value) }
            .map { row -> Point(row.indexOf(value), input.indexOf(row)) }
            .first()
    }
}