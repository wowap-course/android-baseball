package com.example.baseball.domain

import org.junit.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class BaseballNumberTest() {
    @Test
    fun `야구 숫자는 1부터 9사이의 값이다_1`() {
        assertDoesNotThrow{BaseballNumber(1)}
    }
    @Test
    fun `야구 숫자는 1부터 9사이의 값이다_2`() {
        assertDoesNotThrow{BaseballNumber(5)}
    }
    @Test
    fun `야구 숫자는 1부터 9사이의 값이다_3`() {
        assertDoesNotThrow{BaseballNumber(9)}
    }

    @Test
    fun `야구 숫자는 1부터 9사이의 값이다_4`() {
        assertThrows<IllegalArgumentException>{BaseballNumber(0)}
    }
    @Test
    fun `야구 숫자는 1부터 9사이의 값이다_5`() {
        assertThrows<IllegalArgumentException>{BaseballNumber(10)}
    }
}