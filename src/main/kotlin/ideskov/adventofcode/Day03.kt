package ideskov.adventofcode

import java.lang.RuntimeException

fun main() { 
//    val paths = listOf("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7")
//    val paths = listOf("R8,U5,L5,D3", "U7,R6,D4,L4")
//    val paths = listOf("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83")
//        .map { WirePath(it) }

//    println(paths[0].crossPaths(paths[1]))
    val paths  = InputReader("input03").inputLines.map { WirePath(it) }
    println(
        paths[0].crossPaths(paths[1])
            .map { paths[0].path.indexOf(it) + paths[1].path.indexOf(it) + 2 }
            .min()
    )
}

data class Coordinate(val x: Int, val y: Int)

class WirePath(rawPath: String) {

    val path: List<Coordinate> by lazy { 
        val result = mutableListOf<Coordinate>()
        rawPath
            .split(",")
            .forEach { result.addAll(drawPath(it, if (result.isEmpty()) Coordinate(0, 0) else result.last())) }
        result
    }

    fun crossPaths(otherWirePath: WirePath) = path.intersect(otherWirePath.path).filter { it.x != 0 && it.y != 0 }
}

fun drawPath(command: String, startingPoint: Coordinate): List<Coordinate> {
    val number = command.substring(1).toInt()
    return when (command[0]) {
        'R' -> (1..number).map { Coordinate(startingPoint.x + it, startingPoint.y) }
        'L' -> (1..number).map { Coordinate(startingPoint.x - it, startingPoint.y) }
        'U' -> (1..number).map { Coordinate(startingPoint.x, startingPoint.y + it) }
        'D' -> (1..number).map { Coordinate(startingPoint.x, startingPoint.y - it) }
        else -> throw RuntimeException()
    }
}
