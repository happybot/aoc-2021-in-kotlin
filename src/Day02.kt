private class convertToObj(
    val key: String,
    val value: Int) {
    constructor(input: String) : this(
        input.split(" ")[0],
        input.split(" ")[1].toInt());
};

fun main() {
//    fun getActionSum(input: List<String>, action: String): Int {
//        return input.filter { it.contains(action) }.map { it.split(' ')[1].toInt() }
//            .reduce { sum, element -> sum + element }
//    }



    fun part1(input: List<String>): Int {
        var depth = 0;
        var hor = 0;
        input.map(::convertToObj)
            .forEach {
                when (it.key) {
                    "forward" -> hor += it.value;
                    "down" -> depth += it.value;
                    "up" -> depth -= it.value;
                }
            }
        return hor * depth
    }

    fun part2(input: List<String>): Int {
        var depth = 0
        var hor = 0
        var aim = 0
        input.map(::convertToObj)
            .forEach {
                when (it.key) {
                    "forward" -> {hor += it.value; depth += aim * it.value}
                    "down" -> aim += it.value;
                    "up" -> aim -= it.value;
                }
            }
        return hor * depth
    }

    val input = readInput("Day02_test")
    println(part1(input))
    println(part2(input))
}