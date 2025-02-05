package ru.myitschool.lab210

import org.junit.Assert
import org.junit.Assume
import org.junit.Test

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assume.assumeTrue

class RestoreUnitTest {
    @Test
    fun testFailingAssertion() {
        assertEquals("Этот тест должен провалиться", 1, 2)
    }
    @Test
    fun testUnmetAssumption() {
        assumeTrue("Это предположение не выполняется", false)
        assertTrue(true) // Этот код не выполнится
    }
}
