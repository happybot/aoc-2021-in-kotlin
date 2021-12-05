fun main() {
    fun part1(input: List<String>): Int {
        val numbers = input.map { it.toInt() }
        var counter = 0
        var previous = numbers[0];

        for (line in numbers) {
            if (previous < line) {
                counter++
            }
            previous = line
        }

        return counter
    }

    fun part2(input: List<String>): Int {
        val numbers = input.map { it.toInt() }
        var counter = 0
        var previous = numbers[0] + numbers[1] + numbers[2]

        for (i in 1..numbers.size - 3) {
            val current = numbers[i] + numbers[i + 1] + numbers[i + 2]
            if (current > previous) {
                counter++
            }
            previous = current
        }

        return counter
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    println(part1(testInput))
    println(part2(testInput))
}
