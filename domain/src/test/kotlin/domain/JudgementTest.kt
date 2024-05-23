package domain

import baseball.domain.Referee
import baseball.domain.Judgement
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class JudgementTest {

    @Test
    fun `두 숫자를 비교했을 때, 값은 같고 자리만 다른 숫자가 하나라면 볼의 개수는 1 이다`(){
        val answerNumbers:List<Int> = listOf(4,5,6)
        val targetNumbers:List<Int> = listOf(5,1,2)
        val lifeCount = 1
        val count = Judgement().correctCount(answerNumbers, targetNumbers,lifeCount)
        assertThat(count).isEqualTo(Referee(0,1,1))
    }

    @Test
    fun `두 숫자를 비교했을 때, 값은 같고 자리도 같다면 스트라이크의 개수는 1 이다`(){
        val answerNumbers:List<Int> = listOf(4,5,6)
        val targetNumbers:List<Int> = listOf(3,1,6)
        val lifeCount = 1
        val count = Judgement().correctCount(answerNumbers, targetNumbers, lifeCount)
        assertThat(count).isEqualTo(Referee(1,0,1))
    }
}