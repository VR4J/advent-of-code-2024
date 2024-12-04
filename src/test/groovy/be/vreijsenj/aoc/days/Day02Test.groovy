package be.vreijsenj.aoc.days

import spock.lang.Specification

class Day02Test extends Specification {

    def "returns total amount of reports that are safe"() {
        given: "the example puzzle input"
        def input = [
            "7 6 4 2 1",
            "1 2 7 8 9",
            "9 7 6 2 1",
            "1 3 2 4 5",
            "8 6 4 4 1",
            "1 3 6 7 9"
        ]

        when: "the reports are checked"
        def result = new Day02().runPartOne(input)

        then: "the result matches the example answer"
        result == 2
    }

    def "returns total amount of reports that are safe with one excuse"() {
        given: "the example puzzle input"
        def input = [
            "7 6 4 2 1",
            "1 2 7 8 9",
            "9 7 6 2 1",
            "1 3 2 4 5",
            "8 6 4 4 1",
            "1 3 6 7 9"
        ]

        when: "the reports are checked"
        def result = new Day02().runPartTwo(input)

        then: "the result matches the example answer"
        result == 4
    }
}