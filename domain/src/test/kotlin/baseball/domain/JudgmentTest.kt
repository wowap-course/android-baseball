package baseball.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class JudgmentTest {
    @Test
    fun `base 와 비교해 target 에 숫자가 같고 자리도 같은게 두 개라면 스트라이크가 2이다`() {
        // given
        val baseNumbers = BaseballNumbers.from(listOf(1, 2, 3))
        val targetNumbers = BaseballNumbers.from(listOf(4, 2, 3))

        // when
        val actual = Judgment().judgeScore(baseNumbers, targetNumbers)

        // then
        assertThat(actual).isEqualTo(BaseballScore(2, 0))
    }

    @Test
    fun `base 와 비교해 target 에 숫자가 같고 자리도 같은게 한 개이고 자리만 같은게 1개라면 스트라이크가 1 볼 1이다`() {
        // given
        val baseNumbers = BaseballNumbers.from(listOf(1, 2, 4))
        val targetNumbers = BaseballNumbers.from(listOf(4, 2, 7))

        // when
        val actual = Judgment().judgeScore(baseNumbers, targetNumbers)

        // then
        assertThat(actual).isEqualTo(BaseballScore(1, 1))
    }

    @Test
    fun `값이나 위치가 같은 숫자가 하나도 없다면 스트라이크가 0 볼 0이다`() {
        // given
        val baseNumbers = BaseballNumbers.from(listOf(1, 2, 3))
        val targetNumbers = BaseballNumbers.from(listOf(4, 5, 6))

        // when
        val actual = Judgment().judgeScore(baseNumbers, targetNumbers)

        // then
        assertThat(actual).isEqualTo(BaseballScore(0, 0))
    }

    @Test
    fun `값이나 위치가 같은 숫자가 하나도 없다면 스트라이크가 3이다`() {
        // given
        val baseNumbers = BaseballNumbers.from(listOf(1, 2, 3))
        val targetNumbers = BaseballNumbers.from(listOf(1, 2, 3))

        // when
        val actual = Judgment().judgeScore(baseNumbers, targetNumbers)

        // then
        assertThat(actual).isEqualTo(BaseballScore(3, 0))
    }
}
