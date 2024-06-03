package domain

import com.example.baseball.domain.BaseballNumber
import com.example.baseball.domain.BaseballScore
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BaseballScoreTest {
    private val answer = listOf(BaseballNumber(1), BaseballNumber(2), BaseballNumber(3))

    @Test
    fun `볼은 0보다 작을 수 없다`() {
        assertThrows<IllegalArgumentException> {
            BaseballScore(-1, 1, answer)
        }
    }

    @Test
    fun `볼은 3보다 클 수 없다`() {
        assertThrows<IllegalArgumentException> {
            BaseballScore(4, 1, answer)
        }
    }

    @Test
    fun `스트라이크은 0보다 작을 수 없다`() {
        assertThrows<IllegalArgumentException> {
            BaseballScore(1, -1, answer)
        }
    }

    @Test
    fun `스트라이크은 3보다 클 수 없다`() {
        assertThrows<IllegalArgumentException> {
            BaseballScore(1, 4, answer)
        }
    }

    @Test
    fun `answer는 세자리 숫자이다`() {
        //given
        val underThreeDigitsAnswer = listOf(BaseballNumber(2), BaseballNumber(3))
        //when

        //then
        assertThrows<IllegalArgumentException> {
            BaseballScore(1, 4, underThreeDigitsAnswer)
        }
    }

    @Test
    fun `answer는 세자리 숫자이다2`() {
        //given
        val moreThreeDigitsAnswer =
            listOf(BaseballNumber(1), BaseballNumber(2), BaseballNumber(3), BaseballNumber(4))
        //when

        //then
        assertThrows<IllegalArgumentException> {
            BaseballScore(1, 4, moreThreeDigitsAnswer)
        }
    }

    @Test
    fun `answer는 중복이 없는 숫자이다`() {
        //given
        val duplicateAnswer = listOf(BaseballNumber(2), BaseballNumber(2), BaseballNumber(3))
        //when

        //then
        assertThrows<IllegalArgumentException> {
            BaseballScore(1, 4, duplicateAnswer)
        }
    }
}