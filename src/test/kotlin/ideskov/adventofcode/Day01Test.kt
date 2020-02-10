package ideskov.adventofcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.provider.ValueSource

class Day01Test {

    @Test
    @ValueSource()
    fun `find fuel needed for a module`() {
        assertEquals(2, ideskov.adventofcode.Module(12).fuel)
    }
}