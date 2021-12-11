private fun isOneMoreThanZero(input: List<String>,i: Int): Boolean {
    return input.map { it[i] }.count { it == '1' } >= input.map { it[i] }.count { it == '0' }
}



fun main() {
    fun part1(input: List<String>): Int {
        var gammarate_rate = ""
        var epsilonrate_rate = ""

        for (i in 0 until input[0].length) {
            if (isOneMoreThanZero(input,i)) {
                gammarate_rate += "1";
                epsilonrate_rate += "0";
            } else {
                gammarate_rate += "0";
                epsilonrate_rate += "1";
            }
        }
        return Integer.parseInt( gammarate_rate,2) * Integer.parseInt( epsilonrate_rate,2)
    }

    fun part2(input: List<String>): Int {
        var oxygen_generator_input = input
        var co2_scrubber_input = input
        
        for (i in 0 until input[0].length) {
            if (oxygen_generator_input.size > 1) {
                if (isOneMoreThanZero(oxygen_generator_input,i)) {
                    oxygen_generator_input = oxygen_generator_input.filter { it[i] == '1' };
                } else  {
                    oxygen_generator_input = oxygen_generator_input.filter { it[i] == '0' };
                }
            }
            if (co2_scrubber_input.size > 1) {
                if (!isOneMoreThanZero(co2_scrubber_input,i)) {
                    co2_scrubber_input = co2_scrubber_input.filter { it[i] == '1' };
                } else {
                    co2_scrubber_input = co2_scrubber_input.filter { it[i] == '0' };
                }
            }

            if (oxygen_generator_input.size <=1 && co2_scrubber_input.size <=1) {
                break;
            }
        }
        return Integer.parseInt( oxygen_generator_input[0],2) * Integer.parseInt( co2_scrubber_input[0],2)
    }

    val input = readInput("Day03_test")
    println(part1(input))
    println(part2(input))
}