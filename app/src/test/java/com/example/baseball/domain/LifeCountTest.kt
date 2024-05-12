package com.example.baseball.domain

import junit.framework.TestCase.assertTrue
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.jupiter.api.assertThrows

class LifeCountTest {
    @Test
    fun `기본적인 목숨의 개수는 1이다`() {
        //given
        val once = LifeCount(1)

        //then
        assertThat(LifeCount()).isEqualTo(once)
    }
    @Test
    fun `목숨의 개수는 1보다 작을 수 없다`() {
        assertThrows<IllegalArgumentException> { LifeCount(0) }
    }

    @Test
    fun `목숨의 개수는 19를 넘을 수 없다`() {
        assertThrows<IllegalArgumentException> { LifeCount(20) }
    }

    @Test
    fun `1개의 목숨을 늘리면 2개의 목숨이 된다`() {
        //given: 목숨의 개수를 1로 설정한다
        val lifeCount = LifeCount()
        val moreLIfeCount = LifeCount(2)

        //when
        lifeCount.increase()

        //then
        assertThat(lifeCount).isEqualTo(moreLIfeCount)
    }

    @Test
    fun `10개의 목숨을 줄이면 9개의 목숨이 된다`() {
        //given: 목숨의 개수를 10으로 설정한다
        val lifeCount = LifeCount(10)
        val lessLifeCount = LifeCount(9)

        //when
        lifeCount.decrease()

        //then
        assertThat(lifeCount).isEqualTo(lessLifeCount)
    }

    @Test
    fun `19개의 목숩에서는 개수를 늘여도 19개이다`() {
        //given
        val maximumLifeCount = LifeCount(99)

        //when
        maximumLifeCount.increase()

        //then
        assertTrue(maximumLifeCount.count == 19)
    }

    @Test
    fun `1개의 목숨에서는 개수를 줄여도 1개이다`() {
        //given
        val minimumLifeCount = LifeCount()

        //when
        minimumLifeCount.decrease()

        //then
        assertTrue(minimumLifeCount.count == 1)
    }
}