package domain

import com.example.baseball.domain.LifeCount
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
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
    fun `목숨의 개수는 10를 넘을 수 없다`() {
        assertThrows<IllegalArgumentException> { LifeCount(11) }
    }

    @Test
    fun `1개의 목숨을 늘리면 2개의 목숨이 된다`() {
        //given: 목숨의 개수를 1로 설정한다
        var lifeCount = LifeCount()

        //when
        lifeCount++

        //then
        assertThat(lifeCount).isEqualTo(LifeCount(2))
    }

    @Test
    fun `10개의 목숨을 줄이면 9개의 목숨이 된다`() {
        //given: 목숨의 개수를 10으로 설정한다
        var lifeCount = LifeCount(10)

        //when
        lifeCount--

        //then
        assertThat(lifeCount).isEqualTo(LifeCount(9))
    }

    @Test
    fun `10개의 목숩에서는 개수를 늘여도 10개이다`() {
        //given
        var maximumLifeCount = LifeCount(10)

        //when
        maximumLifeCount++

        //then
        assertTrue(maximumLifeCount == LifeCount(10))
    }

    @Test
    fun `1개의 목숨에서는 개수를 줄여도 1개이다`() {
        //given
        var minimumLifeCount = LifeCount()

        //when
        minimumLifeCount--

        //then
        assertTrue(minimumLifeCount == LifeCount(1))
    }
}