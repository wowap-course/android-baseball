package baseball.domain

class Game(val answerNumbers: List<Int>) {
    fun resultCount(inputBaseballNumber: List<Int>, life: Int): Referee {
        val count = Judgement().correctCount(answerNumbers, inputBaseballNumber, life)
        return count
    }
}