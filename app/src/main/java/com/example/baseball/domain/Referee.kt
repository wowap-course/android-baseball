package baseball.domain

class Referee {
    private val score = Score(RESET_NUMBER, RESET_NUMBER)


    fun call(computerNumbers: List<Int>, playerNumbers: List<Int>): Pair<Int, Int> {
        for (i in computerNumbers.indices) {
            if (computerNumbers[i] == playerNumbers[i]) {
                score.strike++
            } else if (playerNumbers.contains(computerNumbers[i])) {
                score.ball++
            }
        }

        return score.strike to score.ball
    }

    fun reset() {
        score.strike = RESET_NUMBER
        score.ball = RESET_NUMBER
    }

    fun isThreeStrike(): Boolean {
        return score.strike == THREE_STRIKE
    }

    companion object {
        const val MIN_RANDOM_NUMBER = 1
        const val MAX_RANDOM_NUMBER = 9
        const val THREE_STRIKE = 3
        const val RESET_NUMBER = 0
        const val MAX_COM_NUMBER_SIZE = 3
    }
}