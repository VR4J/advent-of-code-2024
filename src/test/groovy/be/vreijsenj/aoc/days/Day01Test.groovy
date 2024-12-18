package be.vreijsenj.aoc.days

import spock.lang.Specification

class Day01Test extends Specification {

    def "returns total distance between left and right"() {
        given: "the example puzzle input"
        def input = [
            "3   4",
            "4   3",
            "2   5",
            "1   3",
            "3   9",
            "3   3"
        ]

        when: "the distance is calculated"
        def result = new Day01().runPartOne(input)

        then: "the result matches the example answer"
        result == 11
    }

    def "returns similarity score between left and right"() {
        given: "the example puzzle input"
        def input = [
            "3   4",
            "4   3",
            "2   5",
            "1   3",
            "3   9",
            "3   3"
        ]

        when: "the distance is calculated"
        def result = new Day01().runPartTwo(input)

        then: "the result matches the example answer"
        result == 31
    }

}