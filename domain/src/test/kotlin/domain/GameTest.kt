package domain

import baseball.domain.Game
import baseball.domain.Referee
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameTest {
    @Test
    fun `start함수는 count를 리턴받는가?`(){
        val answerNumber:List<Int> = listOf(1,2,3)
        val game = Game(answerNumber)
        val count = Game(answerNumber).resultCount(listOf(1,2,3))
        assertThat(count).isEqualTo(Referee(3,0))
    }
}