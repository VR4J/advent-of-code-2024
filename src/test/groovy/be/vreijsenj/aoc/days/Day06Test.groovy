package be.vreijsenj.aoc.days

import spock.lang.Specification

class Day06Test extends Specification {

    def "returns the total distinct positions the guard visits before leaving"() {
        given: "the example puzzle input"
        def input = [
            "....#.....",
            ".........#",
            "..........",
            "..#.......",
            ".......#..",
            "..........",
            ".#..^.....",
            "........#.",
            "#.........",
            "......#..."
        ]

        when: "the puzzle is solved"
        def result = new Day06().runPartOne(input)

        then: "the result matches the example answer"
            result == 41
    }
}