package com.example.baseball.domain

class Judgement {
    fun judgeNumber(
        opponentNumber: List<BaseballNumber>,
        answer: List<BaseballNumber>,
        tryCount :Int = 0
    ): BaseballScore {
        val strike = countStrikes(opponentNumber, answer)
        val allBall = countAllBall(opponentNumber, answer)
        val ball = allBall - strike
        return BaseballScore(tryCount, ball, strike, answer)
    }

    private fun countAllBall(
        opponentNumber: List<BaseballNumber>,
        answer: List<BaseballNumber>
    ): Int =
        opponentNumber.count { answer.contains(it) }

    private fun countStrikes(
        opponentNumber: List<BaseballNumber>,
        answer: List<BaseballNumber>
    ): Int =
        opponentNumber.zip(answer).count { it.first == it.second }
}