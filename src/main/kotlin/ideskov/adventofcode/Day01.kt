package ideskov.adventofcode

fun main() {
    println(
        InputReader("input01").inputLines
            .map { Module(it.toInt()) }
            .sumBy { it.addedFuel }
    )
}

class Module(val mass: Int) {
    
    val fuel by lazy { 
        mass / 3 - 2
    }
    
    val addedFuel by lazy {
        addedFuel(mass)
    }

    private fun addedFuel(moduleMass: Int): Int {
        val fuel = moduleMass / 3 - 2
        return if (fuel <= 0) 0 else fuel + addedFuel(fuel)
    }
}
