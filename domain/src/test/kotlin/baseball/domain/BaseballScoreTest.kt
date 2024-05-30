package baseball.domain

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BaseballScoreTest {
    @Test
    fun `숫자야구는 스트라이크가 3이면 정답이다`() {
        // given
        val score = BaseballScore(3, 0)
        // when

        // then
        assertTrue(score.isCorrect())
    }

    @Test
    fun `숫자야구는 스트라이크가 3이 아니면 오답이다`() {
        // given
        val score = BaseballScore(2, 1)
        // when

        // then
        assertFalse(score.isCorrect())
    }
}
