package domain

import com.example.baseball.domain.BaseballNumbers
import com.example.baseball.domain.Judgement
import com.example.baseball.domain.numbergenerator.NumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class JudgementTest() {
    inner class FixedNumberGenerator : NumberGenerator {
        override fun generateNumber() = listOf(1, 2, 3)
    }

    @Test
    fun `입력한 수에 대해 '볼'을 판단할 수 있다`() {
        val opponentNumber =
            BaseballNumbers(FixedNumberGenerator().generateNumber()).baseballNumbers
        val answer = BaseballNumbers(listOf(3, 4, 5)).baseballNumbers
        val score = Judgement().judgeNumber(opponentNumber, answer)
        assertThat(score.ball).isEqualTo(1)
    }

    @Test
    fun `입력한 수에 대해 '스트라이크'를 판단할 수 있다`() {
        val opponentNumber =
            BaseballNumbers(FixedNumberGenerator().generateNumber()).baseballNumbers
        val answer = BaseballNumbers(listOf(1, 2, 5)).baseballNumbers
        val score = Judgement().judgeNumber(opponentNumber, answer)
        assertThat(score.strike).isEqualTo(2)
    }

    @Test
    fun `입력한 수에 대해 '볼'과 '스트라이크'를 판단할 수 있다`() {
        val opponentNumber =
            BaseballNumbers(FixedNumberGenerator().generateNumber()).baseballNumbers
        val answer = BaseballNumbers(listOf(1, 3, 2)).baseballNumbers
        val score = Judgement().judgeNumber(opponentNumber, answer)
        assertThat(score.ball to score.strike).isEqualTo(2 to 1)
    }
}
