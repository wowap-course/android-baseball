package domain

import com.example.baseball.domain.BaseballNumber
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BaseballNumberTest() {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `야구 숫자는 1부터 9사이의 값이다_1`(value : Int) {
        assertDoesNotThrow{ BaseballNumber(value) }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -100, 0, 10, 99, 999])
    fun `야구 숫자는 1부터 9사이의 값이다_2`(value : Int) {
        assertThrows<IllegalArgumentException>{BaseballNumber(value)}
    }
}