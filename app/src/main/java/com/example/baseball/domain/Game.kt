package baseball.domain

class Game{
    fun start(randomBaseballNumber:List<Int>, inputBaseballNumber: List<Int>, life:Int):Referee {
        val count = Judgement().correctCount(randomBaseballNumber,inputBaseballNumber, life)
        return count
    }
}