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

    @Test
    fun `life는 10 위로 올라가면 안된다`() {
        assertThrows<IllegalArgumentException> { Life(11) }
    }

    @Test
    fun `life가 5 일때 증가시키면 6이 된다`() {
        // given
        val life = Life(5)

        // when
        val actual = life.increase()

        // then
        assertThat(actual).isEqualTo(Life(6))
    }

    @Test
    fun `life가 3 일때 감소시키면 2이 된다`() {
        // given
        val life = Life(3)

        // when
        val actual = life.decrease()

        // then
        assertThat(actual).isEqualTo(Life(2))
    }

    @Test
    fun `life가 10 일때 증가시키면 10이 된다`() {
        // given
        val life = Life(10)

        // when
        val actual = life.increase()

        // then
        assertThat(actual).isEqualTo(Life(10))
    }

    @Test
    fun `life가 1 일때 감소시키면 1이 된다`() {
        // given
        val life = Life(1)

        // when
        val actual = life.decrease()

        // then
        assertThat(actual).isEqualTo(Life(1))
    }

}