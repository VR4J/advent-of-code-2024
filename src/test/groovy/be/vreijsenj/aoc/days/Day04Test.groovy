package be.vreijsenj.aoc.days

import spock.lang.Specification

class Day04Test extends Specification {

    def "returns total of all xmas words considering horizontal, vertical, diagonal, backwards, or overlapping"() {
        given: "the example puzzle input"
        def input = [
            "MMMSXXMASM",
            "MSAMXMSMSA",
            "AMXSXMAAMM",
            "MSAMASMSMX",
            "XMASAMXAMM",
            "XXAMMXXAMA",
            "SMSMSASXSS",
            "SAXAMASAAA",
            "MAMMMXMMMM",
            "MXMXAXMASX"
        ]

        when: "the puzzle is solved"
        def result = new Day04().runPartOne(input)

        then: "the result matches the example answer"
        result == 18
    }

    def "returns total of x-mas patterns"() {
        given: "the example puzzle input"
        def input = [
            "MMMSXXMASM",
            "MSAMXMSMSA",
            "AMXSXMAAMM",
            "MSAMASMSMX",
            "XMASAMXAMM",
            "XXAMMXXAMA",
            "SMSMSASXSS",
            "SAXAMASAAA",
            "MAMMMXMMMM",
            "MXMXAXMASX"
        ]

        when: "the puzzle is solved"
        def result = new Day04().runPartTwo(input)

        then: "the result matches the example answer"
        result == 9
    }
}