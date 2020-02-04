package ideskov.adventofcode

fun main() {
    println(
        InputReader("input01").inputLines
            .map { it.toInt() }
            .sumBy { addedFuel(it) }
    )
}

fun addedFuel(moduleMass: Int): Int {
    val fuel = moduleMass / 3 - 2
    return if (fuel <= 0) 0 else fuel + addedFuel(fuel)
}
