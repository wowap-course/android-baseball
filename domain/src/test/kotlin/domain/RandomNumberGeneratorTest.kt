package domain


import baseball.domain.numbergenerator.RandomNumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomNumberGeneratorTest {
    @Test
    fun `각각의 숫자는 다르다`() {
        val randomNumberGenerator = RandomNumberGenerator()
        val numbers = randomNumberGenerator.getNumbers()
        assertThat(numbers).isEqualTo(numbers.distinct())
    }

}