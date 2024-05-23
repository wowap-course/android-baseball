package baseball.domain

class Judgement() {

    fun correctCount(answerNumbers: List<Int>, targetNumbers: List<Int>, life:Int): Referee {
        val strikeCount = getStrikeCount(answerNumbers, targetNumbers)
        val ballCount = getBallCount(answerNumbers, targetNumbers) - strikeCount
        val lifeCount = getLifeCount(strikeCount, life)
        return Referee(strikeCount,ballCount,lifeCount)
    }

    private fun getLifeCount(strikeCount: Int, life: Int): Int {
        if(strikeCount != 3) return life-1
        else return life
    }

    private fun getStrikeCount(answerNumbers: List<Int>, targetNumbers: List<Int>): Int {
        var strikeCount = 0

        for (i in answerNumbers.indices) {
            strikeCount = checkStrike(targetNumbers, i, answerNumbers, strikeCount)
        }
        return strikeCount
    }

    private fun checkStrike(
        targetNumbers: List<Int>,
        i: Int,
        answerNumbers: List<Int>,
        strikeCount: Int
    ): Int {
        var strikeCount1 = strikeCount
        if (targetNumbers[i] == answerNumbers[i]) strikeCount1++
        return strikeCount1
    }

    private fun getBallCount(answerNumbers: List<Int>, targetNumbers: List<Int>): Int {
        var ballCount = 0

        targetNumbers.forEach {
            ballCount = checkBall(it, answerNumbers, ballCount)
        }
        return ballCount
    }

    private fun checkBall(it: Int, answerNumbers: List<Int>, ballCount: Int): Int {
        var ballCount1 = ballCount
        if (it in answerNumbers) ballCount1++
        return ballCount1
    }
}
