package ideskov.adventofcode

fun main() {
    val inputValues = InputReader("input02").inputLines[0]
        .split(",")
        .map { it.toInt() }.toMutableList()

    var input = 0 to 0
    while (input.first < 99) {
        inputValues[1] = input.first
        while (input.second < 99) {
            inputValues[2] = input.second
            if (IntcodeComputer(inputValues).result[0] == 19690720) {
                println(input)
                return
            }
            input = input.first to input.second + 1
        }
        input = input.first + 1 to 0
    }
}

class IntcodeComputer(input: List<Int>) {

    val result: List<Int> by lazy {
        val resultingList = input.toMutableList()

        for (i in input.indices step 4) {
            val opcode = when (resultingList[i]) {
                1 -> Opcode.SUM
                2 -> Opcode.MULTIPLY
                else -> Opcode.HALT
            }
            if (opcode == Opcode.HALT) break

            Instruction(opcode, resultingList[i + 1], resultingList[i + 2], resultingList[i + 3])
                .handle(resultingList)
        }

        resultingList.toList()
    }
}

class Instruction(
    val opcode: Opcode,
    vararg parameters: Int
) {
    val parameters = parameters

    fun handle(list: MutableList<Int>) {
        opcode.operation?.let { list[parameters[2]] = it.invoke(list[parameters[0]], list[parameters[1]]) }
    }

}

enum class Opcode(
    val opcodeValue: Int,
    val operation: ((Int, Int) -> Int)?
) {
    SUM(1, { a, b -> a + b }),
    MULTIPLY(2, { a, b -> a * b }),
    HALT(99, null)
}
