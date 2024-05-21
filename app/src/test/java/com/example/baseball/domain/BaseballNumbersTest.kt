package com.example.baseball.domain

import org.junit.Test
import org.junit.jupiter.api.assertThrows

class BaseballNumbersTest() {
    @Test
    fun `야구 숫자는 0을 가질 수 없다`() {
        assertThrows<IllegalArgumentException> { BaseballNumbers(listOf(0, 2, 1)) }
    }

    @Test
    fun `야구 숫자는 중복될 수 없다`() {
        assertThrows<IllegalArgumentException> { BaseballNumbers(listOf(1, 2, 1)) }
    }

    @Test
    fun `야구 숫자는 3자리 수 이다_1`() {
        assertThrows<IllegalArgumentException> { BaseballNumbers(listOf(1, 2, 3, 4)) }
    }

    @Test
    fun `야구 숫자는 3자리 수 이다_2`() {
        assertThrows<IllegalArgumentException> { BaseballNumbers(listOf()) }
    }
}