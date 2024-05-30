package baseball.domain

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BaseballNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `숫자야구 숫자는 1부터 9 사이여야 한다`(value: Int) {
        assertDoesNotThrow { BaseballNumber(value) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 10, 999, 111111])
    fun `숫자야구 숫자는 1부터 9 사이 숫자가 아닐 수 없다`(value: Int) {
        assertThrows<IllegalArgumentException> { BaseballNumber(value) }
    }
}
