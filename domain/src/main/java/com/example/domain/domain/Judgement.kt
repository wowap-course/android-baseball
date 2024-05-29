package baseball.domain

class Judgement() {

    fun correctCount(answerNumbers: List<Int>, targetNumbers: List<Int>): Referee {
        val strikeCount = getStrikeCount(answerNumbers, targetNumbers)
        val ballCount = getBallCount(answerNumbers, targetNumbers) - strikeCount
        return Referee(strikeCount,ballCount)
    }


    private fun getStrikeCount(answerNumbers: List<Int>, targetNumbers: List<Int>): Int {
        var strikeCount = INIT_STRIKE_COUNT

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
        var ballCount = INIT_BALL_COUNT

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

    companion object{
        private const val INIT_STRIKE_COUNT = 0
        private const val INIT_BALL_COUNT = 0
    }
}
