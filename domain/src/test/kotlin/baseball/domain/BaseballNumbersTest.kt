package baseball.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BaseballNumbersTest {
    @Test
    fun `숫자야구 숫자들의 초기값을 정해주면 그 값을 읽어올 수 있다_1`() {
        // given
        val baseballNumbers = BaseballNumbers(
            setOf(BaseballNumber(1), BaseballNumber(2), BaseballNumber(3)),
        )
        // when

        // then
        assertThat(baseballNumbers.numbers).containsExactly(
            BaseballNumber(1),
            BaseballNumber(2),
            BaseballNumber(3),
        )
    }

    @Test
    fun `숫자야구 숫자들의 초기값을 정해주면 그 값을 읽어올 수 있다_2`() {
        // given
        val baseballNumbers = BaseballNumbers.from(
            listOf(BaseballNumber(1), BaseballNumber(2), BaseballNumber(3)),
        )
        // when

        // then
        assertThat(baseballNumbers.numbers).containsExactly(
            BaseballNumber(1),
            BaseballNumber(2),
            BaseballNumber(3),
        )
    }

    @Test
    fun `숫자야구 숫자들의 초기값을 정해주면 그 값을 읽어올 수 있다_3`() {
        // given
        val baseballNumbers = BaseballNumbers.from(listOf(1, 2, 3))
        // when

        // then
        assertThat(baseballNumbers.numbers).containsExactly(
            BaseballNumber(1),
            BaseballNumber(2),
            BaseballNumber(3),
        )
    }

    @Test
    fun `숫자야구 숫자들은 중복될 수 없다`() {
        assertThrows<IllegalArgumentException> {
            BaseballNumbers.from(
                listOf(BaseballNumber(1), BaseballNumber(1), BaseballNumber(3)),
            )
        }
    }

    @Test
    fun `숫자야구 숫자는 3개여야 한다_1`() {
        assertThrows<IllegalArgumentException> {
            BaseballNumbers(
                setOf(BaseballNumber(1), BaseballNumber(2)),
            )
        }
    }

    @Test
    fun `숫자야구 숫자는 3개여야 한다_2`() {
        assertThrows<IllegalArgumentException> {
            BaseballNumbers(
                setOf(BaseballNumber(1), BaseballNumber(2), BaseballNumber(3), BaseballNumber(4)),
            )
        }
    }
}
