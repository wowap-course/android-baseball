package baseball.domain

class Game(val answerNumbers: List<Int>) {
    fun start(inputBaseballNumber: List<Int>, life: Int): Referee {
        val count = Judgement().correctCount(answerNumbers, inputBaseballNumber, life)
        return count
    }
}