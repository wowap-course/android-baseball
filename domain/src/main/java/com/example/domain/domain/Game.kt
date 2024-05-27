package baseball.domain

class Game(val answerNumbers: List<Int>) {
    fun resultCount(inputBaseballNumber: List<Int>): Referee {
        val count = Judgement().correctCount(answerNumbers, inputBaseballNumber)
        return count
    }
}