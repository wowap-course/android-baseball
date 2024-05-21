package com.example.baseball.domain

import com.example.baseball.domain.numbergenerator.NumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class JudgementTest() {
    inner class FixedNumberGenerator : NumberGenerator {
        override fun generateNumber() = listOf(1, 2, 3)
    }

    @Test
    fun `입력한 수에 대해 '볼'을 판단할 수 있다`() {
        val opponentNumber =
            BaseballNumbers(FixedNumberGenerator().generateNumber()).baseballNumbers
        val answer = BaseballNumbers(listOf(3, 4, 5)).baseballNumbers
        val (ball, _) = Judgement().judgeNumber(opponentNumber, answer)
        assertThat(ball).isEqualTo(1)
    }

    @Test
    fun `입력한 수에 대해 '스트라이크'를 판단할 수 있다`() {
        val opponentNumber =
            BaseballNumbers(FixedNumberGenerator().generateNumber()).baseballNumbers
        val answer = BaseballNumbers(listOf(1, 2, 5)).baseballNumbers
        val (_, strike) = Judgement().judgeNumber(opponentNumber, answer)
        assertThat(strike).isEqualTo(2)
    }

    @Test
    fun `입력한 수에 대해 '볼'과 '스트라이크'를 판단할 수 있다`() {
        val opponentNumber =
            BaseballNumbers(FixedNumberGenerator().generateNumber()).baseballNumbers
        val answer = BaseballNumbers(listOf(1, 3, 2)).baseballNumbers
        val (ball, strike) = Judgement().judgeNumber(opponentNumber, answer)
        assertThat(ball to strike).isEqualTo(2 to 1)
    }
}
