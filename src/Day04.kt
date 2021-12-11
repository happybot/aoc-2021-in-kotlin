fun main() {

    fun getResult(input: List<String>): MutableList<Int> {
        val result = mutableListOf<Int>()
        val input_numbers = input[0].split(',').map{it.toInt()}
        var input_boards = input.filter{it != ""}.drop(1).windowed(5,5).map { board ->
            board.flatMap { row ->
                row.trim().split(Regex("\\s+")).map { it.toInt() to false }
            }
        }

        input_numbers.forEach { n ->
            input_boards = input_boards.map { board ->
                board.map { if (it.first == n) n to true else it }
            }
                .filterNot { board ->
                    val rows = board.chunked(5)
                    val columns = List(5) { col -> rows.map { it[col] } }
                    val bingo = rows.any { row -> row.all { it.second } } || columns.any { col -> col.all { it.second } }
                    if (bingo) result += n * board.sumOf { if (it.second) 0 else it.first }
                    bingo
                }
        }
        return result
    }
    
    fun part1(input: List<String>) = getResult(input).first()
    fun part2(input: List<String>) = getResult(input).last()

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    println(part1(testInput))
    println(part2(testInput))
}
