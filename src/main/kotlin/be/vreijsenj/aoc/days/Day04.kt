package be.vreijsenj.aoc.days

import be.vreijsenj.aoc.days.utils.Grid
import be.vreijsenj.aoc.utils.PuzzleUtils
import kotlin.time.measureTime

object Day04 {

    @JvmStatic
    fun main(args: Array<String>) {
        val elapsed = measureTime {
            val input = PuzzleUtils.getInput(4, 1)

            val resultPartOne = runPartOne(input);
            val resultPartTwo = runPartTwo(input);

            println("Total distance (pt.1): $resultPartOne")
            println("Similarity score (pt.2): $resultPartTwo")
        }

        println("Took $elapsed")
    }

    fun runPartOne(lines: List<String>): Int {
        val rows = lines;
        val columns = rows.first().indices.map { x ->
            rows
                .map { row -> row[x] }
                .joinToString(separator = "")
        }

        return listOf(rows, columns, getLeftDiagonal(rows, columns), getRightDiagonal(rows, columns))
            .sumOf { occurences("XMAS", it) }
    }

    fun runPartTwo(lines: List<String>): Int {
        val grid = Grid.rasterize(lines)
        val centers = grid.filter {
            lines[it.y][it.x] == 'A'
        }

        return centers.map {
            val topLeftPoint = it.top().left()
            val topRightPoint = it.top().right()
            val bottomLeftPoint = it.bottom().left()
            val bottomRightPoint = it.bottom().right()

            val points = listOf(topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint)

            if(points.all { point -> grid.contains(point) }) {
                val topLeft = lines[topLeftPoint.y][topLeftPoint.x]
                val topRight = lines[topRightPoint.y][topRightPoint.x]
                val bottomLeft = lines[bottomLeftPoint.y][bottomLeftPoint.x]
                val bottomRight = lines[bottomRightPoint.y][bottomRightPoint.x]

                topLeft == 'M' && topRight == 'S' && bottomLeft == 'M' && bottomRight == 'S'
                    || topLeft == 'S' && topRight == 'M' && bottomLeft == 'S' && bottomRight == 'M'
                    || topLeft == 'S' && topRight == 'S' && bottomLeft == 'M' && bottomRight == 'M'
                    || topLeft == 'M' && topRight == 'M' && bottomLeft == 'S' && bottomRight == 'S'
            } else {
                false
            }
        }.count { it }
    }

    fun getRightDiagonal(rows: List<String>, columns: List<String>): List<String> {
        val rxDiagonal = columns.first().indices.map { y ->
            rows
                .filterIndexed { x, row -> x + y < row.length }
                .mapIndexed { x, row -> row[x + y] }
                .joinToString(separator = "")
        }
        val ryDiagonal = rows.first().indices.map { x ->
            columns
                .filterIndexed { y, column -> x + y < column.length }
                .mapIndexed { y, column -> column[x + y] }
                .joinToString(separator = "")
        }

        return (rxDiagonal + ryDiagonal).distinct()
    }

    fun getLeftDiagonal(rows: List<String>, columns: List<String>): List<String> {
        val lxDiagonal = columns.first().indices.map { y ->
            rows
                .filterIndexed { x, row -> y - x >= 0 }
                .mapIndexed { x, row -> row[y - x] }
                .joinToString(separator = "")
        }
        val lyDiagonal = rows.first().indices.map { x ->
            columns.reversed()
                .filterIndexed { y, column -> x + y < column.length }
                .mapIndexed { y, column -> column[x + y] }
                .joinToString(separator = "")
        }

        return (lxDiagonal + lyDiagonal).distinct()
    }

    fun occurences(text: String, sequence: List<String>): Int {
        val normal = sequence.sumOf {
            it.split(text).size - 1
        }
        val reversed = sequence.sumOf {
            it.split(text.reversed()).size - 1
        }

        return normal + reversed;
    }
}