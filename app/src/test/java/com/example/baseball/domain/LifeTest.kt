package com.example.baseball.domain

import com.example.baseball.MainActivity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.Test

class LifeTest {
    @Test
    fun `life는 1 밑으로 내려가면 안된다`() {
        assertThrows<IllegalArgumentException> { Life(0) }
    }
}