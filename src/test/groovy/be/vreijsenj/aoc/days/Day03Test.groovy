package be.vreijsenj.aoc.days

import spock.lang.Specification

class Day03Test extends Specification {

    def "returns sum of all valid mul function results"() {
        given: "the example puzzle input"
        def input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"

        when: "the reports are checked"
        def result = new Day03().runPartOne(input)

        then: "the result matches the example answer"
        result == 161
    }

    def "returns sum of all valid mul function results considering do and don't"() {
        given: "the example puzzle input"
        def input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

        when: "the reports are checked"
        def result = new Day03().runPartTwo(input)

        then: "the result matches the example answer"
        result == 48
    }
}