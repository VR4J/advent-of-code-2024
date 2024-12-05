package be.vreijsenj.aoc.days

import spock.lang.Specification

class Day05Test extends Specification {

    def "returns sum of all middle pages of all correctly ordered updates"() {
        given: "the example puzzle input"
        def rules = [
            "47|53",
            "97|13",
            "97|61",
            "97|47",
            "75|29",
            "61|13",
            "75|53",
            "29|13",
            "97|29",
            "53|29",
            "61|53",
            "97|53",
            "61|29",
            "47|13",
            "75|47",
            "97|75",
            "47|61",
            "75|61",
            "47|29",
            "75|13",
            "53|13"
        ]

        def updates = [
            "75,47,61,53,29",
            "97,61,53,29,13",
            "75,29,13",
            "75,97,47,61,53",
            "61,13,29",
            "97,13,75,29,47"
        ]

        when: "the puzzle is solved"
        def result = new Day05().runPartOne(rules, updates)

        then: "the result matches the example answer"
            result == 143
    }

    def "returns sum of all middle pages of all incorrectly ordered updates"() {
        given: "the example puzzle input"
        def rules = [
            "47|53",
            "97|13",
            "97|61",
            "97|47",
            "75|29",
            "61|13",
            "75|53",
            "29|13",
            "97|29",
            "53|29",
            "61|53",
            "97|53",
            "61|29",
            "47|13",
            "75|47",
            "97|75",
            "47|61",
            "75|61",
            "47|29",
            "75|13",
            "53|13"
        ]

        def updates = [
            "75,47,61,53,29",
            "97,61,53,29,13",
            "75,29,13",
            "75,97,47,61,53",
            "61,13,29",
            "97,13,75,29,47"
        ]

        when: "the puzzle is solved"
        def result = new Day05().runPartTwo(rules, updates)

        then: "the result matches the example answer"
            result == 123
    }
}