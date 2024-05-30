import com.example.baseball.domain.Life
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LifeTest {

    @Test
    fun `목숨은 10을 초과할 수 없다`() {
        assertThrows<IllegalArgumentException> { Life(11) }
    }

    @Test
    fun `목숨은 1 미만일 수 없다`() {
        assertThrows<IllegalArgumentException> { Life(0) }
    }

    @Test
    fun `4에서 목숨을 1 증가시키면 목숨은 5이다`() {
        // given
        var life = Life(4)

        // when
        life++

        // then
        assertThat(life).isEqualTo(Life(5))
    }

    @Test
    fun `3에서 목숨을 1 감소시키면 목숨은 3이다`() {
        // given
        var life = Life(4)

        // when
        life--

        // then
        assertThat(life).isEqualTo(Life(3))
    }
}
