package ideskov.adventofcode

import java.io.File

class InputReader(fileName: String) {
    val inputLines = File(InputReader::class.java.getResource("/$fileName").toURI()).readLines()
}